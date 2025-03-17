package main;

public class GravelCar extends RallyCar {
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel= suspensionTravel;
    }
    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    @Override
    double calculatePerformance() {
        return getHorsepower()-getSuspensionTravel();
    }

    
}
