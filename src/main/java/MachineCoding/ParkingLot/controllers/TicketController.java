package MachineCoding.ParkingLot.controllers;

import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.dto.IssueTicketResponseDTO;
import MachineCoding.ParkingLot.dto.enums.ResponseStatus;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.services.TicketService;

public class TicketController {

    TicketService ticketService = new TicketService();

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO){
        // validations
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();

        try {
            Ticket ticket = ticketService.issueTicket(requestDTO.getVehicleNumber(),
                    requestDTO.getVehicleOwnerName(),
                    requestDTO.getVehicleType(),
                    requestDTO.getGateId());


            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}

// Responsibilities of a controller method
// 1. interact with the client => get requestDTO
// 2. validate the request
// 3. call the service, give it the input
// 4. response from the service. => Model object, Ticket
// 5. handle any exceptions given by the service, or any other layer.
// 6. send response to the client => Response DTO
