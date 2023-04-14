package readers.property.excell;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.Test;

import java.io.*;

public class ExcelTest {

    String file;

    public ExcelTest() throws IOException {
    }

    @Test
    public void excelTestWrite() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("KURT");


        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        row.createCell(0).setCellValue("Akla");
        row.createCell(1).setCellValue("ne isle");
        row.createCell(2).setCellValue("ugrasacagini");
        row.createCell(3).setCellValue("gonul ");
        row.createCell(4).setCellValue("ogretir.");

        int lastRow1 = sheet.getPhysicalNumberOfRows();
        Row row1 = sheet.createRow(lastRow1);
        row1.createCell(0).setCellValue(" Gonul ");
        row1.createCell(1).setCellValue(" gelismezse ");
        row1.createCell(2).setCellValue(" akil ");
        row1.createCell(3).setCellValue(" kotuluklerle  ");
        row1.createCell(4).setCellValue(" ugrasir ");

        int lastRow2 = sheet.getPhysicalNumberOfRows();
        Row row2 = sheet.createRow(lastRow2);
        row2.createCell(0).setCellValue("Onun icin");
        row2.createCell(1).setCellValue("dusturumuz");
        row2.createCell(2).setCellValue("Bilim ve");
        row2.createCell(3).setCellValue("Gonuldur");

        int lastRow3 = sheet.getPhysicalNumberOfRows();
        Row row3 = sheet.createRow(lastRow2);
        row3.createCell(0).setCellValue("Oktay Sinanoglu");

        file = "src/test/resources/datafiles/ExcelNewTest3.xls";
        workbook.write(new File(file));

        String file = "src/test/resources/datafiles/ExcelNewCalisma.xls";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

    }

    @Test
    public void excelTestRead() throws IOException {
        String file = "src/test/resources/datafiles/ExcelNewCalisma.xls";
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int lastRow = sheet.getPhysicalNumberOfRows();
        Row row = sheet.getRow(0);
        int lastCell = row.getPhysicalNumberOfCells();
        for (int i = 0; i < lastRow; i++) {
            Row cells = sheet.getRow(lastRow);
            row.forEach(System.out::println);



//        Row row = sheet.getRow(0);
//        row.forEach(System.out::println);

            }
        }

    @Test
    public void excelTestWrite1() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("FATMA HUSNA");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);

        row.createCell(0).setCellValue("DIL");
        row.createCell(1).setCellValue("BILIM");
        row.createCell(2).setCellValue("EDEBIYAT");



        file = "src/test/resources/datafiles/ExcelNewTest3.xls";
        workbook.write(new File(file));


    }


    @Test
    public void excelTestRead1() throws IOException {
        String file = "src/test/resources/datafiles/ExcelNewCalisma.xls";
        FileInputStream fileInputStream1 = new FileInputStream(file);
        Workbook workbook1 = WorkbookFactory.create(fileInputStream1);
        Sheet sheet = workbook1.getSheetAt(0);
        int lastRow = sheet.getPhysicalNumberOfRows();
        Row row = sheet.getRow(0);
        int lastCell = row.getPhysicalNumberOfCells();
        for (int i = 0; i < lastRow; i++) {
            Row cells = sheet.getRow(lastRow);
            row.forEach(System.out::println);
        }

   //     int numRow = sheet.getPhysicalNumberOfRows();
    //    for (int i = 0; i < numRow; i++) {
 //           Row row = sheet.getRow(numRow);
 //           row.forEach(System.out::println);

        }
    }



