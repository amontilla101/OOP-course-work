// @author Alexa Montilla 
// Copyright © Alexa Montilla 2025. All rights reserved. 

// Create a class to represent an object of type Animal
// HW 8.2 - 12.22.25
public class Animal { // class 
	// Attributes
	private String name; 
	private int birthYear; 
	private double weight; 
	private char gender; 
	
	public Animal() { //  constructor
		this.name = ""; // Reminder: no space " ", empty string 
		this.birthYear = 1900;
		this.weight = 0.0; 
		this.gender = 'u';
	}
	
	//public void itName(String name) { // setter for name 
		//this.name = name; // assign parameter to the attribute, which is why I had an error
		
	//}
	
	public Animal(String name, int birthYear, double weight, char gender) { 
		this.name = name; // name - value to assign to the name attribute
		
		this.birthYear = birthYear; // Assign birthYear 
		
		// weight - value to assign to the weight attribute (precision up to 0.01) 
		if(weight < 0) { // check if value is negative 
			this.weight = -1.0; // weight is invalid, assigned -1.0
		} else {
			this.weight = weight; // weight is valid, assigned to attribute 
		}
		
		// gender - value to assign to the gender attribute
		if((gender != 'f') && (gender != 'm') && (gender != 'u')) {	 //  If gender is not f (female), m (male), or u (unknown), set gender to u (use &&)
			this.gender = 'u'; // invalid default
		} 
		else {
			this.gender = gender; // valid - use given value 
		}
			
	} // end 
	
	public String getName() { // Getter for name 
		return name; // return the name attribute since there is no parameter named name for this method 
		
	}
	
	public void setName(String name) { // setter, parameter passed to method 
		this.name = name; // assign the parameter value to the object's attribute 
		
	} 
	
	public int getBirthYear() { // Getter method for birthYear. 
		return birthYear; // return birthYear attribute 
		
	}
	
	public void setBirthYear(int birthYear) { // setter, parameter passed to method 
		this.birthYear = birthYear; // // assign the parameter value to the object's attribute 
	}
	
	public double getWeight() { // Getter for weight 
		return weight;  
	}
	
	public void setWeight(double weight) { // setter method for weight. If weight is negative, set weight to -1.0.
	// check for parameter is negative 
		if(weight < 0) {	
			this.weight = -1.0; // invalid, assign -1.0 to object's attribute
		} else {
			this.weight = weight; // valid, assign parameter to object's attribute
		}
	}
	
	public char getGender() { // getter method for gender 
		return gender; // return gender attribute 
		
	} 
	
	public void setGender(char gender) { // Setter method for gender.
		
		if((gender != 'f') && (gender != 'm') && (gender != 'u')) { //  If gender is not f (female), m (male), or u (unknown), set gender to u 
			this.gender = 'u'; // invalid default
		} 
		else {
			this.gender = gender; // valid - use given value 
		}
		
	}
	// use birthYear and the argument of currentYear to calculate age. 
	public int calculateAge(int currentYear) {
		// check if currentYear is before birthYear 
		if(currentYear < birthYear) {
			return -1; // invalid case 
		} 
		else {
			return currentYear - birthYear; // subtract currentYear and birthYear to get valid age 
		}
		
	}
	
	public boolean isMale() { // This method checks if the animal is a male.
		
		if(gender == 'm') { // This methods returns true if the animal is a male, and returns false otherwise.
			return true; 
		} 
		else {
			return false; 
		}
		
	}
	
	public boolean isFemale() { // This method checks if the animal is a female.
		
		if(gender == 'f') { // This methods returns true if the animal is a female, and returns false otherwise.
			return true; 
		} 
		else {
			return false; 
		}
		
	}
	
	public void printDetails() {
		
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Gender: %c\n", getName(), getBirthYear(), getWeight(), getGender()); 
		
	}
	
	public void gainWeight() { // This method increases the weight attribute by 1.
		weight += 1;
		
	}
	
	// This method increase the weight attribute by weight. Parameter weight can be negative, but the weight of the object cannot get below zero.
	public void gainWeight(double weight) {
		
		double newWeight = this.weight + weight; // create new weight using object's weight(this.weight) and parameter 
		
		if(newWeight < 0) {	// if the new weight is less than 0
			this.weight = 0; // set object's weight to 0 
		} 
		else {
			this.weight = newWeight; 
		}
		
	}
	
	// This method decreases the weight attribute by 1. The weight attribute cannot get below 0.
	public void loseWeight() {
		weight -= 1; 
		
		if(weight < 0) {
			weight = 0; 
		} 

	}
	
	public void loseWeight(double weight) { // This method decreases the weight attribute by weight. The weight attribute cannot get below 0.
		// Similar to gainWeight method 
		double newLoseWeight = this.weight - weight; 
		
		if(newLoseWeight < 0) {
			this.weight = 0; 
		} 
		else {
			this.weight = newLoseWeight; 
		}
	}
	

	public static void main(String[] args) { 
		Animal farmAnimals = new Animal();  
		System.out.println(farmAnimals.getName()); 

	}

}
