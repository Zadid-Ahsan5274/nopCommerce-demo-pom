package com.nopcommerce.testCases;

import com.nopcommerce.pageObjects.DashboardPage;
import com.nopcommerce.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTestRunner extends BaseClass{
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void doLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doAdminLogin(email,password);
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void test_VerifyDashboardPageTitle(){
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(driver.getTitle().equals("Dashboard / nopCommerce administration"));
    }

    @Test(priority = 2)
    public void verifyCompanyLogoPresence(){
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.companyLogo.isDisplayed());
    }

    @Test(priority = 3)
    public void searchFunctionality(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.searchBox.sendKeys("Customers");
    }

    @Test(priority = 4)
    public void clearCache() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clearCacheIcon.click();
        driver.findElement(By.xpath("//span[normalize-space()='Clear cache']")).click();
        Thread.sleep(7000);
        Assert.assertTrue(driver.findElement(By.className("alert-dismissable")).isDisplayed());
    }

    @AfterMethod
    public void doLogout(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.lnkLogout.click();
    }
}
