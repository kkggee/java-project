package javaapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class start extends JFrame {
	private JLabel TextLabel;
	private JButton jButton1;
	private JComboBox<String> jComboBox1;

	public start() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		jComboBox1 = new JComboBox<>(); // 콤보박스
		TextLabel = new JLabel("유기견 보호"); // 유기견 보호 글씨

		ImageIcon icon = new ImageIcon("img.png"); // 돋보기 이미지
		Image himg = icon.getImage();
		Image hchangeImg = himg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		jButton1 = new JButton(new ImageIcon(hchangeImg)); // 이미지 버튼에 생성

		setTitle("Start Menu");
		setLayout(new BorderLayout());

		ImageIcon start = new ImageIcon("start.jpg");
		Image simg = start.getImage();
		Image schangeImg = simg.getScaledInstance(400, 300, Image.SCALE_SMOOTH);

		setContentPane(new JLabel(new ImageIcon(schangeImg)));
		setLayout(null);
		add(jComboBox1);
		add(TextLabel);
		add(jButton1);
		jButton1.setBackground(new Color(255, 250, 240));
		jComboBox1.setBackground(new Color(255, 250, 240));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "고창시", "군산시", 
				"김제시", "남원시", "무주군", "부안군", "순창군",
				"완주군", "익산시", "장수군", "전주시", "정읍시", "진안군" }));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String pick = jComboBox1.getSelectedItem().toString(); // 콤보박스에서 선택된 string 저장
				System.out.println(pick);
				MyQuery mq = new MyQuery();
				JTableWithImage im = new JTableWithImage();
				switch (pick) { // 선택된 string이 "~"일 경우 메인페이지 실행
				case "고창시":
					try {
						setVisible(false); // start 부분 화면 꺼지게
						im.initComponents();
						ArrayList<Product2> s = mq.BindTable("gochang"); //gochang 테이블 데이터 불러오기
						im.populateJTable(s); // 테이블 생성
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "군산시":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("gunsan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "김제시":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("gimje"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "남원시":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("namwon"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "무주군":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("mooju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "부안군":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("buan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "순창군":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("sunchang"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "완주군":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("wanju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "익산시":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("iksan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "장수군":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("jangsoo"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "전주시":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("jeonju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "정읍시":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("jungeup"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		});

		TextLabel.setFont(new Font("휴먼둥근헤드라인", 0, 30));
		TextLabel.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout layout = new GroupLayout(getContentPane()); //layout 선언

	      getContentPane().setLayout(layout); //contentpane 개체 layout 반환
	      
	      layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //원점에 정렬 -> 평행그룹 만들고 반환 *수평 축을 따라 설정
	              .addGroup(layout.createSequentialGroup().addGap(91, 91, 91) // 그룹으로 구성된 label,combobox,button의 왼쪽 프레임 간격
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //textlabel,(combobox, button) 그룹
	                          .addComponent(TextLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
	                          .addGroup(layout.createSequentialGroup() //combobox, button 그룹
	                                .addComponent(jComboBox1, GroupLayout.DEFAULT_SIZE, 130, GroupLayout.DEFAULT_SIZE) // combobox 가로 길이
	                                .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))) // button 가로 길이(short범위 내의 최대값)
	                    .addGap(101, 101, 101))); // label,combobox,button의 오른쪽 간격

	        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //원점에 정렬 -> 평행그룹 만들고 반환 *수직 축을 따라 설정
	              .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(89, 89, 89) // label,combobox,button의 위쪽 간격
	                    .addComponent(TextLabel).addGap(28, 28, 28) //textlabel 
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                          .addComponent(jComboBox1, GroupLayout.DEFAULT_SIZE, 130,  GroupLayout.DEFAULT_SIZE) //combobox 세로 길이
	                          .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)) //button 세로 길이
	                    .addGap(94, 94, 94))); // label,combobox,button의 아래쪽 간격

	      pack(); // 컨테이너의 크기를 구성 요소 들의 크기로 설정
	   }
	}