package Lessions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Less2JSON {
    public static void main(String[] args){
        JSONObject library =  new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title","Война и мир");
        book1.put("author","Лев Толстой");
        book1.put("yaer","1869");

        JSONObject book2 = new JSONObject();
        book2.put("title","Мастер и маргарита");
        book2.put("author","Михаил Булгаков");
        book2.put("yaer","1967");

        books.add(book1);
        books.add(book2);

        library.put("books",books);
        try(FileWriter file =  new FileWriter("src/Lessions/Files/Less2.json")){
            file.write(library.toJSONString());
            System.out.println("JSON файл успешно создан");
        }catch(Exception ex){
            ex.printStackTrace();
        }

        JSONObject book3 = newBook();
        books.add(book3);
        library.remove("books");
        library.put("books", books);
        try(FileWriter file =  new FileWriter("src/Lessions/Files/Less2.json")){
            file.write(library.toJSONString());
            System.out.println("JSON файл успешно создан");
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
    public static JSONObject newBook(){
        Scanner scan =new Scanner(System.in);
        System.out.println("Введите название книги ");
        String title = scan.nextLine();
        System.out.println("Введите название книги ");
        String author = scan.nextLine();
        System.out.println("Введите название книги ");
        String year = scan.nextLine();

        JSONObject newbook =new JSONObject();
        newbook.put("title",title);
        newbook.put("author",author);
        newbook.put("yaer", year);
        return newbook;
    }
}
