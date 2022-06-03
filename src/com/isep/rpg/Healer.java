package com.isep.rpg;

import java.util.List;

public class Healer extends SpellCaster{

	@Override
	void attack(Enemy enemyToAttack) {
	}
	
	void heal(List<Hero> heroes) {
		for(Hero hero: heroes) {
			hero.lifePoints += 10;
		}
	}
	
	Healer(){
		this.name = "healer";
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
