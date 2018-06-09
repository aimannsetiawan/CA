package project2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;


public class MainProgram {
	
	public static void main(String[] args) {
		String USERNAME = JOptionPane.showInputDialog("Enter SQL username");
		String PASS = JOptionPane.showInputDialog("Enter SQL password");
		
		try {	

			ArrayList<Avalues> AvaluesList = new ArrayList<Avalues>();
			ArrayList<measurements> measurementsList = new ArrayList<measurements>();
			ArrayList<substation> substationlList = new ArrayList<substation>();

			Import mySQL = new Import (USERNAME,PASS,substationlList,measurementsList,AvaluesList);
			
			ArrayList<Double> MeasurementV = new ArrayList<Double>();
			ArrayList<Double> MeasurementA = new ArrayList<Double>();
			ArrayList<Double> AnalogV = new ArrayList<Double>();
			ArrayList<Double> AnalogA = new ArrayList<Double>();
			
			ArrayList<Statenumber> measurement = new ArrayList<Statenumber>();
			ArrayList<Statenumber> analog = new ArrayList<Statenumber>();
			
			for (int i=0; i<measurementsList.size();i++) {
			
				if (i%2!=0) {
					double x=measurementsList.get(i).getvalue();
					MeasurementA.add(x);}
				else {
					double x=measurementsList.get(i).getvalue();
					MeasurementV.add(x);
				}
			}
			
			for (int i=0; i<AvaluesList.size();i++) {
				
				if (i%2!=0) {
					double x=AvaluesList.get(i).getvalue();
					AnalogA.add(x);}
				else {
					double x=AvaluesList.get(i).getvalue();
					AnalogV.add(x);
				}
			}
			
			// State Numbering
			
			
			for (int i=0; i<200;i++) {
				int x=i;
				double y=measurementsList.get(i*18).gettime();
				Statenumber s= new Statenumber (x,y);
				
				measurement.add(s);
			}
			
			for (int i=0; i<200;i++) {
				int x=i;
				double y=measurementsList.get(i*18).gettime();
				Statenumber s= new Statenumber (x,y);
				
				measurement.add(s);
			}
			
			for (int i=0; i<20;i++) {
				int x=i;
				double y=AvaluesList.get(i*18).gettime();
				Statenumber s= new Statenumber (x,y);
				
				analog.add(s);
			}
		
			// Storing The Measurements and analog values to two dimentional array
			
			double[][] Measurements = new double[200][18];
			double[][] Avalues = new double[200][18];
			
			for (int i=0; i<200;i++) {
				for (int j=0; j<9;j++) {
				 Measurements [i][j] =MeasurementV.get(i * 9 + j);
				 Measurements [i][j+9] =MeasurementA.get(i * 9 + j);
				}	
			}
			
			for (int i=0; i<20;i++) {
				for (int j=0; j<9;j++) {
					Avalues [i][j] =AnalogV.get(i * 9 + j);
					Avalues [i][j+9] =AnalogA.get(i * 9 + j);
				}	
			}
			
			// Initialize
			double[] clustercenter1 = new double[18];
			double[] clustercenter2 = new double[18];
			double[] clustercenter3 = new double[18];
			double[] clustercenter4 = new double[18];
			
			double[] newclustercenter1 = new double[18];
			double[] newclustercenter2 = new double[18];
			double[] newclustercenter3 = new double[18];
			double[] newclustercenter4 = new double[18];
			
			for (int m = 0; m < 18; m++) {
				clustercenter1[m] = Measurements[40][m];
				clustercenter2[m] = Measurements[80][m];
				clustercenter3[m] = Measurements[120][m];
				clustercenter4[m] = Measurements[160][m];
			}
			

			int count1=0;
			int count2=0;
			int count3=0;
			int count4=0;
			
			ArrayList <cluster> cluster1= new ArrayList<cluster>();
			ArrayList <cluster> cluster2= new ArrayList<cluster>();
			ArrayList <cluster> cluster3= new ArrayList<cluster>();
			ArrayList <cluster> cluster4= new ArrayList<cluster>();
			
			double [] mean1=new double[18];
			double [] mean2=new double[18];
			double [] mean3=new double[18];
			double [] mean4=new double[18];
			
			ArrayList <Double> Resultscls1= new ArrayList<Double>();
			ArrayList <Double> Resultscls2= new ArrayList<Double>();
			ArrayList <Double> Resultscls3= new ArrayList<Double>();
			ArrayList <Double> Resultscls4= new ArrayList<Double>();
			
			while (true) {
			
			boolean check=true;
				
			for (int m = 0; m < 200; m++){
				
				double distance1=0.0;
				double EucD1=0.0;
				
				double distance2=0.0;
				double EucD2=0.0;
				
				double distance3=0.0;
				double EucD3=0.0;
				
				double distance4=0.0;
				double EucD4=0.0;
				
				double [] toCls = new double [18];
		      
				for (int m1 = 0; m1 < 9; m1++){
		           double V1=Measurements[m][m1];
		           double A1=Measurements[m][m1+9];
		           double V2=clustercenter1[m1];
		           double A2=clustercenter1[m1+9];
		           
		           
		           double distance= (Math.pow((V1*Math.cos(Math.toRadians(A1))-V2*Math.cos(Math.toRadians(A2))), 2)+Math.pow((V1*Math.sin(Math.toRadians(A1))-V2*Math.sin(Math.toRadians(A2))), 2));
		           distance1+=distance;
		           EucD1=Math.sqrt(distance1);
		                     
		        }
				
				for (int m1 = 0; m1 < 9; m1++){
			           double V1=Measurements[m][m1];
			           double A1=Measurements[m][m1+9];
			           double V2=clustercenter2[m1];
			           double A2=clustercenter2[m1+9];
			           
			           
			           double distance= (Math.pow((V1*Math.cos(Math.toRadians(A1))-V2*Math.cos(Math.toRadians(A2))), 2)+Math.pow((V1*Math.sin(Math.toRadians(A1))-V2*Math.sin(Math.toRadians(A2))), 2));
			           distance2+=distance;
			           EucD2=Math.sqrt(distance2);
			                     
			        }
				
				for (int m1 = 0; m1 < 9; m1++){
			           double V1=Measurements[m][m1];
			           double A1=Measurements[m][m1+9];
			           double V2=clustercenter3[m1];
			           double A2=clustercenter3[m1+9];
			           
			           double distance= (Math.pow((V1*Math.cos(Math.toRadians(A1))-V2*Math.cos(Math.toRadians(A2))), 2)+Math.pow((V1*Math.sin(Math.toRadians(A1))-V2*Math.sin(Math.toRadians(A2))), 2));
			           distance3+=distance;
			           EucD3=Math.sqrt(distance3);
			                     
			        }
				
				for (int m1 = 0; m1 < 9; m1++){
			           double V1=Measurements[m][m1];
			           double A1=Measurements[m][m1+9];
			           double V2=clustercenter4[m1];
			           double A2=clustercenter4[m1+9];
			           
			           double distance= (Math.pow((V1*Math.cos(Math.toRadians(A1))-V2*Math.cos(Math.toRadians(A2))), 2)+Math.pow((V1*Math.sin(Math.toRadians(A1))-V2*Math.sin(Math.toRadians(A2))), 2));
			           distance4+=distance;
			           EucD4=Math.sqrt(distance4);
			                     
			        }
				
				for (int m1 = 0; m1 < 18; m1++) {
					toCls [m1]=Measurements[m][m1];
				}
				
				double time=0.0;
				
				for (int l1 = 0; l1 < 200; l1++) {
					
					int a = measurement.get(l1).getnum();
					
					if (a==m) {
						time=measurement.get(l1).gettime();
					}
					
				}
				
				
				if (EucD1 <= EucD2 && EucD1 <= EucD3 && EucD1 <= EucD4) {
					count1++;	
					cluster x= new cluster(toCls,m,time);
					cluster1.add(x);
					Resultscls1.add(time);}
				else if (EucD2 <= EucD1 && EucD2 <= EucD3 && EucD2 <= EucD4) {
					count2++;
					cluster x= new cluster(toCls,m,time);
					cluster2.add(x);
					Resultscls2.add(time);}
				else if (EucD3 <= EucD1 && EucD3 <= EucD2 && EucD3 <= EucD4) {
					count3++;
					cluster x= new cluster(toCls,m,time);
					cluster3.add(x);
					Resultscls3.add(time);}
				else if (EucD4 <= EucD1 && EucD4 <= EucD2 && EucD4 <= EucD3) {
					count4++;
					cluster x= new cluster(toCls,m,time);
					cluster4.add(x);
					Resultscls4.add(time);}
				             
			}
		  	
			for (int x = 0; x < 18; x++) {
				for (int x1 = 0; x1 < cluster1.size(); x1++) {
					mean1[x] += cluster1.get(x1).getvalue(x);
				}

				mean1[x] = mean1[x] / cluster1.size();
				newclustercenter1[x] = mean1[x];
				
			}
			
			for (int x = 0; x < 18; x++) {
				for (int x1 = 0; x1 < cluster2.size(); x1++) {
					mean2[x] += cluster2.get(x1).getvalue(x);
				}

				mean2[x] = mean2[x] / cluster2.size();
				newclustercenter2[x] = mean2[x];
				
			}
			
			for (int x = 0; x < 18; x++) {
				for (int x1 = 0; x1 < cluster3.size(); x1++) {
					mean3[x] += cluster3.get(x1).getvalue(x);
				}

				mean3[x] = mean3[x] / cluster3.size();
				newclustercenter3[x] = mean3[x];
				
			}
			
			for (int x = 0; x < 18; x++) {
				for (int x1 = 0; x1 < cluster4.size(); x1++) {
					mean4[x] += cluster4.get(x1).getvalue(x);
				}

				mean4[x] = mean4[x] / cluster4.size();
				newclustercenter4[x] = mean4[x];
				
			}
			
			double  residual1=0.0;
			double  residual2=0.0;
			double  residual3=0.0;
			double  residual4=0.0;
			
			double a1=0.0;
			double a2=0.0;
			double b1=0.0;
			double b2=0.0;
			double c1=0.0;
			double c2=0.0;
			double d1=0.0;
			double d2=0.0;
			
			for (int x = 0; x < 18; x++) {
				 a1+=clustercenter1[x];
				 a2+=newclustercenter1[x];
				 b1+=clustercenter2[x];
				 b2+=newclustercenter2[x];
				 c1+=clustercenter3[x];
				 c2+=newclustercenter3[x];
				 d1+=clustercenter4[x];
				 d2+=newclustercenter4[x];
			}
			
			residual1=a1-a2;
			residual2=b1-b2;
			residual3=c1-c2;
			residual4=c1-c2;
				
			clustercenter1 = newclustercenter1;
			clustercenter2 = newclustercenter2;
			clustercenter3 = newclustercenter3;
			clustercenter4 = newclustercenter4;
		
			if (residual1<=0.0 && residual2<=0.0 && residual3<=0.0 && residual4<=0.0) {
				check=false;
			}
			
			
			if(check==false){ break; }
			
			cluster1.clear();
			cluster2.clear();
			cluster3.clear();
			cluster4.clear();
			
			Resultscls1.clear();
			Resultscls2.clear();
			Resultscls3.clear();
			Resultscls4.clear();
			
			}
			
			Collections.sort(Resultscls1);
			Collections.sort(Resultscls2);
			Collections.sort(Resultscls3);
			Collections.sort(Resultscls4);
		
			
			System.out.println("======================================================================================");
			System.out.println("======================================================================================");
			System.out.println("================================CLUSTERING SUMMARY====================================");
			System.out.println("======================================================================================");
			System.out.println("======================================================================================");
			
			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("Data which belong to cluster 1 are "+cluster1.size()+" data");
			System.out.println("Data which belong to cluster 2 are "+cluster2.size()+" data");
			System.out.println("Data which belong to cluster 3 are "+cluster3.size()+" data");
			System.out.println("Data which belong to cluster 4 are "+cluster4.size()+" data");

			System.out.println(" ");
			System.out.println(" ");
			System.out.println("=================Cluster Center=================");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("=================Cluster1=================");
			System.out.println(" ");
			
			for (int k = 0; k < (clustercenter1.length)/2; k++) {
				 
				 System.out.println("Voltage : "+clustercenter1[k]+" PU");
				 System.out.println("Angle : "+clustercenter1[k+9]+" degree");
			 }
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("=================Cluster2=================");
			System.out.println(" ");
			
			for (int k = 0; k < (clustercenter2.length)/2; k++) {
				 
				 System.out.println("Voltage : "+clustercenter2[k]+" PU");
				 System.out.println("Angle : "+clustercenter2[k+9]+" degree");
			 }
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("=================Cluster3=================");
			System.out.println(" ");
			
			for (int k = 0; k < (clustercenter3.length)/2; k++) {
				 
				 System.out.println("Voltage : "+clustercenter3[k]+" PU");
				 System.out.println("Angle : "+clustercenter3[k+9]+" degree");
			 }
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("=================Cluster4=================");
			System.out.println(" ");
			
			for (int k = 0; k < (clustercenter4.length)/2; k++) {
				 
				 System.out.println("Voltage : "+clustercenter4[k]+" PU");
				 System.out.println("Angle : "+clustercenter4[k+9]+" degree");
			 }
			
			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("CLUSTER 1");
			System.out.println("Time");
			
			for (int k = 0; k < Resultscls1.size(); k++) {
				 
				 System.out.println(Resultscls1.get(k));
				 
			 }
			
			 System.out.println(" ");
			 System.out.println(" ");
			 
			 System.out.println("CLUSTER 2");
			 System.out.println("Time");
			
				for (int k = 0; k < Resultscls2.size(); k++) {
					 
					 System.out.println(Resultscls2.get(k));
					 
				 }
			 
			 System.out.println(" ");
			 System.out.println(" ");
			 
			 System.out.println("CLUSTER 3");
			 System.out.println("Time");
			
				for (int k = 0; k < Resultscls3.size(); k++) {
					 
					 System.out.println(Resultscls3.get(k));
					 
				 }
			 
			 System.out.println(" ");
			 System.out.println(" ");
			
			 System.out.println("CLUSTER 4");
			 System.out.println("Time");
			 
				for (int k = 0; k < Resultscls4.size(); k++) {
					 
					 System.out.println(Resultscls4.get(k));
					 
				 }
			System.out.println(" ");
			System.out.println(" ");	
	
			ArrayList<Double[]> GUIkMEANS1 = new ArrayList<Double[]>();
			ArrayList<Double[]> GUIkMEANS2= new ArrayList<Double[]>();
			ArrayList<Double[]> GUIkMEANS3= new ArrayList<Double[]>();
			ArrayList<Double[]> GUIkMEANS4= new ArrayList<Double[]>();
			
			for (int i=0 ; i<cluster1.size(); i++) {
				Double[]GUIkMEANS1list = new Double[2];
				GUIkMEANS1list[0]=cluster1.get(i).gettime();
				GUIkMEANS1list[1]=(double) 1;
				GUIkMEANS1.add(GUIkMEANS1list);
			}
			
			for (int i=0 ; i<cluster2.size(); i++) {
				Double[]GUIkMEANS2list = new Double[2];
				GUIkMEANS2list[0]=cluster2.get(i).gettime();
				GUIkMEANS2list[1]=(double) 2;
				GUIkMEANS2.add(GUIkMEANS2list);
			}
			
			for (int i=0 ; i<cluster3.size(); i++) {
				Double[]GUIkMEANS3list = new Double[2];
				GUIkMEANS3list[0]=cluster3.get(i).gettime();
				GUIkMEANS3list[1]=(double) 3;
				GUIkMEANS3.add(GUIkMEANS3list);
			}
			
			for (int i=0 ; i<cluster4.size(); i++) {
				Double[]GUIkMEANS4list = new Double[2];
				GUIkMEANS4list[0]=cluster4.get(i).gettime();
				GUIkMEANS4list[1]=(double) 4;
				GUIkMEANS4.add(GUIkMEANS4list);
			}
			

			String[][]GUIkMEANS1Table = new String[GUIkMEANS1.size()][2];   
			String[][]GUIkMEANS2Table = new String[GUIkMEANS2.size()][2];
			String[][]GUIkMEANS3Table = new String[GUIkMEANS3.size()][2];
			String[][]GUIkMEANS4Table = new String[GUIkMEANS4.size()][2];



			for (int i = 0 ; i < GUIkMEANS1.size() ; i++){
				GUIkMEANS1Table[i][0]= Double.toString(GUIkMEANS1.get(i)[0]);
				GUIkMEANS1Table[i][1]= Double.toString(GUIkMEANS1.get(i)[1]);
			}
			

			for (int i = 0 ; i < GUIkMEANS2.size() ; i++){
				GUIkMEANS2Table[i][0]=Double.toString(GUIkMEANS2.get(i)[0]);
				GUIkMEANS2Table[i][1]=Double.toString(GUIkMEANS2.get(i)[1]);
			}

			for (int i = 0 ; i < GUIkMEANS3.size() ; i++){
				GUIkMEANS3Table[i][0]=Double.toString(GUIkMEANS3.get(i)[0]);
				GUIkMEANS3Table[i][1]=Double.toString(GUIkMEANS3.get(i)[1]);
			}

			for (int i = 0 ; i < GUIkMEANS4.size() ; i++){
				GUIkMEANS4Table[i][0]=Double.toString(GUIkMEANS4.get(i)[0]);
				GUIkMEANS4Table[i][1]=Double.toString(GUIkMEANS4.get(i)[1]);
			}
			
				
			
			
			

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////K Nearest Neighbor/////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////Preparing learing set set//////////
ArrayList<Learning> Learningset = new ArrayList<Learning>();

//Inserting cluster 1 to learningset
for (int x = 0;  x < cluster1.size(); x++) {
double [] y = cluster1.get(x).getset(); 
int z= 1;
Learning w= new Learning (y,z);
Learningset.add(w);
}

//Inserting cluster 2 to learningset
for (int x = 0;  x < cluster2.size(); x++) {
double [] y = cluster2.get(x).getset(); 
int z= 2;
Learning w= new Learning (y,z);
Learningset.add(w);
}

//Inserting cluster 3 to learningset
for (int x = 0;  x < cluster3.size(); x++) {
double [] y = cluster3.get(x).getset(); 
int z= 3;
Learning w= new Learning (y,z);
Learningset.add(w);
}

//Inserting cluster 4 to learningset
for (int x = 0;  x < cluster4.size(); x++) {
double [] y = cluster4.get(x).getset(); 
int z= 4;
Learning w= new Learning (y,z);
Learningset.add(w);
}

ArrayList <Double> Resutclf1 = new ArrayList<Double>();
ArrayList <Double> Resutclf2 = new ArrayList<Double>();
ArrayList <Double> Resutclf3 = new ArrayList<Double>();
ArrayList <Double> Resutclf4 = new ArrayList<Double>();

ArrayList<Double[]> GUIkNN1 = new ArrayList<Double[]>();
ArrayList<Double[]> GUIkNN2 = new ArrayList<Double[]>();
ArrayList<Double[]> GUIkNN3 = new ArrayList<Double[]>();
ArrayList<Double[]> GUIkNN4 = new ArrayList<Double[]>();


for (int i = 0; i < 20; i++){	

double Vt1=Avalues[i][0];
double At1=Avalues[i][9];
double Vt2=Avalues[i][1];
double At2=Avalues[i][10];
double Vt3=Avalues[i][2];
double At3=Avalues[i][11];
double Vt4=Avalues[i][3];
double At4=Avalues[i][12];
double Vt5=Avalues[i][4];
double At5=Avalues[i][13];
double Vt6=Avalues[i][5];
double At6=Avalues[i][14];
double Vt7=Avalues[i][6];
double At7=Avalues[i][15];
double Vt8=Avalues[i][7];
double At8=Avalues[i][16];
double Vt9=Avalues[i][8];
double At9=Avalues[i][17];

double distance=0.0;
double EcD=0.0;

ArrayList<results> results = new ArrayList<results>();

for (int j = 0; j < Learningset.size(); j++) {

double Vl1=Learningset.get(j).getvalue(0);
double Al1=Learningset.get(j).getvalue(9);
double Vl2=Learningset.get(j).getvalue(1);
double Al2=Learningset.get(j).getvalue(10);
double Vl3=Learningset.get(j).getvalue(2);
double Al3=Learningset.get(j).getvalue(11);
double Vl4=Learningset.get(j).getvalue(3);
double Al4=Learningset.get(j).getvalue(12);
double Vl5=Learningset.get(j).getvalue(4);
double Al5=Learningset.get(j).getvalue(13);
double Vl6=Learningset.get(j).getvalue(5);
double Al6=Learningset.get(j).getvalue(14);
double Vl7=Learningset.get(j).getvalue(6);
double Al7=Learningset.get(j).getvalue(15);
double Vl8=Learningset.get(j).getvalue(7);
double Al8=Learningset.get(j).getvalue(16);
double Vl9=Learningset.get(j).getvalue(8);
double Al9=Learningset.get(j).getvalue(17);

distance = (Math.pow((Vl1*Math.cos(Math.toRadians(Al1))-Vt1*Math.cos(Math.toRadians(At1))), 2)+Math.pow((Vl1*Math.sin(Math.toRadians(Al1))-Vt1*Math.sin(Math.toRadians(At1))), 2))+
(Math.pow((Vl2*Math.cos(Math.toRadians(Al2))-Vt2*Math.cos(Math.toRadians(At2))), 2)+Math.pow((Vl2*Math.sin(Math.toRadians(Al2))-Vt2*Math.sin(Math.toRadians(At2))), 2))+
(Math.pow((Vl3*Math.cos(Math.toRadians(Al3))-Vt3*Math.cos(Math.toRadians(At3))), 2)+Math.pow((Vl3*Math.sin(Math.toRadians(Al3))-Vt3*Math.sin(Math.toRadians(At3))), 2))+
(Math.pow((Vl4*Math.cos(Math.toRadians(Al4))-Vt4*Math.cos(Math.toRadians(At4))), 2)+Math.pow((Vl4*Math.sin(Math.toRadians(Al4))-Vt4*Math.sin(Math.toRadians(At4))), 2))+
(Math.pow((Vl5*Math.cos(Math.toRadians(Al5))-Vt5*Math.cos(Math.toRadians(At5))), 2)+Math.pow((Vl5*Math.sin(Math.toRadians(Al5))-Vt5*Math.sin(Math.toRadians(At5))), 2))+
(Math.pow((Vl6*Math.cos(Math.toRadians(Al6))-Vt6*Math.cos(Math.toRadians(At6))), 2)+Math.pow((Vl6*Math.sin(Math.toRadians(Al6))-Vt6*Math.sin(Math.toRadians(At6))), 2))+
(Math.pow((Vl7*Math.cos(Math.toRadians(Al7))-Vt7*Math.cos(Math.toRadians(At7))), 2)+Math.pow((Vl7*Math.sin(Math.toRadians(Al7))-Vt7*Math.sin(Math.toRadians(At7))), 2))+
(Math.pow((Vl8*Math.cos(Math.toRadians(Al8))-Vt8*Math.cos(Math.toRadians(At8))), 2)+Math.pow((Vl8*Math.sin(Math.toRadians(Al8))-Vt8*Math.sin(Math.toRadians(At8))), 2))+
(Math.pow((Vl9*Math.cos(Math.toRadians(Al9))-Vt9*Math.cos(Math.toRadians(At9))), 2)+Math.pow((Vl9*Math.sin(Math.toRadians(Al9))-Vt9*Math.sin(Math.toRadians(At9))), 2));
EcD=Math.sqrt(distance);

int cls= Learningset.get(j).getnum();
results rs = new results (EcD,cls);

results.add(rs);
}

Collections.sort(results, new comparator());


int CL1=0;
int CL2=0;
int CL3=0;
int CL4=0;

for (int k = 0; k < 5; k++) {

int a=results.get(k).getnum();

if (a==1) {
CL1++;
}

if (a==2) {
CL2++;
}

if (a==3) {
CL3++;
}

if (a==4) {
CL4++;
}

}



if (CL1 >= CL2 && CL1 >= CL3 && CL1 >= CL4) {
Resutclf1.add(analog.get(i).gettime());
Double[]GUIkNN1list = new Double[2];
GUIkNN1list[0]=analog.get(i).gettime();
GUIkNN1list[1]=(double) 1;
GUIkNN1.add(GUIkNN1list);
;}
else if (CL2 >= CL1 && CL2 >= CL3 && CL2 >= CL4) {
Resutclf2.add(analog.get(i).gettime());
Double[]GUIkNN2list = new Double[2];
GUIkNN2list[0]=analog.get(i).gettime();
GUIkNN2list[1]=(double) 2;
GUIkNN2.add(GUIkNN2list);
;}
else if  (CL3 >= CL1 && CL3 >= CL2 && CL3 >= CL4) {
Resutclf3.add(analog.get(i).gettime());
Double[]GUIkNN3list = new Double[2];
GUIkNN3list[0]=analog.get(i).gettime();
GUIkNN3list[1]=(double) 3;
GUIkNN3.add(GUIkNN3list);
;}
else if  (CL4 >= CL1 && CL4 >= CL2 && CL4 >= CL3) {
Resutclf4.add(analog.get(i).gettime());
Double[]GUIkNN4list = new Double[2];
GUIkNN4list[0]=analog.get(i).gettime();
GUIkNN4list[1]=(double) 4;
GUIkNN4.add(GUIkNN4list);
;}


}

Collections.sort(Resutclf1);
Collections.sort(Resutclf2);
Collections.sort(Resutclf3);
Collections.sort(Resutclf4);

System.out.println("======================================================================================");
System.out.println("======================================================================================");
System.out.println("================================CLASIFICATION SUMMARY=================================");
System.out.println("======================================================================================");
System.out.println("======================================================================================");

System.out.println(" ");
System.out.println(" ");

System.out.println("CLUSTER 1");
System.out.println("Time");


String[][]GUIkNN1Table = new String[GUIkNN1.size()][2];    
String[][]GUIkNN2Table = new String[GUIkNN2.size()][2];
String[][]GUIkNN3Table = new String[GUIkNN3.size()][2];
String[][]GUIkNN4Table = new String[GUIkNN4.size()][2];



	for (int l = 0 ; l < GUIkNN1.size() ; l++){
		GUIkNN1Table[l][0]= Double.toString(GUIkNN1.get(l)[0]);
		GUIkNN1Table[l][1]= Double.toString(GUIkNN1.get(l)[1]);
	}
	

	for (int l = 0 ; l < GUIkNN2.size() ; l++){
		GUIkNN2Table[l][0]=Double.toString(GUIkNN2.get(l)[0]);
		GUIkNN2Table[l][1]=Double.toString(GUIkNN2.get(l)[1]);
	}

	for (int l = 0 ; l < GUIkNN3.size() ; l++){
		GUIkNN3Table[l][0]=Double.toString(GUIkNN3.get(l)[0]);
		GUIkNN3Table[l][1]=Double.toString(GUIkNN3.get(l)[1]);
	}

	for (int l = 0 ; l < GUIkNN4.size() ; l++){
		GUIkNN4Table[l][0]=Double.toString(GUIkNN4.get(l)[0]);
		GUIkNN4Table[l][1]=Double.toString(GUIkNN4.get(l)[1]);
	}
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(GUIkMEANS1Table , GUIkMEANS2Table , GUIkMEANS3Table , GUIkMEANS4Table , GUIkNN1Table , GUIkNN2Table , GUIkNN3Table , GUIkNN4Table);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KmeansGUITable frame = new KmeansGUITable(GUIkMEANS1Table , GUIkMEANS2Table , GUIkMEANS3Table , GUIkMEANS4Table);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	


for (int k = 0; k < Resutclf1.size(); k++) {

System.out.println(Resutclf1.get(k));

}

System.out.println(" ");
System.out.println(" ");

System.out.println("CLUSTER 2");
System.out.println("Time");

for (int k = 0; k < Resutclf2.size(); k++) {

System.out.println(Resutclf2.get(k));

}

System.out.println(" ");
System.out.println(" ");

System.out.println("CLUSTER 3");
System.out.println("Time");

for (int k = 0; k < Resutclf3.size(); k++) {

System.out.println(Resutclf3.get(k));

}

System.out.println(" ");
System.out.println(" ");

System.out.println("CLUSTER 4");
System.out.println("Time");

for (int k = 0; k < Resutclf4.size(); k++) {

System.out.println(Resutclf4.get(k));

}





}



catch (Exception e) {
e.printStackTrace();}
}}