package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    public static Map<Long, Gate> gatesTable = new TreeMap<>();
    public Optional<Gate> findGateById(Long gateId){
        // db.execute("select * from gate where id = gateId")

        // should I return a gate object here?
        // gateId is given by the client, can it lead to any problem?
        // Gate can be null if Id is not in DB.. and null will be returned from here.
        // using the null Gate instance else where can cause npe..
        if(gatesTable.containsKey(gateId)){
            return Optional.of(gatesTable.get(gateId));
        }
        return Optional.empty();
    }
}

// talk about how to handle database here.
// in-memory using hashmaps


// In-memory DB => use HashMap, it resembles the table.
// it has id and object => just like a table.
// HashMap<id, Gate>

// what kind of HashMaps?
// database is sorted according to what? by the id.
// so which hashmap would be better here?
// TreeMap, just to replicate the database.