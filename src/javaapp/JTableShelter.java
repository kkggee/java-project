package javaapp;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class JTableShelter extends JFrame {

	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton jButton1;

	public void populateJTable(ArrayList<Product0> list) throws IOException {

		String[] columnName = { "보호소명", "보호소 주소", "전화번호" };
		Object[][] rows = new Object[list.size()][3];
		setTitle("보호소 정보");
		for (int i = 0; i < list.size(); i++) {
			rows[i][0] = list.get(i).getcareNm();
			rows[i][1] = list.get(i).getcareAddr();
			rows[i][2] = list.get(i).getcareTel();
		}

		TheModel0 model0 = new TheModel0(rows, columnName); // 행, 열
		jTable1.setModel(model0);
		jTable1.setRowHeight(120);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(110);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(220);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
	}

	@SuppressWarnings("unchecked")

	public void initComponents() {
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		ImageIcon icon = new ImageIcon("home.png");
		Image himg = icon.getImage();
		Image hchangeImg = himg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		jButton1 = new JButton(new ImageIcon(hchangeImg));
		ImageIcon shelter = new ImageIcon("shelter.jpg");
		Image rimg = shelter.getImage();
		Image rchangeImg = rimg.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
		setContentPane(new JLabel(new ImageIcon(rchangeImg)));
		setLayout(null);
		add(jTable1);
		add(jScrollPane1);
		add(jButton1);

		jTable1.setBackground(new Color(255, 255, 255));
		jButton1.setBackground(new Color(255, 250, 240));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				new start();
			}
		});

		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jScrollPane1.setViewportView(jTable1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(0, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addContainerGap(0, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jButton1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10)));
		pack();
	}
}