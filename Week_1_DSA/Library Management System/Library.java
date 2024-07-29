public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Assuming the array is sorted
    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Book found
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Book not found
    }
}
