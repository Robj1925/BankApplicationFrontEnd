package SOLIDExercises;

public class Plane extends Vehicle implements Flying, Speed {
    private boolean abilityToFly;
    private double currentSpeedInNauticalMilesPerHour;
    private double currentSpeedInLandMilesPerHour;

    public Plane(int engineSize, boolean manualAssistance) {
        super(engineSize, manualAssistance);
    }

    @Override
    public void setAbilityToFly(boolean abilityToFly) {
        this.abilityToFly = abilityToFly;
    }

    @Override
    public boolean isAbilityToFly() {
        return abilityToFly;
    }

    @Override
    public void setCurrentSpeedInNauticalMilesPerHour(double speed) {
        this.currentSpeedInNauticalMilesPerHour = speed;
    }

    @Override
    public double getCurrentSpeedInNauticalMilesPerHour() {
        return currentSpeedInNauticalMilesPerHour;
    }

    @Override
    public void setCurrentSpeedInLandMilesPerHour(double speed) {
        this.currentSpeedInLandMilesPerHour = speed;
    }

    @Override
    public double getCurrentSpeedInLandMilesPerHour() {
        return currentSpeedInLandMilesPerHour;
    }
}
