package students.items;

public class Grain extends Food{
	
	private static int grainCount = 0;
	public double purchacePrice = 1;// No clue if this is even supposed to be a thing (no direct mention?)

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
		return null;
	}
	
}
