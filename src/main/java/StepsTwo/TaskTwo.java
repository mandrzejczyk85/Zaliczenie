package StepsTwo;

import StepsTwo.PagesTwo.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TaskTwo {

    public WebDriver driver;
    public String url = "https://mystore-testlab.coderslab.pl";

    @Given("Użytkownik znajduje się na stronie głównej strony zakupowej")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    @When("Użytkownik klika w opcję Sign In")
    public void signIn() {
        HomePageTwo homePageTwo = new HomePageTwo(driver);
        homePageTwo.signInPage();
    }
    @And("Użytkownik loguje się do założonego wcześniej konta wpisując email i hasło")
    public void logIn() {
        SignInPageTwo signInPageTwo = new SignInPageTwo(driver);
        signInPageTwo.logInToPage();
    }
    @And("Użytkownik klika w zakładkę Clothes w celu przejścia do strony z ubraniami")
    public void clothesPage() {
        ClothesPageTwo clothesPageTwo = new ClothesPageTwo(driver);
        clothesPageTwo.goToClothesPage();
    }
    @And("Użytkownik wybiera odpowiednie ubranie Hummingbird Printed Sweater oraz sprawdza czy znajduje się na nim rabat 20%")
    public void choiceClothes() {
        ChoiceClotesPageTwo choiceClotesPageTwo = new ChoiceClotesPageTwo(driver);
        choiceClotesPageTwo.clothes();
    }
    @And("^Użytkownik wybiera \"(.*)\" M, ustawia \"(.*)\" na 5 sztuk oraz dodaje zakup do koszyka$")
    public void sizeAndQuantity(String clothesSize, int howManyClothes) throws InterruptedException {
        ChoiceClotesPageTwo choiceClotesPageTwo = new ChoiceClotesPageTwo(driver);
        choiceClotesPageTwo.ChoiceSizeQuantityAndProceedToCheck(clothesSize, howManyClothes);
    }
    @And("Użytkownik potwierdza adres i klika Continue")
    public void confirmAddress() {
        ConfirmAddressPageTwo confirmAddressPageTwo = new ConfirmAddressPageTwo(driver);
        confirmAddressPageTwo.confirmAddress();
    }
    @And("Użytkownik wybiera metodę dostawy i klika Continue")
    public void deliveryMethod() {
        ShippingMethodPAgeTwo shippingMethodPAgeTwo = new ShippingMethodPAgeTwo(driver);
        shippingMethodPAgeTwo.shippingMethod();
    }
    @And("Użytkownik wybiera metodę płatności Pay by Check, potwierdza regulamin i klika Place Order")
    public void payment() {
        PaymentPageTwo paymentPageTwo = new PaymentPageTwo(driver);
        paymentPageTwo.paymentChoice();
    }
    @Then("Użytkownik zapisuje zrzut ekranu z potwierdzeniem zamówienia i kwotą")
    public void screenShot() throws IOException {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:/CodersLab/Selenium/FullPageScreenshot.png"));
    }
    @And("Użytkownik wchodzi w historię zamówień sprawdza czy zamówienie ma status Awaiting check payment oraz czy zgadza się kwota")
    public void verifyOrder() {
    GoToMyOrderHistoryPageTwo goToMyOrderHistoryPageTwo = new GoToMyOrderHistoryPageTwo(driver);
    goToMyOrderHistoryPageTwo.orderHistory();
    }

    @And("Zamknięcie przeglądarki")
    public void tearDown() {
        driver.quit();
    }



}
