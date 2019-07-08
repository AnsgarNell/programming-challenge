package de.exxcellent.challenge.data.readers.files;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CSVFileReaderTest {

	@Test
	void testOpenEmptySource() {
		CSVFileReader instance = new CSVFileReader("");
		Assertions.assertThrows(FileNotFoundException.class, () -> {
		    instance.openSource();
		  });
	}
	
	@Test
	void testOpenSource() throws FileNotFoundException {
		CSVFileReader instance = new CSVFileReader("src/main/resources/de/exxcellent/challenge/weather.csv");
		instance.openSource();
	}
	
	@Test
	void testReadData() throws FileNotFoundException {
		CSVFileReader instance = new CSVFileReader("src/main/resources/de/exxcellent/challenge/weather.csv");
		instance.openSource();
		instance.readData();
	}

}
