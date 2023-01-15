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
		setBounds(100, 100, 643, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATS MENU");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 19, 631, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("HOSTEL STATS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hostel_Stats f1 = new Hostel_Stats();
				f1.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(72, 61, 139));
		btnNewButton.setBounds(206, 83, 202, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRoomsRecord = new JButton("FIND ROOMMATES");
		btnRoomsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Find_Rmates f1 = new Find_Rmates();
				f1.setVisible(true);
			}
		});
		btnRoomsRecord.setForeground(new Color(72, 61, 139));
		btnRoomsRecord.setBounds(206, 153, 202, 29);
		contentPane.add(btnRoomsRecord);
		
		JButton btnEquipmentRecord = new JButton(" EQUIPMENT STATS");
		btnEquipmentRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Equipment_Stats f1 = new Equipment_Stats();
				f1.setVisible(true);
			}
		});
		btnEquipmentRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentRecord.setBounds(206, 216, 202, 29);
		contentPane.add(btnEquipmentRecord);
		
		JButton btnRecord = new JButton(" PAYMENT STATS");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Payment_Stats f1 = new Payment_Stats();
				f1.setVisible(true);
			}
		});
		btnRecord.setForeground(new Color(72, 61, 139));
		btnRecord.setBounds(206, 276, 202, 29);
		contentPane.add(btnRecord);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MENU f1=new MENU();
				f1.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(72, 61, 139));
		btnBack.setBounds(10, 11, 107, 30);
		contentPane.add(btnBack);
	}
}
