package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class CSVReader {
	
	public static void main(String[] args) {
		
		String csvFile = "country.csv";
		String line = "";
		String splitBy = ",";
		
		CSVReader reader = new CSVReader();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(reader.getFileFromResource(csvFile)))) {
			while((line = br.readLine()) != null) {
				String[] country = line.split(splitBy);
				System.out.println("Country [code="+country[4]+" , name="+country[5]+"]");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private File getFileFromResource(String fileName) {
		
		URL resource = getClass().getClassLoader().getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found");
		} else {
			return new File(resource.getFile());
		}
	}
	
}
