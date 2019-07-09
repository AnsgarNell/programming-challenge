/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.data.readers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ansga
 */
public abstract class ChallengeDataReader {
    
    protected String source;
    protected List<List<String>> data;

    public ChallengeDataReader(String source) {
        this.source = source;
        this.data = new ArrayList<>();
    }
    
    public abstract void openSource() throws Exception;
    public abstract void readData() throws Exception;;
    public abstract void closeSource() throws Exception;
    public abstract List<List<String>> getData();
}
