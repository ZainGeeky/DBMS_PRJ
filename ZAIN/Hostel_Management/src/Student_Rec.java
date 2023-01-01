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

public class Student_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField usn;
	private JTextField name;
	private JTextField phno;
	private JTextField email;
	private JTextField city;
	private JTextField dob;
	private JTable table;
	private DefaultTableModel model;
	private Object[] rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Rec frame = new Student_Rec();
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
	public Student_Rec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 52, 293, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USN :");
		lblNewLabel.setBounds(18, 30, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(18, 58, 61, 16);
		panel.add(lblName);
		
		JLabel lblP = new JLabel("PHONE NO :");
		lblP.setBounds(18, 86, 84, 16);
		panel.add(lblP);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(18, 114, 61, 16);
		panel.add(lblEmail);
		
		JLabel lblCity = new JLabel("CITY :");
		lblCity.setBounds(18, 142, 61, 16);
		panel.add(lblCity);
		
		JLabel lblDob = new JLabel("DOB :");
		lblDob.setBounds(18, 170, 61, 16);
		panel.add(lblDob);
		
		usn = new JTextField();
		usn.setBounds(112, 25, 164, 26);
		panel.add(usn);
		usn.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(112, 53, 164, 26);
		panel.add(name);
		
		phno = new JTextField();
		phno.setColumns(10);
		phno.setBounds(112, 81, 164, 26);
		panel.add(phno);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(112, 109, 164, 26);
		panel.add(email);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(112, 137, 164, 26);
		panel.add(city);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(112, 165, 164, 26);
		panel.add(dob);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			private String[] row;

			public void actionPerformed( ActionEvent e) {
				
				model.addRow(row);
				
				/*
				row[0]=usn.getText();
				row[1]=name.getText();
				row[2]=phno.getText();
				row[3]=email.getText();
				row[4]=city.getText();
				row[5]=dob.getText();
				
				model.addRow(row);
				
				usn.setText("");
				name.setText("");
				phno.setText("");
				email.setText("");
				city.setText("");
				dob.setText("");
			*/
			}
		});
		btnNewButton.setBounds(38, 311, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(214, 311, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(214, 352, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(38, 352, 117, 29);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(10, 11, 117, 29);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 52, 377, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(154, 207, 208));
		model = new DefaultTableModel();
		Object[] column = {"USN", "NAME", "PH.NO.", "EMAIL","CITY","DOB"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
