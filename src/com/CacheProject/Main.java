package com.CacheProject;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CacheStore<String, String> cache = CacheStore.getInstance();
        cache.set("v1", "k11");
        cache.set("v2", "k12");
        cache.set("v2", "k121");
        System.out.println(cache.get("v2"));
//        cache.delete("v2");
//        cache.clear();
//        Thread.sleep(2000);
        System.out.println(cache.get("v2"));
    }
}
