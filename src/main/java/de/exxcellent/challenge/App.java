package de.exxcellent.challenge;

import de.exxcellent.challenge.data.parsers.WeatherDataParser;
import de.exxcellent.challenge.data.processors.WeatherDataProcessor;
import de.exxcellent.challenge.data.readers.files.CSVFileReader;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     * @throws Exception 
     */
    public static void main(String... args) throws Exception {
    	
    	if (args.length < 2) {
    		printUsage();
    		throw new IllegalArgumentException("Not enough arguments");
    	}
    	
    	String taskType = args[0];
    	String dataFile = args[1];
    	
    	switch (taskType) {
		case "--weather":
			String dayWithSmallestTempSpread = getWeatherResult(dataFile);     // Your day analysis function call …
	        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
			break;
			
		case "--football":
	        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
	        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
			break;

		default:
			printUsage();
    		throw new IllegalArgumentException("Unexisting task type");
		}
    }

	private static String getWeatherResult(String dataFile) {
		
		CSVFileReader csvFileReader = new CSVFileReader(dataFile);
		WeatherDataParser weatherDataParser = new WeatherDataParser();
		WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor();
		
		try {
			csvFileReader.openSource();
			csvFileReader.readData();
			weatherDataParser.loadData(csvFileReader.getData());
			weatherDataParser.parseRawData();
			weatherDataProcessor.loadParsedData(weatherDataParser.getParsedData());
			weatherDataProcessor.processData();
			return String.valueOf(weatherDataProcessor.getResult());
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;		
		}
	}

	private static void printUsage() {
		System.out.println(
				String.join("\n"
			         , "Usage: App.main(\"--task-type\", \"data-file.csv\")"
			         , "--task-type can be either --weather or --football"
				)
			);	
	}

	
}
