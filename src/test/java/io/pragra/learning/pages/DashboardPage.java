package io.pragra.learning.pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


    @FindBy(xpath = "//div/div/div[2]/div[2]/div[1]/div/div/img")
    protected WebElement threeDotMenu;
    @FindBy(xpath = "//div/div/div[2]/div[2]/div[1]/div/div/div/a" )
    protected WebElement exportExcelLink;


    @FindBy(xpath = "//*[@id=\"Shipments\"]/thead/tr/th[1]/span")
    protected WebElement sortIcon;


    @FindBy(xpath = "//*[@id=\"Shipments\"]/tbody/tr[1]/td[9]/div[1]/img")
    protected WebElement horizontalThreeDotMenu;
    @FindBy(xpath = "//*[@id=\"Shipments\"]/tbody/tr[1]/td[9]/div[2]/a[1]")
    protected WebElement shipAgainLink;


    @FindBy(xpath = "//*[@id=\"Shipments\"]/tbody/tr[1]/td[7]/img")
    protected WebElement downIcon;


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

    // Method to click Three Dot menu
    public void clickThreeDotMenu(){
        Actions action = new Actions(driver);
        action.moveToElement(threeDotMenu).click().build().perform();
        this.exportExcelLink.click();

    }

    // Method to click Sort icon next to Order Number
    public void clickSortIcon(){
        this.sortIcon.click();
    }

    // Method to click Horizontal three dot menu
    public void clickHorizontalThreeDotMenu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(horizontalThreeDotMenu).click().build().perform();
        this.shipAgainLink.click();

    }


   // Method to click down icon present next to quote price
    public void clickDownIcon(){
        Actions action1 = new Actions(driver);
        action1.moveToElement(downIcon).perform();
    }

}
