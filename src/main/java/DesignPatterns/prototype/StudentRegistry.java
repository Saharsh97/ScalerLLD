package main.java.DesignPatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String, Student> map = new HashMap<>();

    public void register(String key, Student baseObject){
        map.put(key, baseObject);
    }

    public Student get(String key){
        return map.get(key);
    }
}
