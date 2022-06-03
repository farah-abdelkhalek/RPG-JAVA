package com.isep.rpg;

import java.util.List;

public abstract class Hero {
	public float lifePoints;
	public float armor;
	public int weaponDamage;
	public List<Potion> potions;
	public List<Food> lembas;
	
	boolean isAlive;
	public String name;
	
	abstract void attack(Enemy enemyToAttack);
	
	void defend() {
		
	}
	
	abstract void useConsumable(Consumable consumableToUse);

	public void receiveDamage(int amountOfDamage) {
		this.lifePoints -= (amountOfDamage / (this.armor / 10));		
	}
}
