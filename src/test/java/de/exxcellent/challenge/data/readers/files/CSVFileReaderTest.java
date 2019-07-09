package de.exxcellent.challenge.data.readers.files;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CSVFileReaderTest {
	
	private static final String RESOURCES_FOLDER = "src/main/resources/de/exxcellent/challenge/";
	private static final String WEATHER_FILE = RESOURCES_FOLDER + "weather.csv";
	private static final String EMPTY_FILE = RESOURCES_FOLDER + "empty.csv";

	@Test
	void testOpenEmptySource() {
		CSVFileReader instance = new CSVFileReader("");
		Assertions.assertThrows(FileNotFoundException.class, () -> {
		    instance.openSource();
		  });
	}
	
	@Test
	void testOpenSource() throws NullPointerException, IOException {
		CSVFileReader instance = new CSVFileReader(WEATHER_FILE);
		instance.openSource();
		assertFalse("BufferedReader must not be null", instance.br == null);
		// If we open the file, we have to close it to be able to continue testing
		instance.closeSource();
	}
	
	@Test
	void testCloseEmptySource() throws Exception {
		CSVFileReader instance = new CSVFileReader("");
		Assertions.assertThrows(NullPointerException.class, () -> {
		    instance.closeSource();
		  });
	}
	
	@Test
	void testCloseFile() throws NullPointerException, IOException  {
		CSVFileReader instance = new CSVFileReader(WEATHER_FILE);
		instance.openSource();
		instance.closeSource();
		// TODO: Must we or can we check this? We just call BufferedReader close() method.
	}
	
	@Test
	void testReadDataWithoutOpeningTheFile() throws IOException {
		CSVFileReader instance = new CSVFileReader(WEATHER_FILE);
		Assertions.assertThrows(NullPointerException.class, () -> {
		    instance.readData();
		  });
	}
	
	@Test
	void testGetDataWithoutOpeningTheFile() throws IOException {
		CSVFileReader instance = new CSVFileReader(WEATHER_FILE);
		List<List<String>> result = instance.getData();
		assertTrue("getData() must return an empty list", result.isEmpty());
	}
	
	@Test
	void testGetDataWithEmptyFile() throws IOException {
		CSVFileReader instance = new CSVFileReader(EMPTY_FILE);
		instance.openSource();
		instance.readData();
		List<List<String>> result = instance.getData();
		instance.closeSource();
		assertTrue("getData() must return an empty list", result.isEmpty());
	}

	@Test
	void testGetData() throws IOException {
		CSVFileReader instance = new CSVFileReader(WEATHER_FILE);
		instance.openSource();
		instance.readData();
		List<List<String>> result = instance.getData();
		instance.closeSource();
		assertFalse("getData() must return a list", result.isEmpty());
	}
}
