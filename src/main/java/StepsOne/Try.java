package StepsOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Try {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl");

        WebElement proba = driver.findElement(By.xpath("//section[@id='content']/section/h2"));
        String prooba = proba.getText();
        System.out.println(prooba);





    }
}
