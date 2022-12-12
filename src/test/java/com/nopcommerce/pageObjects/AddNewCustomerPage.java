package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
    WebDriver driver;

    @FindBy(id = "Email")
    public WebElement emailFieldInput;

    @FindBy(id = "Password")
    public WebElement passwordFieldInput;




    public AddNewCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
