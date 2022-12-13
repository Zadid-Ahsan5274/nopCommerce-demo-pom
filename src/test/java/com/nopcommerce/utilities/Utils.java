package com.nopcommerce.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    private String firstname;
    private String lastname;
    private String username;

    public static String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public static String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static int generateRandomNumber(int min, int max) {
        int number = (int) (Math.floor(Math.random() * ((max - min) + min)));
        return number;
    }

    public void generateRandomData() {
        Faker faker = new Faker();
        setFirstname(faker.name().firstName());
        setLastname(faker.name().lastName());
        setUsername(faker.name().username());
    }
}
