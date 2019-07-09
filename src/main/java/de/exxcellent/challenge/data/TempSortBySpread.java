package de.exxcellent.challenge.data;

import java.util.Comparator;

public class TempSortBySpread implements Comparator<WeatherData>{

	@Override
	public int compare(WeatherData arg0, WeatherData arg1) {
        return Double.compare(arg0.getTsp(), arg1.getTsp());
	}

}
