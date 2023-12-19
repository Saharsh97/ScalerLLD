package MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy;

import MachineCoding.ParkingLot.models.Gate;
import MachineCoding.ParkingLot.models.ParkingSlot;
import MachineCoding.ParkingLot.models.enums.VehicleType;

public interface SlotAllocationStrategy {
    // gate needed to get the closest available slot.
    public ParkingSlot getParkingSlot(VehicleType vehicleType, Gate gate);
}
