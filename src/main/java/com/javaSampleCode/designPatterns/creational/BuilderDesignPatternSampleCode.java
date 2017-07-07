package com.javaSampleCode.designPatterns.creational;

/*
Constructors in Java are used to create object and can take parameters required to create object. 
Problem starts when an Object can be created with lot of parameters, some of them may be mandatory and others may be optional
*/

class Cake {
	private final double sugar; // cup
	private final double butter; // cup
	private final int eggs;
	private final int vanila; // spoon
	private final double flour; // cup
	private final double bakingpowder; // spoon
	private final double milk; // cup
	private final int cherry;

	public static class Builder {
		private double sugar; // cup
		private double butter; // cup
		private int eggs;
		private int vanila; // spoon
		private double flour; // cup
		private double bakingpowder; // spoon
		private double milk; // cup
		private int cherry;

		// builder methods for setting property
		public Builder sugar(double cup) {
			this.sugar = cup;
			return this;
		}

		public Builder butter(double cup) {
			this.butter = cup;
			return this;
		}

		public Builder eggs(int number) {
			this.eggs = number;
			return this;
		}

		public Builder vanila(int spoon) {
			this.vanila = spoon;
			return this;
		}

		public Builder flour(double cup) {
			this.flour = cup;
			return this;
		}

		public Builder bakingpowder(double spoon) {
			this.sugar = spoon;
			return this;
		}

		public Builder milk(double cup) {
			this.milk = cup;
			return this;
		}

		public Builder cherry(int number) {
			this.cherry = number;
			return this;
		}

		// return fully build object
		public Cake build() {
			return new Cake(this);
		}
	}

	// private constructor to enforce object creation through builder
	private Cake(Builder builder) {
		this.sugar = builder.sugar;
		this.butter = builder.butter;
		this.eggs = builder.eggs;
		this.vanila = builder.vanila;
		this.flour = builder.flour;
		this.bakingpowder = builder.bakingpowder;
		this.milk = builder.milk;
		this.cherry = builder.cherry;
	}

	@Override
	public String toString() {
		return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs + ", vanila=" + vanila + ", flour="
				+ flour + ", bakingpowder=" + bakingpowder + ", milk=" + milk + ", cherry=" + cherry + '}';

	}

}

public class BuilderDesignPatternSampleCode {
	public static void main(String[] args) {
		Cake cake = new Cake.Builder().bakingpowder(1).butter(1).cherry(1).flour(1).milk(12).build();

		System.out.println(cake);
	}
}
