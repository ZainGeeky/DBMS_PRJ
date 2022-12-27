import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Equiment_list extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equiment_list frame = new Equiment_list();
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
	public Equiment_list() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipment Record");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBounds(264, 21, 126, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEquipmentId = new JLabel("Equipment ID ");
		lblEquipmentId.setBounds(31, 86, 126, 16);
		contentPane.add(lblEquipmentId);
		
		JLabel lblEquipmentName = new JLabel("Equipment Name");
		lblEquipmentName.setBounds(31, 136, 126, 16);
		contentPane.add(lblEquipmentName);
		
		JLabel lblEquipmentPrice = new JLabel("Equipment Price");
		lblEquipmentPrice.setBounds(31, 191, 126, 16);
		contentPane.add(lblEquipmentPrice);
		
		JLabel lblEquipmentRoomId = new JLabel("Equipment Room ID");
		lblEquipmentRoomId.setBounds(31, 243, 126, 16);
		contentPane.add(lblEquipmentRoomId);
		
		textField = new JTextField();
		textField.setBounds(260, 81, 260, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(260, 131, 260, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(260, 186, 260, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(264, 238, 260, 26);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(264, 310, 117, 29);
		contentPane.add(btnNewButton);
	}
}
