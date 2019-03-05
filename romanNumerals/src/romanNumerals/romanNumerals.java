package romanNumerals;

public class romanNumerals {

	public static void main(String[] args) {

		String romanStr = romanNumeralParser.parseInt(1);
		System.out.printf("result for 1 is %s%n", romanStr);

		romanStr = romanNumeralParser.parseInt(5);
		System.out.printf("result for 5 is %s%n", romanStr);

		romanStr = romanNumeralParser.parseInt(9);
		System.out.printf("result for 9 is %s%n", romanStr);

		romanStr = romanNumeralParser.parseInt(36);
		System.out.printf("result for 36 is %s%n", romanStr);
		
		romanStr = romanNumeralParser.parseInt(2012);
		System.out.printf("result for 2012 is %s%n", romanStr);
		
		romanStr = romanNumeralParser.parseInt(2013);
		System.out.printf("result for 2013 is %s%n", romanStr);
	}

}
