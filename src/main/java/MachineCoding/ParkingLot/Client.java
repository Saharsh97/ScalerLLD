package MachineCoding.ParkingLot;

import MachineCoding.ParkingLot.controllers.TicketController;
import MachineCoding.ParkingLot.dto.IssueTicketRequestDTO;
import MachineCoding.ParkingLot.dto.IssueTicketResponseDTO;
import MachineCoding.ParkingLot.models.enums.VehicleType;

public class Client {
    TicketController ticketController;

    public Client(TicketController ticketController){
        this.ticketController = ticketController;
    }

    public void generateIncomingRequests(){
        testCase1();
        testCase2();
    }

    private void testCase1(){
        // 1.
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setVehicleNumber("MH03AZ7775");
        requestDTO.setGateId(1L);
        requestDTO.setVehicleOwnerName("Saharsh Singh");
        requestDTO.setVehicleType(VehicleType.CAR);

        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(requestDTO);


        System.out.println("Status : " + responseDTO.getResponseStatus());
        System.out.println("TicketGenerated : " + responseDTO.getTicket().getTicketNumber());
    }

    private void testCase2(){
        // 2.
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setVehicleNumber("MH03AZ7775");
        requestDTO.setGateId(1L);
        requestDTO.setVehicleOwnerName("Saharsh Singh");
        requestDTO.setVehicleType(VehicleType.CAR);

        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(requestDTO);


        System.out.println("Status : " + responseDTO.getResponseStatus());
        System.out.println("TicketGenerated : " + responseDTO.getTicket().getTicketNumber());
    }
}
