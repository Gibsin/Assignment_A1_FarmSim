package students.items;

public class UntilledSoil extends Item{
	// represented as /
	
	public UntilledSoil() {
		super(0, 0, -1);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "/";
	}

	@Override
	public Item copy() {
		// TODO Auto-generated method stub
		UntilledSoil unSoilCopy = new  UntilledSoil();
		return unSoilCopy;
	}

}
