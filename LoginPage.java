
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPage {

	public static void main(String s[]) {

		JFrame frame = new JFrame("JFrame Example");
		
		
		JPanel panel = new JPanel();
		
		  panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    //    panel.setBorder(new EmptyBorder(new Insets(5,6,5, 5)));

	        
		panel.setBackground(Color.black	);
	
		JLabel l = new JLabel("<html> <font color='white' size='45'>Log In Now</font></html>", SwingConstants.CENTER);
		
		  panel.add(l);
		
			panel.add(Box.createRigidArea(new Dimension(0, 50)));
			
		final JTextField tf=new JTextField(20);
		
		tf.setMaximumSize( tf.getPreferredSize() );
		
      
		
		
		JButton button = new JButton();
		button.setText("Press me");
		

		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(tf.getText());
				
			}
		});
		
		
		
		panel.add(tf);
		
		panel.add(Box.createRigidArea(new Dimension(0, 50)));
		
		JLabel pw = new JLabel("<html> <font color='white' size='10'>pass</font></html>", SwingConstants.CENTER);
		
		final JTextField pwfield=new JTextField(20);
		
		pwfield.setMaximumSize( pwfield.getPreferredSize() );
		
		
		 panel.add(pw);
		panel.add(pwfield);
		 
		panel.add(button);
		
		
		frame.add(panel);
		frame.setSize(900, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}