package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmAddressPageTwo {

    public ConfirmAddressPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='h4']/label/span")
    WebElement  addressConfirm;
    @FindBy(xpath = "//button[@class='btn btn-primary continue float-xs-right']")
    WebElement continueBtn;

    public void confirmAddress() {
        addressConfirm.click();
        continueBtn.click();
    }
}
