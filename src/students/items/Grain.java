package students.items;

public class Grain extends Food{
	// represented as 'g' or 'G'
	
	private static int grainCount = 0;
	public int purchacePrice = 1;// No clue if this is even supposed to be a thing (no direct mention?)

	public Grain() {
		// Mature: 2, Death: 6, Value: 2
		super(2,6,2); // probably need better way of doing this :/
		grainCount++;
	}

	


	public static int getGenerationCount() {
		return grainCount;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.age >= this.maturationAge)
			return "G";
		
		else 
			return "g";
	}


	@Override
	public Item copy() {

		Grain grainCopy = new Grain();
		grainCopy.setAge(this.age);
		return grainCopy;
	}
}
