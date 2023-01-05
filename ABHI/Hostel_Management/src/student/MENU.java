package student;
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
		setBounds(100, 100, 844, 594);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(76, 0, 650, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("STUDENT RECORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Student_Rec f1 = new Student_Rec();
				f1.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(72, 61, 139));
		btnNewButton.setBounds(285, 126, 230, 43);
		contentPane.add(btnNewButton);
		
		JButton btnRoomsRecord = new JButton("ROOMS RECORD");
		btnRoomsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rooms_Record f1 = new Rooms_Record();
				f1.setVisible(true);
			}
		});
		btnRoomsRecord.setForeground(new Color(72, 61, 139));
		btnRoomsRecord.setBounds(285, 179, 230, 43);
		contentPane.add(btnRoomsRecord);
		
		JButton btnEquipmentRecord = new JButton(" RENT RECORD");
		btnEquipmentRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentRecord.setBounds(285, 232, 230, 43);
		contentPane.add(btnEquipmentRecord);
		
		JButton btnRecord = new JButton(" PAYMENT RECORD");
		btnRecord.setForeground(new Color(72, 61, 139));
		btnRecord.setBounds(285, 285, 230, 43);
		contentPane.add(btnRecord);
		
		JButton btnEquipmentsRecord = new JButton(" EQUIPMENTS RECORD");
		btnEquipmentsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Equiment_list f1 = new Equiment_list();
				f1.setVisible(true);
			}
		});
		btnEquipmentsRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentsRecord.setBounds(285, 338, 230, 43);
		contentPane.add(btnEquipmentsRecord);
		
		JButton btnHostelRecord = new JButton(" HOSTEL RECORD");
		btnHostelRecord.setForeground(new Color(72, 61, 139));
		btnHostelRecord.setBounds(285, 391, 230, 43);
		contentPane.add(btnHostelRecord);
		
		JButton btnLogut = new JButton("LOGUT");
		btnLogut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ADMINLOGIN f1 = new ADMINLOGIN();
				f1.setVisible(true);
			}
		});
		btnLogut.setForeground(new Color(255, 0, 0));
		btnLogut.setBackground(UIManager.getColor("Button.background"));
		btnLogut.setBounds(564, 460, 217, 64);
		contentPane.add(btnLogut);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ABHIJITH_MALLYA\\Desktop\\sahyadri1.jpeg"));
		lblNewLabel_1.setBounds(0, 21, 808, 537);
		contentPane.add(lblNewLabel_1);
	}
}
