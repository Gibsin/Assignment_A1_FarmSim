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
	
	public void run()
	{	
		Scanner userInput = new Scanner(System.in);
		
		System.out.println(field);
		System.out.println("\nBank Balance: $" + this.balance);
		System.out.println("Enter your next action:");
		
		String userAction = userInput.nextLine();
		
		int row, column;
		
		//will add else if later 
		
		if (userAction.equals("q")) {
			//Placeholder
			System.out.println("quit game");
		}
		
		if (userAction.equals("s")) {
			System.out.println(this.field.getSummary());
		}
		
		if (userAction.equals("w")) {
			//do something
		}
		
		
		// these three require coordinates so should be grouped
		if (userAction.length() > 0) {
			if (userAction.charAt(0) == 't' || userAction.charAt(0) == 'p' || userAction.charAt(0) == 'h') {
				
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
				catch (Exception e) {
					System.out.println("placeholder error");
				}
							
			}
		}
		
		
		
	}
	
}
