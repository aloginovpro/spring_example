package ru.loginov.spring.databind;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDatabind<T> implements Databind<T> {

    private final ObjectMapper mapper = new ObjectMapper();

    private final Class<T> clazz;
    private final File file;

    public JsonDatabind(
            Class<T> clazz,
            String fileName
    ) {
        this.clazz = clazz;
        file = new File(fileName);
    }

    @Override
    public void save(T value) {
        try {
            mapper.writeValue(file, value);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save", e);
        }
    }

    @Override
    public T load() {
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load", e);
        }
    }

}
