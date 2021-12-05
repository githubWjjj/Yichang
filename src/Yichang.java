//�û��Զ����쳣����������֤
//����jackey���޸�
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Yichang {
	
	//�Զ����쳣
	class PasswordException extends Exception{
		public PasswordException(String s) {
			super(s);
		}
	}
	//�û���
	class User{
		String username;
		String password;
		public void setUsername(String s) {
			username=s;
		}
		public String getUsername(){
			return username;
		}
		public void setPassword(String s) {
			password=s;
		}
		public String getPassword() {
			return password;
		}
		//���巽��check����֤�����Ƿ�Ϸ�
		public String check(String s) throws PasswordException{
			String result=null;
			int length=s.length();
			int num;
			char c;
			try {
				if(length<4||length>6) {//�ж��Ƿ���4-6֮��,��׽�����쳣
					PasswordException e=new PasswordException("���볤��Ӧ����4��6��֮�䣡");
					throw e;
				}
				num=Integer.parseInt(s);//��׽NumberFormatException�쳣
				result="���óɹ���";
			}catch(NumberFormatException e) {
				result="����ֻ�ܰ������֣�";
				e.printStackTrace();
			}
			return result;
		}
	}
	


	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yichang window = new Yichang();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Yichang() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u5BC6\u7801\u7684\u5408\u6CD5\u5316\u9A8C\u8BC1");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8BBE\u7F6E\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel.setBounds(20, 79, 161, 61);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(184, 92, 229, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u9A8C\u8BC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//����Ϸ�����֤�����쳣����
				User user=new User();
				String name=textField_2.getText();
				user.setUsername(name);
				String s=textField.getText();
				user.setPassword(s);
				String result=null;
				try {
					result=user.check(s);
				} catch (Yichang.PasswordException e1) {
					result=e1.toString();
					e1.printStackTrace();
				}
				textField_1.setText(result);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 22));
		btnNewButton.setBounds(121, 136, 118, 46);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 192, 214, 46);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u9A8C\u8BC1\u7ED3\u679C");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(37, 207, 99, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(20, 32, 134, 54);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 42, 229, 40);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
