import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Entry point: menu-driven console interface for the Library Management System.
 * Wraps all user actions in try/catch so invalid input never crashes the program.
 */
public class Main {

    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedSampleData();

        boolean running = true;
        while (running) {
            printMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        library.displayAllBooks();
                        break;
                    case 2:
                        library.displayAllMembers();
                        break;
                    case 3:
                        handleAddBook();
                        break;
                    case 4:
                        handleAddMember();
                        break;
                    case 5:
                        handleBorrowBook();
                        break;
                    case 6:
                        handleReturnBook();
                        break;
                    case 7:
                        running = false;
                        System.out.println("Exiting Library Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (InvalidIdException | BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. View All Books");
        System.out.println("2. View All Members");
        System.out.println("3. Add New Book");
        System.out.println("4. Register New Member");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleAddBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter Total Copies: ");

        try {
            int copies = Integer.parseInt(scanner.nextLine().trim());
            library.addBook(new Book(id, title, author, copies));
            System.out.println("Book added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Total copies must be a valid number. Book not added.");
        }
    }

    private static void handleAddMember() {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        library.addMember(new Member(id, name));
        System.out.println("Member registered successfully.");
    }

    private static void handleBorrowBook() throws InvalidIdException, BookNotAvailableException {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine().trim();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();

        library.borrowBook(memberId, bookId);
    }

    private static void handleReturnBook() throws InvalidIdException {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine().trim();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();

        library.returnBook(memberId, bookId);
    }

    private static void seedSampleData() {
        library.addBook(new Book("B001", "Effective Java", "Joshua Bloch", 3));
        library.addBook(new Book("B002", "Clean Code", "Robert C. Martin", 2));
        library.addBook(new Book("B003", "The Pragmatic Programmer", "Andrew Hunt", 1));

        library.addMember(new Member("M001", "Boobalan N"));
        library.addMember(new Member("M002", "Ariya"));

        System.out.println("Sample data loaded: 3 books, 2 members.");
    }
}
