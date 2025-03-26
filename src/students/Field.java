package students;

import students.items.Food;
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
		// dev check
		//System.out.println("Created Field");
		//System.out.println(fieldArray.length);
		//System.out.println(fieldArray[0].length);
	}
	
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
					int roll = (int)(Math.random() * 101);
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
			System.out.println("Input outside of field bounds");
		}
		else
			fieldArray[row][column] = newItem;
	}
	
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
		return "PLACEHOLDER";
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
