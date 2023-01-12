package Hostel_management_me;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Rooms_Record extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField Student_USN;
	private JTextField textField_1;
	private JTable table;

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
		setBounds(100, 100, 758, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed( ActionEvent e) {
				
				
			
			}
		});
		btnNewButton.setBounds(575, 228, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(575, 282, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(575, 390, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("ROOMS RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(575, 337, 117, 29);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MENU f1 = new MENU();
				f1.setVisible(true);

			}
		});
		btnBack.setBounds(10, 11, 117, 29);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 228, 545, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox Room_Floor = new JComboBox();
		Room_Floor.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		Room_Floor.setBounds(258, 59, 177, 22);
		panel.add(Room_Floor);
		
		JComboBox Room_Type = new JComboBox();
		Room_Type.setModel(new DefaultComboBoxModel(new String[] {"SINGLE", "DOUBLE", "QUADRUPLE"}));
		Room_Type.setBounds(258, 100, 177, 22);
		panel.add(Room_Type);
		
		JLabel lblNewLabel = new JLabel("Room ID");
		lblNewLabel.setBounds(38, 26, 73, 22);
		panel.add(lblNewLabel);
		
		JLabel lblRoomfloor = new JLabel("Room Floor");
		lblRoomfloor.setBounds(38, 59, 73, 22);
		panel.add(lblRoomfloor);
		
		JLabel lblRoomtype = new JLabel("Room Type");
		lblRoomtype.setBounds(38, 100, 73, 22);
		panel.add(lblRoomtype);
		
		JLabel lblNewLabel_2 = new JLabel("Student USN");
		lblNewLabel_2.setBounds(38, 133, 73, 22);
		panel.add(lblNewLabel_2);
		
		Student_USN = new JTextField();
		Student_USN.setBounds(258, 134, 177, 20);
		panel.add(Student_USN);
		Student_USN.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(258, 27, 177, 20);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 51, 669, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] column = {"ID", "FLOOR", "TYPE", "STD USN"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
