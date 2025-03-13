package students.items;

public class Apples extends Food{
	
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
		return ("Apple Age: " + this.age);
	}

}
