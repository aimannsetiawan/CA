package project2;

public class Statenumber {
	
	int num;
	double time;
	
	public Statenumber (int Num,double Time) {
		
		try {
			
		this.num =Num;
		this.time=Time;
		
		}
		
		catch (NumberFormatException ex) {}
		
	}
	
	public int getnum(){ return num; }
	public double gettime(){ return time; }
	
}
