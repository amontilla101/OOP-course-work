// @author Alexa Montilla 
// Copyright © Alexa Montilla 2025. All rights reserved. 


// Create a class to represent a Farm object containing instances of the Animal objects
// HW 8.2 = 12.22.25

// 4 constructors  
public class Farm { // class
	
	private String farmName; // We need these two, hand in hand 
	private Animal[] animals; // CHECK: this will be the list  // Communicating && array to store Animal objects
	private int numAnimals; // blueprint: this will be the counters // Communicating
	
	public Farm() { // default constructor 
		setFarmName(""); // No name, default farm name 
		animals = new Animal[10]; // By default is 10 
		numAnimals = 0; // no animals yet

	}
	
	public Farm(String farmName) { // Constructs a Farm object with the given values.
		setFarmName(farmName); // using parameter 
		animals = new Animal[10]; // initialize animals with default length 10 
		numAnimals = 0; // set animal to 0
	}
	
	public Farm(int maxAnimals) { // Constructs a Farm object with the given values. If maxAnimals is Negative set to 0.
		setFarmName(""); // default farm name 
		if(maxAnimals < 0) { 
			maxAnimals = 0; 
		}
		
		animals = new Animal[maxAnimals]; // initialize animals arrays with maxAnimals 
		numAnimals = 0; // numANimals to 0 
	}
	// Constructs a Farm object with the given values. If maxAnimals is Negative set to 0.
	public Farm(String farmName, int maxAnimals) { 
		setFarmName(farmName); // set farm name using the parameter inside braces. Ex: (farmName) 
		
		if(maxAnimals < 0) { // handle negative array size
			maxAnimals = 0; // set animal to 0
		}
		
		animals = new Animal[maxAnimals]; // By default is 10 
		numAnimals = 0; // start with 0 animals
	}
	//  Method Detail 
	// Assigns the value of the parameter to the member variable farmName
	public void setFarmName(String farmName) { // setter, 
		this.farmName = farmName; 

	}
	
	public String getFarmName() { // This method returns the value of the String farmName
		return farmName; 
	}
	
	// numAnimals here 
	public void addAnimal(Animal a) {// Hard 
		
		if(numAnimals < animals.length) { // check if there is space available in animals array 
			animals[numAnimals++] = a; // add Animal to next available index 
		} 
		else { // helper method
			resizeAnimalArray(); 
			animals[numAnimals++] = a; // increment numAnimals 
			
			 numAnimals++; // increment number of animals after adding 
		}
		
	} 
	
	private void resizeAnimalArray() {
		Animal[] bigA = new Animal[animals.length * 2]; 
		
		for(int i = 0; i < animals.length; ++i) {
			bigA[i] = animals[i]; 
		}
		
		animals = bigA; 

	}
	
	public Animal getAnimal(int index) {
		// need if statement due to issues. Have to make sure it is the right index 
		if(index >= 0 && index < numAnimals) { // Check index is valid (within range of added animals) 
		return animals[index]; // Return Animal at specified index 
		// (index >= 0 prevents negative indexes) 
		}
		else {
			return null; // invalid index or empty location 
		}

	}
	
	public int getNumAnimals() { //notice no setter… this is a controlled variable
		return numAnimals; 
	}
	
	public Animal getFirstAnimal() { // The first Animal in the array, or null if the array is empty
		
		if(numAnimals == 0) {
			return null; 
		}
		
		return animals[0]; 
	}
	
	// This method will get the last Animal in the array
	public Animal getLastAnimal() {
		// check if there are no animals in farm
		if(numAnimals == 0) {
			return null; // Return null if the array is empty 
		}
		
		return animals[numAnimals - 1]; // return last Animal in the array at index numAnimals - 1
	}
	
	public Animal[] getAnimals() { // Return array of Animal objects in the farm 
		return animals; // array may contain null entries of some slots are empty 
		
	}

	public Animal removeAnimal(int index) {
		if((index < 0) || (index >= numAnimals)) { // check if index is valid 
			return null;  // invalid index, nothing to remove 
		}
		
		Animal removed = animals[index]; // save Animal to be removed
		
		for(int i = index; i < numAnimals - 1; ++i) { // (for loop) shift all elements after 
			animals[i] = animals[i + 1]; 
		}
		
		animals[numAnimals - 1] = null; // set last used slot to null 
		
		numAnimals--; // Decrement numAnimals 
		
		return removed; // Return the removed Animal 
	}

	// This method will clear the entire array and reset numAnimals to 0
	public void removeAllAnimals() {
		animals = new Animal[animals.length]; 
		numAnimals = 0; 

	}
	
	// This method will compute the sum of the weight of all elements in the array
	public double getTotalWeightOfAllAnimals() {
		double totalWeight = 0.0; // initialize total weight to 0
		
		for(int i = 0; i < numAnimals; ++i) { // Loop through all animals currently in farm 
			totalWeight += animals[i].getWeight(); // add each animal's weight to totalWeight 
		}
		
		return totalWeight; // return totalWeight of all animals 
		
	}
	// This method will compute the average weight of all elements in the array
	public double getAverageWeightOfAllAnimals() {
		if(numAnimals == 0) { // if no animals, return 0 to avoid division by 0 
			return 0.0; 
		}
		// Get total weight using the method we already have wrote 
		double totalWeight = getTotalWeightOfAllAnimals(); 
		
		// Calculate average by dividing total weight by number of animals
		double averageWeight = totalWeight / numAnimals; 
		
		return averageWeight; // return average weight 
		
	}
	// This method will scan and count the number of elements in the array with a weight above that of the parameter
	public int getNumberOfAnimalsAboveWeight(double weight) {
		int numAboveWeight = 0; // counter for animals above the given weight 
		
		for(int i = 0; i < numAnimals; ++i) { // For loop through ALL animals currently in farm 
			if(animals[i].getWeight() > weight) { // check if animal's weight is greater than parameter 
				numAboveWeight++; // Increment counter 
			}	
		}
		
		return numAboveWeight; // return total number of animals above given weight 
		
	}
	// This method will scan and count the number of Animal objects in the animals array with a weight below that of the parameter
	public int getNumberOfAnimalsBelowWeight(double weight) { 
		int numBelowWeight = 0; // Counter for animals above the given weight 
		
		// For loop through all animals currently in the farm 
		for(int i = 0; i < numAnimals; ++i) { 
			if(animals[i].getWeight() < weight) { // if the animal's weight is less than the parameter 
				numBelowWeight++; // increment counter 
			}	
		}
		
		return numBelowWeight; // return total number of animals below 
		
	}
	// This method will increase the weight of all Animal objects in the animals array by invoking the gainWeight() method from the Animal class
	public void increaseWeightOfAllAnimals() {
		// increaseWeightOfAllAnimals(weight); 
		for(int i = 0; i < numAnimals; ++i) {
			animals[i].gainWeight(); // increase each animal's weight by 1 
		} // call gainWeight(); 
	}
	
	public void increaseWeightOfAllAnimals(double weight) {
		// Loop through all animals currently in farm 
		for(int i = 0; i < numAnimals; ++i) {
		animals[i].gainWeight(weight); // Increase each animal's weight by given amount 
		// with '.' it is calling 
		
		}
	}
	
	public void printAllDetails() {
		// print farm details in format (printf) 
		System.out.printf("FarmName: %20s | Number of Animals: %4d "
				+ "| Farm Size: %4d\n", getFarmName(), getNumAnimals(), animals.length); 
		// print details of each animals using for loop 
		for(int i = 0; i < numAnimals; ++i) {
			animals[i].printDetails(); 
		}
		
	}
	


} // end class 
