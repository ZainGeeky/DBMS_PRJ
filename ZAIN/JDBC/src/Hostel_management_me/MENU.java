package Hostel_management_me;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MENU extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU frame = new MENU();
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
	public MENU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 29, 650, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("STUDENT RECORD");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Student_Rec f1 = new Student_Rec();
				f1.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(72, 61, 139));
		btnNewButton.setBounds(102, 182, 202, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRoomsRecord = new JButton("ROOMS RECORD");
		btnRoomsRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnRoomsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rooms_Record f1 = new Rooms_Record();
				f1.setVisible(true);
			}
		});
		btnRoomsRecord.setForeground(new Color(72, 61, 139));
		btnRoomsRecord.setBounds(372, 182, 202, 29);
		contentPane.add(btnRoomsRecord);
		
		JButton btnEquipmentRecord = new JButton(" RENT RECORD");
		btnEquipmentRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnEquipmentRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rent_Rec f1 = new Rent_Rec();
				f1.setVisible(true);
			}
		});
		btnEquipmentRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentRecord.setBounds(651, 182, 202, 29);
		contentPane.add(btnEquipmentRecord);
		
		JButton btnRecord = new JButton(" PAYMENT RECORD");
		btnRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Payment_Rec f1 = new Payment_Rec();
				f1.setVisible(true);
			}
		});
		btnRecord.setForeground(new Color(72, 61, 139));
		btnRecord.setBounds(102, 325, 202, 29);
		contentPane.add(btnRecord);
		
		JButton btnEquipmentsRecord = new JButton(" EQUIPMENTS RECORD");
		btnEquipmentsRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnEquipmentsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Equiment_list f1 = new Equiment_list();
				f1.setVisible(true);
			}
		});
		btnEquipmentsRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentsRecord.setBounds(372, 325, 202, 29);
		contentPane.add(btnEquipmentsRecord);
		
		JButton btnHostelRecord = new JButton(" HOSTEL RECORD");
		btnHostelRecord.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnHostelRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hostel_Rec f1 = new Hostel_Rec();
				f1.setVisible(true);
			}
		});
		btnHostelRecord.setForeground(new Color(72, 61, 139));
		btnHostelRecord.setBounds(651, 325, 202, 29);
		contentPane.add(btnHostelRecord);
		
		JButton btnLogut = new JButton("LOGUT");
		btnLogut.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ADMINLOGIN f1 = new ADMINLOGIN();
				f1.setVisible(true);
			}
		});
		btnLogut.setForeground(new Color(255, 0, 0));
		btnLogut.setBackground(UIManager.getColor("Button.background"));
		btnLogut.setBounds(372, 507, 202, 29);
		contentPane.add(btnLogut);
		
		JButton btnStats = new JButton("STATS");
		btnStats.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stats f1=new Stats();
				f1.setVisible(true);
			}
		});
		btnStats.setForeground(new Color(72, 61, 139));
		btnStats.setBounds(372, 467, 202, 29);
		contentPane.add(btnStats);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\Stats.png"));
		lblNewLabel_2.setBounds(425, 365, 98, 91);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\PAY.png"));
		lblNewLabel_2_1.setBounds(149, 222, 98, 91);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\EQIUP.png"));
		lblNewLabel_2_2.setBounds(425, 222, 98, 91);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\Hostel.png"));
		lblNewLabel_2_3.setBounds(702, 222, 98, 91);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("New label");
		lblNewLabel_2_4.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\Student.png"));
		lblNewLabel_2_4.setBounds(159, 80, 98, 91);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("New label");
		lblNewLabel_2_5.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\Room.png"));
		lblNewLabel_2_5.setBounds(425, 80, 98, 91);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("New label");
		lblNewLabel_2_6.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\RENT.png"));
		lblNewLabel_2_6.setBounds(702, 80, 98, 91);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_1.setBounds(43, 29, 860, 527);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_3.setBounds(0, 0, 950, 582);
		contentPane.add(lblNewLabel_3);
	}
}
