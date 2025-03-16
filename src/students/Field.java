package students;

import students.items.Item;
import students.items.Soil;

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
		
		System.out.println("Created Field");
		System.out.println(fieldArray.length);
		System.out.println(fieldArray[0].length);
	}
	
	public Item get(int row, int column) {
		if (row > fieldArray.length || column > fieldArray[0].length) {
			System.out.println("Input outside of field bounds");
			return null;
		}
		
		else {
							
			return fieldArray[row][column].copy();
		}
					
	}
	
	public void tick() {
		
	}
	
	public void till(int row, int column) {
		fieldArray[row][column] =  new Soil();
	}
	
	public void plant(int row, int column, Item newItem) {
		fieldArray[row][column] =  newItem;
	}
	
	public double getValue() {
		return 0;
	}
	
	public String getSummary() {
		return null;
	}
	
	
	
}
