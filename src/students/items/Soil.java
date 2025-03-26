package students.items;

public class Soil extends Item{
	// represented as .
	
	public Soil() {
		super(0, 0, 0);
		
	}
	
	public Soil(Soil soil) {
		super(0, 0, 0);		
		this.setAge(soil.age);
	}
		
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ".";
	}

	
	@Override
	public Soil copy() {
		return new Soil(this);
		// TODO Auto-generated method stub
	}

	

}

