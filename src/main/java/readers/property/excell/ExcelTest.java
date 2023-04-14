package readers.property.excell;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.Test;

import java.io.*;

public class ExcelTest1 {

String file;

    @Test
    public void excelTestCreate() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Alistirma");


        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        row.createCell(0).setCellValue("Aysegul");
        row.createCell(1).setCellValue("Kurt");

        String file = "src/test/resources/datafiles/ExcelNewCalisma.xls";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

    }

    @Test
    public void testRead() throws IOException {
        String file = "src/test/resources/datafiles/ExcelNewCalisma.xls";
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("FATMA HUSNA");
        Row row = sheet.getRow(0);
        row.forEach(System.out::println);
        workbook.close();
        fileInputStream.close();

    }

    @Test
    public void excelReadWrite() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("FATMA HUSNA");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);

        row.createCell(0).setCellValue("Turkiye");
        row.createCell(1).setCellValue("Izmir");
        row.createCell(2).setCellValue("Tire");
        int lastRow = sheet.getPhysicalNumberOfRows();
        Row row1 = sheet.createRow(lastRow);
        row1.createCell(0).setCellValue(" Basarili");

        file = "src/test/resources/datafiles/ExcelNewTest3.xls";
        workbook.write(new File(file));


    }


    @Test
    public void read() throws IOException {
        String file = "src/test/resources/datafiles/ExcelNewCalisma.xls";
        FileInputStream fileInputStream1 = new FileInputStream(file);
        Workbook workbook1 = WorkbookFactory.create(fileInputStream1);
        Sheet sheet = workbook1.getSheet("FATMA HUSNA");
        int numRow = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < numRow; i++) {
            Row row = sheet.getRow(i);
            row.forEach(System.out::println);

        }
    }
}

