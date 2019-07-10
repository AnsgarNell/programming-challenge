package de.exxcellent.challenge.data.processors;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.data.FootballData;

class FootballDataProcessorTest {

	@Test
	void testLoadNullParsedData() {
		FootballDataProcessor instance = new FootballDataProcessor();
		List<FootballData> data = null;	
		Assertions.assertThrows(NullPointerException.class, () -> {
			instance.loadParsedData(data);
		  });
	}
	
	@Test
	void testLoadEmptyParsedData() {
		FootballDataProcessor instance = new FootballDataProcessor();
		List<FootballData> data = new ArrayList<>();	
		instance.loadParsedData(data);
		assertTrue("The parsed data must be empty", instance.parsedData.isEmpty());
	}
	
	@Test
	void testLoadParsedData() {
		List<FootballData> data = Arrays.asList(
			new FootballData("Arsenal", 79, 36),
			new FootballData("Liverpool", 67, 30),
			new FootballData("Manchester United", 87, 45)
		);
		FootballDataProcessor instance = new FootballDataProcessor();
		instance.loadParsedData(data);
		assertFalse("The parsed data must not be empty", instance.parsedData.isEmpty());
	}
	
	@Test
	void testProcessNullData() {
		FootballDataProcessor instance = new FootballDataProcessor();
		Assertions.assertThrows(NullPointerException.class, () -> {
			instance.processData();
		  });
	}
	
	@Test
	void testProcessEmptyData() {
		FootballDataProcessor instance = new FootballDataProcessor();
		List<FootballData> data = new ArrayList<>();
		instance.loadParsedData(data);
		instance.processData();
		assertTrue("The output must be null", instance.output == null);
	}
	
	@Test
	void testProcessData() {
		FootballDataProcessor instance = new FootballDataProcessor();
		List<FootballData> data = Arrays.asList(
				new FootballData("Arsenal", 79, 36),
				new FootballData("Liverpool", 67, 30),
				new FootballData("Manchester United", 87, 45)
			);
		instance.loadParsedData(data);
		instance.processData();
		assertFalse("The output must not be null", instance.output == null);
	}

}
