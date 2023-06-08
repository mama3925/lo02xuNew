package jdfke;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class AdversCas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdversCas window = new AdversCas();
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
	public AdversCas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("The killed and the information in this zone is above");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}