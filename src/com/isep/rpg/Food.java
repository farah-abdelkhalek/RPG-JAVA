package com.isep.rpg;

public class Food implements Consumable{

	@Override
	public int use() {
		int newHealthPoints = 10;
		return newHealthPoints;
	}

}
