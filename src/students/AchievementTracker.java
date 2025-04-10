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
	public int checkAchievements() {
		int xpReward = 0;
		if (foodHarvested.getHasBeenAchieved() == false) {
			foodHarvested.checkAchievementCompletion();
			if (foodHarvested.getHasBeenAchieved()) {
				System.out.println("Congratulations you have achieved 20 food harvested!");
				xpReward += foodHarvested.getXpReward();
			}
						
		}
		
		if (applesHarvested.getHasBeenAchieved() == false) {
			applesHarvested.checkAchievementCompletion();
			if (applesHarvested.getHasBeenAchieved()) {
				System.out.println("Congratulations you have achieved 10 apples harvested!");
				xpReward += applesHarvested.getXpReward();
			}
						
		}
		
		if (grainHarvested.getHasBeenAchieved() == false) {
			grainHarvested.checkAchievementCompletion();
			if (grainHarvested.getHasBeenAchieved()) {
				System.out.println("Congratulations you have achieved 10 grain harvested!");
				xpReward += grainHarvested.getXpReward();
			}
						
		}
		
		if (soilTilled.getHasBeenAchieved() == false) {
			soilTilled.checkAchievementCompletion();
			if (soilTilled.getHasBeenAchieved()) {
				System.out.println("Congratulations you have achieved 30 soil tilled!");
				xpReward += soilTilled.getXpReward();
			}
						
		}
		
		if (weedsRemoved.getHasBeenAchieved() == false) {
			weedsRemoved.checkAchievementCompletion();
			if (weedsRemoved.getHasBeenAchieved()) {
				System.out.println("Congratulations you have achieved 20 Weeds removed!");
				xpReward += weedsRemoved.getXpReward();
			}
						
		}
		
		return xpReward;
		
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
