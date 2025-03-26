package students;

import java.util.Scanner;

import students.items.Food;
import students.items.Item;

public class Farm {
	private int balance;
	private Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.balance = startingFunds;
		this.field = new Field(fieldWidth, fieldHeight);
		
	}
	
	private int[] coordinates(String command) {
		int[] location = new int[2];
		
		String[] commandData = command.split(" ");
		// TODO: Add Exception for this. (maybe)
		if (commandData.length > 3)
			System.out.println("Error: Too many command arguments.");
		
		else {
			
			try {
				location[0] = Integer.parseInt(commandData[1]);
				location[1] = Integer.parseInt(commandData[2]); 
				
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Error: Missing command arguments");
			}
			catch(NumberFormatException e) {
				System.out.println("Error: Command arguments must be a number.");
			}
					
		}
		
		return location;
	}
	
	
	
	public void run()
	{	
		int row, column;
		Scanner userInput = new Scanner(System.in);
		
		System.out.println(field);
		System.out.println("\nBank Balance: $" + this.balance);
		System.out.println("Enter your next action:");
		
		// Testing 
		String testCommand = "t p 4";
		int[] x = coordinates(testCommand);
		System.out.println(x[0]);
		System.out.println(x[1]);
		
		//int errorMaker = Integer.parseInt("d");
		
		// TODO: Add action list.

		String userAction = userInput.nextLine();
		
		
		
		// TODO: Add while loop.
		// Strings are kind weird, will change this to something else.
		while (userAction.equals("q") == false){
			
		}
		
		if (userAction.equals("q")) {
			// TODO: Add real quit function
			System.out.println("quit game");
			// Scanner is no longer needed.
			userInput.close();
		}
		
		if (userAction.equals("s")) {
			System.out.println(this.field.getSummary());
		}
		
		if (userAction.equals("w")) {
			//TODO: Add functionally to wait
		}
		
		// TODO: resolve issue of field locations(index) being -1 of the represented values.
		// These three commands require coordinates. Grouped so coordinates can be parsed in one place. 
		if (userAction.length() > 0) {
			if (userAction.charAt(0) == 't' || userAction.charAt(0) == 'p' || userAction.charAt(0) == 'h') {
				
				// Separates the coordinates from the command. 
				String[] actionSplit = userAction.split(" ");
								
				try {
					row = Integer.parseInt(actionSplit[1]);
					column = Integer.parseInt(actionSplit[2]);
					

					if (userAction.charAt(0) == 't') {
						this.field.till(row, column);
					}
					
					else if (userAction.charAt(0) == 'p') {
						//TODO: Add functionality 
					}
					
					else if (userAction.charAt(0) == 'h') {
						Item harvestTarget = this.field.get(row, column);
						if (harvestTarget instanceof Food) {
							this.balance += harvestTarget.getValue();
							//Does the plant get removed?
						}
					}
					
				}
				// TODO: Add better Exception handling.
				catch (Exception e) {
					System.out.println("placeholder error");
				}
							
			}
		}
		
		
		
	}
	
}
