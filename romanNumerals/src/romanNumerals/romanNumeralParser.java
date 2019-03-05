package romanNumerals;

import java.lang.Exception;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class romanNumeralParser {
	private final static int INTEGER_1 = 1;
	private final static int INTEGER_4 = 4;
	private final static int INTEGER_5 = 5;
	private final static int INTEGER_9 = 9;
	private final static int INTEGER_10 = 10;
	private final static int INTEGER_40 = 40;
	private final static int INTEGER_50 = 50;
	private final static int INTEGER_90 = 90;
	private final static int INTEGER_100 = 100;
	private final static int INTEGER_400 = 400;
	private final static int INTEGER_500 = 500;
	private final static int INTEGER_900 = 900;
	private final static int INTEGER_1000 = 1000;
	
	private final static String ROMAN_1 = "I";
	private final static String ROMAN_4 = "IV";
	private final static String ROMAN_5 = "V";
	private final static String ROMAN_9 = "IX";
	private final static String ROMAN_10 = "X";
	private final static String ROMAN_40 = "XL";
	private final static String ROMAN_50 = "L";
	private final static String ROMAN_90 = "XC";
	private final static String ROMAN_100 = "C";
	private final static String ROMAN_400 = "CD";
	private final static String ROMAN_500 = "D";
	private final static String ROMAN_900 = "CM";
	private final static String ROMAN_1000 = "M";
	
	/**
	 * Map for evaluating a numerical value into Roman string representation
	 * e.g. 
	 * 	1 = "I"
	 *  5 = "V"
	 */
	private static final Map<Integer, String> myRomanMap = Collections.unmodifiableMap(
		    new HashMap<Integer, String>() {
				private static final long serialVersionUID = 42L;
				{
			        put(INTEGER_1, ROMAN_1);
			        put(INTEGER_4, ROMAN_4);
			        put(INTEGER_5, ROMAN_5);
			        put(INTEGER_9, ROMAN_9);
			        put(INTEGER_10, ROMAN_10);
			        put(INTEGER_40, ROMAN_40);
			        put(INTEGER_50, ROMAN_50);
			        put(INTEGER_90, ROMAN_90);
			        put(INTEGER_100, ROMAN_100);
			        put(INTEGER_400, ROMAN_400);
			        put(INTEGER_500, ROMAN_500);
			        put(INTEGER_900, ROMAN_900);
			        put(INTEGER_1000, ROMAN_1000);
		    	}
		    });
	
	/**
	 * Display a roman number representation of the given integer value
	 * @param value numerical value to be converted to roman numericals
	 * @return roman number representation of the parameter value
	 */
	public static String parseInt(int value) {
		Set<Entry<Integer, String>> myMapSet = myRomanMap.entrySet();
		String romanStr = new String();
		int x = value;
		// Loop until the whole integer has been handled. On each iteration
		// it finds the highest roman numerical (I, V, etc.) from the map 
		// when compared to the remaining unprocessed int value. 
		// This roman numerical string is appended to the result string
		//
		// For example, for number 6, start with x = 6
		// 		Iteration	x		highest	roman
		// 		1			6		5		V	-> x = x - 5 = 1
		// 		2			1		1		I	-> x = x - 1 = 0 -> iteration ends
		//		-> result is "VI"
		//
		// For example, for number 2012, start with x = 2012
		// 		Iteration	x		highest	roman
		// 		1			2012	1000	M	-> x = x - 1000 = 1012
		// 		2			1012	1000	M	-> x = x - 1000 = 12
		//		3			12		10		X	-> x = x - 10 = 2
		//		4			2		1		I	-> x = x - 1 = 1
		//		5			1		1		I	-> x = x - 1 = 0 -> iteration ends
		//		-> result is "MMXII"
		// 
		while(x != 0) {	
			Iterator<Entry<Integer, String>> myMapIter = myMapSet.iterator();
			int highest = -1;
			while(myMapIter.hasNext()) {
				Map.Entry<Integer, String> entry=(Map.Entry<Integer, String>)myMapIter.next();
				int intValue = entry.getKey();
				// Get highest int value smaller than the remainder from last
				// iteration from the Map. This value is used as a key
				// for the roman string representation of the found int value
				highest = ( intValue <= x && highest < intValue) ? intValue : highest;  
			}			
			// That part of the roman numerical is taken care of, reduce it's
			// value from the remaining numerical value for next iteration
			x = x - highest;
			romanStr = romanStr + myRomanMap.get(highest);
		}
		return romanStr;
	}
}