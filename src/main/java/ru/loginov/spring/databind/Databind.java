package ru.loginov.spring.databind;

public interface Databind<T> {

    void save(T value);

    T load();

}
