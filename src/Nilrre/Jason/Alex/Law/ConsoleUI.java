package Nilrre.Jason.Alex.Law;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options
	 *            - Strings representing the menu options
	 * @param withQuit
	 *            - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 * @throws IOException
	 */
	static int promptForMenuSelection(String[] options, boolean withQuit) throws IOException {
		boolean valid;
		int value = -1;
		if (options == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(options);
			if (withQuit == true) {
				System.out.println("0: Quit");
			}
			String user = in.readLine();
			try {
				value = Integer.parseInt(user);
			} catch (NumberFormatException nfe) {
				System.out.println("Must Enter a Number in the Menu");
				valid = false;
			}
		} while (valid == false);
		return value;
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses
	 * that will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters
	 * "no", the method returns false. All other inputs are considered invalid,
	 * the user will be informed, and the prompt will repeat.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param trueString
	 *            - the case insensitive value that will evaluate to true
	 * @param falseString
	 *            - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 * @throws IOException
	 */
	static boolean promptForBool(String prompt, String trueString, String falseString) throws IOException {
		boolean user = false;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String userInput = in.readLine();
			if (userInput.equalsIgnoreCase(trueString)) {
				user = true;
			} else if (userInput.equalsIgnoreCase(falseString)) {
				user = false;
			} else {
				System.out.println("Error");
				valid = false;
			}
		} while (valid == false);
		return user;

	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the byte value
	 * @throws IOException
	 */
	static byte promptForByte(String prompt, byte min, byte max) throws IOException {
		byte userInput = 0;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			try {
				userInput = Byte.parseByte(input);
				if (min > userInput || userInput > max) {
					valid = false;
					System.out.println("Out Of Range");
				}
			} catch (NumberFormatException nfe) {
				valid = false;
				System.out.println("Invalid Input");
			}

		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a short
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the short value
	 * @throws IOException
	 */
	static short promptForShort(String prompt, short min, short max) throws IOException {
		short userInput = 0;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			try {
				userInput = Short.parseShort(input);
				if (min > userInput || userInput > max) {
					valid = false;
					System.out.println("Out of Range");
				}
			} catch (NumberFormatException nfe) {
				valid = false;
				System.out.println("Invalid Input");
			}
		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing an int
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the int value
	 * @throws IOException
	 */
	static int promptForInt(String prompt, int min, int max) throws IOException {
		int userInput = 0;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			try {
				userInput = Integer.parseInt(input);
				if (min > userInput || userInput > max) {
					valid = false;
					System.out.println("Out of Range");
				}
			} catch (NumberFormatException nfe) {
				valid = false;
				System.out.println("Invalid Input");
			}
		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the long value
	 * @throws IOException
	 */
	static long promptForLong(String prompt, long min, long max) throws IOException {
		long userInput = 0;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			try {
				userInput = Long.parseLong(input);
				if (min > userInput || userInput > max) {
					valid = false;
					System.out.println("Out of Range");
				}
			} catch (NumberFormatException nfe) {
				valid = false;
				System.out.println("Invalid Input");
			}
		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the float value
	 * @throws IOException
	 */
	static float promptForFloat(String prompt, float min, float max) throws IOException {
		float userInput = 0;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			try {
				userInput = Float.parseFloat(input);
				if (min > userInput || userInput > max) {
					valid = false;
					System.out.println("Out of Range");
				}
			} catch (NumberFormatException nfe) {
				valid = false;
				System.out.println("Invalid Input");
			}
		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the double value
	 * @throws IOException
	 */
	static double promptForDouble(String prompt, double min, double max) throws IOException {
		double userInput = 0;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			try {
				userInput = Double.parseDouble(input);
				if (min > userInput || userInput > max) {
					valid = false;
					System.out.println("Out of Range");
				}
			} catch (NumberFormatException nfe) {
				valid = false;
				System.out.println("Invalid Input");
			}
		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns
	 * the String. When allowEmpty is true, empty responses are valid. When
	 * false, responses must contain at least one character (including
	 * whitespace).
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user.
	 * @param allowEmpty
	 *            - when true, makes empty responses valid
	 * @return the input from the user as a String
	 * @throws IOException
	 */
	static String promptForInput(String prompt, boolean allowEmpty) throws IOException {
		boolean valid;
		String userInput;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			userInput = in.readLine();
			if (allowEmpty == false) {
				if (userInput == "") {
					valid = false;
				} else {
					valid = true;
				}
			} else {
				valid = true;
			}
		} while (valid == false);
		return userInput;
	}

	/**
	 * Generates a prompt that expects a single character input representing a
	 * char value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the char value
	 * @throws IOException
	 */
	static char promptForChar(String prompt, char min, char max) throws IOException {
		char userInput;
		boolean valid;
		if (prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		do {
			valid = true;
			System.out.println(prompt);
			String input = in.readLine();
			userInput = input.charAt(0);
			if (min > userInput || userInput > max) {
				valid = false;
				System.out.println("Invalid Input");
			}
		} while (valid == false);
		return userInput;
	}
}