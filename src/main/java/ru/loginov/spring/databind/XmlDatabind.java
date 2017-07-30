package ru.loginov.spring.databind;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XmlDatabind<T> implements Databind<T> {

    private final File file;

    public XmlDatabind(String fileName) {
        file = new File(fileName);
    }

    @Override
    public void save(T value) {
        try (
                FileOutputStream stream = new FileOutputStream(file);
                XMLEncoder encoder = new XMLEncoder(stream)
        ) {
            encoder.writeObject(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T load() {
        try (
                FileInputStream stream = new FileInputStream(file);
                XMLDecoder encoder = new XMLDecoder(stream)
        ) {
            return (T) encoder.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load", e);
        }
    }

}
