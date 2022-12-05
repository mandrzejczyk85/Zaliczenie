package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPAgeTwo {
    public ShippingMethodPAgeTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='col-sm-1']/span")
    WebElement deliveryOption;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    WebElement continueBtn;

    public void shippingMethod() {
        deliveryOption.click();
        continueBtn.click();
    }
}
