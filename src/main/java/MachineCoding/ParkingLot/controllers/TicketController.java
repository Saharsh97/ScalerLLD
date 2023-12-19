package MachineCoding.ParkingLot.controllers;

import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.dto.IssueTicketResponseDTO;
import MachineCoding.ParkingLot.dto.enums.ResponseStatus;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.services.TicketService;

// 10 controllers, all of them are using TicketService methods.
// you will make 10 different service objects.

// the same can be achieved, by having reference of 1 single service object.
// and all the controllers, use the reference, and call the methods.

public class TicketController {

    // dependency injection.
    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

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
