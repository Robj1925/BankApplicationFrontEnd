package SOLIDExercises;

public abstract class Vehicle {
	private int engineSize;
	private boolean manualAssistance;

	public Vehicle(int engineSize, boolean manualAssistance) {
		this.engineSize = engineSize;
		this.manualAssistance = manualAssistance;
	}

	// Getter and Setter methods
	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public boolean isManualAssistance() {
		return manualAssistance;
	}

	public void setManualAssistance(boolean manualAssistance) {
		this.manualAssistance = manualAssistance;
	}
}