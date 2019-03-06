package romanNumerals;

public class romanNumerals {

	public static void main(String[] args) {
		System.out.println("Roman numbers for 0-1000:");
		for( int i=0; i<1001; ++i) {
			String romanStr = romanNumeralParser.parseInt(i);
			if(romanStr.isEmpty()) {
				romanStr = "Not a valid Roman numeral";
			}
			System.out.printf("%5d: %s%n", i, romanStr);
		}
	}

}
