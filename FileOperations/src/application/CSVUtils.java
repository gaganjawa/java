package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {
	
	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE ='"';

	public static void main(String[] args) {
		
		String csvFile = "country2.csv";
		
		CSVReader csvReader = new CSVReader();
		try (Scanner scanner = new Scanner(csvReader.getFileFromResource(csvFile))) {
			while(scanner.hasNext()) {
				List<String> line = parseLine(scanner.nextLine());
	            System.out.println("Country [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static List<String> parseLine(String nextLine) {
		return parseLine(nextLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	}
	
    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

	public static List<String> parseLine(String nextLine, char separator, char quote) {
		List<String> result = new ArrayList<String>();
		
		if (nextLine == null || nextLine.isEmpty()) {
			return result;
		}
		
		if (separator == ' ') {
			separator = DEFAULT_SEPARATOR;
		}
		
		if (quote == ' ') {
			quote = DEFAULT_QUOTE;
		}
		
		StringBuffer value = new StringBuffer();
		boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;
        
        char[] chars = nextLine.toCharArray();
		
        for (char ch : chars) {
			
        	if (inQuotes) {
				startCollectChar = true;
				if (ch == quote) {
					inQuotes = false;
					doubleQuotesInColumn = false;
				} else {
					if (ch == '\"') {
						if (!doubleQuotesInColumn) {
							value.append(ch);
							doubleQuotesInColumn = true;
						}
					} else {
						value.append(ch);
					}
				}
			} else {
				if (ch == quote) {
					inQuotes = true;
					
					if (chars[0] != '"' && quote == '\"') {
						value.append('"');
					}
					
					//double quotes in column will hit this!
					if (startCollectChar) {
						value.append(ch);
					}
				} else if (ch == separator) {
					result.add(value.toString());
					
					value = new StringBuffer();
					startCollectChar = false;
				} else if (ch == '\r') {
					// ignoring LF characters
					continue;
				} else if (ch == '\n') {
					// end of file
					break;
				} else {
					value.append(ch);
				}
			}
		}
        
        result.add(value.toString());
        
		return result;
	}

}
