import java.util.Scanner;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Issued Books");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                }
                case 2 -> library.showBooks();
                case 3 -> {
                    System.out.print("Enter title to issue: ");
                    String title = scanner.nextLine();
                    library.issueBook(title);
                }
                case 4 -> {
                    System.out.print("Enter title to return: ");
                    String title = scanner.nextLine();
                    library.returnBook(title);
                }
                case 5 -> IssuedBooksManager.displayIssuedBooks();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
