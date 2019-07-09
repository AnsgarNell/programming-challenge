package de.exxcellent.challenge.data.processors;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.data.WeatherData;

class WeatherDataProcessorTest {

	@Test
	void testLoadNullParsedData() {
		WeatherDataProcessor instance = new WeatherDataProcessor();
		List<WeatherData> data = null;	
		Assertions.assertThrows(NullPointerException.class, () -> {
			instance.loadParsedData(data);
		  });
	}
	
	@Test
	void testLoadEmptyParsedData() {
		WeatherDataProcessor instance = new WeatherDataProcessor();
		List<WeatherData> data = new ArrayList<>();	
		instance.loadParsedData(data);
		assertTrue("The parsed data must be empty", instance.parsedData.isEmpty());
	}
	
	@Test
	void testLoadParsedData() {
		List<WeatherData> data = Arrays.asList(
			new WeatherData(1, 88.0, 59.0),
			new WeatherData(2, 79.0, 63.0),
			new WeatherData(3, 77.0, 55.0)
		);
		WeatherDataProcessor instance = new WeatherDataProcessor();
		instance.loadParsedData(data);
		assertFalse("The parsed data must not be empty", instance.parsedData.isEmpty());
	}
	
	@Test
	void testProcessNullData() {
		WeatherDataProcessor instance = new WeatherDataProcessor();
		Assertions.assertThrows(NullPointerException.class, () -> {
			instance.processData();
		  });
	}
	
	@Test
	void testProcessEmptyData() {
		WeatherDataProcessor instance = new WeatherDataProcessor();
		List<WeatherData> data = new ArrayList<>();
		instance.loadParsedData(data);
		instance.processData();
		assertTrue("The output must be null", instance.output == null);
	}
	
	@Test
	void testProcessData() {
		WeatherDataProcessor instance = new WeatherDataProcessor();
		List<WeatherData> data = Arrays.asList(
				new WeatherData(1, 88.0, 59.0),
				new WeatherData(2, 79.0, 63.0),
				new WeatherData(3, 77.0, 55.0)
			);
		instance.loadParsedData(data);
		instance.processData();
		assertFalse("The output must not be null", instance.output == null);
	}

}
