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
import javax.swing.ImageIcon;

public class Payment_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField EID;
	private JTextField EPRICE;
	private JTextField EROOMID;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblNewLabel = new JLabel("Payment ID :");
		lblNewLabel.setBounds(20, 16, 100, 16);
		panel.add(lblNewLabel);
		
		JLabel lblP = new JLabel("Date :");
		lblP.setBounds(20, 88, 84, 16);
		panel.add(lblP);
		
		EID = new JTextField();
		EID.setBounds(130, 11, 202, 26);
		panel.add(EID);
		EID.setColumns(10);
		
		EPRICE = new JTextField();
		EPRICE.setColumns(10);
		EPRICE.setBounds(130, 48, 202, 26);
		panel.add(EPRICE);
		
		EROOMID = new JTextField();
		EROOMID.setColumns(10);
		EROOMID.setBounds(130, 83, 202, 26);
		panel.add(EROOMID);
		
		JLabel lblName_1 = new JLabel("Student USN :");
		lblName_1.setBounds(20, 56, 100, 16);
		panel.add(lblName_1);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(356, 21, 84, 16);
		panel.add(lblAmount);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(356, 55, 84, 16);
		panel.add(lblDescription);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(466, 16, 202, 26);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(466, 50, 202, 26);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("ADD");
		
		btnNewButton.setBounds(37, 380, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(185, 380, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(327, 380, 117, 29);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(475, 380, 117, 29);
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
		Object[] column = {"Payment ID", "Student USN","Date" ,"Amount","Description"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setBounds(619, 380, 117, 29);
		contentPane.add(btnPrint);
		
		JLabel lblPaymentRecord = new JLabel("Payment Record");
		lblPaymentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentRecord.setForeground(new Color(128, 0, 128));
		lblPaymentRecord.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblPaymentRecord.setBounds(87, 0, 650, 40);
		contentPane.add(lblPaymentRecord);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("\\\\Mac\\Home\\Desktop\\5 DBMS PRGT\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_1.setBounds(0, 0, 777, 449);
		contentPane.add(lblNewLabel_1);
	}
}
