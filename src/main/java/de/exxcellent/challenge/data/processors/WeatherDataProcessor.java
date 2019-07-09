package de.exxcellent.challenge.data.processors;

import java.util.Collections;
import de.exxcellent.challenge.data.TempSortBySpread;
import de.exxcellent.challenge.data.WeatherData;

public class WeatherDataProcessor extends ChallengeDataProcessor<WeatherData> {

	@Override
	public void processData() throws NullPointerException, NumberFormatException {
		if(parsedData.isEmpty()) {
			System.out.println("There is no parsed data");
			return;
		}
		
		for (final WeatherData data : parsedData) {
			data.calculateTemperatureSpread();
		}
		
		Collections.sort(parsedData, new TempSortBySpread());
		
		output = parsedData.get(0).getDay();
	}

}
