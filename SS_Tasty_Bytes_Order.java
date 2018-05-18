/*
Program Name: SS_Tasty_Bytes_Order.java
Purpose: Allow User To choose From Menus and then Tells their Bill Due.
Coder: Sandeep Singh
Date: Mon April 2, 2018
*/

// Importing ArrayList From the Java Utility
import java.util.ArrayList;
import java.util.Scanner;

public class SS_Tasty_Bytes_Order
{
	public static void main(String[] args)
	{
		//Print Title of the Program using println Method
		SS_Utilities.println("*****************************\n*  Welcome to Tasty Bytes!  *\n*****************************\n");
		SS_Utilities.myScanner(); //Initialize Scanner Object
		
		//Prompt user
		SS_Utilities.print("First tell me how many people there are in your group: ");
		// Saving the user input
		int noOfDiners = SS_Utilities.testInteger();
		System.out.println(); //Go to next Line
	
		
		//Make String Array for recording all the diners
		String [] dinerArray = new String [noOfDiners];
		
		//Use for loop to ask diners their name
		for (int i=1; i<=noOfDiners; i++)
		{
			//Prompt User using print method
			SS_Utilities.print("Please enter the name of diner #"+i+": ");
			String name = SS_Utilities.testString();//Saving the user input and testing whether is it String or not
			dinerArray[i-1] = name; //saving the name of the diner in the diner Array
		}
	
		SS_Utilities.println("\nNow each person will need to order an item from each menu category\nincluding appetizer, main course, dessert, and beverage.\n\nI will ask each diner for all their menu selection.\n");
		//Making Arrays for the menus and their price
		String[] appetizerArray = {"**No Selection**","Deep Fried Calamari","Soup du Jour","Garden Salad","Garlic Bread"};
		double[] appetizerPrice = {0.00,7.50,4.99,3.99,4.50};
		
		String[] mainCourseArray = {"**No Selection**","Rib-Steak","Fettuccini Alfredo","Pan-Fried Sole","Mediterranean Platter","Vegetarian Lasagna"};
		double[] mainCoursePrice = {0.00,15.95,11.25,17.95,13.50,9.00};
		
		String[] dessertArray = {"**No Selection**","Ice Cream Sundae","Cheesecake","Chocolate Truffle Cake","Raspberry Mousse"};
		double[] dessertPrice = {0.00,2.95,5.00,6.00,4.50};
		
		String[] beverageArray = {"**No Selection**","Water","Juice","Pop","Milk","Coffee","Tea"};
		double[] beveragePrice = {0.00,0.00,2.00,2.00,2.00,1.75,1.75};
		
		//Initializing Variables (Act as accumulator variables)
		double bill = 0.00;
		double totalBill = 0.00;
		//Initializing Array for recording the bills of each diner
		double[] billingArray = new double [noOfDiners];
		
		//Use for loop to ask user about their selections from each menus
		for (int i=0; i<dinerArray.length; i++)
		{
			//Initializing Array List to record the selections made by the user
			ArrayList <String> selection = new ArrayList<String>();
			System.out.println(dinerArray[i]+", please make your selections from the following menus:\nPlease select one item from the Appetizer menu.\n");
			
			SS_Utilities.printMenu(appetizerArray, appetizerPrice); // Print the Appetizer menu using 'printMenu' Method
			int appetizerSelection = SS_Utilities.validateUserInput(appetizerArray); // Prompt user to select their dish and validate the input using 'validateUserInput' method
			if (appetizerSelection != 1) // Not saving 'no selection'  if  user inputs 1
			{
			selection.add(appetizerArray[appetizerSelection - 1 ]);
			}// End if
			bill+= appetizerPrice[appetizerSelection- 1 ]; //calculating the bill amount in the accumulator variable
			
			SS_Utilities.print("\nPlease select one item from the Main course menu.\n\n");
			SS_Utilities.printMenu(mainCourseArray, mainCoursePrice);// Print the Appetizer menu using 'printMenu' Method
			int mainCourseSelection = SS_Utilities.validateUserInput(mainCourseArray);// Prompt user to select their dish and validate the input using 'validateUserInput' method
			if (mainCourseSelection != 1)//Not saving 'no selection'  if  user inputs 1
			{
				selection.add(mainCourseArray[mainCourseSelection - 1]);
			}// End if
			bill += mainCoursePrice[mainCourseSelection-1];//calculating the bill amount in the accumulator variable
			
			SS_Utilities.print("\nPlease select one item from the Dessert menu.\n\n");
			SS_Utilities.printMenu(dessertArray, dessertPrice);// Print the Appetizer menu using 'printMenu' Method
			int dessertSelection = SS_Utilities.validateUserInput(dessertArray);// Prompt user to select their dish and validate the input using 'validateUserInput' method
			if (dessertSelection != 1)//Not saving 'no selection'  if  user inputs 1
			{
				selection.add(dessertArray[dessertSelection - 1]);//calculating the bill amount in the accumulator variable
			}//End if
			bill += dessertPrice[dessertSelection - 1];
			
			SS_Utilities.print("\nPlease select one item from the Beverage menu.\n\n");
			SS_Utilities.printMenu(beverageArray, beveragePrice);// Print the Appetizer menu using 'printMenu' Method
			int beverageSelection = SS_Utilities.validateUserInput(beverageArray);// Prompt user to select their dish and validate the input using 'validateUserInput' method
			if (beverageSelection != 1)//Not saving 'no selection'  if  user inputs 1
			{
				selection.add(beverageArray[beverageSelection - 1]);
			}//End if
			bill += beveragePrice[beverageSelection - 1];//calculating the bill amount in the accumulator variable
			
			SS_Utilities.println("\nThank you, "+dinerArray[i]+". Your order consists of:\n");// Thank the diner
			
			SS_Utilities.printArrayList(selection);//Print All the selections made by the diner using the method named 'printArrayList'
			
			//Saving the whole bill for  one diner in billing Array
			billingArray[i] = bill;
			totalBill += bill; // Calculate total bill by adding all the bills
			bill = 0.00; //Empty the bill variable
		}// End For Loop
	
		SS_Utilities.println("\n------------------------------------------------------------------------");
		SS_Utilities.print("All Orders have been completed.\n\nFor just one bill, enter the number 1. \nFor separate bills, enter the number 2.");
		
		int billingCode; //Initializing an int variable
		//input validation using do-While loop
		do {
		System.out.print("\nEnter the biling code: "); //Prompt user
		billingCode = SS_Utilities.testInteger(); //Check whether the input is int or not
		} while(billingCode > 2 || billingCode < 1); //Condition
		
		if (billingCode == 1) //If user want one bill
		{
			double taxAmt = SS_Utilities.salesTax(totalBill); //Calculate HST (Rounded) from the method called 'salesTax'
			System.out.printf("\nThe total bill for your group comes to $%.2f before taxes.\nHST (13%%) total is $%.2f. \n\n", totalBill,taxAmt); // formatting

			String tipQ = SS_Utilities.validateTip(); //Ask user for the tip and returns after validating
			
			switch (tipQ)
			{
			case "y": //if user want to give tip
			SS_Utilities.print("Enter the percentage tip as a whole number (i.e 15 for 15%): "); //prompt user using 'print' method
			int tip = SS_Utilities.testInteger(); // test whether the input is an integer or not using testInteger method
			double tipAmt = SS_Utilities.approximately(totalBill,tip); //Calculate tip Amount from the  method called 'approximately' and returns to the nearest nickel
			double finalBill = tipAmt + totalBill + taxAmt; //Calculate Final Bill
			System.out.printf("\nThank You. With a %d%% tip of $%.2f, your total bill comes to $%.2f \n",tip,tipAmt,finalBill); //Formatting
			break;
			
			case "n": //If user don't want to tip
				double finalAmt = totalBill + taxAmt; //Calculate the final Bill
			System.out.printf("Your total bill comes to be $%.02f. including taxes.",finalAmt); //Formatting
			break;
			} // End Switch
		}// End if
		else if (billingCode == 2) //If user want separate bills
		{
			for (int i=0; i< noOfDiners;i++) //Use for loop to calculate individual  bill of each diner
			{
			double taxAmt = SS_Utilities.salesTax(billingArray[i]); //Calculate HST (Rounded) from the method called 'salesTax'
			System.out.printf("\n\n%s, your total bill comes to $%.2f before taxes.\nHST (13%%) total is $%.2f.\n\n",dinerArray[i],billingArray[i],taxAmt);
			String tipQ = SS_Utilities.validateTip();//Ask user for the tip and returns after validating
			switch (tipQ)
			{
			case "y":
			SS_Utilities.print("Enter the percentage tip as a whole number (i.e 15 for 15%): ");
			int tip = SS_Utilities.testInteger(); // test whether the input is an integer or not using testInteger method
			double tipAmt = SS_Utilities.approximately(billingArray[i],tip);//Calculate tip Amount from the  method called 'approximately' and returns to the nearest nickel
			double finalBill = tipAmt + billingArray[i] + taxAmt;//Calculate Final Bill
			System.out.printf("Thank You. With a %d%% tip of $%.2f, your total bill comes to $%.2f.\n",tip,tipAmt,finalBill);
			break;
			case "n":
				double finalAmt = billingArray[i] + taxAmt;
				System.out.printf("\n%s, Your total bill comes to $%.2f including taxes.",dinerArray[i],finalAmt);
			break;
			}// End Switch
			}// End for Loop
			
		}// End else if	
		SS_Utilities.println("\n\nThank you for your patronage, and please come again!");
	}//end main
}//end class