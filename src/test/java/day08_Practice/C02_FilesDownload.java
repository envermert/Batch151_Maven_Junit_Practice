package day08_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        Thread.sleep(3000);








        File silinicekDosya = new File("/Users/enver/Downloads");
        silinicekDosya.delete();

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("(//a)[21]")).click();
        Thread.sleep(3000);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini
        // test ediniz
        ///Users/enver/Downloads/some-file.txt
       // Assert.assertTrue(Files.exists(Paths.get("Users/enver/Downloads/some-file.txt")));


        //daha dinamik hale getirelim
        //Users/enver                           /Downloads/some-file.txt


        String farkliKisim =System.getProperty("user.home");
        String ortakKisim = "/Downloads/some-file.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
