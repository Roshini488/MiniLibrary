import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class IssuedBooksManager {
    private static final String FILE_NAME = "issued_books.txt";

    public static void saveIssuedBook(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(book.getTitle() + "," + book.getAuthor());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving issued book: " + e.getMessage());
        }
    }

    public static void removeIssuedBook(Book book) {
        try {
            List<String> lines = new ArrayList<>(Files.readAllLines(new File(FILE_NAME).toPath()));
            lines.removeIf(line -> line.startsWith(book.getTitle() + "," + book.getAuthor()));
            Files.write(new File(FILE_NAME).toPath(), lines);
        } catch (IOException e) {
            System.out.println("Error updating issued books: " + e.getMessage());
        }
    }

    public static void displayIssuedBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("Issued Books:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(" - " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading issued books.");
        }
    }
}
