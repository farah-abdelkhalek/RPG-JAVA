package com.isep.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	public List<Hero> heroes;
	public List<Enemy> enemies;
	public int playerTurn;
	public InputParser inputParser;
	
	public void playGame() {
		this.inputParser = new InputParser();
		int numberOfHeroes = chooseNumberOfHeroes();
		chooseHeroes(numberOfHeroes);
		while (!heroes.isEmpty()) {
			generateCombat();
			fightCombat();
		}
	}
	
	public void checkEnemyLifePoints(Enemy enemy) {
		if (enemy.lifePoints <= 0) {
			System.out.println("l'ennemi a peri");
			enemies.remove(enemy);
		}
	}
	
	public void checkHeroLifePoints(Hero hero) {
		if (hero.lifePoints <= 0) {
			System.out.println("le hero a peri");
			heroes.remove(hero);
		}
	}
	
	void fightCombat() {
		playerTurn = 1;
		while (!heroes.isEmpty() && !enemies.isEmpty()) {
			if (new Random().nextInt(10) <= 4) {
				System.out.println("\ntour " + playerTurn);
				enemiesPlay();	
				playersPlay();
			} else {
				System.out.println("\ntour " + playerTurn);
				playersPlay();
				enemiesPlay();
				playerTurn++;
			}
			
			
		}
		if (enemies.isEmpty()) {
			System.out.println("Bravo, vous avez battu tous les ennemis ! L'aventure continue");
			rewardPlayers();
		}
		
		if (heroes.isEmpty()) {
			System.out.println("Game Over");
		}
	}

	private void rewardPlayers() {
		for (int i = 0; i < heroes.size(); i++) {
			System.out.println("choix de recompense du joueur " + (i+1) + " (armure/degats/nourriture :");
			chooseReward(inputParser.parseInputAsString(), heroes.get(i));
		}
	}

	public void chooseReward(String rewardChoice, Hero hero) {
		switch (rewardChoice) {
		case "armure": {
			hero.armor += 10;
			break;
		}
		case "degats": {
			hero.weaponDamage += 10;
			break;
		}
		case "nourriture": {
			hero.lembas.add(new Food());
			
		}
		default:
			System.out.println("valeur incorrecte, armure sera attribue");
		}
	}

	private void enemiesPlay() {
		for (int i = 0; i < enemies.size(); i++) {
			int random = new Random().nextInt(heroes.size());
			enemies.get(i).attackHero(heroes.get(random));
			System.out.println("l'ennemi " + (i+1) + " attaque le joueur " + (random + 1));
			System.out.println("il reste " + heroes.get(random).lifePoints + " pv au joueur " + (random+1));
			checkHeroLifePoints(heroes.get(random));
		}
	}

	private void playersPlay() {
		for (int i = 0; i < heroes.size(); i++) {
			System.out.println("au tour du joueur " + (i+1));
			System.out.println("choisir entre attaquer/utiliser/defendre " + (i+1));
			String action = inputParser.parseInputAsString();
			switch (action) {
			case "attaquer": {
				Enemy chosenEnemy = chooseEnemyToAttack();
				heroes.get(i).attack(chosenEnemy);
				System.out.println("il reste " + chosenEnemy.lifePoints + " pv a l'ennemi choisi");
				checkEnemyLifePoints(chosenEnemy);
				break;			
			}
			case "utiliser":{
				//heroes.get(i).useConsumable();
			}
			
			case "defendre":{
				
			}
			default:
				System.out.println("valeur incorrecte, attaque choisie");
				Enemy chosenEnemy = chooseEnemyToAttack();
				heroes.get(i).attack(chosenEnemy);
				System.out.println("il reste " + chosenEnemy.lifePoints + " pv a l'ennemi choisi");
				checkEnemyLifePoints(chosenEnemy);
			}
			
		}
	}

	private Enemy chooseEnemyToAttack() {
		System.out.println("choisir l'ennemi a attaquer entre 1 et " + enemies.size());
		int enemytoAttackNumber = inputParser.parseInputAsInt()-1;
		Enemy chosenEnemy = enemies.get(enemytoAttackNumber);
		return chosenEnemy;
	}

	public void generateCombat() {
		System.out.println("");
		System.out.println("nouveau combat ! Les ennemis sont : ");
		this.enemies = new ArrayList<Enemy>();
		for (Hero hero : heroes) {
			
			if (new Random().nextInt(100) <= 90) {
				enemies.add(new BasicEnemy());
				System.out.println("un ennemi basique");
			}
			else {
				enemies.add(new Boss());
				System.out.println("un Boss");
			}
		}
		System.out.println("");
	}
	
	//fonctions additionnelles
	int chooseNumberOfHeroes(){
		System.out.println("Entrer le nombre de joueurs :");
		int numberOfHeroes = this.inputParser.parseInputAsInt();
		this.heroes = new ArrayList<Hero>(numberOfHeroes);
		return numberOfHeroes;
	}
	
	void chooseHeroes(int numberOfHeroes) {
		for(int i = 0; i < numberOfHeroes; i++) {
			System.out.println("Entrer la classe du joueur " + (i+1) + " (warrior/hunter/healer/mage) : ");
			String newHeroType = new InputParser().parseInputAsString();
			this.addHero(newHeroType);
		}
	}

	private void addHero(String newHeroType) {
		switch (newHeroType){
		case "hunter": {
			this.heroes.add(new Hunter());
			break;
		}
		case "healer": {
			this.heroes.add(new Healer());
			break;
		}
		case "mage": {
			this.heroes.add(new Mage());
			break;
		}
		case "warrior": {
			this.heroes.add(new Warrior());
			break;
		}
		default:
			System.out.println("Choix invalide. Un warrior sera attribue a ce joueur");
			this.heroes.add(new Warrior());
		}
	}
}
