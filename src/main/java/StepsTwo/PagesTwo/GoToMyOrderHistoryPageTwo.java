package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GoToMyOrderHistoryPageTwo {
    public GoToMyOrderHistoryPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    WebElement clickMyAccount;
    @FindBy(xpath = "//a[@id='history-link']")
    WebElement history;
    @FindBy(xpath = "//tbody/tr[1]/td[2][@class='text-xs-right']")
    WebElement lastOrderPrice;
    @FindBy(xpath = "//tbody/tr[1]/td[4]/span[@class='label label-pill bright']")
    WebElement lastOrderStatus;


    public void orderHistory() {
        clickMyAccount.click();
        history.click();
        Assert.assertEquals(lastOrderPrice.getText(), "€143.60", "We have a problem");
        Assert.assertTrue(lastOrderPrice.isDisplayed());
        Assert.assertEquals(lastOrderStatus.getText(), "Awaiting check payment");
        Assert.assertTrue(lastOrderStatus.isDisplayed());
    }
}

