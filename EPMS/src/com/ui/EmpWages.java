package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.WagesDAO;
import com.entity.Wages;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpWages extends JFrame {

	private JPanel contentPane;
	private JTextField empcode;
	private JTextField empfact;
	private JTextField empdeduction;
	private JTextField empsubsidy;
	private JTextField empmoney;
	private JTextField emppostWages;
	private JTextField empbaseWages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int id = 0;
					WagesDAO w = new WagesDAO();
					w.query(id);
					EmpWages frame = new EmpWages(id);
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
	public EmpWages(int id) {
		//查询信息回来
		WagesDAO w = new WagesDAO();
		Wages wages = w.query(id);
		
		setResizable(false);
		setTitle("\u5DE5\u8D44\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 10, 73, 24);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//员工查询信息
				//修改信息
				String keyword = empcode.getText(); 
				WagesDAO w = new WagesDAO();
				w.getAll(keyword);
				Wages wages = new Wages();
				wages.setCode(id); //修改时需要获得该修改人的ID

				//因为不能int直接转string所以要转换类型
				String codes = empcode.getText();
				int code = Integer.valueOf(codes);
				wages.setCode(code);
				
				String baseWagess = empbaseWages.getText();
				int baseWages = Integer.valueOf(baseWagess);
				wages.setBaseWages(baseWages);
				
				String postWagess = emppostWages.getText();
				int postWages = Integer.valueOf(postWagess);
				wages.setPostWages(postWages);
				
				String moneys = empmoney.getText();
				double money = Double.valueOf(moneys);
				wages.setMoney(money);
				
				String subsidys = empsubsidy.getText();
				int subsidy = Integer.valueOf(subsidys);
				wages.setSubsidy(subsidy);
				
				String deductions = empdeduction.getText();
				int deduction = Integer.valueOf(deductions);
				wages.setDeduction(deduction);
				
				String facts = empfact.getText();
				double fact = Double.valueOf(facts);
				wages.setFact(fact);
			}
		});
		btnNewButton.setBounds(10, 271, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u57FA\u672C\u5DE5\u8D44\uFF1A");
		lblNewLabel_1.setBounds(10, 54, 73, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5C97\u4F4D\u5DE5\u8D44\uFF1A");
		lblNewLabel_1_1.setBounds(10, 89, 73, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u6C34\u7535\u8D39\uFF1A");
		lblNewLabel_1_1_1.setBounds(10, 122, 73, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u6D25\u8D34\uFF1A");
		lblNewLabel_1_1_2.setBounds(10, 158, 73, 15);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("\u6263\u9664\u5DE5\u8D44\uFF1A");
		lblNewLabel_1_1_3.setBounds(10, 196, 73, 15);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("\u672C\u6708\u5B9E\u53D1\u5DE5\u8D44\uFF1A");
		lblNewLabel_1_1_4.setBounds(10, 233, 93, 15);
		contentPane.add(lblNewLabel_1_1_4);
		
		//类型转换
		String empcodes = String.valueOf(wages.getCode());
		empcode = new JTextField(empcodes);
		empcode.setBounds(104, 12, 122, 21);
		contentPane.add(empcode);
		empcode.setColumns(10);
		
		String empfacts = String.valueOf(wages.getCode());
		empfact = new JTextField(empfacts);
		empfact.setBounds(104, 230, 122, 21);
		contentPane.add(empfact);
		empfact.setColumns(10);
		
		String empdeductions = String.valueOf(wages.getCode());
		empdeduction = new JTextField(empdeductions);
		empdeduction.setColumns(10);
		empdeduction.setBounds(104, 193, 122, 21);
		contentPane.add(empdeduction);
		
		String empsubsidys = String.valueOf(wages.getCode());
		empsubsidy = new JTextField(empsubsidys);
		empsubsidy.setColumns(10);
		empsubsidy.setBounds(104, 155, 122, 21);
		contentPane.add(empsubsidy);
		
		String empmoneys = String.valueOf(wages.getCode());
		empmoney = new JTextField(empmoneys);
		empmoney.setColumns(10);
		empmoney.setBounds(104, 119, 122, 21);
		contentPane.add(empmoney);
		
		String emppostWagess = String.valueOf(wages.getCode());
		emppostWages = new JTextField(emppostWagess);
		emppostWages.setColumns(10);
		emppostWages.setBounds(104, 86, 122, 21);
		contentPane.add(emppostWages);
		
		String empbaseWagess = String.valueOf(wages.getCode());
		empbaseWages = new JTextField(empbaseWagess);
		empbaseWages.setColumns(10);
		empbaseWages.setBounds(104, 51, 122, 21);
		contentPane.add(empbaseWages);
		
		JButton btnNewButton_1 = new JButton("\u6253\u5370");
		btnNewButton_1.setBounds(133, 271, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}
