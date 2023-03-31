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



public class ManagementCompany {
	private final int  MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10; 

	private double mgmFeePer;
	private String name; 
	private Property[]properties; 
	private String taxID; 
	private Plot plot; 
	int count; 


	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}



	public ManagementCompany(String name,String taxID,double mgmFeePer) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}



	public ManagementCompany(String name,String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		this.plot = new Plot(x,y,width,depth);
		this.properties =new Property[MAX_PROPERTY];
	}



	public ManagementCompany(ManagementCompany c) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = c.name;
		this.taxID = c.taxID;
		this.mgmFeePer = c.mgmFeePer;
		this.plot = c.plot;
	}




	public String getName() {
		return this.name; 
	} 



	public Plot getPlot() {
		return this.plot;
	}



	public int addProperty(Property p) {

		if (p == null)
		{
			return -2;
		}
		else if (!this.plot.encompasses(p.getPlot()))
		{
			return -3;
		}
		for (int i = 0; i < MAX_PROPERTY; i++) {

			if (properties[i] != null) {

				if (p.getPlot().overlaps(properties[i].getPlot())) {

					return -4;
				}

			} 

			else {
				break;
			}
		}
		for (int i = 0; i < MAX_PROPERTY; i++) {

			if (properties[i] == null) {

				properties[i] = new Property(p);
				return i;
			}
		}
		return -1;

	}


	public int addProperty(String name,String city,double rent,String owner, int x, int y, int width,int depth) {

		return addProperty(new Property(name,city,rent,owner,x,y,width,depth));

	}


	public int addProperty(String name,String city,double rent,String owner) {		

		return addProperty(new Property(name,city,rent,owner));

	}






	public String displayPropertyAtIndex(int i){

		return properties[i].toString()+"";

	}


	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}



	public double maxRentProp() {

		return properties[maxRentPropertyIndex()].getRentAmount();
	}



	private int maxRentPropertyIndex() {
		int index = 0;

		double max = 0;
		for(int i = 0; i<MAX_PROPERTY;i++) {

			if(properties[i]!=null) {


				if(properties[i].getRentAmount() > max) {

					max = properties[i].getRentAmount();
					index = i; 
				}
			}

		}
		return index;
	}





	public String toString() {
		String str = "";
		str = ("List of the properties for Alliance, taxID: " + taxID+"\n"+"__________________________________________________\n");



		for(int i = 0; i < MAX_PROPERTY; i++) {

			if(properties[i] != null)
				str += (" Property Name: " + properties[i].getPropertyName() +"\n" +
						"  Located in: " + properties[i].getCity() + "\n" + 
						"  Belonging to: " + properties[i].getOwner() + "\n" + 
						"  Rent Amount: " + properties[i].getRentAmount()+"\n"); 

		}

		str += ("__________________________________________________\n"+"Total management Fee: " + mgmFeePer);



		return str;
	}


	public double totalRent() {
		double total = 0.0;
		for(int i = 0; i < MAX_PROPERTY; i++) {

			if(properties[i] != null) {
				total += properties[i].getRentAmount();

			}

		}

		return total; 
	}


}