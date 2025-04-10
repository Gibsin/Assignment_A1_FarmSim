package students;
/**Tracks Achievement information for a generic achievement. Does not perform any additional logic for an achievement**/
public class AchivementData {
	private int count;
	private int achievedCount;
	private boolean hasBeenAchieved;
	private int xpReward;

	public AchivementData(int achievedCount, int xpReward) {
		this.xpReward = xpReward;
		this.achievedCount = achievedCount;
		this.count = 0;
		this.hasBeenAchieved = false;
	}
	
	/**Increments the achievement counter by the value amount.**/
	// Was used instead of a setter as the counter should only be added to. 
	public void increaseAchivementCounter(int value) {
		this.count += value;
	}
	
	/**checks if the achievement conditions have been met.**/
	public void checkAchievementCompletion() {
		if (this.count >= this.achievedCount) {
			this.hasBeenAchieved = true;
		}
	}
	
	public int getXpReward() {
		return this.xpReward;
	}

	public boolean getHasBeenAchieved(){
		return this.hasBeenAchieved;
	}
	
	
	
}
