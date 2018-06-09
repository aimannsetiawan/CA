package project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Image;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;

	public GUI(String[][]cluster1 , String[][]cluster2 , String[][]cluster3 , String[][]cluster4 , String[][]knn1 , String[][]knn2 , 
			String[][]knn3 , String[][]knn4) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EH2745 Assignment 2");
		setBounds(100, 100, 496, 253);
		contentPane = new JPanel();
		getContentPane().setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttKMC = new JButton("K-means Clustering Tables");
		buttKMC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttKMC.setBounds(205, 95, 219, 41);
		contentPane.add(buttKMC);
		buttKMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KmeansGUITable  kmeanstable = new KmeansGUITable(cluster1 , cluster2 , cluster3 , cluster4);
				kmeanstable.setVisible(true);
			}
		});
		
		
		JButton buttKNN = new JButton("KNN Classification Tables");
		buttKNN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttKNN.setBounds(205, 147, 219, 41);
		contentPane.add(buttKNN);
		buttKNN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KNNGUITable  knntable = new KNNGUITable(knn1 , knn2 , knn3 , knn4);
				knntable.setVisible(true);
			}
		});
		
		
		JLabel lblEh = new JLabel("EH 2745 - Assignment 2");
		lblEh.setForeground(new Color(255, 0, 0));
		lblEh.setFont(new Font("TITUS Cyberbit Basic", Font.PLAIN, 16));
		lblEh.setBounds(229, 11, 195, 41);
		getContentPane().add(lblEh);
		
		JLabel lblAimanSetiawan = new JLabel("Aiman Setiawan");
		lblAimanSetiawan.setBounds(24, 155, 97, 14);
		getContentPane().add(lblAimanSetiawan);
		
		JLabel lblHeraldusPanjiArikson = new JLabel("Heraldus Panji Arikson");
		lblHeraldusPanjiArikson.setBounds(24, 175, 140, 14);
		getContentPane().add(lblHeraldusPanjiArikson);
		
		JLabel lblGroup = new JLabel("Group 19");
		lblGroup.setBounds(24, 136, 97, 14);
		getContentPane().add(lblGroup);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Capture.JPG")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(24, 11, 116, 115);
		getContentPane().add(lblNewLabel);
		
		JLabel lblComputerApplicationIn = new JLabel("Computer Application in Power System");
		lblComputerApplicationIn.setForeground(Color.RED);
		lblComputerApplicationIn.setFont(new Font("TITUS Cyberbit Basic", Font.PLAIN, 16));
		lblComputerApplicationIn.setBounds(183, 43, 275, 41);
		getContentPane().add(lblComputerApplicationIn);
		
	}
}