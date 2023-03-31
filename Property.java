/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Due: 03/31/2023
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Harlene Kaur
 */



public class Property {

	private String city; 
	private String owner; 
	private String propertyName; 
	private double rentAmount; 
	private Plot plot; 



	public Property(){
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0 ;
		this.plot = new Plot(0,0,1,1);

	}


	public Property(String propertyName, String city, double rentAmount, String owner){
		this.city = city; 
		this.owner = owner; 
		this.propertyName = propertyName; 
		this.rentAmount = rentAmount; 
	}



	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.city = city;
		this.propertyName = propertyName; 
		this.rentAmount = rentAmount; 
		this.owner = owner; 
		this.plot = new Plot(x,y,width,depth);
	}



	public Property(Property property){
		this.city = property.getCity();
		this.propertyName = property.getOwner(); 
		this.rentAmount = property.getRentAmount();
		this.owner = property.getOwner();
		this.plot = new Plot(property.getPlot().getX(),property.getPlot().getY(),property.getPlot().getWidth(),property.getPlot().getDepth());
	}



	public Plot getPlot() {
		return this.plot;
	}



	public String getCity(){
		return this.city;
	}


	public String getOwner() {
		return this.owner;
	}

	public String getPropertyName() {
		return this.propertyName;
	}




	public double getRentAmount() {
		return this.rentAmount;
	}


	public void setPlot(int x, int y, int width, int depth){
		this.plot = new Plot(x,y,width,depth);
	}


	public void setCity(String city) {
		this.city = city; 
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName; 
	}


	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount; 
	}



	public String toString() {


		return "Property Name: "+this.propertyName+"\r\n" + 
				"               Located in "+this.city+"\r\n" + 
				"               Belonging to: "+this.owner+"\r\n" + 
				"               Rent Amount: "+this.rentAmount+ " ";
	}

}