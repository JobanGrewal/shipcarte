package io.pragra.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//div/div/div[1]/div/div[3]/div/form/div[1]/input" )
    private WebElement username;

    @FindBy(xpath = "//div/div/div[1]/div/div[3]/div/form/div[2]/div/input")
    private WebElement password;


    @FindBy(xpath = "//div/div/div[1]/div/div[3]/div/form/button")
    private WebElement submit;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage keyInUsername(String username){
        this.username.sendKeys(username);
        return this;
    }

   public LoginPage keyInPassword(String password){
        this.password.sendKeys(password);
        return this;
   }
    public void submit(){
        this.submit.click();
    }
}
