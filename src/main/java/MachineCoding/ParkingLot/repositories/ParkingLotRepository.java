package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Gate;
import MachineCoding.ParkingLot.models.ParkingLot;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    public static Map<Long, ParkingLot> parkingLotTable = new TreeMap<>();
    public Optional<ParkingLot> getParkingLotByGate(Gate gate){
        // write a for loop over all parkingLot and nested loop for gate.
        // easiest would be, the client also gives the parkingLot id, the machine will give the parkingLot id.

//        String response = db.execute("select * from parking_lots");
//        List<ParkingLot> parkingLots = convertToParkingLotList(response)
        for(ParkingLot parkingLot: parkingLotTable.values()){
            for(Gate gateObject: parkingLot.getGates()){
                if(gateObject.getGateNumber() == gate.getGateNumber()){
                    return Optional.of(parkingLot);
                }
            }
        }
        return Optional.empty();
    }
}
