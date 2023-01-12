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

public class Equiment_list extends JFrame {

	private JPanel contentPane;
	private JTextField EID;
	private JTextField EPRICE;
	private JTextField EROOMID;
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
		setBounds(100, 100, 758, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 247, 488, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(18, 16, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(18, 53, 61, 16);
		panel.add(lblName);
		
		JLabel lblP = new JLabel("PRICE :");
		lblP.setBounds(18, 89, 84, 16);
		panel.add(lblP);
		
		JLabel lblEmail = new JLabel("ROOM ID :");
		lblEmail.setBounds(18, 130, 91, 16);
		panel.add(lblEmail);
		
		EID = new JTextField();
		EID.setBounds(164, 11, 253, 26);
		panel.add(EID);
		EID.setColumns(10);
		
		EPRICE = new JTextField();
		EPRICE.setColumns(10);
		EPRICE.setBounds(164, 85, 253, 26);
		panel.add(EPRICE);
		
		EROOMID = new JTextField();
		EROOMID.setColumns(10);
		EROOMID.setBounds(164, 125, 253, 26);
		panel.add(EROOMID);
		
		JComboBox ENAME = new JComboBox();
		ENAME.setBounds(164, 50, 253, 22);
		panel.add(ENAME);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed( ActionEvent e) {
				
				
				
				model.addRow(row);
				row[0]=EID.getText();
				row[1]=ENAME.getToolkit();
				row[2]=EPRICE.getText();
				row[3]=EROOMID.getText();
				
				
				
				EID.setText("");
				ENAME.setToolTipText("");
				EPRICE.setText("");
				EROOMID.setText("");
				
			
			}
		});
		btnNewButton.setBounds(570, 247, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(570, 293, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(570, 340, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("EQUIPMENT RECORD");
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
		scrollPane.setBounds(40, 46, 658, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(154, 207, 208));
		model = new DefaultTableModel();
		Object[] column = {"ID", "NAME", "PRICE", "ROOM ID"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
