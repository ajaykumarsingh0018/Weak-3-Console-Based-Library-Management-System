package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String BOOK_FILE = "data/books.dat";
    private final String MEMBER_FILE = "data/members.dat";

    public void saveBooks(List<Book> books) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(BOOK_FILE))) {

            out.writeObject(books);

        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    public List<Book> loadBooks() {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(BOOK_FILE))) {

            return (List<Book>) in.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveMembers(List<Member> members) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(MEMBER_FILE))) {

            out.writeObject(members);

        } catch (IOException e) {
            System.out.println("Error saving members.");
        }
    }

    public List<Member> loadMembers() {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(MEMBER_FILE))) {

            return (List<Member>) in.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}