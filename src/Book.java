/**
 * Represents a book in the library catalog.
 * Extends LibraryItem (inheritance) and overrides displayInfo() (polymorphism).
 */
public class Book extends LibraryItem {

    private final String author;
    private int totalCopies;
    private int availableCopies;

    public Book(String id, String title, String author, int totalCopies) {
        super(id, title);
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    public void returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("ID: %-6s | Title: %-30s | Author: %-20s | Available: %d/%d%n",
                getId(), getTitle(), author, availableCopies, totalCopies);
    }
}
