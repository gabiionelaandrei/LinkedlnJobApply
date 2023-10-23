package utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.opencsv.CSVReader;

public class CSVDataReader {
	String[] csvLineData;
	Map<String, String> credentials = new HashMap<String, String> (); 
	

	public Map<String, String> getCredentials() {
		
		try {
			FileReader credentialsFile = new FileReader("C:\\Users\\ProBook 6470b\\OneDrive\\Desktop\\Linkedin project\\credentials.csv");
			CSVReader readCredentialsFile = new CSVReader(credentialsFile);
			readCredentialsFile.skip(1);
			csvLineData = readCredentialsFile.readNext();
			readCredentialsFile.close();	
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		if(csvLineData != null) {
			
			credentials.put("Username", csvLineData[0]);
			credentials.put("Password", csvLineData[1]);
		}
		
		return credentials;
		
	}
	

}
