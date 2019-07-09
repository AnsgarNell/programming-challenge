package de.exxcellent.challenge.data.parsers;

import java.util.List;

public abstract class ChallengeDataParser {
	
	protected List<List<String>> rawData;
	protected List<List<String>> parsedData;
	
	public abstract void loadData(List<List<String>> rawData);
	public abstract void parseRawData();
	public abstract List<List<String>> getParsedData();
}
