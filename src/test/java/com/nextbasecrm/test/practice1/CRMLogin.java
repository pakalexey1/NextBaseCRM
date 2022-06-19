package com.nextbasecrm.test.practice1;

import com.nextbasecrm.test.utilities.ConfigurationReader;
import com.nextbasecrm.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CRMLogin {


    public static void crmLogin(String username, String password){

        //1- go to the url
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //2- Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.name("USER_LOGIN"));
        inputUsername.sendKeys(username);

        //3- Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys(password);

        //4- Click to Log In button
        Driver.getDriver().findElement(By.xpath("//input[@value='Log In']")).click();


    }
}
