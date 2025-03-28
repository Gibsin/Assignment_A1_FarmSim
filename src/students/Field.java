package students;


import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

public class Field {
	private Item[][] fieldArray;
	
	public Field(int height, int width)
	{
		this.fieldArray = new Item[height][width];
		
		int row, column;
		for (row = 0; row < height; row++) {
			
			for (column = 0; column < width; column++) {
				fieldArray[row][column] = new Soil();
				
			}
		
		}
	}
	
	/**Returns Item at specified location (row column)**/
	public Item get(int row, int column) {
		if (row > fieldArray.length || column > fieldArray[0].length) {
			System.out.println("Input outside of field bounds");
			return null;
		}
		
		else {
							
			return (fieldArray[row][column]);
		}
					
	}
	
	
	public void tick() {
		int row, column;
		int height = fieldArray.length;
		int width = fieldArray[0].length;
		for (row = 0; row < height; row++) {
			
			for (column = 0; column < width; column++) {
				fieldArray[row][column].tick();
				if (fieldArray[row][column].died()) {
					fieldArray[row][column] = new UntilledSoil();
				}
				if (fieldArray[row][column] instanceof Soil) {
					int roll = (int)(Math.random() * 101); //Creates whole number from 1 - 100
					if (roll <= 20) 
						fieldArray[row][column] = new Weed();
					
					
				}	
				
			}
			
		}
		
	}
	
	
	public void till(int row, int column) {
		if (row > fieldArray.length || column > fieldArray[0].length) {
			System.out.println("Input outside of field bounds");
		}
		
		else
			fieldArray[row][column] =  new Soil();
	}
	
	public void plant(int row, int column, Food newItem) {
		if (row > fieldArray.length || column > fieldArray[0].length) {
		}
		else
			fieldArray[row][column] = newItem;
	}
	
	/**Returns the total value all items in the field **/
	public double getValue() {
		double sumValue = 0;
		int row, column;
		int height = fieldArray.length;
		int width = fieldArray[0].length;
		for (row = 0; row < height; row++) {
			
			for (column = 0; column < width; column++) {
				sumValue += fieldArray[row][column].getValue();
			}
			
		}
		
		return sumValue;
	}
	
	//TODO: implement this
	public String getSummary() {
		int row, column;
		int height = fieldArray.length;
		int width = fieldArray[0].length;
		int appleCount = 0;
		int grainCount = 0;
		int weedCount = 0;
		int soilCount = 0;
		int untilledCount = 0;
		
		int index;
		// Uses the name of the class to determine and count instances of each class. 
		String[] types = {"Apples", "Grain", "Soil", "UntilledSoil", "Weed"}; 
		int[] count = {0, 0, 0, 0, 0};		
		
		for (row = 0; row < height; row++) {			
			for (column = 0; column < width; column++) {
				for (index = 0; index < types.length; index++) {
					if (fieldArray[row][column].getClass().getSimpleName().equals(types[index])) {
						count[index] += 1;
						break;
					}
				}
				
			}
					
		}

		String returnSummary = "Apples:" + count[0] +"\nGrain: " + count[1] + 
				"\nSoil: " + count[2] + "\nUntilled: " + count[3] + "\nWeed: " + count[4]
						+ "\nFor a total of: $" + this.getValue()
						+ "\nTotal apples created: " + Apples.getGenerationCount()
						+ "\nTotal grain created: " + Grain.getGenerationCount();
		
		return returnSummary;
	}
	
	@Override
	public String toString() {
		
		int row, column;
		int height = fieldArray.length;
		int width = fieldArray[0].length;
		String fieldDisplay = "";
		fieldDisplay += String.format("%3s", "");
		for (column = 0; column < width; column++) {
			fieldDisplay += String.format("%3s", (column + 1));
		}
		fieldDisplay += "\n";
		
		for (row = 0; row < height; row++) {
			fieldDisplay += String.format("%-3s", (row + 1));
			for (column = 0; column < width; column++) {
				fieldDisplay += String.format("%3s", this.get(row, column));
				
			}
			fieldDisplay += "\n";
		}
	
		return fieldDisplay;
	}
	
	
	
}
