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
				//查询员工工资信息，如果有关键字就模糊搜索，反之查询全部
				String keyword = textField.getText(); 
				WagesDAO w = new WagesDAO();
				Vector<Vector<String>> list = w.getAll(keyword);
				
				Vector<String> head =  new Vector<String>();
				head.add("员工编号");
				head.add("基本工资");
				head.add("岗位工资");
				head.add("水电费");
				head.add("津贴费");
				head.add("扣除工资");
				head.add("实发金额");
				
				//3.设置值
				table = new JTable(list,head);
				scrollPane.setViewportView(table);
				
			}
		});
		btnNewButton.setBounds(196, 29, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加信息
				AdminInsertWages frame = new AdminInsertWages();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(314, 29, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改信息
				 int rows = table.getSelectedRow();
	                if(rows == -1) { //没有选中行时得到的是-1
	                    JOptionPane.showMessageDialog(null, "请选择行！");
	                    return;
	                }
	                //根据行和列，获取对应的数字
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
				//删除功能
				int rows = table.getSelectedRow();
				if (rows == -1) {
					JOptionPane.showMessageDialog(null, "请选择行");
					return;
				}
				//根据行和列，获取对应的数字
				String val = (String) table.getValueAt(rows, 0);
				//去WagesDAO中执行删除
				WagesDAO w = new WagesDAO();
				boolean result = w.delete(val);
				if (result) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					updateAll(null);
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			}

		});
		btnNewButton_3.setBounds(533, 29, 93, 23);
		contentPane.add(btnNewButton_3);
//		this.updateAll();
		
		JButton btnNewButton_4 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出系统
				dispose();
			}
		});
		
		btnNewButton_4.setBounds(533, 387, 93, 23);
		contentPane.add(btnNewButton_4);
		
		
		updateAll(null);
		
	}
	
	//表格更新
	public void updateAll(String keyword) {
		//表格

		WagesDAO w = new WagesDAO();
		Vector<Vector<String>> list = w.getAll(null);
		
		//2.设置表头
		Vector<String> head =  new Vector<String>();
		head.add("员工编号");
		head.add("基本工资");
		head.add("岗位工资");
		head.add("水电费");
		head.add("津贴费");
		head.add("扣除工资");
		head.add("实发金额");
		
		//3.设置值
		table = new JTable(list,head);
		scrollPane.setViewportView(table);
		
	}
}
