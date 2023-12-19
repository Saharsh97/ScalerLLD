package MachineCoding.ParkingLot.services;

import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.exceptions.GateNotFoundException;
import MachineCoding.ParkingLot.models.*;
import MachineCoding.ParkingLot.models.enums.SlotAllocationStrategyType;
import MachineCoding.ParkingLot.models.enums.VehicleType;
import MachineCoding.ParkingLot.models.factories.SlotAllocationStrategyFactory;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy.SlotAllocationStrategy;
import MachineCoding.ParkingLot.repositories.GateRepository;
import MachineCoding.ParkingLot.repositories.ParkingLotRepository;
import MachineCoding.ParkingLot.repositories.TicketRepository;
import MachineCoding.ParkingLot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

// internal thing, not talking to client. so do we need DTO here as well?
// can we return the actual model, Ticket here?

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
                              Long gateId) throws GateNotFoundException {
        // have a flow chart in mind when you implement a service method.

        // create a Ticket Object
        // set all the attributes of ticket, such as entryTime, gate, operator, vehicle,
        // assigning a parking slot
        // returning the ticket

        Ticket ticket = new Ticket();

        // have to set ticketNumber.
        // can do this by appending a random number after ticketid.
        // when do we have a ticket id? when we store it in a database.
        // we will talk about simple id generation.
        // complex ones to be talked in HLD module, in distributed systems.

        ticket.setEntryTime(new Date());

        // lets set the gate
        // I only have a gateId, how will I get the gate object from the gateId? by checking DB
        // classes only define the structure and the attributes.
        // but where do we store the actual data? the database.

        // all CRUD operations go to the Repositories.
        // Repositories contain methods that read/write, do CRUD on the Database.
        // create repository package now. GateRepository,

        // * do gate repo explanation *

        // ask gate repository to find gate by id
//        Gate gate = gateRepository.findGateById(gateNumber);
        // here gate could be null.
        // how can we deal with this? Optional!
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
//        gateOptional.get(); // hint: 'Optional.get()' without 'isPresent()' check
        if(!gateOptional.isPresent()){
            throw new GateNotFoundException("Gate not found for id " + gateId);
        }
        // optional looks cleaner, more robust, more properties, more functionalities.
        // you will find optional in a lot of codebases.
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);

        // set operator. from where can we get this? the gate object.
        ticket.setGeneratedBy(gate.getCurrentOperator());


        // now lets set the vehicle
        // should I directly start creating the object of vehicle?
        // in the schema design, we had a vehicles table. dont you think this vehicle could already be present in that table.
        // is it possible my vehicle is already present in the database? previous customer. coming in daily basis.
        // then we should be checking our database for this existing vehicle.
        // vehicle repository.

        // * explain vehicle repository *
        Vehicle savedVehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        if(!vehicleOptional.isPresent()){
            // throw error??
            // instead we should create a new vehicle object, and save it to db for later fetching
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setNameOfOwner(ownerName);
            // save this vehicle to database. Where should I write the save method.
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
            System.out.println("vehicle saved to DB!");
        } else {
            System.out.println("This vehicle already exists in my Vehicle Table!");
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);




        // assign the slot.
        // based on strategy type.
        // we have put a strategy type in what entity? in the ParkingLot.
        // if we directly store the actual implementation of slotAllocationStrategy,
        // we are again going to have a tight coupling, so instead lets store enum.
        // how will I get the actual object now, using the enum??

        // do we have parkingLot object here?
        // how will we get the parkingLot object?
        // using the gate! a gate is a part of only one ParkingLot!
        // use the gate, to find the parkingLot. not the optimized approach, but it will work.
        // other way is, client gives the parkingLot id, via the scanner machine.

        //  * Parking Lot Repository * //
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotByGate(gate);
        if(!parkingLotOptional.isPresent()){
            // not possible!! so remove optional here!
            return null;
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        // now we have the parking lot. what should we do now?
        // now we should have the implementation of these strategies. => implement them.
        SlotAllocationStrategyType allocationStrategyType = parkingLot.getSlotAllocationStrategyType();
        SlotAllocationStrategy slotAllocationStrategy = SlotAllocationStrategyFactory.getSlotAllocationStrategyByStrategyType(allocationStrategyType);
        ParkingSlot assignedParkingSlot = slotAllocationStrategy.getParkingSlot(vehicleType, gate);
        ticket.setParkingSlot(assignedParkingSlot);

        // now ticket is ready.
        // before the sending the response, I need to something?? Save the ticket to db
        ticket = ticketRepository.saveTicket(ticket);
        // now ticket also has an id.
        ticket.setTicketNumber("Ticket_" + ticket.getId());
        return ticket;
    }
}

// how to handle injections?
// frameworks help you with that. they help you start your system.
// but here we have to setup by ourself.


