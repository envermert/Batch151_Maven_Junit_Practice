package day09_Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    //Ulkeler dosyasindaki 0. satir index'in, 4.hucre index'ine yeni bir cell olusturalim.
    //olusturdugumuz hucreye "Nufus" yazdiralim.

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        //ulkeler dosyasini bizim sistemimize getirdik

        Workbook workbook = WorkbookFactory.create(fis);
        //dosyayi workbook'a atadik.

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");


        //1.Satir index'in, 4. hucre index'ine yeni bir cell olusturun
        //olusturdugunuz hucreye "15000" yazdirin.

        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(15000);

        //2.Satir index'in, 4. hucre index'ine yeni bir cell olusturun
        //olusturdugunuz hucreye 25000 yazdirin.

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(25000);



        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //datalari bizim class'imizdan ulkeler dosyasina gonderiyoruz.

        workbook.write(fos);
        //workbook'daki datalari fos'a yazdik

        fis.close();
        fos.close();
        workbook.close();


    }
}
