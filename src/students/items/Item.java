package students.items;

public abstract class Item {
	int age = 0;
	int maturationAge;
	int deathAge;
	double value;
	
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
		if (this.age > this.deathAge)
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
