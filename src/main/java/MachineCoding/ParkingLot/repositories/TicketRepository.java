package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();

    // static counter to generate id.
    // will this work for distributed system? use UUID there, or other algorithms.
    private Long previousId = 0L;

    public Ticket saveTicket(Ticket ticket){
        // db.execute save ticket command.
        previousId += 1;
        ticket.setId(previousId);
        tickets.put(previousId, ticket);
        return ticket;
    }
}
