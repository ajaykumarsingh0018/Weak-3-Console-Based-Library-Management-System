package library;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void saveBooks(ArrayList<Book> books) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"));

        for (Book b : books) {
            writer.write(b.toFileString());
            writer.newLine();
        }

        writer.close();
    }

    public static ArrayList<Book> loadBooks() throws IOException {

        ArrayList<Book> books = new ArrayList<>();

        File file = new File("books.txt");

        if (!file.exists())
            return books;

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {

            books.add(Book.fromFileString(line));

        }

        reader.close();

        return books;
    }
}