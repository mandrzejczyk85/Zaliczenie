package StepsOne.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationPage {

    public PersonalInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='field-alias']")
    WebElement alias;
    @FindBy(xpath = "//input[@id='field-address1']")
    WebElement address;
    @FindBy(xpath = "//input[@id='field-city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='field-postcode']")
    WebElement zipPostalCode;
    @FindBy(xpath = "//select[@id='field-id_country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='field-phone']")
    WebElement phone;
    @FindBy(xpath = "//section[@id='content']/div/div/form/footer/button")
    WebElement saveBtn;

    public void addAddress(String aliaS, String addresS, String citY, String zipPostalCodE, String countrY, String phonE) {

        alias.sendKeys(aliaS);
        address.sendKeys(addresS);
        city.sendKeys(citY);
        zipPostalCode.sendKeys(zipPostalCodE);
        Select country = new Select(this.country);
        country.selectByVisibleText(countrY);
        phone.sendKeys(phonE);
        saveBtn.submit();
    }
}
