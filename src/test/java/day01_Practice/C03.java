package day01_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.List;

public class C03 {





    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazon() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("nutella", Keys.ENTER);

        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın*
//            for (int i = 0; i <25 ; i++) {
//
//            List<WebElement> urunler = driver.findElements(By.xpath("(//img[@class='s-image'])[position()<=25 and position()>0]"));
//            urunler.get(i).click();
//            System.out.println(driver.getTitle());
//            driver.navigate().back();

        List<WebElement> nutellaUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0; i <nutellaUrunleri.size() ; i++) {

            nutellaUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

            nutellaUrunleri.get(i).click();

            System.out.println((i+1) + ".URUN TİTLE : " + driver.getTitle());

            driver.navigate().back();




        }
    }
}
