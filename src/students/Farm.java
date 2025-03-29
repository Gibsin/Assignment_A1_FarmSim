package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;

public class Farm {
	private int balance;
	private Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.balance = startingFunds;
		this.field = new Field(fieldWidth, fieldHeight);
		
	}
	
	/**Separates the command type from the coordinate arguments**/
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
	
	/** Prints out farm commands, balance and field.**/
	private void printInstuctions() {
		// This was placed in it's own function to make any changes to the command list easier.
		System.out.println(field);
		System.out.println("Bank Balance: $" + this.balance);
		System.out.println("\nEnter your next action:");
		System.out.println("t x y: till \nh x y: harvest \np x y: plant \ns: field summary \nw: wait \nq: quit");	
	}
	
	/**Starts the process for the player to buy new crops**/
	private Food buyCrops() {
		Scanner userInput = new Scanner(System.in);
		boolean validSelection = false;
		Food returnItem = null;
		
		while (validSelection == false) {
			System.out.println("Enter: \n-'a' to buy an apple for $" + Apples.getPurchacePrice()
			+ "\n- 'g' to buy grain for $" + Grain.getPurchacePrice());
			String userAction = userInput.nextLine();
			
			if (userAction.equals("a")) {
				validSelection = true;
				if (this.balance >= Apples.getPurchacePrice()) {
					System.out.println("Purchaced Apple");
					this.balance -= Apples.getPurchacePrice();
					returnItem = new Apples();
				}
				else
					System.out.println("You do not have enough money to Purchace Apple, returning to farm.");
			}
			
			else if (userAction.equals("g")) {
				validSelection = true;
				if (this.balance >= Grain.getPurchacePrice()) {
					System.out.println("Purchaced Grain");
					this.balance -= Grain.getPurchacePrice();
					returnItem = new Grain();
				}
				else
					System.out.println("You do not have enough money to Purchace Grain, returning to farm.");
			}
							
			else {
				System.out.println(userAction + " is not a valid selection.");
			}
		}
		return returnItem;
		
		
	}
	
	
	
	
	/**Starts the game(will add better description)**/
	public void run()
	{	
		int row, column;
		int[] commandCoordinates;
		Scanner userInput = new Scanner(System.in);
		// Actions like field summary should not pass the turn.
		// This Bool makes it so that some actions wont pass the turn.
		boolean turnPassed;
		
		printInstuctions();
		
		String userAction = userInput.nextLine();
			

		// Strings are kind weird, will change this to something else.
		while (userAction.equals("q") == false){
			turnPassed = false;
			
			// These Command have extra text so need to isolate the first char.
			if (userAction.length() > 1) {
				turnPassed = true;
				commandCoordinates = coordinates(userAction);
				// resolves issue of field coordinates shown being +1 their array index.
				row = commandCoordinates[0] - 1;
				column = commandCoordinates[1] - 1;
				
				try {
			
					if (userAction.charAt(0) == 't') {
						field.till(row, column);	
						}
					
					else if (userAction.charAt(0) == 'p') {
						if (field.get(row, column) instanceof Soil) {
							Food newCrop = buyCrops();
							if (newCrop != null) {
								field.plant(row, column, newCrop);
							}
							
						}
						else
							System.out.println("You may only plant on soil.");
						
						
					}
			
					else if (userAction.charAt(0) == 'h') {
						Item harvestTarget = this.field.get(row, column);
						if (harvestTarget instanceof Food) {
						this.balance += harvestTarget.getValue();
						if (harvestTarget.getAge() < harvestTarget.getMaturationAge()) {
							System.out.println("Crop was harvested prematurely!");
						}
						System.out.println("Crop was harvested for $" + harvestTarget.getValue());
						this.field.till(row, column); //Assumed that the area is re-tilled? 
						}
						else {
							System.out.println("This is not a harvestable item!");
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Error: Provided coordinates out of bounds of field.");
				}
			
			}
		
		
			else if (userAction.equals("q")) {
				// TODO: Add real quit function
				System.out.println("quit game");
				// Scanner is no longer needed.
				userInput.close();
				break;
			}
		
			else if (userAction.equals("s")) {
				System.out.println(this.field.getSummary());
			}
			
			else if (userAction.equals("w")) {
				turnPassed = true;				
				System.out.println("Doing nothing, waiting till next turn...");
			}
			
			else {
				turnPassed = true;	
				System.out.println("Invalid Command. You lose a turn.");
			}
			
			
			if (turnPassed == true)
				this.field.tick();
			
			printInstuctions();
			
			userAction = userInput.nextLine();
			// END OF LOOP
		}
		System.out.println("Game Ended");
	}
}

		
		
	
