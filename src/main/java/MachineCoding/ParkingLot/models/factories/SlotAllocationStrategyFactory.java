package MachineCoding.ParkingLot.models.factories;

import MachineCoding.ParkingLot.models.enums.SlotAllocationStrategyType;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategies.FarthestSlotAllocationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategies.NearestSlotAllocationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategies.RandomSlotAllocationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategies.SlotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategyByType(SlotAllocationStrategyType type){
        if(type == SlotAllocationStrategyType.RANDOM){
            return new RandomSlotAllocationStrategy();
        } else if(type == SlotAllocationStrategyType.NEAREST_TO_GATE){
            return new NearestSlotAllocationStrategy();
        } else {
            return new FarthestSlotAllocationStrategy();
        }
    }
}
