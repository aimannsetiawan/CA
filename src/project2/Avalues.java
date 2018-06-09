package project2;

public class Avalues {
	
	private String RDFID;
	private String Name;
	private String SubrdfID;
	private double Time;
	private double Value;
	
	
	public Avalues (String rdfID,String name,String time,String value,String subrdfID) {
		
		try {
		RDFID =rdfID;
		Name = name;
		Time=Double.parseDouble(time);
		Value=Double.parseDouble(value);
		SubrdfID=subrdfID;
		}
		
		catch (NumberFormatException ex) {}
		
	}
	
	public String getrdfID(){ return RDFID; }
	public String getname(){ return Name; }
	public double gettime (){ return Time; }
	public double getvalue(){ return Value; }
	public String getsubrdfID(){ return SubrdfID; }
}
