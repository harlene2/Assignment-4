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



public class Plot {	
	private int x; 
	private int y; 
	private int width; 
	private int depth; 



	public Plot(){
		x = 0; 
		y = 0; 
		width = 1;
		depth = 1; 
	}


	public Plot(Plot p){
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.width; 
	}



	public Plot(int x, int y, int width, int depth){
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.depth = depth; 
	}



	public int getX() {
		return x; 
	}


	public int getY() {
		return y; 
	}



	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	} 


	public int getWidth(){
		return this.width;
	}


	public int getDepth() {
		return this.depth; 
	}


	public boolean overlaps(Plot plot) {
		int xOverlap = this.x + width;
		int yOverlap = this.y + depth; 

		int rangeOfX = plot.getX()+plot.getWidth();
		int rangeOfY = plot.getY()+plot.getDepth(); 

		if (yOverlap <= plot.getY() ||this.y >=rangeOfY ) {
			return false;
		}
		if (xOverlap <= plot.getX() || this.x >= rangeOfX) {
			return false;
		}
		return true;


	}



	public String toString() {

		return "Upper left: ("+this.getX()+","+this.getY()+"); Width: "+this.getWidth()+" Depth: "+this.getDepth();
	}



	public boolean encompasses(Plot plot) {

		int xPlot = x + this.getWidth();

		int yPlot = y + this.getDepth();
		boolean encompasses = false; 
		if((this.getX()<=plot.getX()&&xPlot>=plot.getX()+plot.getWidth())&&
				(this.getY()<=plot.getY()&&yPlot>=plot.getY()+plot.getDepth())) {
			encompasses = true; 
		}
		return encompasses;
	}




}