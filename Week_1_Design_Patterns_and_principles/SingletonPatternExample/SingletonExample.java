
// Singleton class
class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
            return logger;
        }
        return logger;
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        // Logger logger = new Logger(); => Throws error as constructor is private

        Logger logger = Logger.getInstance(); // Create new instance
        System.out.println("Instance1 hashcode:" + logger.hashCode()); // Get hashcode

        Logger logger2 = Logger.getInstance(); // Same instance is returned
        System.out.println("Instance2 hashcode:" + logger2.hashCode()); // Same hashcode
    }
}