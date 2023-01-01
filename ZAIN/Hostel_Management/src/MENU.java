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
		setBounds(100, 100, 650, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 19, 650, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("STUDENT RECORD");
		btnNewButton.setForeground(new Color(72, 61, 139));
		btnNewButton.setBounds(225, 58, 202, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRoomsRecord = new JButton("ROOMS RECORD");
		btnRoomsRecord.setForeground(new Color(72, 61, 139));
		btnRoomsRecord.setBounds(225, 99, 202, 29);
		contentPane.add(btnRoomsRecord);
		
		JButton btnEquipmentRecord = new JButton(" RENT RECORD");
		btnEquipmentRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentRecord.setBounds(225, 140, 202, 29);
		contentPane.add(btnEquipmentRecord);
		
		JButton btnRecord = new JButton(" PAYMENT RECORD");
		btnRecord.setForeground(new Color(72, 61, 139));
		btnRecord.setBounds(225, 181, 202, 29);
		contentPane.add(btnRecord);
		
		JButton btnEquipmentsRecord = new JButton(" EQUIPMENTS RECORD");
		btnEquipmentsRecord.setForeground(new Color(72, 61, 139));
		btnEquipmentsRecord.setBounds(225, 222, 202, 29);
		contentPane.add(btnEquipmentsRecord);
		
		JButton btnHostelRecord = new JButton(" HOSTEL RECORD");
		btnHostelRecord.setForeground(new Color(72, 61, 139));
		btnHostelRecord.setBounds(225, 263, 202, 29);
		contentPane.add(btnHostelRecord);
		
		JButton btnLogut = new JButton("LOGUT");
		btnLogut.setForeground(new Color(255, 0, 0));
		btnLogut.setBackground(UIManager.getColor("Button.background"));
		btnLogut.setBounds(225, 304, 202, 29);
		contentPane.add(btnLogut);
	}
}
