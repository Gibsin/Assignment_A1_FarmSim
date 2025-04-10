package students;

import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Item;
import students.items.Weed;

public class AchievementTracker {
	private AchivementData foodHarvested;
	private AchivementData applesHarvested; 
	private AchivementData grainHarvested;
	private AchivementData soilTilled;
	private AchivementData weedsRemoved;
	
	public AchievementTracker() {
		this.foodHarvested = new AchivementData(20, 25);
		this.applesHarvested = new AchivementData(10, 15); 
		this.grainHarvested = new AchivementData(10, 15);
		this.soilTilled = new AchivementData(30, 10);
		this.weedsRemoved = new AchivementData(20, 25);
		
	}
	
	/**checks the player stats and awards achievements and xp points**/	
	public void checkAchievements() {
		
		
	}
	
	public void updateHavrvestStats(Food food) {
		this.foodHarvested.increaseAchivementCounter(1);
		if (food instanceof Apples) {
			this.applesHarvested.increaseAchivementCounter(1);
		}
		
		else if (food instanceof Grain) {
			this.grainHarvested.increaseAchivementCounter(1);
			
		}
	}
	
	
	public void updateTillStats(Item tilledItem) {
		soilTilled.increaseAchivementCounter(1);
		if (tilledItem instanceof Weed) {
			weedsRemoved.increaseAchivementCounter(1);
		}
	}
}
