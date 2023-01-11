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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

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
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abhijith", "abhijith");
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
							+ " FROM STUDENT ORDER BY USN");
			rs = pst.executeQuery();
			DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			tb1.getDataVector().removeAllElements();
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
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
					JOptionPane.showMessageDialog(null,"INVALID OPERATION");
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
		setBounds(100, 100, 1163, 669);
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
			// private String[] row;

			public void actionPerformed(ActionEvent e) {

				String USN, STUDENT_NAME, STUDENT_PHONE, STUDENT_EMAIL, STUDENT_CITY, STUDENT_DOB;
				USN = usn.getText();
				STUDENT_NAME = name.getText();
				STUDENT_PHONE = phno.getText();
				STUDENT_EMAIL = email.getText();
				STUDENT_CITY = city.getText();
				STUDENT_DOB = dob.getText();

				try {
					pst = con.prepareStatement("insert into STUDENT VALUES(?,?,?,?,?,?)");
					pst.setString(1, USN);
					pst.setString(2, STUDENT_NAME);
					pst.setString(3, STUDENT_PHONE);
					pst.setString(4, STUDENT_EMAIL);
					pst.setString(5, STUDENT_CITY);
					pst.setString(6, STUDENT_DOB);
					pst.executeUpdate();
					table_load();
					usn.setText("");
					name.setText("");
					phno.setText("");
					email.setText("");
					city.setText("");
					dob.setText("");
					usn.requestFocus();

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"INVALID OPERATION");
				}

			}
		});
		btnNewButton.setBounds(38, 311, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String USN, STUDENT_NAME, STUDENT_PHONE, STUDENT_EMAIL, STUDENT_CITY, STUDENT_DOB;
				USN = usn.getText();
				STUDENT_NAME = name.getText();
				STUDENT_PHONE = phno.getText();
				STUDENT_EMAIL = email.getText();
				STUDENT_CITY = city.getText();
				STUDENT_DOB = dob.getText();
				try {
					pst = con.prepareStatement(
							"UPDATE STUDENT set USN = ?,STUDENT_NAME=?,STUDENT_PHONE=?,STUDENT_EMAIL=?,STUDENT_CITY=?,STUDENT_DOB=? where USN =?");
					pst.setString(1, USN);
					pst.setString(2, STUDENT_NAME);
					pst.setString(3, STUDENT_PHONE);
					pst.setString(4, STUDENT_EMAIL);
					pst.setString(5, STUDENT_CITY);
					pst.setString(6, STUDENT_DOB);
					pst.setString(7, USN);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();
					usn.setText("");
					name.setText("");
					phno.setText("");
					email.setText("");
					city.setText("");
					dob.setText("");
					usn.requestFocus();

				}

				catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"INVALID OPERATION");
				}

			}
		});
		btnUpdate.setBounds(214, 311, 117, 29);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String USN = usn.getText();
				 int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to Delete the record","Warning",JOptionPane.YES_NO_OPTION);
if(dialogResult == JOptionPane.YES_OPTION){
	try {	
	pst = con.prepareStatement("DELETE FROM STUDENT WHERE USN=?");    
    pst.setString(1,USN);
    pst.executeUpdate();
    JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
	}
	catch (Exception e1) {
		// TODO: handle exception
	    JOptionPane.showMessageDialog(null,"INVALID OPERATION");
	}    
    usn.setText("");
	name.setText("");
	phno.setText("");
	email.setText("");
	city.setText("");
	dob.setText("");
	usn.requestFocus();
    table_load();
    
}
}
			
		});
		btnDelete.setBounds(214, 352, 117, 29);
		contentPane.add(btnDelete);

		JLabel lblNewLabel_1 = new JLabel("STUDENT RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(116, 16, 758, 16);
		contentPane.add(lblNewLabel_1);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
				usn.setText("");
				name.setText("");
				phno.setText("");
				email.setText("");
				city.setText("");
				dob.setText("");
				usn.requestFocus();
			}
		});
		btnClear.setBounds(38, 352, 117, 29);
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

		JScrollPane student_list = new JScrollPane();
		student_list.addMouseListener(new MouseAdapter() {
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

			}
		});
		student_list.setBounds(367, 52, 758, 522);
		contentPane.add(student_list);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBackground(new Color(154, 207, 208));
		// model = new DefaultTableModel();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "USN", "NAME", "PHONE", "EMAIL", "CITY", "DOB" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(119);
		table.getColumnModel().getColumn(4).setPreferredWidth(102);
		table.getColumnModel().getColumn(5).setPreferredWidth(79);
		student_list.setViewportView(table);
		Connect();
		table_load();
	}
}
