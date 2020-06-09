package com.mashibing;

@FunctionalInterface
public interface FireStrategy<T> {
    void fire(T t);
}
