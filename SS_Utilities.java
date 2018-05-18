/*
Program Name: SS_Utilities.java
Purpose: All Methods Used in the Project
Coder: Sandeep Singh
Date: Mon April 2, 2018
*/

//Importing Scanner and ArrayList From the java Utility
import java.util.ArrayList;
import java.util.Scanner;

public class SS_Utilities 
{
	private static Scanner input; //Making private Scanner Object
	/**
	 * myScanner - Initialize the Scanner Object
	 * @return - input
	 */
	public static Scanner myScanner()
	{
		input = new Scanner(System.in);
		return input; // Returns the input
	}//End myScanner
	
	//------------------------------------------------------------------------------------------
	/**
	 * println - Prints a string or int to the console with
	 * 			 a new line.
	 * @param text - The string to print OR number - The int to print
	 */
	public static void println(String text)
	{
		System.out.println(text);
	} //end println
	
	//Method Overloading
	public static void println(int number)
	{
		System.out.println(number);
	} //end println
	
	//------------------------------------------------------------------------------------------
	/**
	 * print - Prints a string or an int or a double to the console without new line
	 * @param text - The string to print or integer or decimal
	 */
	public static void print(String text) //Prints String
	{
		System.out.print(text);
	} //end print
	
	// Method Overloading 
	public static void print(int integer) //Prints Integer
	{
		System.out.print(integer);
	} // End print
	
	// Method Overloading
	public static void print(double decimal) //Prints Double value
	{
		System.out.print(decimal);
	} //End print
	
	//------------------------------------------------------------------------------------------
	/**
	 * printMenu - Prints menus with Serial numbers, Dollar Sign and the Price
	 * @param - String Array of Dish Names
	 * @param - Double Array of Prices
	 */
	public static void printMenu(String[] StringArray,double[] doubleArray)
	{
		for (int a=0;a<StringArray.length;a++) // For loop
		System.out.printf(a+1+" . " +StringArray[a]+" $%.2f\n",doubleArray[a]); //Prints all the menu items of each menu in correct Format
		System.out.println(); //Add a Line
	} // End printMenu
	
	//------------------------------------------------------------------------------------------
	/**
	 * testInteger - Tests whether the user input is of datatype int or not.
	 * @return - User input (if Int type)
	 */
	public static int  testInteger()
	{
		while (true)
			if (input.hasNext()) //Check whether input has something in it or not.
			{
				if (input.hasNextInt()) // Check whether input has int type
				{
					int value = input.nextInt();
					input.nextLine(); //Flush the Buffer
					return value; //Return the user input after checking
				}//End if
				else
				{
					print("INVALID INPUT. Please Enter Again: "); //Prompts user with an error if he puts wrong datatype
					input.nextLine();// Flush the Buffer
				}//End else
			}//End if
	}//End testInteger
	
	//------------------------------------------------------------------------------------------
	/**
	 * testString - Tests whether the user input is of datatype String or not.
	 * @return - User input (if String Type)
	 */
	public static String testString()
	{
		while (true)
		if (input.hasNext()) //Check whether input has something in it or not.
		{
			if (input.hasNextLine()) // Check whether input has String type
			{
				return input.nextLine(); //Return the user input after checking
			}//End if
			else
			{
				print("INVALID INPUT. Please Enter Again: "); //Prompts user with an error if he puts wrong datatype
				input.nextLine();// Flush the Buffer
			}//End else
		}// End if 		
	}//End testString
	
	//------------------------------------------------------------------------------------------
	/**
	 * testSelection - Tests whether the user enters the Correct selection input of datatype Int
	 * 				   And gives Customized Error if its wrong.
	 * @return - User input (Int)
	 */
	public static int  testSelection()
	{
		while (true)
			if (input.hasNext())//Check whether input has something in it or not.
			{
				if (input.hasNextInt())// Check whether input has int type
				{
					int value = input.nextInt();
					input.nextLine(); //Flush the Buffer
					return value; // Return the user input after Checking
				}//End if
				else
				{
					print("INVALID INPUT. Please enter your selection #: "); //Customized Error For the wrong Selection Input
					input.nextLine(); // Flush the Buffer
				}//End else
			}//End if
	}//End testSelection
	
