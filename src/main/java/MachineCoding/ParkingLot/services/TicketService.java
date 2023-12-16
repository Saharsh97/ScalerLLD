package MachineCoding.ParkingLot.services;

import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.models.enums.VehicleType;

public class TicketService {

    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType,
                              String gateNumber){
        // get the free parking slot => run SlotAllocationStrategy
        // add some more details.
        // create the Ticket object
        return null;
    }
}
