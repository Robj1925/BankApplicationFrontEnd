package SOLIDExercises;


public class Car extends Vehicle implements LandVehicle, Speed {
    private int numberOfAxles;
    private double currentSpeedInLandMilesPerHour;

    public Car(int engineSize, boolean manualAssistance) {
        super(engineSize, manualAssistance);
    }

    @Override
    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    @Override
    public void setCurrentSpeedInLandMilesPerHour(double speed) {
        this.currentSpeedInLandMilesPerHour = speed;
    }

    @Override
    public double getCurrentSpeedInLandMilesPerHour() {
        return currentSpeedInLandMilesPerHour;
    }

    @Override
    public void setCurrentSpeedInNauticalMilesPerHour(double speed) {
        throw new UnsupportedOperationException("Cars do not support nautical speed.");
    }

    @Override
    public double getCurrentSpeedInNauticalMilesPerHour() {
        throw new UnsupportedOperationException("Cars do not support nautical speed.");
    }
}