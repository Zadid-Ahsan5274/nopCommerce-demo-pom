package com.nopcommerce.testCases;

import com.nopcommerce.pageObjects.CustomerPage;
import com.nopcommerce.pageObjects.DashboardPage;
import com.nopcommerce.pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void searchByEmail() throws InterruptedException {
        customerPage = new CustomerPage(driver);
        customerPage.emailSearchField.sendKeys("arthur_holmes@nopCommerce.com");
        customerPage.searchCustomers.click();
        Thread.sleep(5000);
        List<WebElement> email_cells = driver.findElements(By.tagName("td"));
        String email_text = email_cells.get(1).getText();
        Assert.assertTrue(email_text.equals("arthur_holmes@nopCommerce.com"));
    }

    @Test(priority = 2)
    public void searchByDOB(){
        customerPage = new CustomerPage(driver);
        customerPage.dobMonthDropdown.click();
        for(int i = 0; i < 4; i++){
            customerPage.dobMonthDropdown.sendKeys(Keys.ARROW_DOWN);
        }
        customerPage.dobMonthDropdown.sendKeys(Keys.ENTER);
        customerPage.dobDayDropdown.click();
        for(int i = 0; i < 20; i++){
            customerPage.dobDayDropdown.sendKeys(Keys.ARROW_DOWN);
        }
        customerPage.dobDayDropdown.sendKeys(Keys.ENTER);
        customerPage.searchCustomers.click();
        String table_text = driver.findElement(By.className("dataTables_empty")).getText();
        Assert.assertTrue(table_text.equals("No data available in table"));
    }

    @AfterMethod
    public void doLogout(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.lnkLogout.click();
    }

}
