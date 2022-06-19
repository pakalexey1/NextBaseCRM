package com.nextbasecrm.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
Q: How are we able to return the same instance of our driver?
- We implemented Singleton Design Pattern.

Q: What is a design pattern?
- Repetable solution to a repeating issue.

Q: Singleton Design Pattern:
- Singleton Design Pattern makes sure we are returning the same instance every time we call our method.
- In our case we are trying to return the same instance of DRIVER
     */

    private Driver() {
        //private - to close access to the object from outside the class
    }

    private static WebDriver driver; // to close access from outside the class, and static - to be able to access through the Class without creating an obj

    public static WebDriver getDriver() {
        // created a reusable utility method, which will return same driver instance when we call it

        if (driver == null) { //1st time always null, and it will go inside the if statement

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.quit(); //this line terminates the existing session. value will not even be null
            driver = null;
        }
    }

}
