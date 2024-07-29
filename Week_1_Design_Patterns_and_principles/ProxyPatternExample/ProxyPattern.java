interface Image {
    void display();
}

class RealImage implements Image {
    String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadImage(filename);
    }

    public void loadImage(String filename) {
        try {
            System.out.println("Loading " + filename + " from server...");
            Thread.sleep(1000);
            System.out.println("Image loaded!");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.err.println("Failed to load " + filename);
        }

    }

    @Override
    public void display() {
        System.out.println("Displaying image...");
    }
}

class ProxyImage implements Image {
    private RealImage image;
    String filename;

    ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (image == null) { // Caching
            this.image = new RealImage(filename);
        }
        image.display();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        // Image image = new RealImage("flower.jpg"); Even when I don't call display
        // method, it will still be loaded from the server
        Image image = new ProxyImage("flower.jpg"); // Image not loaded (lazy initialization)

        image.display(); // The image will be loaded and displayed

        image.display();

    }
}