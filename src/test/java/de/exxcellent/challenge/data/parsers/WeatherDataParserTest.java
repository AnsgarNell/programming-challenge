package de.exxcellent.challenge.data.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.data.WeatherData;

import static org.junit.Assert.*;

class WeatherDataParserTest {

	@Test
	void testLoadNullData() {
		WeatherDataParser instance = new WeatherDataParser();
		List<List<String>> data = null;	
		Assertions.assertThrows(NullPointerException.class, () -> {
			instance.loadData(data);
		  });
	}
	
	@Test
	void testParseNullData() {
		WeatherDataParser instance = new WeatherDataParser();
		Assertions.assertThrows(NullPointerException.class, () -> {
			instance.parseRawData();
		  });
	}
	
	@Test
	void testParseWrongData() {
		List<List<String>> data = Arrays.asList(
				Arrays.asList("Team","Games","Wins","Losses","Draws","Goals","Goals Allowed","Points"),
				Arrays.asList("Arsenal","38","26","9","3","79","36","87"),
				Arrays.asList("Liverpool","38","24","8","6","67","30","80"),
				Arrays.asList("Manchester United","38","24","5","9","87","45","77")
		);
		WeatherDataParser instance = new WeatherDataParser();	
		instance.loadData(data);
		instance.parseRawData();
		assertTrue("The parsed data must be empty", instance.parsedData.isEmpty());
		
		data = Arrays.asList(
				Arrays.asList("Day","Games","Wins","Losses","Draws","Goals","Goals Allowed","Points"),
				Arrays.asList("Arsenal","38","26","9","3","79","36","87"),
				Arrays.asList("Liverpool","38","24","8","6","67","30","80"),
				Arrays.asList("Manchester United","38","24","5","9","87","45","77")
		);	
		instance.loadData(data);
		instance.parseRawData();
		assertTrue("The parsed data must be empty", instance.parsedData.isEmpty());
		
		data = Arrays.asList(
				Arrays.asList("Day","MxT","Wins","Losses","Draws","Goals","Goals Allowed","Points"),
				Arrays.asList("Arsenal","38","26","9","3","79","36","87"),
				Arrays.asList("Liverpool","38","24","8","6","67","30","80"),
				Arrays.asList("Manchester United","38","24","5","9","87","45","77")
		);	
		instance.loadData(data);
		instance.parseRawData();
		assertTrue("The parsed data must be empty", instance.parsedData.isEmpty());
		
		data = Arrays.asList(
				Arrays.asList("Day","MxT","MnT","Losses","Draws","Goals","Goals Allowed","Points"),
				Arrays.asList("Arsenal","38","26","9","3","79","36","87"),
				Arrays.asList("Liverpool","38","24","8","6","67","30","80"),
				Arrays.asList("Manchester United","38","24","5","9","87","45","77")
		);	
		instance.loadData(data);
		instance.parseRawData();
		assertTrue("The parsed data must be empty", instance.parsedData.isEmpty());
		
		data = Arrays.asList(
				Arrays.asList("Day","MxT","MnT","Losses","Draws","Goals","Goals Allowed","Points"),
				Arrays.asList("1","88","59","9","3","79","36","87"),
				Arrays.asList("Liverpool","38","24","8","6","67","30","80"),
				Arrays.asList("Manchester United","38","24","5","9","87","45","77")
		);	
		instance.loadData(data);
		instance.parseRawData();
		assertTrue("The parsed data must contain only one parsed object", instance.parsedData.size() == 1);
	}
	
	@Test
	void testParseData() {
		List<List<String>> data = Arrays.asList(
				Arrays.asList("Day","MxT","MnT","AvT","AvDP","1HrP TPcpn","PDir","AvSp","Dir","MxS","SkyC","MxR","Mn","R AvSLP"),
				Arrays.asList("1","88","59","74","53.8","0","280","9.6","270","17","1.6","93","23","1004.5"),
				Arrays.asList("2","79","63","71","46.5","0","330","8.7","340","23","3.3","70","28","1004.5"),
				Arrays.asList("3","77","55","66","39.6","0","350","5","350","9","2.8","59","24","1016.8")
		);
		WeatherDataParser instance = new WeatherDataParser();	
		instance.loadData(data);
		instance.parseRawData();
		assertFalse("The parsed data can not be empty", instance.parsedData.isEmpty());
		assertTrue("The parsed data must contain three parsed objects", instance.parsedData.size() == 3);
	}
	
	@Test
	void testGetNullParsedData() {
		WeatherDataParser instance = new WeatherDataParser();
		List<WeatherData> result = instance.getParsedData();
		assertTrue("The result data must be null", result == null);
	}
	
	@Test
	void testGetEmptyParsedData() {
		WeatherDataParser instance = new WeatherDataParser();
		List<List<String>> data = new ArrayList<>();	
		instance.loadData(data);
		instance.parseRawData();
		List<WeatherData> result = instance.getParsedData();
		assertTrue("The result data must be empty", result.isEmpty());
	}
	
	@Test
	void testGetParsedData() {
		List<List<String>> data = Arrays.asList(
				Arrays.asList("Day","MxT","MnT","AvT","AvDP","1HrP TPcpn","PDir","AvSp","Dir","MxS","SkyC","MxR","Mn","R AvSLP"),
				Arrays.asList("1","88","59","74","53.8","0","280","9.6","270","17","1.6","93","23","1004.5"),
				Arrays.asList("2","79","63","71","46.5","0","330","8.7","340","23","3.3","70","28","1004.5"),
				Arrays.asList("3","77","55","66","39.6","0","350","5","350","9","2.8","59","24","1016.8")
		);
		WeatherDataParser instance = new WeatherDataParser();	
		instance.loadData(data);
		instance.parseRawData();
		List<WeatherData> result = instance.getParsedData();
		assertFalse("The result data can not be empty", result.isEmpty());
	}
	
}
