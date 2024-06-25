package SOLIDExercises;

public class Boat extends Vehicle implements WaterPowered, Speed {
	private boolean waterPowered;
	private double currentSpeedInNauticalMilesPerHour;

	public Boat(int engineSize, boolean manualAssistance) {
		super(engineSize, manualAssistance);
	}

	@Override
	public void setWaterPowered(boolean waterPowered) {
		this.waterPowered = waterPowered;
	}

	@Override
	public boolean isWaterPowered() {
		return waterPowered;
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
		throw new UnsupportedOperationException("Boats do not support land speed.");
	}

	@Override
	public double getCurrentSpeedInLandMilesPerHour() {
		throw new UnsupportedOperationException("Boats do not support land speed.");
	}
}
