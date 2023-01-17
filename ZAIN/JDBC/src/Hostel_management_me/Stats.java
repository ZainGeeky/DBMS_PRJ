package Hostel_management_me;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Stats extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stats frame = new Stats();
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
	public Stats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("HOSTEL STATS");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hostel_Stats f1 = new Hostel_Stats();
				f1.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(72, 61, 139));
		btnNewButton.setBounds(265, 107, 202, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRoomsRecord = new JButton("FIND ROOMMATES");
		btnRoomsRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnRoomsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Find_Rmates f1 = new Find_Rmates();
				f1.setVisible(true);
			}
		});
		btnRoomsRecord.setForeground(new Color(72, 61, 139));
		btnRoomsRecord.setBounds(265, 177, 202, 29);
		contentPane.add(btnRoomsRecord);
		
		JButton btnEquipmentRecord = new JButton(" EQUIPMENT STATS");
		btnEquipmentRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnEquipmentRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Equipment_Stats f1 = new Equipment_Stats();
				f1.setVisible(true);
			}
		});
		btnEquipmentRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentRecord.setBounds(265, 240, 202, 29);
		contentPane.add(btnEquipmentRecord);
		
		JButton btnRecord = new JButton(" PAYMENT STATS");
		btnRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Payment_Stats f1 = new Payment_Stats();
				f1.setVisible(true);
			}
		});
		btnRecord.setForeground(new Color(72, 61, 139));
		btnRecord.setBounds(265, 300, 202, 29);
		contentPane.add(btnRecord);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MENU f1=new MENU();
				f1.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(72, 61, 139));
		btnBack.setBounds(69, 35, 107, 30);
		contentPane.add(btnBack);
		
		JLabel lblStatsMenu = new JLabel("Stats Menu");
		lblStatsMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatsMenu.setForeground(new Color(128, 0, 128));
		lblStatsMenu.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblStatsMenu.setBounds(187, 46, 375, 40);
		contentPane.add(lblStatsMenu);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel.setBounds(42, 23, 667, 412);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_1.setBounds(0, 0, 748, 457);
		contentPane.add(lblNewLabel_1);
	}
}
