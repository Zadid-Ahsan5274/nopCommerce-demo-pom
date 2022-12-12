package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "Email")
    WebElement txtEmail;

    @FindBy(id = "Password")
    WebElement txtPassword;

    @FindBy(id = "RememberMe")
    WebElement checkBoxRememberMe;

    @FindBy(id = "Email-error")
    public WebElement emailWarningText;

    @FindBy(className = "validation-summary-errors")
    public WebElement noCustomerFoundWarning;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doAdminLogin(String email, String pwd) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
        checkBoxRememberMe.click();
        btnSubmit.click();
    }
}
