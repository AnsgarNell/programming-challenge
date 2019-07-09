/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.data.readers.web.services;

import de.exxcellent.challenge.data.readers.ChallengeDataReader;
import java.util.List;

/**
 *
 * @author ansga
 */
public class WebServiceDataReader extends ChallengeDataReader{

    public WebServiceDataReader(String source) {
        super(source);
    }

    @Override
    public void openSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<String>> getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void closeSource() throws Exception {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.	
	}
    
}
