import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library member and the books they currently have borrowed.
 */
public class Member {

    private final String memberId;
    private final String name;
    private final List<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayInfo() {
        System.out.printf("Member ID: %-6s | Name: %-20s | Books Borrowed: %d%n",
                memberId, name, borrowedBooks.size());
    }
}
