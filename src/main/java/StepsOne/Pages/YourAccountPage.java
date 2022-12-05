package StepsOne.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='addresses-link']/span/i")
    WebElement addressBtn;

    public void addressButton() {
        addressBtn.click();
    }

}
