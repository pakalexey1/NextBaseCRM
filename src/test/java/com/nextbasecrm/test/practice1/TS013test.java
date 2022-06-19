package com.nextbasecrm.test.practice1;

import com.nextbasecrm.test.utilities.ConfigurationReader;
import com.nextbasecrm.test.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS013test {
    @Test
    public void testTS013() {


        //"Given I am on nextbasecrm.com authorization page
        //When I enter my helpdesk user name
        //And I enter invalid password
        //And I click on Log In button
        CRMLogin.crmLogin(ConfigurationReader.getProperty("helpDeskUsername2"), "asdfsadf");


        //Then the user should see ""Incorrect login or password"" message"
        WebElement errorMessage = Driver.getDriver().findElement(By.cssSelector("div[class='errortext']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Incorrect login or password";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        Driver.closeDriver();


    }
}

/*
"Given I am on nextbasecrm.com autorization page
When I enter my helpdesk user name
And I enter invalid password
And I click on Log In button
Then the user should see "Incorrect login or password" message"

Data:
Username:
helpdesk1@cybertekschool.com
helpdesk2@cybertekschool.com

Password: asdfsadf
 */