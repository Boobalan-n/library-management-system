/**
 * Abstract base class for anything the library can catalog.
 * Demonstrates abstraction + encapsulation: subclasses must define their own
 * displayInfo(), while id/title stay private with controlled access.
 */
public abstract class LibraryItem {

    private final String id;
    private final String title;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayInfo();
}
