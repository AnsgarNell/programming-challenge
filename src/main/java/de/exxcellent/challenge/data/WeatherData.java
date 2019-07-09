package de.exxcellent.challenge.data;

public final class WeatherData {
	
	private int day;
	private double mxT;
	private double mnT;
	private double tSp = 0.0;
	
	public WeatherData() {
		this.day = 0;
		this.mxT = 0.0;
		this.mnT = 0.0;
	}
	
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
	
	public double getTsp() {
		return tSp;
	}
	
	public void calculateTemperatureSpread() {
		this.tSp = this.mxT - this.mnT;
	}

}
