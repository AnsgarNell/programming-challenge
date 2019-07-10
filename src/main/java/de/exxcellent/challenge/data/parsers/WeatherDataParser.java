package de.exxcellent.challenge.data.parsers;

import java.util.ArrayList;

import de.exxcellent.challenge.data.WeatherData;

public class WeatherDataParser extends ChallengeDataParser<WeatherData> {

	@Override
	public void parseRawData() throws NullPointerException, NumberFormatException {
		parsedData = new ArrayList<>();
		
		if(rawData.isEmpty()) {
			System.out.println("There is no raw data");
			return;
		}
		
		// Check if the rawData contains what we expect
		if(!rawData.get(0).get(0).equals("Day")) return;
		if(!rawData.get(0).get(1).equals("MxT")) return;
		if(!rawData.get(0).get(2).equals("MnT")) return;
		
		for (int i = 1; i < rawData.size(); i++) {
			
			WeatherData weatherData = new WeatherData();
			
			try {
				int day = Integer.parseInt(rawData.get(i).get(0));
				double mxT = Double.parseDouble(rawData.get(i).get(1));
				double mnT = Double.parseDouble(rawData.get(i).get(2));
				
				weatherData.setDay(day);
				weatherData.setMxT(mxT);
				weatherData.setMnT(mnT);
				
				parsedData.add(weatherData);
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.toString());
			}
		}
	}
}
