package jdfke;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ZoneAffect {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ouvreZone(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZoneAffect window = new ZoneAffect();
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
	public ZoneAffect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("affectation des combattants");
		lblNewLabel.setForeground(new Color(136, 189, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(164, 23, 252, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("halle");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(103, 78, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BDE");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(103, 122, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("biblio");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(103, 184, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("quartier ad");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(103, 241, 74, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("halles");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(103, 288, 54, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("0");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(265, 101, 54, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("0");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(265, 135, 54, 15);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("0");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(265, 169, 54, 15);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("0");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(265, 203, 54, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("0");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(265, 241, 54, 15);
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton btnNewButton_1 = new JButton("+/-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlusHalle.OpenPlusHalle(null);
			}
		});
		btnNewButton_1.setBounds(350, 97, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("+/-");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlusHalle.OpenPlusHalle(null);
			}
		});
		btnNewButton_3.setBounds(350, 131, 93, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("+/-");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlusHalle.OpenPlusHalle(null);
			}
		});
		btnNewButton_5.setBounds(350, 165, 93, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("+/-");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlusHalle.OpenPlusHalle(null);
			}
		});
		btnNewButton_7.setBounds(350, 199, 93, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_9 = new JButton("+/-");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlusHalle.OpenPlusHalle(null);
			}
		});
		btnNewButton_9.setBounds(350, 233, 93, 23);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("mêlée");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane(); 
				int option = jop.showConfirmDialog(null, "Are you sure to start the melee ?", 
				"<Titre>", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION)Melee.main(null);
				
			}
		});
		btnNewButton_10.setBounds(484, 354, 93, 23);
		frame.getContentPane().add(btnNewButton_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(ZoneAffect.class.getResource("/imgs/uttflougrand.png")));
		lblNewLabel_11.setBounds(0, -1, 587, 406);
		frame.getContentPane().add(lblNewLabel_11);
	}
}