package com.nopcommerce.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nopcommerce.utilities.ReadConfig;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getApplicationURL();
    public String email = readConfig.getEmail();
    public String password = readConfig.getPassword();
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setUp(String br) {
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equals("ff")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(baseURL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

