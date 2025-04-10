package students;


import java.util.Scanner;

import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import java.util.HashMap;

public class Farm {
	private int balance;
	private Field field;
	private int xpPoints;
	final int DEFAULT_ACTIONS_PER_TURN = 1;// not sure if i need this
	private int actionsPerTurn;
	private int actionsTaken;
	private SkillData[] skillList;
	private HashMap<String, Integer> sellBonus;
	private AchievementTracker achievementTracker;
	
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.balance = startingFunds;
		this.field = new Field(fieldWidth, fieldHeight);
		this.xpPoints = 0;
		this.achievementTracker = new AchievementTracker();
		this.actionsPerTurn = DEFAULT_ACTIONS_PER_TURN;
		this.sellBonus = new HashMap<String, Integer>();
		this.sellBonus.put("Apples", 0);
		this.sellBonus.put("Grain", 0);
		
		// Skill list 
		this.skillList = new SkillData[5];
		this.skillList[0] = new SkillData(6, "Weed Spawns", "Decrease the spawn rate of weeds by 3% per level.", 5, 2);
		this.skillList[1] = new SkillData(10, "Actions Per Turn", "Increase the number of actions you can take per turn by 1 per level.", 10, 5);
		this.skillList[2] = new SkillData(10, "Apple Sell Bonus", "Increase the sell price of apples by $2 per level.", 6, 3);
		this.skillList[4] = new SkillData(10, "Grain Sell Bonus", "Increase the sell price of Grain by $2 per level.", 6, 3);
		
	}
	
	/**Separates the command type from the coordinate arguments**/
	private int[] coordinates(String command) {
		int[] location = new int[2];
		
		String[] commandData = command.split(" ");
		if (commandData.length > 3)
			System.out.println("Error: Too many command arguments.");
		
		else {
			
			try {
				// Column then row. Feels more natural.
				location[0] = Integer.parseInt(commandData[2]);
				location[1] = Integer.parseInt(commandData[1]); 
				
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
		System.out.println("\n" + field);
		System.out.println("Exp Points: " + this.xpPoints);
		System.out.println("Bank Balance: $" + this.balance);
		System.out.println("Actions Taken: " + this.actionsTaken + "/" + this.actionsPerTurn);
		System.out.println("\nEnter your next action:");
		System.out.println("t x y: till \nh x y: harvest "
				+ "\np x y: plant \nx: exp shop"
				+ "\ns: field summary \nw: wait \nq: quit");	
	}
	
		
	/**Starts the process for the player to buy new crops**/
	private Food buyCrops() {
		Scanner purchaseInput = new Scanner(System.in);
		boolean validSelection = false;
		Food returnItem = null;
		
		while (validSelection == false) {
			System.out.println("Enter: \n-'a' to buy an apple for $" + Apples.getPurchacePrice()
			+ "\n-'g' to buy grain for $" + Grain.getPurchacePrice());
			String userAction = purchaseInput.nextLine();
				
			
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
	
	
	/**Gives the player the specified amount of xp and shows them the amount gained.**/
	//added to clean up code
	private void earnXp(int xpAmount) {
		int gainedXp = xpAmount;
		this.xpPoints += gainedXp;
		System.out.println("Gained " + gainedXp + " XP");
	}
	
	//exp shop that lets the player upgrade their farm and skills.
	private void expShop() {	
		
		System.out.println("Skills");
		boolean leaveShop = false;
		
		
		while (leaveShop == false) {
			
			for (int index = 0; index < this.skillList.length; index++) {
				String skillEntry = (index + 1) + " - " + this.skillList[index].getName();
				
				if (this.skillList[index].isMaxLevel()) 
					skillEntry += "| Level: MAX";
				else {
					skillEntry += (" | Price: $" + this.skillList[index].getPrice() + " | Level: ");
					skillEntry += (this.skillList[index].getLevel());
					}
	
				skillEntry += ("\n    " + this.skillList[index].getSkillDesc() + "\n" );
				
				System.out.println(skillEntry);
			}
			
			System.out.println("b - Go back to farm.");
			
			
			Scanner purchaseInput = new Scanner(System.in);
			String userAction = purchaseInput.nextLine();
			
			if (userAction.equals("b")) {
				leaveShop = true;
				continue;
				
			}
			
			try {
				int selection = Integer.parseInt(userAction) - 1;
				if (this.skillList[selection].isMaxLevel() == false && this.xpPoints >= skillList[selection].getPrice()) {

					this.skillList[selection].levelSkill();
					
					if (selection == 0) {
						int currentRate = field.getWeedSpawnRate();
						this.field.setWeedSpawnRate(currentRate - 3);
						this.xpPoints -= skillList[selection].getPrice();
					}
					
					else if (selection == 1) {
						this.actionsPerTurn += 1;	
						this.xpPoints -= skillList[selection].getPrice();	
					}
					
					else if (selection == 2) {
						this.sellBonus.put("Apples", this.sellBonus.get("Apples") + 2);
						this.xpPoints -= skillList[selection].getPrice();
					}
					
					else if (selection == 3) {
						this.sellBonus.put("Grain", this.sellBonus.get("Grain") + 2);
						this.xpPoints -= skillList[selection].getPrice();
					}
					
				}
				else {
					if (this.skillList[selection].isMaxLevel()) 
						System.out.println("This Skill is already max level!");
					
					else
						System.out.println("You can't afford this skill");
				}
					
			}
		
			
			catch(NumberFormatException e) {
				System.out.println("Please type the number of the skill you wish to buy.");
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid selection - number does not appear on skill list");
			}
		
		}
		
	
	}
	
	
		
	/**Starts the game(will add better description)**/
	public void run()
	{	
		int row, column;
		int[] commandCoordinates;
		actionsTaken = 0;
		Scanner userInput = new Scanner(System.in);
		// Actions like field summary should not pass the turn.
		// This Bool makes it so that some actions wont pass the turn.
		
		printInstuctions();
		
		String userAction = userInput.nextLine();
			
		// Strings are kind weird, will change this to something else.
		while (userAction.equals("q") == false){

			// These Command have extra text so need to isolate the first char.
			// not happy with the structure.
			if (userAction.length() > 1) {
				commandCoordinates = coordinates(userAction);
				// resolves issue of field coordinates shown being +1 their array index.
				row = commandCoordinates[1] - 1;
				column = commandCoordinates[0] - 1;
				
				try {
			
					if (userAction.charAt(0) == 't') {
						field.till(row, column);
						Item tillTarget = field.get(row, column);
						this.achievementTracker.updateTillStats(tillTarget);
						earnXp(1);
						actionsTaken += 1;
						}
					
					else if (userAction.charAt(0) == 'p') {
						if (field.get(row, column) instanceof Soil) {
							Food newCrop = buyCrops();
							if (newCrop != null) {
								System.out.println("Succesfully planted new crop!");
								field.plant(row, column, newCrop);
								earnXp(2);	
								actionsTaken += 1;
							}
							
						}
						else
							System.out.println("You may only plant on soil. Passing turn.");
										
					}
					
					
					//Harvest
					else if (userAction.charAt(0) == 'h') {						
						Item harvestTarget = this.field.get(row, column);
						
						if (harvestTarget instanceof Food) {
												
							
							if (harvestTarget.getAge() >= harvestTarget.getMaturationAge()) {		
								String cropType = harvestTarget.getClass().getSimpleName();
								int sellValue = harvestTarget.getValue() + this.sellBonus.get(cropType);	
								System.out.println("Crop was harvested for $" + sellValue);
								this.field.till(row, column); //Assumed that the area is re-tilled? 	
								this.balance += sellValue;
								earnXp(3);
							}
							else {
								System.out.println("Crop was harvested prematurely and has no value!");
								}
							
							
							actionsTaken += 1;

							
						}
						else {
							System.out.println("This is not a harvestable item!");
						}
					}
					//Harvest
					
					
					
					else
						System.out.println("Invalid Command. You lose a turn.");	
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Error: Provided coordinates out of bounds of field.");
				}
			
			}
		
		
			else if (userAction.equals("q")) {
				System.out.println("quit game");
				// Scanner is no longer needed.
				userInput.close();

				break;
			}
		
			else if (userAction.equals("s")) {
				System.out.println(this.field.getSummary());
			}
			
			else if (userAction.equals("w")) {
				actionsTaken = this.actionsPerTurn;
				System.out.println("Doing nothing, waiting till next turn.");
			}
			
			else if (userAction.equals("x")) {
				expShop();
			}
			
			else {	
				actionsTaken += 1;
				System.out.println("Invalid Command. You lose an action.");
			}
			
			
			if (actionsTaken >= this.actionsPerTurn) {
				System.out.println("Turn ended. Passing time....");
				this.field.tick();
				actionsTaken = 0;
			}
			achievementTracker.checkAchievements();
			
			printInstuctions();
			
			userAction = userInput.nextLine();
			// END OF LOOP
		}
		System.out.println("Game Ended");
	}
}

		
		
	
