package StepsOne.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class YourAddressesPage {

    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//section[@id='content']/div[3]/a")
    WebElement createBtn;

    @FindBy(xpath = "//section[@id='content']/div[2]/article/div/h4")
    WebElement verifyAddress;

//    @FindBy(xpath = "//article[@class='alert alert-success']/ul/li")
//    WebElement succesfullAdd;

    @FindBy(xpath = "//section[@id='content']/div[2]/article/div[2]/a[2]")
    WebElement deleteAddress;

    @FindBy(xpath = "//article[@class='alert alert-success']/ul/li")
    WebElement verifyDeletedAddress;

    //---------------------------------------------------------------------------------
    public void createNewAddressBtn() {
        createBtn.click();
    }

    public void verifyAddAddress() {
        Assert.assertEquals(verifyAddress.getText(), "Adres Domowy", "Coś poszło nie tak");
    }
//    public void addedAddress() {
//        Assert.assertTrue(succesfullAdd.isDisplayed());
//    }
    public void delete() {
        deleteAddress.click();
    }
    public void verifyAddressDelete() {
        Assert.assertTrue(verifyDeletedAddress.isDisplayed());
    }

}
