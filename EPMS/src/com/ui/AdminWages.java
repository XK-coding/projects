package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import com.dao.WagesDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AdminWages extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWages frame = new AdminWages();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminWages() {
		setResizable(false);
		setTitle("\u5458\u5DE5\u5DE5\u8D44\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		scrollPane.setBounds(10, 73, 616, 254);
		contentPane.add(scrollPane);
		
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 33, 67, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 30, 78, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ѯԱ��������Ϣ������йؼ��־�ģ����������֮��ѯȫ��
				String keyword = textField.getText(); 
				WagesDAO w = new WagesDAO();
				Vector<Vector<String>> list = w.getAll(keyword);
				
				Vector<String> head =  new Vector<String>();
				head.add("Ա�����");
				head.add("��������");
				head.add("��λ����");
				head.add("ˮ���");
				head.add("������");
				head.add("�۳�����");
				head.add("ʵ�����");
				
				//3.����ֵ
				table = new JTable(list,head);
				scrollPane.setViewportView(table);
				
			}
		});
		btnNewButton.setBounds(196, 29, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�����Ϣ
				AdminInsertWages frame = new AdminInsertWages();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(314, 29, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�޸���Ϣ
				 int rows = table.getSelectedRow();
	                if(rows == -1) { //û��ѡ����ʱ�õ�����-1
	                    JOptionPane.showMessageDialog(null, "��ѡ���У�");
	                    return;
	                }
	                //�����к��У���ȡ��Ӧ������
	                int val = Integer.valueOf((String)table.getValueAt(rows, 0));
	                System.out.println(table.getValueAt(rows, 0));
	                AdminUpdateWages frame = new AdminUpdateWages(val);
					frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(423, 29, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ɾ������
				int rows = table.getSelectedRow();
				if (rows == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ����");
					return;
				}
				//�����к��У���ȡ��Ӧ������
				String val = (String) table.getValueAt(rows, 0);
				//ȥWagesDAO��ִ��ɾ��
				WagesDAO w = new WagesDAO();
				boolean result = w.delete(val);
				if (result) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					updateAll(null);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			}

		});
		btnNewButton_3.setBounds(533, 29, 93, 23);
		contentPane.add(btnNewButton_3);
//		this.updateAll();
		
		JButton btnNewButton_4 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�˳�ϵͳ
				dispose();
			}
		});
		
		btnNewButton_4.setBounds(533, 387, 93, 23);
		contentPane.add(btnNewButton_4);
		
		
		updateAll(null);
		
	}
	
	//������
	public void updateAll(String keyword) {
		//���

		WagesDAO w = new WagesDAO();
		Vector<Vector<String>> list = w.getAll(null);
		
		//2.���ñ�ͷ
		Vector<String> head =  new Vector<String>();
		head.add("Ա�����");
		head.add("��������");
		head.add("��λ����");
		head.add("ˮ���");
		head.add("������");
		head.add("�۳�����");
		head.add("ʵ�����");
		
		//3.����ֵ
		table = new JTable(list,head);
		scrollPane.setViewportView(table);
		
	}
}
