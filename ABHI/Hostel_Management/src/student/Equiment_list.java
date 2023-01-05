package student;
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

public class Equiment_list extends JFrame {

	private JPanel contentPane;
	private JTextField EID;
	private JTextField ENAME;
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
		panel.setBounds(38, 52, 293, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(18, 34, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(18, 62, 61, 16);
		panel.add(lblName);
		
		JLabel lblP = new JLabel("PRICE :");
		lblP.setBounds(18, 90, 84, 16);
		panel.add(lblP);
		
		JLabel lblEmail = new JLabel("ROOM ID :");
		lblEmail.setBounds(18, 118, 91, 16);
		panel.add(lblEmail);
		
		EID = new JTextField();
		EID.setBounds(112, 29, 164, 26);
		panel.add(EID);
		EID.setColumns(10);
		
		ENAME = new JTextField();
		ENAME.setColumns(10);
		ENAME.setBounds(112, 57, 164, 26);
		panel.add(ENAME);
		
		EPRICE = new JTextField();
		EPRICE.setColumns(10);
		EPRICE.setBounds(112, 85, 164, 26);
		panel.add(EPRICE);
		
		EROOMID = new JTextField();
		EROOMID.setColumns(10);
		EROOMID.setBounds(112, 113, 164, 26);
		panel.add(EROOMID);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed( ActionEvent e) {
				
				
				
				model.addRow(row);
				row[0]=EID.getText();
				row[1]=ENAME.getText();
				row[2]=EPRICE.getText();
				row[3]=EROOMID.getText();
				
				
				
				EID.setText("");
				ENAME.setText("");
				EPRICE.setText("");
				EROOMID.setText("");
				
			
			}
		});
		btnNewButton.setBounds(38, 273, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(214, 273, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(214, 314, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("EQUIPMENT RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(38, 314, 117, 29);
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
		scrollPane.setBounds(363, 52, 377, 386);
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
