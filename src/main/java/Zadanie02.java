import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Zadanie02 {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl");
        //------------------------------------------------------------------------------------------------------------
        //      1   zaloguje się na tego samego użytkownika z zadania 1
        //------------------------------------------------------------------------------------------------------------
        WebElement signIn = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signIn.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='field-email']"));
        email.sendKeys("testerski@tester.pl");
        WebElement password = driver.findElement(By.xpath("//input[@id='field-password']"));
        password.sendKeys("aaaaa");
        WebElement signInBtn = driver.findElement(By.xpath("//button[@id='submit-login']"));
        signInBtn.click();
        //------------------------------------------------------------------------------------------------------------
        //  2 wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
        //------------------------------------------------------------------------------------------------------------
        WebElement clothes = driver.findElement(By.xpath("//li[@id='category-3']/a"));
        clothes.click();
        WebElement hummingbird = driver.findElement(By.xpath("//section[@id='products']/div[3]/div/div[2]/article/div/div/a"));
        hummingbird.click();
        WebElement discount = driver.findElement(By.xpath("//div[@class='current-price']/span[2]"));
        Assert.assertEquals(discount.getText(), "SAVE 20%", "It's not ok");
        Assert.assertTrue(discount.isDisplayed());
        //-------------------------------------------------------------------------------------------------------------
        //  3   wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
        //-------------------------------------------------------------------------------------------------------------
        WebElement size = driver.findElement(By.xpath("//select[@id='group_1']"));
        Select choseSize = new Select(size);
        choseSize.selectByVisibleText("M");
        Thread.sleep(300);
        //-------------------------------------------------------------------------------------------------------------
        //  4   wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
        //-------------------------------------------------------------------------------------------------------------
//            WebElement quantityClick = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
//            quantityClick.click();
        WebElement quantity = driver.findElement(By.xpath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']"));
        for (int i = 1; i < 5; i++) {
            quantity.click();
        }
//        quantity.click();
//        quantity.sendKeys(Keys.BACK_SPACE); żeby skasować jedynkę
//        quantity.sendKeys("5");
        //-------------------------------------------------------------------------------------------------------------
        //  5   dodaj produkt do koszyka,
        //-------------------------------------------------------------------------------------------------------------
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"));
        addToCartBtn.click();
        //-------------------------------------------------------------------------------------------------------------
        //  6   przejdzie do opcji - checkout,
        //-------------------------------------------------------------------------------------------------------------
        WebElement checkout = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        checkout.click();
        WebElement proceedToCheck = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        proceedToCheck.click();
        //-------------------------------------------------------------------------------------------------------------
        //  7   potwierdzi address (możesz go dodać wcześniej ręcznie),
        //-------------------------------------------------------------------------------------------------------------
        WebElement addressConfirm = driver.findElement(By.xpath("//header[@class='h4']/label/span"));
        addressConfirm.click();
        WebElement continueBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary continue float-xs-right']"));
        continueBtn.click();
        //-------------------------------------------------------------------------------------------------------------
        //  8   wybierze metodę odbioru - PrestaShop "pick up in store",
        //-------------------------------------------------------------------------------------------------------------
        WebElement deliveryOption = driver.findElement(By.xpath("//div[@class='col-sm-1']/span"));
        deliveryOption.click();
        WebElement continueButton = driver.findElement(By.xpath("//button[@name='confirmDeliveryOption']"));
        continueButton.click();
        //-------------------------------------------------------------------------------------------------------------
        //  9   wybierze opcję płatności - Pay by Check, kliknie na "order with an obligation to pay",
        //-------------------------------------------------------------------------------------------------------------
        WebElement payByCheck = driver.findElement(By.xpath("//input[@id='payment-option-1']"));
        payByCheck.click();
        WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        agreeCheckbox.click();
        WebElement placeOrder = driver.findElement(By.xpath("//button[@class='btn btn-primary center-block']"));
        placeOrder.click();
        //-------------------------------------------------------------------------------------------------------------
        //  10  zrobi screenshot z potwierdzeniem zamówienia i kwotą.
        //-------------------------------------------------------------------------------------------------------------
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C:/CodersLab/Selenium/FullPageScreenshot.png"));
        //-------------------------------------------------------------------------------------------------------------
        //  11  Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek)
        //-------------------------------------------------------------------------------------------------------------
        WebElement clickMyAccount = driver.findElement(By.xpath("//span[@class='hidden-sm-down']"));
        clickMyAccount.click();
        WebElement history = driver.findElement(By.xpath("//a[@id='history-link']"));
        history.click();
        //-------------------------------------------------------------------------------------------------------------
        //  12  sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment"
        //      i kwotą taką samą jak na zamówieniu dwa kroki wcześniej
        //-------------------------------------------------------------------------------------------------------------
        WebElement lastOrderPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[2][@class='text-xs-right']"));
        Assert.assertEquals(lastOrderPrice.getText(), "€143.60", "We have a problem");
        Assert.assertTrue(lastOrderPrice.isDisplayed());

        WebElement lastOrderStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/span[@class='label label-pill bright']"));
        Assert.assertEquals(lastOrderStatus.getText(), "Awaiting check payment");
        Assert.assertTrue(lastOrderStatus.isDisplayed());
    }
}

