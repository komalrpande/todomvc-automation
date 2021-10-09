package com.todomvc.commonutils;


import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    public Properties properties;
    private final String propertyFilePath = "src/test/resources/config/configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String property(String propertyName) {
        String property = properties.getProperty(propertyName);
        if (property != null)
            return property;
        else
            throw new RuntimeException(propertyName + "not specified in the configuration.properties file.");
    }
}
