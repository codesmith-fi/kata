/**
 * 
 */
package fizzbuzz;

/**
 * @author erno
 *
 * This class has logic to evaluate the given number against Fizz/Buzz logic
 * 
 */
public class FizzBuzzEvaluator {
	
	/**
	 * Method to evaluate if the given number is Fizz
	 * meaning it's divisible by three
	 * @param number Number to be tested for Fizz rule
	 * @return true if the number is Fizz
	 */
	public static boolean isFizz(int number) {
		return ((number % 3 == 0) && (number != 0));
	}
	
	/**
	 * Method to evaluate if the given number is Buzz
	 * meaning it's divisible by five
	 * @param number Number to be tested for Buzz rule
	 * @return true if the number is Buzz
	 */
	public static boolean isBuzz(int number) {
		return ((number % 5 == 0) && (number != 0));
	}
	
	/**
	 * Helper method to check that the given number is not either Fizz or
	 * Buzz.
	 * 
	 * @param number A number to be checked against Fizz/Buzz rule
	 * @return true if the number is not divisable by three or five
	 * 	otherwise false
	 */
	public static boolean isNotFizzBuzz(int number) {
		return !isFizz(number) && !isBuzz(number);
	}
}
