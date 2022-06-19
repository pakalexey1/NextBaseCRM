package com.nextbasecrm.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create Properties class object (coming from Java, helps to reach to configuration.properties)
    private static Properties properties = new Properties();

    //running 1st, doing it ONE time
    //need static since static have to be initialized in static block ONLY
    static {

        try {
    //2- We need to open the file in the Java memory
            FileInputStream file = new FileInputStream("configuration.properties");
            //now we have to load this file
    //3- We need to load the "properties" object with the fileStream
            properties.load(file);
            //after we have to close this file, it shouldn't be opened, we have to free up the memory
            file.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading configuration properties file");
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
    //4- Use properties object and getProperty method to pass "key" and read "value"
        return properties.getProperty(key);
    }


}
