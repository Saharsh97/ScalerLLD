package MachineCoding.ParkingLot.repository;

import MachineCoding.ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gateTable = new TreeMap<>();

    public Optional<Gate> getGateByGateNumber(Long gateNumber){
        // String response = db.execute("select * from gate where gate_number = gateNumber");
        // Gate gateObject = convertToGateObject(response);
        // if(gateObject != null){
        //      return Optional.of(gateObject);
        // }
        if(gateTable.containsKey(gateNumber)){
            return Optional.of(gateTable.get(gateNumber));
        }
        return Optional.empty();
    }
}

// Table => id, columns
// hashmap => id, object
//