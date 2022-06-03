package com.isep.rpg;

public class Mage extends SpellCaster{

	@Override
	void attack(Enemy enemyToAttack) {
		if (this.manaPoints > 0) {
			enemyToAttack.receiveDamage(weaponDamage);
		} else {
			System.out.println("impossible d'attaquer, plus de mana");
		}	
	}
	
	public Mage() {
		this.name = "mage";
		this.armor = 15;
		this.lifePoints = 100;
		this.weaponDamage = 15;
		this.manaPoints = 10;
	}
	
	@Override
	void useConsumable(Consumable consumableToUse) {
		this.manaPoints++;
	}


}
