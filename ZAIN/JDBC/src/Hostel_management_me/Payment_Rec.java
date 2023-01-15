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

public class Payment_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField EID;
	private JTextField EROOMID;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment_Rec frame = new Payment_Rec();
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
	public Payment_Rec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 51, 699, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT ID :");
		lblNewLabel.setBounds(20, 16, 100, 16);
		panel.add(lblNewLabel);
		
		JLabel lblP = new JLabel("DATE :");
		lblP.setBounds(20, 88, 84, 16);
		panel.add(lblP);
		
		EID = new JTextField();
		EID.setBounds(130, 11, 202, 26);
		panel.add(EID);
		EID.setColumns(10);
		
		EROOMID = new JTextField();
		EROOMID.setColumns(10);
		EROOMID.setBounds(130, 83, 202, 26);
		panel.add(EROOMID);
		
		JLabel lblName_1 = new JLabel("USN :");
		lblName_1.setBounds(20, 56, 100, 16);
		panel.add(lblName_1);
		
		JLabel lblAmount = new JLabel("AMOUNT :");
		lblAmount.setBounds(356, 21, 84, 16);
		panel.add(lblAmount);
		
		JLabel lblDescription = new JLabel("DESCRIPTION :");
		lblDescription.setBounds(356, 55, 100, 16);
		panel.add(lblDescription);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(466, 16, 202, 26);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(466, 50, 202, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 48, 202, 26);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("ADD");
		
		btnNewButton.setBounds(104, 380, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(327, 380, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("PAYMENT RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(555, 380, 117, 29);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 189, 699, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(154, 207, 208));
		model = new DefaultTableModel();
		Object[] column = {"PAYMENT ID", "USN","DATE" ,"AMOUNT","DESCRIPTION"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}