package students.items;

public class Apples extends Food{
	// represented as 'a' or 'A'
	
	private static int appleCount = 0;
	public double purchacePrice = 2;
	
	public Apples() {
		super(3, 5, 3);
		appleCount++;
		
	}
	
	public static int getGenerationCount() {
		return appleCount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.age >= this.maturationAge)
			return "A";
		
		else 
			return "a";
	}

	@Override
	public Item copy() {
		// TODO Auto-generated method stub
		Apples applesCopy = new Apples();
		applesCopy.setAge(this.age);
		return applesCopy;
	}

}
