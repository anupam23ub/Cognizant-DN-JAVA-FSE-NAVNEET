package WEEK1.Algorithms_DS.exercise7;

class FinancialForecaster {
    public double predictValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return predictValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }
    public static void main(String[] args) {
        FinancialForecaster forecaster = new FinancialForecaster();

        double futureValue = forecaster.predictValue(1000.0, 0.05, 10);
        System.out.printf("$%.2f%n", futureValue);
    }
}
