package project2;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;


import java.awt.Font;

public class KmeansGUITable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	public KmeansGUITable(String[][]Cluster1 , String[][]Cluster2 , String[][]Cluster3 , String[][]Cluster4) {
		
		String[] columnheaders = {"Times"};
		setTitle("K-Means Clustering");
		setBounds(100, 100, 959, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.getHSBColor(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 48, 440, 200);
		contentPane.add(scrollPane);
		table_4 = new JTable(Cluster1 , columnheaders);
		scrollPane.setViewportView(table_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(480, 48, 440, 200);
		contentPane.add(scrollPane_1);
		table_1 = new JTable(Cluster2 , columnheaders);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(13, 305, 440, 200);
		contentPane.add(scrollPane_2);
		table_2 = new JTable(Cluster3 , columnheaders);
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(480, 305, 440, 200);
		contentPane.add(scrollPane_3);
		table_3 = new JTable(Cluster4 , columnheaders);
		scrollPane_3.setViewportView(table_3);
		
		JLabel lbl1 = new JLabel("High load rate during peak hours (Cluster 1)");
		lbl1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lbl1.setBounds(81, 0, 326, 49);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Low load rate during night (Cluster 2)");
		lbl2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lbl2.setBounds(520, 0, 326, 49);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("Disconnection of a line for maintenance (Cluster 3)");
		lbl3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lbl3.setBounds(81, 259, 326, 49);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("Shut down of generator for maintenance (Cluster 4)");
		lbl4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lbl4.setBounds(530, 259, 340, 49);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl4);
		
		
	}
}
