package students.items;

public class Apples extends Food{
	// represented as 'a' or 'A'
	
	private static int appleCount = 0;
	private static int purchacePrice = 2;
	
	public Apples() {
		super(3, 5, 3);
		appleCount++;
		
	}
	
	public Apples(Apples apple) {
		super(3, 5, 3);
		this.setAge(apple.getAge());
	}
	
	public static int getGenerationCount() {
		return appleCount;
	}
	
	public static int getPurchacePrice() {
		return purchacePrice;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.getAge() >= this.getMaturationAge())
			return "A";
		
		else 
			return "a";
	}

	@Override
	public Apples copy() {
		return new Apples(this);
	}


}
