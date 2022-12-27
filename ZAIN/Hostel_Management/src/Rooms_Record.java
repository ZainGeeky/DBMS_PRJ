import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class Rooms_Record extends JFrame {

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
					Rooms_Record frame = new Rooms_Record();
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
	public Rooms_Record() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rooms Record");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 21, 652, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblRoomsId = new JLabel("Rooms ID");
		lblRoomsId.setBounds(61, 80, 104, 28);
		contentPane.add(lblRoomsId);
		
		JLabel lblRoomsFloor = new JLabel("Rooms Floor");
		lblRoomsFloor.setBounds(61, 132, 104, 28);
		contentPane.add(lblRoomsFloor);
		
		JLabel lblRoomsType = new JLabel("Rooms Type");
		lblRoomsType.setBounds(61, 187, 104, 28);
		contentPane.add(lblRoomsType);
		
		JLabel lblRoomsStudentUsn = new JLabel("Rooms Student USN");
		lblRoomsStudentUsn.setBounds(61, 248, 168, 28);
		contentPane.add(lblRoomsStudentUsn);
		
		textField = new JTextField();
		textField.setBounds(306, 81, 267, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(306, 133, 267, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(306, 188, 267, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(306, 249, 267, 26);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(269, 300, 117, 29);
		contentPane.add(btnNewButton);
	}

}
