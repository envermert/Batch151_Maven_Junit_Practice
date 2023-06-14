package day01_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void bestBuy() {
        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com/");

        // sayfa Title'ini alın "Best" içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Best"));

        // BestBuy logosunun görüntülendigini test edin
        WebElement logo =  driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        // Canada logosunun görüntülendigini test edin
        WebElement canadaLogo = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
        Assert.assertTrue(canadaLogo.isDisplayed());
    }
}

