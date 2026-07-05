import java.util.ArrayList;
import java.util.List;

/**
 * Core engine of the system: manages the catalog of books, registered members,
 * and the borrow/return workflow, including validation and exception handling.
 */
public class Library {

    private final List<Book> books;
    private final List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // ---------- Book management ----------

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(String bookId) throws InvalidIdException {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }
        throw new InvalidIdException("No book found with ID: " + bookId);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog yet.");
            return;
        }
        for (Book book : books) {
            book.displayInfo();
        }
    }

    // ---------- Member management ----------

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(String memberId) throws InvalidIdException {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        throw new InvalidIdException("No member found with ID: " + memberId);
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        for (Member member : members) {
            member.displayInfo();
        }
    }

    // ---------- Borrow / Return workflow ----------

    public void borrowBook(String memberId, String bookId)
            throws InvalidIdException, BookNotAvailableException {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (!book.isAvailable()) {
            throw new BookNotAvailableException(
                    "'" + book.getTitle() + "' is currently not available (0 copies left).");
        }

        book.borrowCopy();
        member.addBorrowedBook(book);
        System.out.println(member.getName() + " successfully borrowed '" + book.getTitle() + "'.");
    }

    public void returnBook(String memberId, String bookId) throws InvalidIdException {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (!member.getBorrowedBooks().contains(book)) {
            throw new InvalidIdException(
                    member.getName() + " has not borrowed the book '" + book.getTitle() + "'.");
        }

        book.returnCopy();
        member.removeBorrowedBook(book);
        System.out.println(member.getName() + " successfully returned '" + book.getTitle() + "'.");
    }
}
