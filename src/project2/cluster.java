package project2;

public class cluster {
	 
		double[] C = new double[18];
		int state ;
		double time;
		
	    public cluster(double [] set1, int m,double Time) {

	        this.C = set1;
	        this.state=m;
	        this.time=Time;
	               
	    }
	    public double[] getset() {
	        return C;
	    }
	    public double getvalue(int i) {
	        return C[i];
	    }
	    public double gettime() {
	        return time;
	    }
	    public int getstate() {
	        return state;
	    }
}
