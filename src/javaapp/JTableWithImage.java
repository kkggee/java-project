package javaapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JTableWithImage extends JFrame {

	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton jButton1;
	private JButton jButton2;

	public void populateJTable(ArrayList<Product2> list) throws IOException {
		String[] columnName = { "이미지", "나이", "품종", "성별", "발생날짜", "발생장소", "보호소명" };
		Object[][] rows = new Object[list.size()][7];
		setTitle("유기견 정보");
		for (int i = 0; i < list.size(); i++) { // 데이터를 데이터 수만큼 반복
			if (list.get(i).getMyImage() != null) { // 이미지가 null이 아닌경우 실행
				URL url = new URL(list.get(i).getMyImage());  // url 데이터 가져옴
				Image img = ImageIO.read(url);   // url -> 이미지
				Image update = img.getScaledInstance(150, 120, Image.SCALE_SMOOTH); // 이미지 사이즈
				ImageIcon image = new ImageIcon(update); // 아이콘 생성
				rows[i][0] = image;
			} else { // 데이터가 null인 경우 배열에 null 저장
				rows[i][0] = null;
			}
			//배열에 데이터 저장
			rows[i][1] = list.get(i).getage();
			rows[i][2] = list.get(i).getkindCd();
			rows[i][3] = list.get(i).getsexCd();
			rows[i][4] = list.get(i).gethappenDt();
			rows[i][5] = list.get(i).gethappenPlace();
			rows[i][6] = list.get(i).getcareNm();

		}
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = list.get(0).gethappenPlace(); // 첫번째 행의 happenPlace 값을 s에 저장
				MyQuery0 mq0 = new MyQuery0();
				JTableShelter js = new JTableShelter();
				if (s.contains("고창")) { // s에 '고창'이라는 단어가 포함된 경우
					try {
						setVisible(false);  
						js.initComponents(); 
						js.populateJTable(mq0.BindTable("sgochang"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("군산")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("sgunsan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("김제")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("sgimje"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("남원")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("snamwon"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("무주")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("smooju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("부안")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("sbuan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("순창")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("ssunchang"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("완주")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("swanju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("익산")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("siksan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("장수")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("sjangsoo"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("전주")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("sjeonju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (s.contains("정읍")) {
					try {
						setVisible(false);
						js.initComponents();
						js.populateJTable(mq0.BindTable("sjungeup"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});

		TheModel model = new TheModel(rows, columnName); // 행, 열
		jTable1.setModel(model);
		jTable1.setRowHeight(120);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
		jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
		jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
		jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
		jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
	}

	@SuppressWarnings("unchecked")

	public void initComponents() {
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jButton1 = new JButton();
		jButton1.setText("보호소 위치");
		ImageIcon icon = new ImageIcon("home.png");
		Image himg = icon.getImage();
		Image hchangeImg = himg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		jButton2 = new JButton(new ImageIcon(hchangeImg));

		setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		ImageIcon start = new ImageIcon("table.jpg");
		Image simg = start.getImage();
		Image schangeImg = simg.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);

		setContentPane(new JLabel(new ImageIcon(schangeImg)));
		setLayout(null);
		add(jButton2);
		add(jTable1);
		add(jScrollPane1);
		add(jButton1);

		jTable1.setBackground(new Color(255, 255, 255));
		jButton1.setBackground(new Color(255, 250, 240));
		jButton2.setBackground(new Color(255, 250, 240));

		jScrollPane1.setViewportView(jTable1);
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				new start();

			}
		});
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(0, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(0, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10).addComponent(jButton2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

						.addContainerGap().addComponent(jButton1)));
		pack();

	}

}