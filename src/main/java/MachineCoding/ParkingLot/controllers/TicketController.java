package MachineCoding.ParkingLot.controllers;

import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.dto.IssueTicketResponseDTO;
import MachineCoding.ParkingLot.dto.enums.ResponseType;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.services.TicketService;

public class TicketController {
    // depedency injection. this is coming from, outside this class.
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO) {
        // validations can be added, but focus on the more important stuff for the requirements.
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try {   // add exceptions after basic ticket response
            Ticket ticket = ticketService.issueTicket(requestDTO.getVehicleNumber(),
                    requestDTO.getVehicleOwnerName(),
                    requestDTO.getVehicleType(),
                    requestDTO.getGateId());


            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(ResponseType.SUCCESS);
        } catch (Exception e){
            // client does not understand exception, tell them, this happened. sorry.
            responseDTO.setResponseStatus(ResponseType.FAILURE);
            responseDTO.setFailureMessage(e.getMessage());
        }
        return responseDTO; // controller done.
    }
}

// Controller responsibilities:
// 1. interact with the client => get requestDTO
// 2. validations on input
// 3. call the service, provide it with the input
// 4. receive the output from the service
// 5. send it to client in a proper format => return responseDTO

// DTOs only used for communication to outer system.

