package Lessions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Less4Read {
    public static void main(String[] args){
        try {
            String filePath = "src/Lessions/Files/Less4.xlsx";
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook  = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Товары");

            for (Row row: sheet){
                for(Cell cell: row){
                    System.out.print(cell.toString()+"\t");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
