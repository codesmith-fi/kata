/**
 * 
 */
package fizzbuzz;	

/**
 * @author erno
 *
 */
public final class FizzBuzz {

	/**
	 * Program entry point for the FizzBuzz application. Displays output in 
	 * the console window. Evaluates a series of numbers to see if the 
	 * number is either Fizz or Buzz depending on if the number is divisible
	 * by three or five. If neither, the number itself is displayed.
	 * 
	 * @param args If a number is given the app displays the following
	 *		Fizz, the number is divisible by three
	 *		Buzz, the number is divisible by five
	 *		the number itself, none of the above
	 *		If no argument, displays Fizz/Buzz evaluation for numbers 1-100
	 *@return String "Fizz", "Buzz" or the number itself if argument was given
	 */
	public static void main(String[] args) {
		// Todo: Arguments not yet implemented 
		if(args.length > 0) {
			throw new IllegalArgumentException("Arguments not yet implemented!");
		}
		
		// Go though numbers from 1 to 100 and print out either "Fizz", "Buzz", "FizzBuzz"
		// or the number itself depending on if the number is divisible by three, five 
		// or neither
		System.out.printf("Checking numbers from 1 to 100 for Fizz/Buzz:%n");
		for(int i = 1; i <= 100; i++) {
			String value = String.valueOf(i);
			FizzBuzz.checkString(value);
		}
	}
	
	public static void checkString(String valueStr) {
		if(FizzBuzzEvaluator.isFizz(valueStr)) {
			System.out.print("Fizz");
		}
		if(FizzBuzzEvaluator.isBuzz(valueStr)) {
			System.out.print("Buzz");
		}
		if(!FizzBuzzEvaluator.isFizz(valueStr) && !FizzBuzzEvaluator.isBuzz(valueStr)) {
			System.out.print(i);		
		}
		System.out.println("");		
	}
}
