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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 51, 70, 25);
		contentPane.add(lblNewLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(85, 53, 150, 24);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(26, 104, 70, 25);
		contentPane.add(lblNewLabel_1);
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.EMPLOYEE}));
		userTypeComboBox.setBounds(122, 157, 113, 23);
		contentPane.add(userTypeComboBox);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//��¼��ť���¼�
				loginAct(ae);
			}
		});
		loginButton.setBounds(26, 198, 93, 23);
		contentPane.add(loginButton);
		
		JButton disposeButton = new JButton("\u9000\u51FA");
		disposeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�˳�
				dispose();
			}
		});
		disposeButton.setBounds(214, 238, 93, 23);
		contentPane.add(disposeButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u5DE5\u8D44\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 24));
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
		//�ж��û����Ƿ�Ϊ��
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ�");
			return;
		}
		//�ж������Ƿ�Ϊ��
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "���벻��Ϊ�գ�");
			return;
		}
		
		if ("ϵͳ����Ա".equals(selectedItem.getName())) {
			//ϵͳ����Ա��¼
			AccountDAO accountDAO = new AccountDAO();
			Account accountTmp = new Account();
			accountTmp.setZhanghao(userName);
			accountTmp.setPassword(password);
			Account account = accountDAO.login(accountTmp);
			if (account == null) {
				JOptionPane.showMessageDialog(this, "�û������������");
				return;
			} else {
				JOptionPane.showMessageDialog(this, "��¼�ɹ���");
				AdminSystem frame = new AdminSystem();
				frame.setVisible(true);
				dispose();
			}
		} else {
			//Ա����¼
		}
	}
}
