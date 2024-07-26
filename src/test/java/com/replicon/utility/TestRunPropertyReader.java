package com.replicon.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestRunPropertyReader {

    static Properties properties = new Properties();

    public static String readProperties(String key) {
        String propertiesFile = "src/test/resources/testrun.properties";
        try {
            FileInputStream fis = new FileInputStream(propertiesFile);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException found while reading: " + propertiesFile);
        } catch (IOException e) {
            System.out.println("IOException found while reading: " + propertiesFile);
        }
        return properties.getProperty(key);
    }

}
