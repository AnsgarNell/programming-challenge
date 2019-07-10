package de.exxcellent.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {
	
	@Test
    public void runWithoutArguments() throws Exception {      
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	App.main();
        });
    }
	
	@Test
    public void runWithOneArgument() throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			App.main("--test");
		});
    }
	
	@Test
    public void runWithInvalidArguments() throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			App.main("--test", "weather.csv");
		});
    }

	@Test
    public void runWeather() throws Exception {
		App.main("--weather", "weather.csv");
    }
    

    @Test
    public void runFootball() throws Exception {
		App.main("--football", "football.csv");
    }

}