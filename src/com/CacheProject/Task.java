package com.CacheProject;

import java.util.concurrent.CompletableFuture;

class Task<K, V> {
    Operation operation;
    K key;
    V value;
    CompletableFuture<V> future; // only used for GET

    Task(Operation operation, K key, V value) {
        this(operation, key, value, null);
    }

    Task(Operation operation, K key, V value, CompletableFuture<V> future) {
        this.operation = operation;
        this.key = key;
        this.value = value;
        this.future = future;
    }
}
