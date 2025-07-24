import java.util.ArrayList;
import java.util.List;

public class Library {
    @SuppressWarnings("FieldMayBeFinal")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(String title) {
        Book book = findBook(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            book.issue();
            IssuedBooksManager.saveIssuedBook(book);
            System.out.println("Book issued.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null && book.isIssued()) {
            book.returnBook();
            IssuedBooksManager.removeIssuedBook(book);
            System.out.println("Book returned.");
        } else {
            System.out.println("Invalid return operation.");
        }
    }
}
