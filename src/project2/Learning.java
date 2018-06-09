package project2;

public class Learning {
	
	double [] Set;
	int num;
	
	public Learning (double set [], int i ) {
		
		this.Set=set;
		this.num=i;	
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
}
