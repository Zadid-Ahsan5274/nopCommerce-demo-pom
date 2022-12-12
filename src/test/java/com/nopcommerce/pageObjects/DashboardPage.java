package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    @FindBy(partialLinkText = "Logout")
    @CacheLookup
    public WebElement lnkLogout;

    @FindBy(xpath = "//img[@class='brand-image-xl logo-xl']")
    @CacheLookup
    public WebElement companyLogo;

    @FindBy(xpath = "//input[@placeholder='Search']")
    @CacheLookup
    public WebElement searchBox;

    @FindBy(xpath = "//i[@class='fas fa-cogs']")
    public WebElement clearCacheIcon;


    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


}
