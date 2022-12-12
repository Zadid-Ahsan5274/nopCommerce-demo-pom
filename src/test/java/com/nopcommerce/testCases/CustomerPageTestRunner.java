package com.nopcommerce.testCases;

import com.nopcommerce.pageObjects.CustomerPage;
import com.nopcommerce.pageObjects.DashboardPage;
import com.nopcommerce.pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class CustomerPageTestRunner extends BaseClass{

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @BeforeMethod
    public void doLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doAdminLogin(email,password);
        Thread.sleep(5000);
        customerPage = new CustomerPage(driver);
        customerPage.customerLink.click();
        driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void searchByEmail() throws InterruptedException {
        customerPage = new CustomerPage(driver);
        //driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
        customerPage.emailSearchField.sendKeys("arthur_holmes@nopCommerce.com");
        customerPage.searchCustomers.click();
        Thread.sleep(5000);
        List<WebElement> email_cells = driver.findElements(By.tagName("td"));
        String email_text = email_cells.get(1).getText();
        Assert.assertTrue(email_text.equals("arthur_holmes@nopCommerce.com"));
    }

    @Test(priority = 2)
    public void searchByDOB() throws InterruptedException {
        customerPage = new CustomerPage(driver);
        //driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
        customerPage.dobMonthDropdown.click();
        for(int i = 0; i < 4; i++){
            customerPage.dobMonthDropdown.sendKeys(Keys.ARROW_DOWN);
        }
        customerPage.dobMonthDropdown.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        customerPage.dobDayDropdown.click();
        for(int i = 0; i < 20; i++){
            customerPage.dobDayDropdown.sendKeys(Keys.ARROW_DOWN);
        }
        customerPage.dobDayDropdown.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        customerPage.searchCustomers.click();
        String table_text = driver.findElement(By.className("dataTables_empty")).getText();
        Assert.assertTrue(table_text.equals("No data available in table"));
    }

    @Test(priority = 3)
    public void searchByCustomerRole() throws InterruptedException {
        customerPage = new CustomerPage(driver);
        //driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
        customerPage.customerRolesSearchField.click();
        customerPage.customerRolesSearchField.sendKeys(Keys.ARROW_UP);
        customerPage.customerRolesSearchField.sendKeys(Keys.ARROW_UP);
        //customerPage.customerRolesSearchField.sendKeys(Keys.ARROW_UP);
        customerPage.customerRolesSearchField.sendKeys(Keys.ENTER);
        customerPage.searchCustomers.click();
        Thread.sleep(5000);
        List<WebElement> email_cells = driver.findElements(By.tagName("td"));
        String email_text = email_cells.get(3).getText();
        if(email_text.contains("Registered")&&(email_text.contains("Forum Moderators"))){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    @AfterMethod
    public void doLogout(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.lnkLogout.click();
    }

}
