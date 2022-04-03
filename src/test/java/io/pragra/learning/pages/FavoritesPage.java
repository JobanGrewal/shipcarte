package io.pragra.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FavoritesPage {
    WebDriver driver;

    @FindBy(xpath = "//div/div/div[2]/div/div[1]/div[1]/div/span")
    private WebElement pageHeading;

    @FindBy(xpath = "//div/div/div[2]/div/div[2]/div/form/div/div/div[1]/select")
    private WebElement filters;

    @FindBy(xpath =" //div/div/div[2]/div/div[2]/div/form/div/div/div[2]/div/input" )
    private WebElement startDate;

    @FindBy(xpath = "//div/div/div[2]/div/div[2]/div/form/div/div/div[3]/div/input")
    private WebElement endDate;


    @FindBy(id = "myInput")
    private WebElement searchbox;

    @FindBy(xpath = "//div/div/div[2]/div/div[2]/div/form/div/div/div[5]/button")
    private WebElement applybutton;

    @FindBy(xpath = "//div/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[7]/button")
    private WebElement quoteLink;

//    @FindBy(xpath = "//div/div/div[2]/div/div[2]/div/div[2]/div[2]/ngb-pagination/ul/li[4]/a")
//    private WebElement nextPage;

    public FavoritesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public String getHeading(){
        return this.pageHeading.getText();
    }

    public FavoritesPage keyInFilter(){
        Select select = new Select(filters);
        select.selectByValue("LTL");
        return this;
    }

    public FavoritesPage keyInStartDate(String startDate){
        this.startDate.sendKeys(startDate);
        return this;
    }


    public FavoritesPage keyInEndDate(String endDate){
        this.endDate.sendKeys(endDate);
        return this;
    }
    public FavoritesPage keyInSearchBox(String searchbox){
        this.searchbox.sendKeys(searchbox);
        return this;
    }

    public void apply(){
        this.applybutton.click();
    }

    public QuotePage clickQuote(){
        this.quoteLink.click();
        return new QuotePage(driver);
    }

//    public void nextPage(){
//        this.nextPage.click();
//    }
}
