import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainScreen {

	private JFrame frame;

	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setBounds(100, 100, 512, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnNewOrder = new JButton("Order");
		btnNewOrder.setBackground(Color.BLACK);
		btnNewOrder.setForeground(Color.RED);
		btnNewOrder.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		btnNewOrder.setBounds(113, 57, 310, 62);
		frame.getContentPane().add(btnNewOrder);
		
		JButton btnNewFeedback = new JButton("Feedback");
		btnNewFeedback.setBackground(Color.BLACK);
		btnNewFeedback.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		btnNewFeedback.setForeground(Color.RED);
		btnNewFeedback.setBounds(113, 178, 310, 62);
		frame.getContentPane().add(btnNewFeedback);
		
		
		btnNewOrder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				frame.setVisible(false);
				new Order();
				
			}
		});
		
		
	}

}
