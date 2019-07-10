/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.data.readers.files;

import de.exxcellent.challenge.data.readers.ChallengeDataReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ansga
 */
public class CSVFileReader extends ChallengeDataReader{
    
	private final static String RESOURCES_FOLDER = "src/main/resources/de/exxcellent/challenge/";
    private static final String COMMA_DELIMITER = ",";
	BufferedReader br;

    public CSVFileReader(String fileName) {
        super(RESOURCES_FOLDER + fileName);
    }

    @Override
    public void openSource() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(source));
    }

    @Override
    public void readData() throws IOException, NullPointerException {
    	String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            data.add(Arrays.asList(values));
        }
    }

    @Override
    public List<List<String>> getData() {
        return data;
    }

	@Override
	public void closeSource() throws IOException, NullPointerException {
		br.close();
	}
    
}
