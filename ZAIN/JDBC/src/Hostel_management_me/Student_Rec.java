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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Student_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField usn;
	private JTextField name;
	private JTextField phno;
	private JTextField email;
	private JTextField city;
	private JTextField dob;
	private JTable table;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abhijith", "abhijith");
			System.out.println("connected");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void table_load() {
		try {
			pst = con.prepareStatement(
					"SELECT USN,STUDENT_NAME ,STUDENT_PHONE,STUDENT_EMAIL,STUDENT_CITY,TO_CHAR(STUDENT_DOB,'dd/MM/yyyy') AS STUDENT_DOB"
							+ ", HOSTEL_ID , ROOM_ID FROM student ORDER BY USN");
			rs = pst.executeQuery();
			System.out.println(rs);
			DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			tb1.getDataVector().removeAllElements();
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_Rec() {
		// connect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRATION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(38, 72, 293, 246);
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

		JLabel lblHostelId = new JLabel("HOSTEL ID :");
		lblHostelId.setBounds(18, 197, 61, 16);
		panel.add(lblHostelId);

		JLabel lblRentId = new JLabel("ROOM ID :");
		lblRentId.setBounds(18, 220, 61, 16);
		panel.add(lblRentId);
		sql_connection rv = new sql_connection();
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(112, 217, 164, 22);
		panel.add(comboBox_1);

		ResultSet rs = rv.display_sql("select HOSTEL_ID FROM HOSTEL ");
		try {
			while (rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hid;
				int hostelIndex = comboBox.getSelectedIndex();
				hid = comboBox.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("select DISTINCT(ROOM_ID) FROM ROOM WHERE HOSTEL_ID=? ");
					pst.setString(1, hid);
					ResultSet rs = pst.executeQuery();
					try {comboBox_1.removeAllItems();
						while (rs.next()) {
							comboBox_1.addItem(rs.getString(1));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		comboBox.setBounds(112, 194, 164, 22);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			// private String[] row;

			public void actionPerformed(ActionEvent e) {

				String USN, STUDENT_NAME, STUDENT_PHONE, STUDENT_EMAIL, STUDENT_CITY, STUDENT_DOB, S_ROOM, S_HOSTEL;
				;
				USN = usn.getText();
				STUDENT_NAME = name.getText();
				STUDENT_PHONE = phno.getText();
				STUDENT_EMAIL = email.getText();
				STUDENT_CITY = city.getText();
				STUDENT_DOB = dob.getText();
				S_HOSTEL = comboBox.getSelectedItem().toString();
				S_ROOM = comboBox_1.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("insert into student VALUES(?,?,?,?,?,?,?,?)");
					pst.setString(1, USN);
					pst.setString(2, STUDENT_NAME);
					pst.setString(3, STUDENT_PHONE);
					pst.setString(4, STUDENT_EMAIL);
					pst.setString(5, STUDENT_CITY);
					pst.setString(6, STUDENT_DOB);
					pst.setString(7, S_ROOM);
					pst.setString(8, S_HOSTEL);
					pst.executeUpdate();
					table_load();
					usn.setText("");
					name.setText("");
					phno.setText("");
					email.setText("");
					city.setText("");
					dob.setText("");
					comboBox.setSelectedItem(null);
					comboBox_1.setSelectedItem(null);
					usn.requestFocus();

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});
		btnNewButton.setBounds(38, 328, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String USN, STUDENT_NAME, STUDENT_PHONE, STUDENT_EMAIL, STUDENT_CITY, STUDENT_DOB, S_ROOM, S_HOSTEL;

				USN = usn.getText();
				STUDENT_NAME = name.getText();
				STUDENT_PHONE = phno.getText();
				STUDENT_EMAIL = email.getText();
				STUDENT_CITY = city.getText();
				STUDENT_DOB = dob.getText();
				S_HOSTEL = comboBox.getSelectedItem().toString();
				S_ROOM = comboBox_1.getSelectedItem().toString();
				try {
					pst = con.prepareStatement(
							"UPDATE STUDENT set STUDENT_NAME=?,STUDENT_PHONE=?,STUDENT_EMAIL=?,STUDENT_CITY=?,STUDENT_DOB=?,HOSTEL_ID=? ,ROOM_ID=? where USN =?");
					pst.setString(1, STUDENT_NAME);
					pst.setString(2, STUDENT_PHONE);
					pst.setString(3, STUDENT_EMAIL);
					pst.setString(4, STUDENT_CITY);
					pst.setString(5, STUDENT_DOB);
					pst.setString(6, S_HOSTEL);
					pst.setString(7, S_ROOM);
					pst.setString(8, USN);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();
					usn.setText("");
					name.setText("");
					phno.setText("");
					email.setText("");
					city.setText("");
					dob.setText("");
					comboBox.setSelectedItem(null);
					comboBox_1.setSelectedItem(null);
					usn.requestFocus();

				}

				catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});
		btnUpdate.setBounds(214, 328, 117, 29);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String USN = usn.getText();
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						pst = con.prepareStatement("DELETE FROM STUDENT WHERE USN=?");
						pst.setString(1, USN);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "INVALID OPERATION");
					}
					usn.setText("");
					name.setText("");
					phno.setText("");
					email.setText("");
					city.setText("");
					dob.setText("");
					comboBox.setSelectedItem(null);
					comboBox_1.setSelectedItem(null);
					usn.requestFocus();
					table_load();

				}
			}

		});
		btnDelete.setBounds(214, 396, 117, 29);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				usn.setText("");
				name.setText("");
				phno.setText("");
				email.setText("");
				city.setText("");
				dob.setText("");
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				usn.requestFocus();
			}
		});
		btnClear.setBounds(38, 396, 117, 29);
		contentPane.add(btnClear);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MENU f1 = new MENU();
				f1.setVisible(true);
			}
		});
		btnBack.setBounds(38, 11, 117, 29);
		contentPane.add(btnBack);

		JScrollPane student_list = new JScrollPane();
		student_list.setBounds(336, 65, 648, 398);
		contentPane.add(student_list);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				System.out.println(selectedIndex);
				usn.setText(model.getValueAt(selectedIndex, 0).toString());
				name.setText(model.getValueAt(selectedIndex, 1).toString());
				phno.setText(model.getValueAt(selectedIndex, 2).toString());
				email.setText(model.getValueAt(selectedIndex, 3).toString());
				city.setText(model.getValueAt(selectedIndex, 4).toString());
				dob.setText(model.getValueAt(selectedIndex, 5).toString());
				comboBox.setSelectedItem(table.getValueAt(selectedIndex, 7));
				comboBox_1.setSelectedItem(table.getValueAt(selectedIndex, 8));

			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setBorder(new CompoundBorder());
		table.setForeground(Color.BLACK);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.LIGHT_GRAY);
		// model = new DefaultTableModel();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "USN", "NAME", "PHONE", "EMAIL", "CITY", "DOB", "HOSTELID", "ROOM ID" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(119);
		table.getColumnModel().getColumn(4).setPreferredWidth(102);
		table.getColumnModel().getColumn(5).setPreferredWidth(79);
		table.getColumnModel().getColumn(5).setPreferredWidth(79);
		table.getColumnModel().getColumn(6).setPreferredWidth(119);
		table.getColumnModel().getColumn(7).setPreferredWidth(119);
		student_list.setViewportView(table);
		
		JLabel lblStudentRecord = new JLabel("Student Record");
		lblStudentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRecord.setForeground(new Color(128, 0, 128));
		lblStudentRecord.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblStudentRecord.setBounds(214, 11, 650, 40);
		contentPane.add(lblStudentRecord);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 994, 493);
		contentPane.add(lblNewLabel_1);
		Connect();
		table_load();
		Object hostel_id = comboBox_1.getSelectedItem();
		if (hostel_id != null) {
		} else {
		    JOptionPane.showMessageDialog(null, "Please select a hostel");
		}
	}
}
