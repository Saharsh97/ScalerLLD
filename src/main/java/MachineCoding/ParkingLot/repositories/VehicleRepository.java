package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    Map<String, Vehicle> vehicleTable = new TreeMap<>();
    private static long vehicleCounter = 100L;

    public Optional<Vehicle> getVehicleByVehicleNumber(String vehicleNumber){
        // db.execute("select * from vehicle where number = vehicleNumber")
        if(vehicleTable.containsKey(vehicleNumber)){
            return Optional.of(vehicleTable.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        // db.execute("insert into vehicle (number, type, ...) values (vehicle.getVehicleNumber(), ...)");
        // difference between the vehicle in return type and vehicle in parameter??
        // we will be getting the id of the vehicle object.
        vehicleTable.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}
