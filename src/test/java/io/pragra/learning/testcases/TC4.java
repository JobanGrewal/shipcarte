// Sort Order Number in increasing order
package io.pragra.learning.testcases;

import io.pragra.learning.drivermanager.DriverManager;
import io.pragra.learning.pages.DashboardPage;
import io.pragra.learning.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC4 {
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
        Thread.sleep(3000);
        dashboard.clickSortIcon();
        Thread.sleep(5000);
        driver.quit();
    }
}


