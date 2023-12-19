package MachineCoding.ParkingLot.dto;

import MachineCoding.ParkingLot.models.Vehicle;
import MachineCoding.ParkingLot.models.enums.VehicleType;

public class IssueTicketRequestDTO {
    private String vehicleNumber;
    private String vehicleOwnerName;
    private VehicleType vehicleType;
    private Long gateId;
    private String priority;


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}
