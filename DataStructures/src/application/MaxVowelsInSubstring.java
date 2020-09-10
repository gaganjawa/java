package application;

import java.util.HashSet;
import java.util.Set;

public class MaxVowelsInSubstring {

	public static void main(String[] args) {
		
		System.out.println(findSubstring("eiuaooo", 5));
	}
	
	   public static String findSubstring(String s, int k) {
		    // Write your code here

		    int maxCount =0;
		    String result = " ";
		        for(int i=0;i<=s.length() - k;i++) {
		        	int count = 0;
		            String ss = s.substring(i, k+i);
		            Set<Character> charSet = new HashSet<Character>();
		            for (Character c : ss.toCharArray()) {
		                if(c == 'a' || c == 'e' || c=='i' ||c=='o' || c=='u') {
		                	if(!charSet.contains(c)) {
		                		charSet.add(c);
		                		++count;
		                	}
		                }
		            }
		            if(count>maxCount) {
		                maxCount = count;
		                result = ss;
		            } else if (count == maxCount) {
						result = String.valueOf(ss.charAt(0)).compareTo(String.valueOf(result.charAt(0))) < 1 ? ss : result;
					}
		        }
		    return result.equals(" ")? "Not found!" : result;
		    }
		}
