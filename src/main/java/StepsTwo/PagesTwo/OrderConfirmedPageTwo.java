package StepsTwo.PagesTwo;

import StepsTwo.TaskTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OrderConfirmedPageTwo {
    TaskTwo zadanie2 = new TaskTwo();
    public OrderConfirmedPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void ScreenShotPage() throws IOException {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(zadanie2.driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:/CodersLab/Selenium/FullPageScreenshot.png"));
    }
}
