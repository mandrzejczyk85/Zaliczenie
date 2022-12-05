package StepsTwo.PagesTwo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ChoiceClotesPageTwo {

    public ChoiceClotesPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='products']/div[3]/div/div[2]/article/div/div/a")
    WebElement hummingbird;
    @FindBy(xpath = "//div[@class='current-price']/span[2]")
    WebElement discount;
    @FindBy(xpath = "//select[@id='group_1']")
    WebElement size;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement quantityClick;
    @FindBy(xpath = "//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']")
    WebElement quantity;
    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    WebElement addToCartBtn;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkout;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement proceedToCheck;

    public void clothes() {
        hummingbird.click();
        Assert.assertEquals(discount.getText(), "SAVE 20%", "It's not ok");
        Assert.assertTrue(discount.isDisplayed());
    }

    public void ChoiceSizeQuantityAndProceedToCheck(String clothesSize,int howManyClothes) throws InterruptedException {
        Select choiceSize = new Select(size);
        choiceSize.selectByVisibleText(clothesSize);

        Thread.sleep(300);

        for (int i = 1; i < howManyClothes; i++) {
            quantity.click();
        }
        addToCartBtn.click();
        checkout.click();
        proceedToCheck.click();
    }
}
//        WebElement sizeTitle = driver.findElement(By.xpath("//form[@id='add-to-cart-or-refresh']/div[1]/div/span"));
//        wait.until(ExpectedConditions.textToBe((By) sizeTitle, "Size: M"));
//        Thread.sleep(300);
//        String sizerrrr = sizeTitle.getText();