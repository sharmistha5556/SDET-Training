
public class Car {

	String colour;
	int make;
	String transmission;
	int tyres;
	int doors;
	
	
	Car() 
	{ 
		
		this.doors=4;	
		this.tyres=4;	
	}
	
	public void displayCharacteristics() {
		System.out.println("Car colour is " +colour);
		System.out.println("Car make is " +make);
		System.out.println("Car transmission is " +transmission);
		System.out.println("Car tyres is " +tyres);
		System.out.println("Car doors is " +doors);
	}
	
	public void accelerate() {
		System.out.println("the car is moving forward");
	}
	public void brake() {
		System.out.println("the car has stopped");
	}

}
