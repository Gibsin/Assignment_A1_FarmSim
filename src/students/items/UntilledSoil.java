package students.items;

public class UntilledSoil extends Item{
	// represented as /
	
	public UntilledSoil() {
		super(0, 0, -1);
		
	}
	
	public UntilledSoil(UntilledSoil unSoil) {
		super(0, 0, 0);		
		this.setAge(unSoil.getAge());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "/";
	}

	@Override
	public Item copy() {
		// TODO Auto-generated method stub
		return new UntilledSoil(this);
	}

}
