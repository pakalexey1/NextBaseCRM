package com.nextbasecrm.test.practice1;

import com.nextbasecrm.test.utilities.ConfigurationReader;
import com.nextbasecrm.test.utilities.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TS012test {
    @Test
    public void testTS012() {

        final String USERNAME = "asdfas@cybertekschool.com";

        CRMLogin.crmLogin(USERNAME, ConfigurationReader.getProperty("password"));
        String expectedMessage1 = "Incorrect login or password";

        WebElement errorMsg = Driver.getDriver().findElement(By.className("errortext"));

        System.out.println(errorMsg.getText());

        String actualMessage1 = errorMsg.getText();

        Assert.assertEquals(expectedMessage1, actualMessage1);

        Driver.closeDriver();
    }
}
