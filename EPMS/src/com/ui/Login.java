package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.AccountDAO;
import com.entity.Account;
import com.entity.UserType;
import com.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JComboBox userTypeComboBox;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 51, 70, 25);
		contentPane.add(lblNewLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(85, 53, 150, 24);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(26, 104, 70, 25);
		contentPane.add(lblNewLabel_1);
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.EMPLOYEE}));
		userTypeComboBox.setBounds(122, 157, 113, 23);
		contentPane.add(userTypeComboBox);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//登录按钮绑定事件
				loginAct(ae);
			}
		});
		loginButton.setBounds(26, 198, 93, 23);
		contentPane.add(loginButton);
		
		JButton disposeButton = new JButton("\u9000\u51FA");
		disposeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出
				dispose();
			}
		});
		disposeButton.setBounds(214, 238, 93, 23);
		contentPane.add(disposeButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u5DE5\u8D44\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(61, 10, 206, 31);
		contentPane.add(lblNewLabel_2);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.setBounds(161, 198, 93, 23);
		contentPane.add(registerButton);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(85, 107, 150, 24);
		contentPane.add(passwordField);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//判断用户名是否为空
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		//判断密码是否为空
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		
		if ("系统管理员".equals(selectedItem.getName())) {
			//系统管理员登录
			AccountDAO accountDAO = new AccountDAO();
			Account accountTmp = new Account();
			accountTmp.setZhanghao(userName);
			accountTmp.setPassword(password);
			Account account = accountDAO.login(accountTmp);
			if (account == null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			} else {
				JOptionPane.showMessageDialog(this, "登录成功！");
				AdminSystem frame = new AdminSystem();
				frame.setVisible(true);
				dispose();
			}
		} else {
			//员工登录
		}
	}
}
