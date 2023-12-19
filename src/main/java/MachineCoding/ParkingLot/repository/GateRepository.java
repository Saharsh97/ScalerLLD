package MachineCoding.ParkingLot.repository;

import MachineCoding.ParkingLot.models.Gate;

import java.util.Optional;

public class GateRepository {
    public Optional<Gate> getGateByNumber(String gateNumber){
        // String response = db.execute("select * from gate where gate_number = gateNumber");
        // Gate gateObject = convertToGateObject(response);
        // if(gateObject != null){
        //      return Optional.of(gateObject);
        // }
        return Optional.empty();
    }
}
