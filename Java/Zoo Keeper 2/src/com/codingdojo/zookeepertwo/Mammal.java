package com.codingdojo.zookeepertwo;

public class Mammal {
	int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println(energyLevel);
		return energyLevel;
	}
	
	
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
