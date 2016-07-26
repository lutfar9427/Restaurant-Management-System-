import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;


public class Registeration {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	int cdsa;
	

	/**
	 * Create the application.
	 */
	public Registeration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		frame = new JFrame();
		
		
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 21));
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblEasyRegisteration = new JLabel("Easy Registeration");
		lblEasyRegisteration.setForeground(Color.MAGENTA);
		lblEasyRegisteration.setFont(new Font("Snap ITC", Font.PLAIN, 22));
		lblEasyRegisteration.setBounds(101, 22, 276, 48);
		frame.getContentPane().add(lblEasyRegisteration);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.MAGENTA);
		lblEmail.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblEmail.setBounds(10, 104, 71, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.MAGENTA);
		lblPassword.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblPassword.setBounds(10, 151, 105, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(78, 104, 299, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 151, 258, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		btnDone.setForeground(Color.MAGENTA);
		btnDone.setBackground(Color.BLACK);
		btnDone.setBounds(104, 201, 200, 50);
		frame.getContentPane().add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					DoneClicked(textField.getText(),new String(passwordField.getPassword()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

		});
		
		
	}
	

	
	
	private void DoneClicked(String email, String password) throws Exception {
		
		  if(email.length()==0||password.length()==0){			  
			  JOptionPane.showMessageDialog(null,"Enter a Valid email and password?");
			  return;			  
		  }
		  
		  else{
			  
			boolean found=  checkDatabaseExistance(email,password,false);
			  
			if(found){
				
				
				JOptionPane.showMessageDialog(null,"This email registered before");				
		
			}
			else{
				JOptionPane.showMessageDialog(null,"Registeration Done");
			
				writeToDataBase(email,password);
				
			}
			
		  }		  
		
	}
	
	
	private void writeToDataBase(String email, String password) throws Exception {
		 MySQLAccess dao = new MySQLAccess();
		    
		dao.writeToDataBase(email,password);
		
		
	}

	private boolean checkDatabaseExistance(String email, String pw,boolean checkPw) throws Exception {

		
		 MySQLAccess dao = new MySQLAccess();
		    
		return dao.readDataBase(email,pw,checkPw);
		  		
	}
	
	
	
	
}
