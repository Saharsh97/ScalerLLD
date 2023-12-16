package MachineCoding.ParkingLot.dto;

import MachineCoding.ParkingLot.dto.enums.ResponseStatus;
import MachineCoding.ParkingLot.models.ParkingSlot;
import MachineCoding.ParkingLot.models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private String message;
    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
