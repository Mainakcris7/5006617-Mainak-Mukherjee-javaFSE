public class FinancialForecast {

    // Method to calculate future value recursively
    public static double calculateFutureValue(double currentValue, double growthRate, int timePeriod) {

        if (timePeriod == 0) {
            return currentValue;
        }

        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, timePeriod - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double growthRate = 0.05;
        int timePeriod = 1;

        double futureValue = calculateFutureValue(currentValue, growthRate, timePeriod);
        System.out.println("Future Value: " + futureValue);
    }
}
