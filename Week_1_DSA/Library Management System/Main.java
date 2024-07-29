public class Main {
    public static void main(String[] args) {
        // Create sample books
        Book[] books = {
                new Book(1, "Feluda", "Satyajit Roy"),
                new Book(2, "1984", "George Orwell"),
                new Book(3, "To Kill a Mockingbird", "Harper Lee")
        };

        // Initialize Library with books
        Library library = new Library(books);

        // Linear Search Test
        Book result = library.linearSearchByTitle("1984");
        System.out.println("Linear Search Result: " + result);

        // Binary Search Test
        result = library.binarySearchByTitle("Feluda");
        System.out.println("Binary Search Result: " + result);
    }
}
