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

public class Hostel_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField EID;
	private JTextField EPRICE;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hostel_Rec frame = new Hostel_Rec();
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
	public Hostel_Rec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 247, 502, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOSTEL ID :");
		lblNewLabel.setBounds(20, 29, 139, 16);
		panel.add(lblNewLabel);
		
		JLabel lblP = new JLabel("HOSTEL NAME :");
		lblP.setBounds(20, 110, 146, 16);
		panel.add(lblP);
		
		EID = new JTextField();
		EID.setBounds(200, 24, 253, 26);
		panel.add(EID);
		EID.setColumns(10);
		
		EPRICE = new JTextField();
		EPRICE.setColumns(10);
		EPRICE.setBounds(200, 61, 253, 26);
		panel.add(EPRICE);
		
		JLabel lblName_1 = new JLabel("LOCATION :");
		lblName_1.setBounds(20, 69, 170, 16);
		panel.add(lblName_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Boys", "Girls", "Staff"}));
		comboBox.setBounds(200, 107, 253, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		
		btnNewButton.setBounds(570, 247, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(570, 293, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(570, 340, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("HOSTEL RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(570, 380, 117, 29);
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
		scrollPane.setBounds(40, 44, 678, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(154, 207, 208));
		model = new DefaultTableModel();
		Object[] column = {"HOSTEL ID", "LOCATION", "HOSTEL NAME"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
