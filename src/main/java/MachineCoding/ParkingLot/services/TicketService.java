package MachineCoding.ParkingLot.services;

import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.exceptions.GateNotFoundException;
import MachineCoding.ParkingLot.exceptions.ParkingLotNotFoundException;
import MachineCoding.ParkingLot.models.*;
import MachineCoding.ParkingLot.models.enums.GateStatus;
import MachineCoding.ParkingLot.models.enums.SlotAllocationStrategyType;
import MachineCoding.ParkingLot.models.enums.VehicleType;
import MachineCoding.ParkingLot.models.factories.SlotAllocationStrategyFactory;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategies.SlotAllocationStrategy;
import MachineCoding.ParkingLot.repository.GateRepository;
import MachineCoding.ParkingLot.repository.ParkingLotRepository;
import MachineCoding.ParkingLot.repository.TicketRepository;
import MachineCoding.ParkingLot.repository.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType,
                              Long gateNumber) throws GateNotFoundException, ParkingLotNotFoundException {
        // 1. create the ticket
        Ticket ticket = new Ticket();

        // 2. fill the attributes of ticket.



        // set entryTime
        ticket.setEntryTime(new Date());

        // set gate
        // we have a database. we have tables for all the models.
        // table for vehicle. table for gate, table for operator, table for parkingLot etc.
        // table for gate.
        // this will store all the information about all the gates.

        // I want to get gate details for the given gateNumber.
        // I will execute a SQL query on the gate table => get the gate data for that gateNumber.


        // I will use Repositories to handle all the CRUD operations on a Model.

        Optional<Gate> gateOptional = gateRepository.getGateByGateNumber(gateNumber);
        if(!gateOptional.isPresent()){
            throw new GateNotFoundException("Gate does not exist for the given gateNumber " + gateNumber);
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);

        // set operator
        ticket.setGeneratedBy(gate.getCurrentOperator());

        // set vehicle
        // get the vehicle from database table. if it exists, then we can set it in the ticket.
        // if the vehicle record doesnt not exist in the table, I will add a new record the table.
        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(!vehicleOptional.isPresent()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setNameOfOwner(ownerName);
            vehicle.setVehicleType(vehicleType);

            // save this vehicle to the database table.
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);



        // set assigned parking slot.
        // for this parking lot, I have to get the strategy.

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotByGateId(gate.getId());
        if(!parkingLotOptional.isPresent()){
            throw new ParkingLotNotFoundException("Parking lot not found");
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        SlotAllocationStrategyType strategyType = parkingLot.getSlotAllocationStrategyType();
        SlotAllocationStrategy slotAllocationStrategy = SlotAllocationStrategyFactory.getSlotAllocationStrategyByType(strategyType);
        ParkingSlot assignedSlot = slotAllocationStrategy.getParkingSlot(gate, vehicleType);
        ticket.setParkingSlot(assignedSlot);

        // save the ticket to db table.
        ticket = ticketRepository.saveTicket(ticket);

        // set ticketNumber
        // ticketNumber will be related to ticketId
        ticket.setTicketNumber("Ticket_" + ticket.getId());
        // 3. give back to controller
        return ticket;
    }
}
