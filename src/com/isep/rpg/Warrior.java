package com.isep.rpg;

public class Warrior extends Hero{

	@Override
	void attack(Enemy enemyToAttack) {
		enemyToAttack.receiveDamage(weaponDamage);
	}

	public Warrior() {
		this.name = "warrior";
		this.armor = 20;
		this.lifePoints = 100;
		this.weaponDamage = 20;
	}

	@Override
	void useConsumable(Consumable consumableToUse) {
		this.lifePoints++;
	}
}
