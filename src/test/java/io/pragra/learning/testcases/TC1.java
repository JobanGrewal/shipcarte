package io.pragra.learning.testcases;

import io.pragra.learning.drivermanager.DriverManager;
import io.pragra.learning.pages.DashboardPage;
import io.pragra.learning.pages.FavoritesPage;
import io.pragra.learning.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TC1 {

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
        FavoritesPage favorites = new FavoritesPage(driver);
        favorites.clickQuote();
        Thread.sleep(4000);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get("quoteDetails.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
