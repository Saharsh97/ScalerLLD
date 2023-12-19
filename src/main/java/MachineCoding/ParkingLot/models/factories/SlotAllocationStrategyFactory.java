package MachineCoding.ParkingLot.models.factories;

import MachineCoding.ParkingLot.models.enums.SlotAllocationStrategyType;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy.FarthestSlotAllocationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy.NearestSlotAllocationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy.RandomSlotAllocationStrategy;
import MachineCoding.ParkingLot.models.strategies.slotAllocationStrategy.SlotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategyByStrategyType(SlotAllocationStrategyType type){
        if(type == SlotAllocationStrategyType.RANDOM){
            return new RandomSlotAllocationStrategy();
        } else if(type == SlotAllocationStrategyType.NEAREST_TO_GATE){
            return new NearestSlotAllocationStrategy();
        } else if(type == SlotAllocationStrategyType.FARTHEST_FROM_GATE){
            return new FarthestSlotAllocationStrategy();
        }
        return null;
    }
}
