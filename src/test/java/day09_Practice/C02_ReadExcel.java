package day09_Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    
    //Ulkeler dosyasindaki "Baskent (Ingilizce)" sutununu yazdiriniz

    @Test
    public void test01() throws IOException {

        String dosyaYolu ="src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirNumarasi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirNumarasi);
        //getLastRowNum() son satir numarasini index olarak verir.


     /*
     2.YOl:

       for (int i = 0; i <=sonSatirNumarasi ; i++) {

           String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);
        }
*/
        for (int i = 0; i <= sonSatirNumarasi ; i++) {

          String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            System.out.println(satirdakiData);

        }
    }
}
