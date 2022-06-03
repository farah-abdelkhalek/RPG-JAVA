package com.isep.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.isep.rpg.BasicEnemy;
import com.isep.rpg.Enemy;
import com.isep.rpg.Game;
import com.isep.rpg.Hero;
import com.isep.rpg.Hunter;
import com.isep.rpg.Warrior;

class Tests {

	Game game = new Game();
	Warrior warrior = new Warrior();
	BasicEnemy basicEnemy = new BasicEnemy();
	
	@Test
	void checkNumberOfEnemiesFor3Players() {
		game.heroes = new ArrayList<Hero>();
		game.heroes.add(new Hunter());
		game.heroes.add(new Hunter());
		game.heroes.add(new Hunter());
		game.generateCombat();
		assertEquals(3, game.enemies.size());
	}
	
	@Test
	void checkThatHeroGetsDamage() {
		warrior.receiveDamage(100);
		assertEquals(50, warrior.lifePoints);
	}
	
	@Test
	void checkThatEnemyGetsDamage() {
		basicEnemy.receiveDamage(10);
		assertEquals(15, basicEnemy.lifePoints);
	}
	
	@Test
	void checkThatHeroDies() {
		game.heroes = new ArrayList<Hero>();
		game.heroes.add(warrior);
		warrior.receiveDamage(1000);
		game.checkHeroLifePoints(warrior);
		assertTrue(game.heroes.isEmpty());
	}
	
	@Test
	void checkThatEnemyDies() {
		game.enemies = new ArrayList<Enemy>();
		game.enemies.add(basicEnemy);
		basicEnemy.receiveDamage(1000);
		game.checkEnemyLifePoints(basicEnemy);
		assertTrue(game.enemies.isEmpty());
	}
	
	@Test
	void checkArmureReward() {
		game.chooseReward("armure", warrior);
		assertEquals(30, warrior.armor);
	}
	
	@Test
	void checkDamageReward() {
		game.chooseReward("degats", warrior);
		assertEquals(30, warrior.weaponDamage);
	}

}
