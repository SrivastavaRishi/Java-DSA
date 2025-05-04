package com.CacheProject;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, String>hashMap;

    Cache(){
        hashMap = new HashMap<>();
    }

    public String get(String key){
        return hashMap.get(key);
    }

    public boolean post(String key, String value){
        try{
            hashMap.put(key, value);
        } catch(Exception e){
            System.out.println("Error message : "+ e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(String key){
        try{
            hashMap.remove(key);
        } catch(Exception e){
            System.out.println("Error message : "+ e.getMessage());
            return false;
        }
        return true;
    }

    public void getAll(){
        if(hashMap.isEmpty()){
            System.out.println("Empty hashmap !!");
        }
        for(String key: hashMap.keySet()){
            System.out.println(key + ":: " + hashMap.values());
        }
    }
}
