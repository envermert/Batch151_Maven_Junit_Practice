package day11_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {

        girisYap();

        //input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i dinamik olarak yazdirin.

        int satir = 3;
        int sutun = 3;

        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(arananCell.getText());


    }

    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // GELİSMİS
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // GÜVENLİ DEGİL


        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // LOG IN

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();



    }
}
