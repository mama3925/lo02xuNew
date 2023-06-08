package jdfke;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MoiTreve {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoiTreve window = new MoiTreve();
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
	public MoiTreve() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("to add or delete student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlusHalle.OpenPlusHalle(null);
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("the information of the allier in this zone is showed above");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}