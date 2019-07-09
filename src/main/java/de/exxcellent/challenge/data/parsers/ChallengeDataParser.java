package de.exxcellent.challenge.data.parsers;

import java.util.List;

public abstract class ChallengeDataParser {
	
	protected List<List<String>> rawData;
	protected List<List<String>> parsedData;
	
	public void loadData(List<List<String>> rawData) throws NullPointerException {
		if(rawData.isEmpty())
			System.out.println("The received data is empty");
		this.rawData = rawData;	
	}
	
	public abstract void parseRawData() throws Exception;
	
	public List<List<String>> getParsedData() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
