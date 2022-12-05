package StepsTwo.PagesTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPageTwo {

    public ClothesPageTwo(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@id='category-3']/a")
    WebElement clothes;

    public void goToClothesPage() {
        clothes.click();
    }
}
