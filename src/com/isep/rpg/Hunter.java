package com.isep.rpg;

public class Hunter extends Hero{
	int arrows;

	@Override
	void attack(Enemy enemyToAttack) {
		if (this.arrows > 0) {
			enemyToAttack.receiveDamage(weaponDamage);
		} else {
			System.out.println("impossible d'attaquer, plus de fleches !");
		}
	}
	
	public Hunter() {
		this.name = "hunter";
		this.armor = 15;
		this.lifePoints = 100;
		this.weaponDamage = 15;
		this.arrows = 10;
	}

	@Override
	void useConsumable(Consumable consumableToUse) {
		this.lifePoints++;
	}
}
