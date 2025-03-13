package students.items;

public abstract class Item {
	// unsure what the visibility should be. protected / private 
	protected int age = 0;
	private int maturationAge;
	private int deathAge;
	private double value;
	
	public Item(int maturationAge, int deathAge, double value) {
		this.maturationAge = maturationAge; 
		this.deathAge = deathAge;
		this.value = value;
		
	}
	
	public void tick() {
		this.age++;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public boolean died(){
		if (this.age > this.deathAge && this.deathAge != 0)// accounts for weeds / soil infinite life span
			return true;
		else 
			return false;
	}
	
	public double getValue() {
		if (this.age >= this.maturationAge) {
			return this.value;

		}
		else 
			return 0;
	}
	
	// TODO: equals method 
	
	@Override
	public abstract String toString();
		
		
	
}
