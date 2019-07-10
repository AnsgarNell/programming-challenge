package de.exxcellent.challenge.data.parsers;

import java.util.List;

public abstract class ChallengeDataParser<T> {
	
	protected List<List<String>> rawData;
	protected List<T> parsedData;
	
	public void loadData(List<List<String>> rawData) throws NullPointerException {
		if(rawData.isEmpty())
			System.out.println("The received data is empty");
		this.rawData = rawData;	
	}
	
	public abstract void parseRawData() throws Exception;
	
	public List<T> getParsedData() {
		return parsedData;
	}
}
