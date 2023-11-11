package main.java.DesignPatterns.prototypeExplanation;

// we should be able to store the base objects, and get the bas objects.

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String, Student> map = new HashMap<>();

    public void register(String key, Student student){
        map.put(key, student);
    }

    public Student get(String key){
        return map.get(key);
    }
//    </2>
}
