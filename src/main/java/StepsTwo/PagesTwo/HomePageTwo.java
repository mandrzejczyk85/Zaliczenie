package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTwo {
    public HomePageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signIn;

    public void signInPage() {
        signIn.click();
    }
}
