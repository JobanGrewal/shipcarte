package io.pragra.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"nav-bar\"]/nav/div[1]/div/div[1]/a")
    protected WebElement favoritesLink;
    @FindBy(xpath = "//*[@id=\"nav-bar\"]/nav/div[1]/div/div[2]/a/span[2]" )
    protected WebElement dashboardLink;
    @FindBy(xpath = "//*[@id=\"nav-bar\"]/nav/div[1]/div/div[3]/a/span[2]" )
    protected WebElement quoteLink;
    @FindBy(xpath = "//*[@id=\"nav-bar\"]/nav/div[1]/div/div[4]/a/span[2]")
    protected WebElement quoteHistorylink;
    @FindBy(xpath ="//*[@id=\"nav-bar\"]/nav/div[1]/div/div[5]/a/span[2]" )
    protected WebElement shipmentLink;
    @FindBy(xpath ="//*[@id=\"nav-bar\"]/nav/div[1]/div/div[6]/a/span[2]" )
    protected WebElement addressBookLink;


    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public FavoritesPage clickFavorites(){
        this.favoritesLink.click();
        return new FavoritesPage(driver);
    }
    public QuotePage clickQuote(){
        this.quoteLink.click();
        return new QuotePage(driver);
    }

}
