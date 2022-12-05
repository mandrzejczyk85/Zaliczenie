package StepsOne;


import StepsOne.Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskOne {

    public WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl";

    @Given("Użytkownik znajduje się na stronie głównej")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("Użytkownik wybiera opcję Sign In")
    public void goToLogInPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @And("Użytkownik wpisuje prawidłowy email i haslo a następnie zatwierdza dane poprzez wybranie przycisku zalogowania")
    public void loginInput() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login();
    }

    @And("Użytkownik klika w pole ADDRESS na stronie Your Account")
    public void clickAddressBtn() {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.addressButton();
    }

    @And("Użytkwonik klika w pole Create new address na stronie Your addresses")
    public void clickCreateNewAddressButton() {
        YourAddressesPage yourAddressPage = new YourAddressesPage(driver);
        yourAddressPage.createNewAddressBtn();
    }

    @And("^Użytkownik uzupełnia formularz danymi \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void personalDataInput(String aliaS, String addresS, String citY, String zipPostalCodE, String countrY, String phonE) {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.addAddress(aliaS,addresS,citY,zipPostalCodE,countrY,phonE);
    }

    @Then("Użytkownik zostaje przeniesiony na stronę z dodanym adresem i sprawdza poprawność danych")
        public void verifyAddress() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.verifyAddAddress();
    }
    @And("Użytkownik usuwa dodany adres i sprawdza poprawność jego usunięcia")
    public void deleteAndVerify() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.delete();
        yourAddressesPage.verifyAddressDelete();
    }

    @And("Zamykanie przeglądarki")
    public void tearDown() {
        driver.quit();
    }
}
