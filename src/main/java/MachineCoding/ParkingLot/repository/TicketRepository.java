package MachineCoding.ParkingLot.repository;

import MachineCoding.ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> ticketTable = new TreeMap<>();
    private static Long counter = 0L;

    public Ticket saveTicket(Ticket ticket){
        // db.execute(insert into tickets (..) Values (ticket.getEntryTime()...))
        // String response = db.execute(select * from tickets where ticket_entry_time = ticket.getEntryDate());
        // ticket = convertToTicketObject(response);
        counter++;
        ticket.setId(counter);
        ticketTable.put(counter, ticket);
        return ticket;
    }
}
