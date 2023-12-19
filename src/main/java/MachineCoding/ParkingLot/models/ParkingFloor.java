package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.models.enums.ParkingFloorStatus;
import MachineCoding.ParkingLot.models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private List<ParkingSlot> parkingSlotList;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingFloorStatus parkingFloorStatus;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSlotList = new ArrayList<>();
        this.allowedVehicleTypes = new ArrayList<>();
        this.parkingFloorStatus = ParkingFloorStatus.OPEN;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
}
