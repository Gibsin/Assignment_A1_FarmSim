package students.items;

public abstract class Item {
	// unsure what the visibility should be. protected / private 
	protected int age = 0;
	protected int maturationAge;
	private int deathAge;
	private int value;
	
	public Item(int maturationAge, int deathAge, int value) {
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
		if (this.age > this.deathAge && this.deathAge != 0)// accounts for weeds / s infinite life span
			return true;
		else 
			return false;
	}
	
	//TODO: CHECK THIS
	public int getValue() {
		if (this.age >= this.maturationAge) {
			int returnValue = this.value;
			return returnValue;

		}
		else 
			return 0;
	}
	
	public int getDeathAge() {
		return this.deathAge;
	}
	
	// TODO: equals method 
	@Override
	public boolean equals(Object other) {
		if (other instanceof Item) {
			if (other.getClass() == this.getClass()){
				if (((Item) other).age == this.age 
						&& ((Item) other).getValue() == this.value
						&& ((Item) other).getDeathAge() == this.deathAge
						&& ((Item) other).maturationAge == this.maturationAge) {
					return true;
				}
				
			}
			
		}
		
		return false;
	}
	
	@Override
	public abstract String toString();
	
	public abstract Item copy();//provides easy copy for other items
	
	
		
		
	
}
