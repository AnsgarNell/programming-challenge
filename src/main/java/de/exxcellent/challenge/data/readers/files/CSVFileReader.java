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
import java.util.List;

/**
 *
 * @author ansga
 */
public class CSVFileReader extends ChallengeDataReader{
    
    BufferedReader br;

    public CSVFileReader(String source) {
        super(source);
    }

    @Override
    public void openSource() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(source));
    }

    @Override
    public void readData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<String>> getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
