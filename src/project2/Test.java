package project2;

public class Test {
	
	double [] Set;
	int num;
	double Time;
	
	public Test (double set [], int i, double time ) {
		
		this.Set=set;
		this.num=i;	
		this.Time=time;
	}
	
	 public double[] getset() {
	        return Set;
	    }
	    public double getvalue(int i) {
	        return Set[i];
	    }
	  public int getnum() {
	        return num;
	    }
	  public double gettime() {
	        return Time;
	    }
}
