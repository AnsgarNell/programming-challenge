package de.exxcellent.challenge.data.processors;

import java.util.Collections;
import de.exxcellent.challenge.data.TeamsSortByDistance;
import de.exxcellent.challenge.data.FootballData;

public class FootballDataProcessor extends ChallengeDataProcessor<FootballData> {

	@Override
	public void processData() throws NullPointerException, NumberFormatException {
		if(parsedData.isEmpty()) {
			System.out.println("There is no parsed data");
			return;
		}
		
		for (final FootballData data : parsedData) {
			data.calculateDistance();
		}
		
		Collections.sort(parsedData, new TeamsSortByDistance());
		
		output = parsedData.get(0).getTeam();
	}

}
