package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {
	
	public void throwThings() {
		System.out.println("Gorilla is throwing things");
		this.setEnergy(-5);
	}
	
	public void eatBananas() {
		System.out.println("Gorilla is eating bananas");
		this.setEnergy(10);
	}
	
	public void climb() {
		System.out.println("Gorilla is climbing");
		this.setEnergy(-10);
	}
	

}
