package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Import {
	
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/";
	String  User;
	String  Pass;
	String sql = null;
	
	public Import (String USERNAME,String PASS,ArrayList<substation> substationlList,ArrayList<measurements> measurementsList,ArrayList<Avalues> AvaluesList ) {
		
		User=USERNAME;
		Pass=PASS;   
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to mySQL local server...");
			con = DriverManager.getConnection(DB_URL, User, Pass);
			
			st = con.createStatement();

		    // State POWER SYSTEM as database, which are going to be used to create table and to store data 
		    con = DriverManager.getConnection(DB_URL + "subtables", User, Pass);
		    sql = "USE 	SUBTABLES"; 
		    st.executeUpdate(sql) ; 
		    
			sql = "SELECT * FROM substations";
			ResultSet rs = st.executeQuery(sql);
			
			 while (rs.next()) {
			    	substation x = new substation(rs.getString("rdfid"), rs.getString("name"), rs.getString("region_id"));
			    	substationlList.add(x);
			    }
			 
			sql = "SELECT * FROM measurements";
			rs = st.executeQuery(sql);
				
			while (rs.next()) {
					measurements x = new measurements(rs.getString("rdfid"), rs.getString("name"), rs.getString("time"), rs.getString("value"), rs.getString("sub_rdfid") );
					measurementsList.add(x);
				    }
			
			sql = "SELECT * FROM analog_values";
			rs = st.executeQuery(sql);
				
			while (rs.next()) {
					Avalues x = new Avalues(rs.getString("rdfid"), rs.getString("name"), rs.getString("time"), rs.getString("value"), rs.getString("sub_rdfid") );
					AvaluesList.add(x);
				    }
	
			
		}
		
	    catch(SQLException eq){
		eq.printStackTrace();
		}
	    catch(Exception e){
		e.printStackTrace();
		}
		
}
}
