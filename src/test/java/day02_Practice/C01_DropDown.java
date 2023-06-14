package day02_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
     driver.close();
    }


    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Books" secenegini secin

        //Dropdown 3 adimda handle edilir.
        //1-Dropdown Locate edilir.
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Select Objesi olusturulur.
        Select select = new Select(ddm);

        //3-Optionlardan birtanesi secilir.
        // select.selectByVisibleText("Books");
        // select.selectByIndex(5); // index ile secim
        // select.selectByValue("search-alias=stripbooks-intl-ship");
        ddm.sendKeys("Books");

        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucElementi.getText().contains("Java")); //1.Yol

        //String aramaSonucYazisi = aramaSonucElementi.getText();

        //Assert.assertTrue(aramaSonucYazisi.contains("Java"));




    }





}


