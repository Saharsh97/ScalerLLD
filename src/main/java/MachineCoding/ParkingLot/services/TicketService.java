package MachineCoding.ParkingLot.services;

import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.exceptions.GateNotFoundException;
import MachineCoding.ParkingLot.models.Gate;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.models.enums.GateStatus;
import MachineCoding.ParkingLot.models.enums.VehicleType;
import MachineCoding.ParkingLot.repository.GateRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    GateRepository gateRepository;

    public TicketService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType,
                              String gateNumber) throws GateNotFoundException {
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

        Optional<Gate> gateOptional = gateRepository.getGateByNumber(gateNumber);
        if(!gateOptional.isPresent()){
            throw new GateNotFoundException("Gate does not exist for the given gateNumber " + gateNumber);
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);

        // set operator
        ticket.setGeneratedBy(gate.getCurrentOperator());

        // set vehicle

        // set assigned parking slot.






        // set ticketNumber
        // ticketNumber will be related to ticketId
//        ticket.setTicketNumber("Ticket_" + ticket.getId());
        // 3. give back to controller
        return ticket;
    }
}
