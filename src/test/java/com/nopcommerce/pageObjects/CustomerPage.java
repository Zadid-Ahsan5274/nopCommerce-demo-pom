package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

   @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
   public WebElement customerLink;

   @FindBy(xpath = "//a[@class='btn btn-primary']")
   public WebElement addNewCustomerBtn;

   @FindBy(id = "search-customers")
   public WebElement searchCustomers;

   @FindBy(id = "SearchEmail")
   public WebElement emailSearchField;

   @FindBy(id = "SearchFirstName")
   public WebElement firstNameSearchField;

   @FindBy(id = "SearchLastName")
   public WebElement LastNameSearchField;

   @FindBy(id = "SearchMonthOfBirth")
   public WebElement dobMonthDropdown;

   @FindBy(id = "SearchDayOfBirth")
   public WebElement dobDayDropdown;

   @FindBy(id = "SearchCompany")
   public WebElement searchCompanyField;

   @FindBy(id = "SearchIpAddress")
   public WebElement searchIPAddressField;

   @FindBy(xpath = "//input[@role='listbox']")
   public WebElement customerRolesSearchField;

   @FindBy(partialLinkText = "customers")
   public WebElement learnMoreAboutCustomersLink;

   @FindBy(id = "customers-grid")
   public WebElement customersTable;

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



}
