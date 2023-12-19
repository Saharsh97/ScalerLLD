package MachineCoding.ParkingLot;

import MachineCoding.ParkingLot.controllers.TicketController;
import MachineCoding.ParkingLot.repository.GateRepository;
import MachineCoding.ParkingLot.repository.ParkingLotRepository;
import MachineCoding.ParkingLot.repository.TicketRepository;
import MachineCoding.ParkingLot.repository.VehicleRepository;
import MachineCoding.ParkingLot.services.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {

        // We have to resolve the dependencies
        // what order should the dependencies be made, so that code is runnable.
        // what solves the dependency graphs?? topological sorting.
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);


    }
}
