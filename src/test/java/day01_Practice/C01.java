package day01_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {




    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void url() {
        // https://www.sahibinden.com/ sayfasina gidin
        driver.get("https://www.sahibinden.com/");

        // Title ve Url'ini alın ve yazdırın
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Title'in "Online" kelimesini içerip içermedigini test edin
        Assert.assertTrue(driver.getTitle().contains("Online"));

        // Url'in "sahibinden" kelimesini içerip içermedigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("sahibinden"));

        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");

        // Title'ini alın ve yazdırın
        System.out.println(driver.getTitle());

        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(driver.getTitle().contains("more") );

        // sahibinden.com'a geri dönün
        driver.navigate().back();

        // sayfayı yenileyin
        driver.navigate().refresh();

        // amazon.com'a tekrar gelin
        driver.navigate().forward();
    }
}
