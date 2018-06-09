package project2;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;

public class KNNGUITable extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	
	public KNNGUITable(String[][]Knn1 , String[][]Knn2 , String[][]Knn3 , String[][]Knn4) {
		
		String[] columnheaders = {"Times"};
		setTitle("K-Nearest Neighbour Classification");
		setBounds(100, 100, 940, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.getHSBColor(175, 238, 238));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 420, 105);
		contentPane.add(scrollPane);
				
		table_4 = new JTable(Knn1 , columnheaders);
		scrollPane.setViewportView(table_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(465, 47, 420, 105);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(Knn2 , columnheaders);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 205, 420, 105);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable(Knn3 , columnheaders);
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(465, 205, 420, 105);
		contentPane.add(scrollPane_3);
		
		table_3 = new JTable(Knn4 , columnheaders);
		scrollPane_3.setViewportView(table_3);
		
		JLabel lblNewLabel = new JLabel("High load rate during peak hours (Cluster 1)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD , 14));
		lblNewLabel.setBounds(81, 0, 326, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblLowLoadRate = new JLabel("Low load rate during night (Cluster 2)");
		lblLowLoadRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowLoadRate.setFont(new Font("Trebuchet MS", Font.BOLD , 14));
		lblLowLoadRate.setBounds(510, 0, 326, 49);
		contentPane.add(lblLowLoadRate);
		
		JLabel lblDisconnectionOfA = new JLabel("Disconnection of a line for maintenance (Cluster 3)");
		lblDisconnectionOfA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisconnectionOfA.setFont(new Font("Trebuchet MS", Font.BOLD , 14));
		lblDisconnectionOfA.setBounds(70, 155, 350, 49);
		contentPane.add(lblDisconnectionOfA);
		
		JLabel lblShutDownOf = new JLabel("Shut down of generator for maintenance (Cluster 4)");
		lblShutDownOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblShutDownOf.setFont(new Font("Trebuchet MS", Font.BOLD , 14));
		lblShutDownOf.setBounds(495, 155, 350, 49);
		contentPane.add(lblShutDownOf);
		
		
	}
}
