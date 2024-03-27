package Lessions;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Less4Exel {
    public static void main(String[] args){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Товары");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Товар");
            headerRow.createCell(1).setCellValue("Характеристики");
            headerRow.createCell(2).setCellValue("Стоимость");

            Row dataRow1 = sheet.createRow(1);
            dataRow1.createCell(0).setCellValue("Книга");
            dataRow1.createCell(1).setCellValue("Жанр: фантастика, автора: Иванов И.И.");
            dataRow1.createCell(2).setCellValue(500.00);

            Row dataRow2 = sheet.createRow(2);
            dataRow2.createCell(0).setCellValue("Компьютер");
            dataRow2.createCell(1).setCellValue("Процессор: Intel core 15");
            dataRow2.createCell(2).setCellValue(25000.00);

            Scanner scan =new Scanner(System.in);
            System.out.println("Введите название товара ");
            String name = scan.nextLine();
            System.out.println("Введите состав");
            String cont = scan.nextLine();
            System.out.println("Введите стоимость ");
            String price = scan.nextLine();

            Row dataRow3 = sheet.createRow(2);
            dataRow3.createCell(0).setCellValue(name);
            dataRow3.createCell(1).setCellValue(cont);
            dataRow3.createCell(2).setCellValue(price);

            String filePath = "src/Lessions/Files/Less4.xlsx";
            FileOutputStream outputStream  = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Данные записаны");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
