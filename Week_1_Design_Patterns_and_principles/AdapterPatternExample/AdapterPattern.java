
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of Rs. " + amount + " through PayPal.");
    }
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment of Rs. " + amount + " through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);

    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);

    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypalPaymentProcessor = new PayPalAdapter(new PayPal());
        paypalPaymentProcessor.processPayment(500.0);

        PaymentProcessor stripePaymentProcessor = new StripeAdapter(new Stripe());
        stripePaymentProcessor.processPayment(100.0);

    }
}