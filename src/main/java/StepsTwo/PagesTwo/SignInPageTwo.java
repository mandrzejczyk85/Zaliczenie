package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageTwo {

    public String login = "testerski@tester.pl";
    public String pswd = "aaaaa";

    public SignInPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='field-email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='field-password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement signInBtn;
    @FindBy(xpath = "//li[@id='category-3']/a")
    WebElement clothes;

    public void logInToPage() {
        email.sendKeys(login);
        password.sendKeys(pswd);
        signInBtn.click();
    }
}
