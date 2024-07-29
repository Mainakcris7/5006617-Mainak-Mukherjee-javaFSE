import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer e);

    void deregister(Observer e);

    void notifyObservers();
}

interface Observer {
    void update(double price);
}

class MobileApp implements Observer {
    double price;
    String name;

    MobileApp(String name) {
        this.name = name;
    }

    public void update(double price) {
        System.out.println("MobileApp: " + name + " stock price updated with Rs." + price);
    }
}

class WebApp implements Observer {
    double price;
    String name;

    WebApp(String name) {
        this.name = name;
    }

    public void update(double price) {
        System.out.println("WebApp: " + name + " stock price updated with Rs." + price);
    }
}

class StockMarket implements Stock {
    List<Observer> observers;
    double price;

    StockMarket() {
        observers = new ArrayList<>();
    }

    public void stockUpdate(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this.price);
        }
    }
}

public class ObserverPatten {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        MobileApp m1 = new MobileApp("App1");
        MobileApp m2 = new MobileApp("App2");
        WebApp w1 = new WebApp("Web1");
        WebApp w2 = new WebApp("Web2");
        market.register(m1);
        market.register(m2);
        market.register(w1);
        market.register(w2);
        market.stockUpdate(110.0); // Notify all observers
    }
}