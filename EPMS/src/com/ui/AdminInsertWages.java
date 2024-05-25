package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.WagesDAO;
import com.entity.Wages;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminInsertWages extends JFrame {

	private JPanel contentPane;
	private JTextField code;
	private JTextField baseWages;
	private JTextField postWages;
	private JTextField money;
	private JTextField subsidy;
	private JTextField deduction;
	private JTextField fact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInsertWages frame = new AdminInsertWages();
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
	public AdminInsertWages() {
		setTitle("\u6DFB\u52A0\u5458\u5DE5\u5DE5\u8D44\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(28, 27, 90, 27);
		contentPane.add(lblNewLabel);
		
		JLabel 基本工资 = new JLabel("\u57FA\u672C\u5DE5\u8D44\uFF1A");
		基本工资.setBounds(28, 64, 90, 27);
		contentPane.add(基本工资);
		
		JLabel 岗位工资 = new JLabel("\u5C97\u4F4D\u5DE5\u8D44\uFF1A");
		岗位工资.setBounds(28, 109, 90, 27);
		contentPane.add(岗位工资);
		
		JLabel lblNewLabel_3 = new JLabel("\u6C34\u7535\u8D39\uFF1A");
		lblNewLabel_3.setBounds(28, 154, 90, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6D25\u8D34\u5DE5\u8D44\uFF1A");
		lblNewLabel_4.setBounds(28, 197, 90, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6263\u9664\u85AA\u916C\uFF1A");
		lblNewLabel_5.setBounds(28, 244, 90, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5B9E\u53D1\u5DE5\u8D44\uFF1A");
		lblNewLabel_6.setBounds(28, 288, 90, 27);
		contentPane.add(lblNewLabel_6);
		
		code = new JTextField();
		code.setBounds(107, 30, 108, 21);
		contentPane.add(code);
		code.setColumns(10);
		
		baseWages = new JTextField();
		baseWages.setColumns(10);
		baseWages.setBounds(107, 67, 108, 21);
		contentPane.add(baseWages);
		
		postWages = new JTextField();
		postWages.setColumns(10);
		postWages.setBounds(107, 112, 108, 21);
		contentPane.add(postWages);
		
		money = new JTextField();
		money.setColumns(10);
		money.setBounds(107, 157, 108, 21);
		contentPane.add(money);
		
		subsidy = new JTextField();
		subsidy.setColumns(10);
		subsidy.setBounds(107, 200, 108, 21);
		contentPane.add(subsidy);
		
		deduction = new JTextField();
		deduction.setColumns(10);
		deduction.setBounds(107, 247, 108, 21);
		contentPane.add(deduction);
		
		fact = new JTextField();
		fact.setColumns(10);
		fact.setBounds(107, 291, 108, 21);
		contentPane.add(fact);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加信息
				Wages wages = new Wages();
//				WagesDAO w = new WagesDAO();
				//因为不能int直接转string所以要转换类型
				String codes = code.getText();
				int code = Integer.valueOf(codes);
				wages.setCode(code);
				
				String baseWagess = baseWages.getText();
				int baseWages = Integer.valueOf(baseWagess);
				wages.setBaseWages(baseWages);
				
				String postWagess = postWages.getText();
				int postWages = Integer.valueOf(postWagess);
				wages.setPostWages(postWages);
				
				String moneys = money.getText();
				double money = Double.valueOf(moneys);
				wages.setMoney(money);
				
				String subsidys = subsidy.getText();
				int subsidy = Integer.valueOf(subsidys);
				wages.setSubsidy(subsidy);
				
				String deductions = deduction.getText();
				int deduction = Integer.valueOf(deductions);
				wages.setDeduction(deduction);
				
				String facts = fact.getText();
				double fact = Double.valueOf(facts);
				wages.setFact(fact);
				
				//执行添加
				WagesDAO w = new WagesDAO();
				if(w.add(wages)){
                    JOptionPane.showMessageDialog(null, "添加成功！");
                    
                }else {
                    JOptionPane.showMessageDialog(null, "添加失败！");
                }
			}
		});
		btnNewButton.setBounds(25, 346, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出
				dispose();
			}
		});
		btnNewButton_1.setBounds(160, 346, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
