// @author Alexa Montilla 
// Copyright © Alexa Montilla 2025. All rights reserved. 

// HW 8.3 Date: 12.22.25

//Create a Driver class to use your Farm and Animal classes and create instances of them.
public class Driver {
	public static void main(String[] args) {
		// 1. Create a Farm of size 10 (array)
		Farm farm = new Farm("Farm of ten", 10); 
		
		// 2. Create 5 Animal Objects with the details specified in the table below
		Animal a1 = new Animal("cow", 2012, 1000.5, 'f');
		Animal a2 = new Animal("pig", 2009, 550.5, 'm');
		Animal a3 = new Animal("donkey", 1999, 773.42, 'm');
		Animal a4 = new Animal("sheep", 2016, 164.23, 'f');
		Animal a5 = new Animal("goose", 2004, 10.75, 'f');
		
		// Add the 5 Animal objects to the Farm
		farm.addAnimal(a1); 
		farm.addAnimal(a2); 
		farm.addAnimal(a3); 
		farm.addAnimal(a4); 
		farm.addAnimal(a5); 
		
		// Call the printDetails method from the Farm to print all the Farm and Animal details.
		farm.printAllDetails(); 
		
	}

}
