package de.exxcellent.challenge.data.processors;

import java.util.List;

public abstract class ChallengeDataProcessor<T> {
	
	protected List<T> parsedData;
	protected Object output;
	
	public void loadParsedData(List<T> parsedData) throws NullPointerException {
		if(parsedData.isEmpty())
			System.out.println("The received parsed data is empty");
		this.parsedData = parsedData;	
	}
	
	public abstract void processData() throws Exception;
}