	//------------------------------------------------------------------------------------------
	/**
	 * ValidateUserInput - Ask the user for their Selection and Validates.
	 * 					   Whether it is within the menus' range or not
	 * @param - String Array of menus
	 * @return - The user input After validating
	 */
	public static int validateUserInput(String[] array)
	{
		
		boolean condition = true; // Setting the boolean Condition
		int result = 1; //Setting int variable result to 1
		
		while(condition) //Use While loop for validating the user input
		{
			print("Please enter your selection #: "); //Ask User about their Selection
			int select = testSelection(); //Tests whether the inputed value is int or not.
			if(select > array.length ||select <= 0 ) // Condition which is not needed
			{
				print("INVALID SELECTION. "); // Shown Error and Asks User To enter Again
			}// End if
			
			else 
			{
				condition = false;
				if(select != 1) // If user input is not equal to 1 so that "No Selecton" is not added in the ArrayList
				{
					result = select;
				} // End if
			}// End else		
		}// End while Loop
		return result; // Returns The user input after Validating
	} // End validate
	
	//------------------------------------------------------------------------------------------
	/**
	 * roundOff - Rounds Off to two decimal Places
	 * @param - double value which needs to be rounded off to two decimal places
	 * @return - Returns the rounded Value
	 */
	public static double roundOff(double value)
	{
		double result= Math.round(value * 100.0)/100.0;
		return result;
	}//End roundOff
	
	//------------------------------------------------------------------------------------------
	/**
	 * salesTax - Calculates and rounds off the sales Tax
	 * @param - double value which is needed to be taxed
	 * @return - salesTax Amount
	 */
	public static double salesTax(double value)
	{
		double result = value * 0.13;
		double finalresult = roundOff(result); //Rounding off using roundOff Method
		return finalresult;
	}//End salesTax
	//------------------------------------------------------------------------------------------
	/**
	 * approximately - Calculates the Tip to nearest Nickel
	 * @param - int Value (Percentage)
	 * @param - double value
	 * @return - Tip Amount rounded to nearest Nickel
	 */
	public static double approximately(double value, int number)
	{
		double result = value * ((double)number/100);
		result = Math.round(result * 20.0)/20.0; //Convert tip Amount to nearest Nickel
		return result;
	}//End approximately
	
	//------------------------------------------------------------------------------------------
	/**
	 * printArrayList - Print an ArrayList of String (Using for Each loop and Tab)
	 * @param selection - The array of Strings
	 */
	public static void printArrayList(ArrayList<String> selection)
	{
		for (String value : selection) //foreach loop
		{
			System.out.println("\t" + value); //Using Tab to shift the ArrayList
		} //End foreach Loop
		
		//go to the next line
		System.out.println();
	}// End printArrayList
	
	//------------------------------------------------------------------------------------------
	/**
	 * validateTip - Tests Whether the user has entered correct letter for the tip or not
	 * @return - User input of String Type or Give Error
	 */
	public static String validateTip()
	{
		boolean condition = true; //Initialize boolean Condition
		String input = null;
		while (condition) //True
		{
			print("Would you like to leave a tip? Enter Y or N: "); //Prompts User
			String decision = testString().toLowerCase(); //Checks whether the input is String or not
			if (!decision.equals("y") && !decision.equals("n")) //Conditions to Check
			{
				println("INVALID SELECTION. "); //Error
			}
			else
			{
				input = decision; //Store the correct user input After validating
				break; // Go Out of loop
			}
		}
		return input; //Return the correct input
	}//End validateTip
	
	//------------------------------------------------------------------------------------------
}// End Class