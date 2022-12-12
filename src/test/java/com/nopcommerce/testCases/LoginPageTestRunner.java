package com.nopcommerce.testCases;

import com.nopcommerce.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTestRunner extends BaseClass{
    LoginPage loginPage;
    @Test(priority = 1)
    public void test_LoginWithBlankEmailAndBlankPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin("","");
        Thread.sleep(5);
        Assert.assertTrue(loginPage.emailWarningText.isDisplayed());
    }

    @Test(priority = 2)
    public void test_LoginWithBlankEmailAndValidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin("",password);
        Thread.sleep(5);
        Assert.assertTrue(loginPage.emailWarningText.isDisplayed());
    }

    @Test(priority = 3)
    public void test_LoginWithBlankEmailAndInvalidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin("","admin123");
        Thread.sleep(5);
        Assert.assertTrue(loginPage.emailWarningText.isDisplayed());
    }

    @Test(priority = 4)
    public void test_LoginWithValidEmailAndBlankPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin(email,"");
        Thread.sleep(5);
        Assert.assertTrue(loginPage.noCustomerFoundWarning.isDisplayed());
    }

    @Test(priority = 5)
    public void test_LoginWithValidEmailAndInvalidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin(email,"admin123");
        Thread.sleep(5);
        Assert.assertTrue(loginPage.noCustomerFoundWarning.isDisplayed());
    }

    @Test(priority = 6)
    public void test_LoginWithInvalidEmailAndInvalidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin("admin123@yourstore.com","admin123");
        Thread.sleep(5);
        Assert.assertTrue(loginPage.noCustomerFoundWarning.isDisplayed());
    }

    @Test(priority = 7)
    public void test_LoginWithValidEmailAndValidPassword() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin(email,password);
        Thread.sleep(5);
        Assert.assertTrue(driver.getTitle().equals("Dashboard / nopCommerce administration"));
    }
}
