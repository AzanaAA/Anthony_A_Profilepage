package com.codingdojo.zookeepertwo;

public class Bat extends Mammal {
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("Bat is flying");
		energyLevel -= 50;
		displayEnergy();
	}
	
	public void eatHumans() {
		System.out.println("The bat is eating humans");
		energyLevel += 25;
		displayEnergy();
	}
	
	public void attackTown() {
		System.out.println("Bat is attacking the town");
		energyLevel -= 100;
		displayEnergy();
	}

}
