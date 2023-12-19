package MachineCoding.ParkingLot;

import MachineCoding.ParkingLot.controllers.TicketController;
import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.dto.IssueTicketResponseDTO;
import MachineCoding.ParkingLot.dto.enums.ResponseStatus;

public class Client {
    public static void main(String[] args) {
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setGateId(1L);
        requestDTO.setVehicleNumber("MH03AZ7775");

        TicketController controller = new TicketController();
        IssueTicketResponseDTO responseDTO = controller.issueTicket(requestDTO);

        if(responseDTO.getResponseStatus() == ResponseStatus.SUCCESS){
            // park the car
        } else {
            // retry...
        }
    }
}
