package io.pragra.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotePage {
    WebDriver driver;


    @FindBy(xpath = "//div/div/div[2]/div[1]/h3")
    private WebElement pageHeading1;

    public QuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getHeading1() {
        return this.pageHeading1.getText();
    }

}