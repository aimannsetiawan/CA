package project2;

public class substation {
	
	private String RDFID;
	private String Name;
	private String Region;
	
	public substation (String rdfID,String name,String region) {
		
		try {
		RDFID =rdfID;
		Name = name;
		Region=region;
		}
		
		catch (NumberFormatException ex) {}
		
	}
	
	public String getrdfID(){ return RDFID; }
	public String getname(){ return Name; }
	public String getregion(){ return Region; }
}
