package de.exxcellent.challenge.data.parsers;

import java.util.ArrayList;

import de.exxcellent.challenge.data.FootballData;

public class FootballDataParser extends ChallengeDataParser<FootballData> {

	@Override
	public void parseRawData() throws NullPointerException, NumberFormatException {
		parsedData = new ArrayList<>();
		
		if(rawData.isEmpty()) {
			System.out.println("There is no raw data");
			return;
		}
		
		// Check if the rawData contains what we expect
		if(!rawData.get(0).get(0).equals("Team")) return;
		if(!rawData.get(0).get(5).equals("Goals")) return;
		if(!rawData.get(0).get(6).equals("Goals Allowed")) return;
		
		for (int i = 1; i < rawData.size(); i++) {
			
			FootballData footballData = new FootballData();
			
			
			try {
				String team = rawData.get(i).get(0);
				int goals = Integer.parseInt(rawData.get(i).get(5));
				int goalsAllowed = Integer.parseInt(rawData.get(i).get(6));
				
				footballData.setTeam(team);
				footballData.setGoals(goals);
				footballData.setGoalsAllowed(goalsAllowed);
				
				parsedData.add(footballData);
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.toString());
			}
		}
	}
}
