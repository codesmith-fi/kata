/**
 * 
 */
package fizzbuzz;	

/**
 * FizzBuzz kata implementation, application entry point with needed testing
 * logic
 * @see http://codingdojo.org/kata/FizzBuzz/ 
 * @author erno
 *
 */
public final class FizzBuzz {

	/**
	 * Program entry point for the FizzBuzz application. Displays output in 
	 * the console window. Evaluates a series of numbers to see if the 
	 * number is either Fizz or Buzz depending on if the number is divisible
	 * by three or five or contains "3" or "5". 
	 * If neither, the number itself is displayed.
	 * 
	 * @param args If a number is given the app displays the following
	 *		Fizz, the number is divisible by three or contains "3"
	 *		Buzz, the number is divisible by five or contains "5"
	 *		the number itself, none of the above
	 *		If no argument, displays Fizz/Buzz evaluation for numbers 1-100
	 */
	public static void main(String[] args) {
		// If argument was provided, the first arg will be checked
		if(args.length > 0) {
			FizzBuzz.checkString(args[0]);			
		} else {
			// Go though numbers from 1 to 100 and print out either "Fizz", "Buzz", "FizzBuzz"
			// or the number itself depending on if the number is divisible by three, five 
			// or neither
			System.out.printf("Checking numbers from 1 to 100 for Fizz/Buzz:%n");
			for(int i = 1; i <= 100; i++) {
				String value = String.valueOf(i);
				FizzBuzz.checkString(value);
			}
		}
	}
	
	/**
	 * Helper method to do the actual Fizz, Buzz testing for a given string
	 * @param valueStr number string to be tested
	 */
	public static void checkString(String valueStr) {
		try {
			if(FizzBuzzEvaluator.isFizz(valueStr)) {
				System.out.print("Fizz");
			}
			if(FizzBuzzEvaluator.isBuzz(valueStr)) {
				System.out.print("Buzz");
			}
			if(!FizzBuzzEvaluator.isFizz(valueStr) && !FizzBuzzEvaluator.isBuzz(valueStr)) {
				System.out.print(valueStr);		
			}
			System.out.println("");
		} catch(NumberFormatException e) {
			System.out.printf("String %s is not a valid number!%n", valueStr);
		}
	}
}
