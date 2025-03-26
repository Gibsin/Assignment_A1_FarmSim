package students.items;

public class Weed extends Item{
	// represented as #

	public Weed() {
		super(0, 0, -1); // how to make their death infinite?
		// TODO Auto-generated constructor stub
	}
	
	public Weed(Weed weed) {
		super(0,0,-1);
		this.setAge(weed.getAge());
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "#";
	}


	@Override
	public Item copy() {
		// TODO Auto-generated method stub
		Weed weedCopy = new Weed();
		return weedCopy;
	}

}
