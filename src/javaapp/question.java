package javaapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.*;

public class question extends JFrame {
	JCheckBox jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4; // 질문 4개
	JButton jButton1; // 확인 버튼
	JOptionPane jOptionPane1; // 메세지창

	public question() {
		setTitle("Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);
		jCheckBox1 = new JCheckBox("반려동물을 맞이할 환경적 준비, 마음의 각오는 되어 있습니까?", false);
		jCheckBox2 = new JCheckBox("모든 가족과의 합의는 되어 있습니까?", false);
		jCheckBox3 = new JCheckBox("결혼,임신,유학,이사 등으로 가정환경이 바뀌어도 끝까지 책임지고 보살피겠다는 결심이 섰습니까?", false);
		jCheckBox4 = new JCheckBox("입양으로 인한 경제적 부담을 짊어질 의사와 능력이 있습니까?", false);
		add(jCheckBox1);
		add(jCheckBox2);
		add(jCheckBox3);
		add(jCheckBox4);
		JButton jButton1 = new JButton("확인");
		add(jButton1);
		setSize(700, 400);
		setVisible(true);
		jCheckBox1.setBounds(70, 100, 600, 20);
		jCheckBox2.setBounds(70, 140, 600, 20);
		jCheckBox3.setBounds(70, 180, 600, 20);
		jCheckBox4.setBounds(70, 220, 600, 20);
		jButton1.setBounds(300, 260, 70, 30);

		jButton1.setBackground(new Color(255, 255, 255));
		jCheckBox1.setBackground(new Color(255, 224, 167));
		jCheckBox2.setBackground(new Color(255, 224, 167));
		jCheckBox3.setBackground(new Color(255, 224, 167));
		jCheckBox4.setBackground(new Color(255, 224, 167));

		Container contentPane = getContentPane();
		contentPane.setBackground(new Color(255, 224, 167));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (jCheckBox1.isSelected() && jCheckBox2.isSelected() && jCheckBox3.isSelected()
						&& jCheckBox4.isSelected()) { // 모든 질문이 체크되면
					setVisible(false);
					new start(); // start페이지로 이동
				} else { // 아닌 경우 메세지창 생성
					jOptionPane1 = new JOptionPane();
					JOptionPane.showMessageDialog(null, "모든 질문에 체크해주세요");
				}
			}
		});
	}
}