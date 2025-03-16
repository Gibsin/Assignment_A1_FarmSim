package students.items;

public class Soil extends Item{
	// represented as .
	
	public Soil() {
		super(0, 0, 0);
		
	}
		
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ".";
	}


	@Override
	public Item copy() {
		// TODO Auto-generated method stub
		Soil soilCopy = new Soil();
		return soilCopy;
	}

}

