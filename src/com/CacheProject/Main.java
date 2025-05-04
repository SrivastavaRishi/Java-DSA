package com.CacheProject;

public class Main {
    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.getAll();
        cache.post("v1", "k1");
        cache.getAll();
        cache.delete("v1");
        System.out.println(cache.get("lak"));
    }
}
