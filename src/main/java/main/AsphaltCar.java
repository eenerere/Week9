package main;

public class AsphaltCar extends RallyCar {
    private double downforse;

    public AsphaltCar(String make, String model, int horsepower, double downforse) {
        super(make, model, horsepower);
        this.downforse= downforse;
    }
    public double getDownforse() {
        return downforse;
    }

    @Override
    double calculatePerformance() {
        return getHorsepower()-getDownforse();
    }
    
}
