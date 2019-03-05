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
	 * @param number string of a number to be tested
	 * @return true if the number is Fizz
	 */
	public static boolean isFizz(String number) {
		int val = Integer.parseInt(number);
		return (val % 3 == 0) && (val != 0);
	}
	
	/**
	 * Method to evaluate if the given number is Buzz
	 * meaning it's divisible by five
	 * @param number string of a number to be tested
	 * @return true if the number is Buzz
	 */
	public static boolean isBuzz(String number) {
		int val = Integer.parseInt(number);
		return (val % 5 == 0) && (val != 0);
	}
}
