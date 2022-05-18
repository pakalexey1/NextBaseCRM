package com.nextbasecrm.test.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS011test {

    final String USERNAME1 = "helpdesk1@cybertekschool.com";
    final String USERNAME2 = "helpdesk2@cybertekschool.com";
    final String PASSWORD = "UserUser";

    @Test
    public void testTS011_1 (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://login.nextbasecrm.com/");
        WebElement usernameBox = driver.findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys(USERNAME1);

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        String expectedHeader1 = "CRM";
        String expectedHeader2 = "24";

        WebElement header1 = driver.findElement(By.xpath("//a[@id='logo_24_a']/span/span[@class='logo-text']"));
        String actualHeader1 = header1.getText();

        WebElement header2 = driver.findElement(By.xpath("//a[@id = 'logo_24_a']/span/span[@class='logo-color']"));

        String actualHeader2 = header2.getText();

        Assert.assertEquals(expectedHeader1, actualHeader1);
        Assert.assertEquals(expectedHeader2, actualHeader2);

        //System.out.println("Expected Header1 Test passed: " + expectedHeader1.equals(actualHeader1));
        //System.out.println("Expected Header2 Test passed: " + expectedHeader2.equals(actualHeader2));

        driver.quit();

    }

    @Test
    public void testTS011_2 (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login.nextbasecrm.com/");
        WebElement usernameBox = driver.findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys(USERNAME2);

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        String expectedHeader1 = "CRM";
        String expectedHeader2 = "24";

        WebElement header1 = driver.findElement(By.xpath("//a[@id='logo_24_a']/span/span[@class='logo-text']"));
        String actualHeader1 = header1.getText();

        WebElement header2 = driver.findElement(By.xpath("//a[@id = 'logo_24_a']/span/span[@class='logo-color']"));

        String actualHeader2 = header2.getText();

        Assert.assertEquals(expectedHeader1, actualHeader1);
        Assert.assertEquals(expectedHeader2, actualHeader2);

        driver.quit();
    }
}
