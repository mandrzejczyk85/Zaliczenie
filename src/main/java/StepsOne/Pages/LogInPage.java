package StepsOne.Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {


    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='field-email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='field-password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement signInBtn;

    public void login() {
        email.sendKeys("testerski@tester.pl");
        password.sendKeys("aaaaa");
        signInBtn.click();
    }
}
