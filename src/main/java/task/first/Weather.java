package task.first;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Weather {
    protected static WebDriver driver;

    public static void main (String[] args) {

        //setup
        System.setProperty("webdriver.chrome.driver", "C:/ProgramData/chocolatey/lib/chromedriver/tools/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // declaration variables
        String URL = "http://www.yandex.ru";
        String input_bar = "//*[@id=\"text\"]";
        String key = "погода";

        driver.get(URL);
        driver.findElement(By.xpath(input_bar)).sendKeys(key);
        String popup = driver.findElement(By.xpath("//li[@data-bem = '{\"suggest2-item\":{\"val\":\""+ key +"\"}}']")).findElement(By.className("suggest2-item__fact")).getText();
        System.out.println(popup);

        driver.quit();
    }
}
