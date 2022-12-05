package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPageTwo {
    public PaymentPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='payment-option-1']")
    WebElement payByCheck;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement agreeCheckbox;
    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    WebElement placeOrder;


    public void paymentChoice() {
        payByCheck.click();
        agreeCheckbox.click();
        placeOrder.click();
    }
}
