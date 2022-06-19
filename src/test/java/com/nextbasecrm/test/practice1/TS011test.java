package com.nextbasecrm.test.practice1;

import com.nextbasecrm.test.utilities.ConfigurationReader;
import com.nextbasecrm.test.utilities.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TS011test {


    @Test
    public void testTS011_1() {

        CRMLogin.crmLogin(ConfigurationReader.getProperty("helpDeskUsername1"), ConfigurationReader.getProperty("password"));

        String expectedHeader1 = "CRM";
        String expectedHeader2 = "24";

        WebElement header1 = Driver.getDriver().findElement(By.xpath("//a[@id='logo_24_a']/span/span[@class='logo-text']"));
        String actualHeader1 = header1.getText();

        WebElement header2 = Driver.getDriver().findElement(By.xpath("//a[@id = 'logo_24_a']/span/span[@class='logo-color']"));

        String actualHeader2 = header2.getText();

        Assert.assertEquals(expectedHeader1, actualHeader1);
        Assert.assertEquals(expectedHeader2, actualHeader2);

        //System.out.println("Expected Header1 Test passed: " + expectedHeader1.equals(actualHeader1));
        //System.out.println("Expected Header2 Test passed: " + expectedHeader2.equals(actualHeader2));

        Driver.closeDriver();

    }

    @Test
    public void testTS011_2() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement usernameBox = Driver.getDriver().findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("helpDeskUsername2"));

        WebElement passwordBox = Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        Driver.getDriver().findElement(By.className("login-btn")).click();


        String expectedHeader1 = "CRM";
        String expectedHeader2 = "24";

        WebElement header1 = Driver.getDriver().findElement(By.xpath("//a[@id='logo_24_a']/span/span[@class='logo-text']"));
        String actualHeader1 = header1.getText();

        WebElement header2 = Driver.getDriver().findElement(By.xpath("//a[@id = 'logo_24_a']/span/span[@class='logo-color']"));

        String actualHeader2 = header2.getText();

        Assert.assertEquals(expectedHeader1, actualHeader1);
        Assert.assertEquals(expectedHeader2, actualHeader2);

        Driver.closeDriver();
    }
}
