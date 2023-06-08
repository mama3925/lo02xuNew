package jdfke;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EG23 {

	private JFrame frmCe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EG23 window = new EG23();
					window.frmCe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EG23() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCe = new JFrame();
		frmCe.setTitle("CestDuBrutal");
		frmCe.setBounds(100, 100, 602, 426);
		frmCe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCe.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Démarrer une partie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Affect1.ouvreGestionText(null);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		
		btnNewButton.setBounds(184, 203, 214, 47);
		frmCe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("La bataille des programmes");
		lblNewLabel.setForeground(new Color(128, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
		lblNewLabel.setBounds(67, 78, 450, 89);
		frmCe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		lblNewLabel_1.setBounds(0, 0, 587, 379);

		frmCe.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(EG23.class.getResource("/imgs/uttflougrand.png")));
		JMenuBar menuBar = new JMenuBar();
		frmCe.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("fichier");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ouvrir de fichier");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("enregistrer ");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("configurer");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("aide");
		menuBar.add(mnNewMenu_2);
	}
}