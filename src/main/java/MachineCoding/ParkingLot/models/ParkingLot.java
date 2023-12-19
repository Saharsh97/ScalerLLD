package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.models.enums.FeeCalculationStrategyType;
import MachineCoding.ParkingLot.models.enums.ParkingLotStatus;
import MachineCoding.ParkingLot.models.enums.SlotAllocationStrategyType;
import MachineCoding.ParkingLot.models.enums.VehicleType;
import MachineCoding.ParkingLot.models.strategies.feeCalculationStrategy.FeeCalculationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy.SlotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseModel{
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private SlotAllocationStrategyType slotAllocationStrategyType;

    public ParkingLot() {
        this.address = "";
        this.parkingFloors = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.allowedVehicleTypes = new ArrayList<>();
        this.parkingLotStatus = ParkingLotStatus.OPEN;
        this.feeCalculationStrategyType = FeeCalculationStrategyType.HOURLY;
        this.slotAllocationStrategyType = SlotAllocationStrategyType.RANDOM;
    }

    public SlotAllocationStrategyType getSlotAllocationStrategyType() {
        return slotAllocationStrategyType;
    }

    public void setSlotAllocationStrategyType(SlotAllocationStrategyType slotAllocationStrategyType) {
        this.slotAllocationStrategyType = slotAllocationStrategyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
