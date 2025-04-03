package students;

public class SkillData {
	private int level;
	private int maxLevel;
	private String skillName;
	private String skillDesc;
	private int price;
	private int priceIncrease;
	
	public SkillData(int maxLevel, String name, String desc, int price, int priceIncrease) {
		this.level = 0;
		this.maxLevel = maxLevel;
		this.skillName = name;
		this.skillDesc = desc;
		this.price = price;
		this.priceIncrease = priceIncrease;	
	}
	
	public boolean isMaxLevel() {
		if (this.level >= this.maxLevel) {
			return true;
		}
		else
			return false;
	}
	
	public void levelSkill() {
		this.level += 1;
		this.price += this.priceIncrease;
	}
	
	public String getName() {
		return this.skillName;
	}
	
	public String getSkillDesc() {
		return this.skillDesc;
	}
	
	public int getPrice() {
		return this.price;
	}

	public int getLevel() {
		return level;
	}
}
