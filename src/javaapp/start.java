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
		jComboBox1 = new JComboBox<>(); // �޺��ڽ�
		TextLabel = new JLabel("����� ��ȣ"); // ����� ��ȣ �۾�

		ImageIcon icon = new ImageIcon("img.png"); // ������ �̹���
		Image himg = icon.getImage();
		Image hchangeImg = himg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		jButton1 = new JButton(new ImageIcon(hchangeImg)); // �̹��� ��ư�� ����

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
		jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "��â��", "�����", 
				"������", "������", "���ֱ�", "�ξȱ�", "��â��",
				"���ֱ�", "�ͻ��", "�����", "���ֽ�", "������", "���ȱ�" }));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String pick = jComboBox1.getSelectedItem().toString(); // �޺��ڽ����� ���õ� string ����
				System.out.println(pick);
				MyQuery mq = new MyQuery();
				JTableWithImage im = new JTableWithImage();
				switch (pick) { // ���õ� string�� "~"�� ��� ���������� ����
				case "��â��":
					try {
						setVisible(false); // start �κ� ȭ�� ������
						im.initComponents();
						ArrayList<Product2> s = mq.BindTable("gochang"); //gochang ���̺� ������ �ҷ�����
						im.populateJTable(s); // ���̺� ����
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "�����":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("gunsan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "������":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("gimje"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "������":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("namwon"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "���ֱ�":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("mooju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "�ξȱ�":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("buan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "��â��":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("sunchang"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "���ֱ�":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("wanju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "�ͻ��":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("iksan"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "�����":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("jangsoo"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "���ֽ�":
					try {
						setVisible(false);
						im.initComponents();
						im.populateJTable(mq.BindTable("jeonju"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "������":
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

		TextLabel.setFont(new Font("�޸յձ�������", 0, 30));
		TextLabel.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout layout = new GroupLayout(getContentPane()); //layout ����

	      getContentPane().setLayout(layout); //contentpane ��ü layout ��ȯ
	      
	      layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //������ ���� -> ����׷� ����� ��ȯ *���� ���� ���� ����
	              .addGroup(layout.createSequentialGroup().addGap(91, 91, 91) // �׷����� ������ label,combobox,button�� ���� ������ ����
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //textlabel,(combobox, button) �׷�
	                          .addComponent(TextLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
	                          .addGroup(layout.createSequentialGroup() //combobox, button �׷�
	                                .addComponent(jComboBox1, GroupLayout.DEFAULT_SIZE, 130, GroupLayout.DEFAULT_SIZE) // combobox ���� ����
	                                .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))) // button ���� ����(short���� ���� �ִ밪)
	                    .addGap(101, 101, 101))); // label,combobox,button�� ������ ����

	        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //������ ���� -> ����׷� ����� ��ȯ *���� ���� ���� ����
	              .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(89, 89, 89) // label,combobox,button�� ���� ����
	                    .addComponent(TextLabel).addGap(28, 28, 28) //textlabel 
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                          .addComponent(jComboBox1, GroupLayout.DEFAULT_SIZE, 130,  GroupLayout.DEFAULT_SIZE) //combobox ���� ����
	                          .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)) //button ���� ����
	                    .addGap(94, 94, 94))); // label,combobox,button�� �Ʒ��� ����

	      pack(); // �����̳��� ũ�⸦ ���� ��� ���� ũ��� ����
	   }
	}