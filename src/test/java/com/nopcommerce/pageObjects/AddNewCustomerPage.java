package com.nopcommerce.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddNewCustomerPage {
    WebDriver driver;

    @FindBy(id = "Email")
    public WebElement emailFieldInput;

    @FindBy(id = "Password")
    public WebElement passwordFieldInput;

    @FindBy(id = "FirstName")
    public WebElement firstNameFieldInput;

    @FindBy(id = "LastName")
    public WebElement lastNameFieldInput;

    @FindBy(id = "Gender_Male")
    public WebElement genderRadioMale;

    @FindBy(id = "Gender_Female")
    public WebElement genderRadioFemale;

    @FindBy(id= "DateOfBirth")
    WebElement calendarDOB;

    @FindBy(id = "Company")
    public WebElement companyField;

    @FindBy(id = "IsTaxExempt")
    public WebElement isTaxExemptCheckBox;

    @FindBy(className = "k-multiselect-clearable")
    public List<WebElement> rolesDropdownBox;

    @FindBy(id = "VendorId")
    public WebElement vendorField;

    @FindBy(id = "Active")
    public WebElement activeCheckBox;

    @FindBy(id = "AdminComment")
    public WebElement adminCommentTextField;

    @FindBy(className = "alert-success")
    public WebElement customerCreateSuccessAlert;

    @FindBy(name = "save")
    public WebElement saveButtons;

    public AddNewCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        emailFieldInput.sendKeys(email);
    }

    public void setPassword(String pwd) {
        passwordFieldInput.sendKeys(pwd);
    }

    public void setFirstName(String first_name){
        firstNameFieldInput.sendKeys(first_name);
    }

    public void setLastName(String last_name){
        lastNameFieldInput.sendKeys(last_name);
    }

    public void setGender(){
        genderRadioMale.click();
    }

    public void setDOB(String dob){
        calendarDOB.sendKeys(dob);
    }

    public void setCompanyName(String company){
        companyField.sendKeys(company);
    }

    public void taxExempt(){
        isTaxExemptCheckBox.click();
    }

    public void setVendor(){
        vendorField.sendKeys(Keys.ARROW_DOWN);
        vendorField.sendKeys(Keys.ENTER);
    }

    public void setAdminComment(String comment){
        adminCommentTextField.sendKeys(comment);
    }

}
