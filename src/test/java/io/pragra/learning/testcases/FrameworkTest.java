package io.pragra.learning.testcases;

import io.pragra.learning.conf.FrameWorkConfig;
import io.pragra.learning.drivermanager.DriverManager;
import io.pragra.learning.pages.*;
import io.pragra.learning.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FrameworkTest {
    @Test
    public void testBrowserType() {
        String browser = FrameWorkConfig.getProperty("browser.type");

        Assert.assertEquals(browser,"CHROME","Mismatch of Broswertype");
    }

    @Test
    public void osTest() throws InterruptedException {
       WebDriver driver = DriverManager.getDriver();
       driver.get("https://staging.shipcarte.com/#/signin");
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(driver);

        login
                .keyInUsername("akhil.95")
                .keyInPassword("Akhil@1995")
                .submit();
        Thread.sleep(3000);


        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickFavorites();
        Thread.sleep(5000);
//        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("window.scrollBy(0,250)");
        FavoritesPage favorites = new FavoritesPage(driver);
        Assert.assertEquals(favorites.getHeading(),"Favorite Orders");
        favorites
                .keyInFilter();
                //.keyInSearchBox("john")
                //.apply();
        //favorites.clickQuote();

        Thread.sleep(5000);
        driver.quit();
    }

}
