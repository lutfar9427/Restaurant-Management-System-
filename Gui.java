import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;


public class Gui {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblWaleedsRestaurant;
	private JButton btnRegisterButton;
	private JButton btnGo;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
				
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	//frame.setLocationRelativeTo(null);
	
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogInNow = new JLabel("Log in Now");
		lblLogInNow.setForeground(Color.MAGENTA);
		lblLogInNow.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblLogInNow.setBounds(126, 54, 158, 34);
		frame.getContentPane().add(lblLogInNow);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.MAGENTA);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(37, 99, 53, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.MAGENTA);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(25, 153, 80, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(90, 99, 261, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblWaleedsRestaurant = new JLabel("Welcome to Waleed's Restaurant");
		lblWaleedsRestaurant.setForeground(Color.MAGENTA);
		lblWaleedsRestaurant.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblWaleedsRestaurant.setBounds(25, 0, 384, 50);
		frame.getContentPane().add(lblWaleedsRestaurant);
		
		btnRegisterButton = new JButton("Register Now");
		btnRegisterButton.setBackground(Color.BLACK);
		btnRegisterButton.setForeground(Color.MAGENTA);
		btnRegisterButton.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		btnRegisterButton.setBounds(10, 201, 200, 50);
		frame.getContentPane().add(btnRegisterButton);
		
		btnGo = new JButton("Go");
		btnGo.setBackground(Color.BLACK);
		btnGo.setForeground(Color.MAGENTA);
		btnGo.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		btnGo.setBounds(220, 201, 158, 53);
		frame.getContentPane().add(btnGo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 153, 243, 20);
		frame.getContentPane().add(passwordField);
		
		btnGo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				try {
					GoClicked(textField.getText(),new String(passwordField.getPassword()));
				
				} catch (Exception e) {
					e.printStackTrace();
				}
						
			}
		});
		
		
		btnRegisterButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
                
				frame.setVisible(false);
				new Registeration();
				
			}
		});
		
		
		
		
		
	}

	
	
	
	private void GoClicked(String email, String pw) throws Exception {
 
		
		  if(email.length()==0||pw.length()==0){			  
			  JOptionPane.showMessageDialog(null,"Enter Valid email and password");
			  return;			  
		  }
		  
		  else{
			  
			boolean found=  checkDatabaseExistance(email,pw);
			  
			if(found){
				JOptionPane.showMessageDialog(null,"Welcome :D");		
				
				frame.setVisible(false);
				new MainScreen();
				
				
			}
			else{
				JOptionPane.showMessageDialog(null,"Wrong email or password please register");
				
			}
			
		  }		  
		  
		
	}

	
	
	private boolean checkDatabaseExistance(String email, String pw) throws Exception {

		
		 MySQLAccess dao = new MySQLAccess();
		    
		return dao.readDataBase(email,pw,true);
		  		
	}
}
