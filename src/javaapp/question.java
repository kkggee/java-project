package javaapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.*;

public class question extends JFrame {
	JCheckBox jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4; // ���� 4��
	JButton jButton1; // Ȯ�� ��ư
	JOptionPane jOptionPane1; // �޼���â

	public question() {
		setTitle("Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);
		jCheckBox1 = new JCheckBox("�ݷ������� ������ ȯ���� �غ�, ������ ������ �Ǿ� �ֽ��ϱ�?", false);
		jCheckBox2 = new JCheckBox("��� �������� ���Ǵ� �Ǿ� �ֽ��ϱ�?", false);
		jCheckBox3 = new JCheckBox("��ȥ,�ӽ�,����,�̻� ������ ����ȯ���� �ٲ� ������ å������ �����ǰڴٴ� ����� �����ϱ�?", false);
		jCheckBox4 = new JCheckBox("�Ծ����� ���� ������ �δ��� ������ �ǻ�� �ɷ��� �ֽ��ϱ�?", false);
		add(jCheckBox1);
		add(jCheckBox2);
		add(jCheckBox3);
		add(jCheckBox4);
		JButton jButton1 = new JButton("Ȯ��");
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
						&& jCheckBox4.isSelected()) { // ��� ������ üũ�Ǹ�
					setVisible(false);
					new start(); // start�������� �̵�
				} else { // �ƴ� ��� �޼���â ����
					jOptionPane1 = new JOptionPane();
					JOptionPane.showMessageDialog(null, "��� ������ üũ���ּ���");
				}
			}
		});
	}
}