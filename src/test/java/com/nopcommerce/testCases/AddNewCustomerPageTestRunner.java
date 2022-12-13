package com.nopcommerce.testCases;

import com.nopcommerce.pageObjects.AddNewCustomerPage;
import com.nopcommerce.pageObjects.CustomerPage;
import com.nopcommerce.pageObjects.DashboardPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCustomerPageTestRunner extends BaseClass{

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddNewCustomerPage addNewCustomerPage;
    CustomerPage customerPage;

    @BeforeMethod
    public void doLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doAdminLogin(email,password);
        Thread.sleep(5000);
        customerPage = new CustomerPage(driver);
        customerPage.customerLink.click();
        driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
        Thread.sleep(5000);
        customerPage.addNewCustomerBtn.click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void createNewEmployee() throws InterruptedException {
        addNewCustomerPage = new AddNewCustomerPage(driver);
        /*addNewCustomerPage.setEmail("az_test6@mail.com");
        addNewCustomerPage.setPassword("P@ssword123");
        addNewCustomerPage.setFirstName("Tom");
        addNewCustomerPage.setLastName("Rodger");*/
        Utils utils = new Utils();
        utils.generateRandomData();
        String fName = utils.getFirstname();
        String lName = utils.getLastname();
        String userName = utils.getUsername();
        String email = userName +"@mail.com";
        addNewCustomerPage.setEmail(email);
        addNewCustomerPage.setPassword("P@ssword123");
        addNewCustomerPage.setFirstName(fName);
        addNewCustomerPage.setLastName(lName);
        //addNewCustomerPage.setGender();
        addNewCustomerPage.setDOB("4/20/1996");
        addNewCustomerPage.setCompanyName("ABC Company");
        addNewCustomerPage.taxExempt();
        addNewCustomerPage.setVendor();
        addNewCustomerPage.setAdminComment("This customer is generated automatically");
        addNewCustomerPage.saveButtons.click();
        Thread.sleep(5000);
        String expected_message = "The new customer has been added successfully.";
        String actual_message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
        Assert.assertTrue(actual_message.contains(expected_message));
    }

    @AfterMethod
    public void doLogout(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.lnkLogout.click();
    }



}
