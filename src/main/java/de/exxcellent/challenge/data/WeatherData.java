package de.exxcellent.challenge.data;

public final class WeatherData {
	
	private int day;
	private double mxT;
	private double mnT;
	
	public WeatherData(int day, double mxT, double mnT) {
		this.day = day;
		this.mxT = mxT;
		this.mnT = mnT;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getMxT() {
		return mxT;
	}
	public void setMxT(double mxT) {
		this.mxT = mxT;
	}
	public double getMnT() {
		return mnT;
	}
	public void setMnT(double mnT) {
		this.mnT = mnT;
	}

}
