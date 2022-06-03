package com.isep.rpg;

public abstract class Enemy {
	public int lifePoints;
	int amountOfDamage;
	
	public void receiveDamage(int amountOfDamage) {
		this.lifePoints -= amountOfDamage;		
	}
	
	void attackHero(Hero heroToAttack) {
		heroToAttack.receiveDamage(amountOfDamage);
	}
}
