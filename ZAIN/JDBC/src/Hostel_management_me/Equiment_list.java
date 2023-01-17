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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Equiment_list extends JFrame {

	private JPanel contentPane;
	private JTextField eid;
	private JTextField ename;
	private JTextField eprice;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;

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
			DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			tb1.getDataVector().removeAllElements();
			pst = con.prepareStatement("SELECT * FROM EQUIPMENT");
			rs = pst.executeQuery();
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5) });
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
		panel.setBounds(40, 231, 488, 185);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("EID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(75, 13, 113, 16);
		panel.add(lblNewLabel);

		JLabel lblP = new JLabel("ETYPE :");
		lblP.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblP.setBounds(75, 109, 113, 16);
		panel.add(lblP);

		JLabel lblEmail = new JLabel("ROOM ID :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEmail.setBounds(75, 148, 113, 16);
		panel.add(lblEmail);

		eid = new JTextField();
		eid.setBounds(198, 10, 253, 27);
		panel.add(eid);
		eid.setColumns(10);

		ename = new JTextField();
		ename.setColumns(10);
		ename.setBounds(198, 39, 253, 27);
		panel.add(ename);

		eprice = new JTextField();
		eprice.setColumns(10);
		eprice.setBounds(198, 76, 253, 28);
		panel.add(eprice);

		JComboBox etype = new JComboBox();
		etype.setModel(new DefaultComboBoxModel(
				new String[] { "FURNITURE", "ELECTRONICS", "CONSTRUCTION", "STATIONARY", "PLUMBING" }));
		etype.setBounds(198, 108, 253, 23);
		panel.add(etype);

		JLabel lblName_1 = new JLabel("ENAME :");
		lblName_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblName_1.setBounds(75, 41, 113, 16);
		panel.add(lblName_1);
		sql_connection rv = new sql_connection();
		JComboBox eroom = new JComboBox();
		ResultSet rs = rv.display_sql("select ROOM_ID FROM ROOM ");
		try {
			while (rs.next()) {
				eroom.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eroom.setBounds(198, 142, 253, 22);
		panel.add(eroom);

		JLabel lblName = new JLabel("EPRICE :");
		lblName.setBounds(75, 77, 113, 16);
		panel.add(lblName);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String eqid, eqname, eqprice, eqtype, eqroomid;
				eqid = eid.getText();
				eqname = ename.getText();
				eqprice = eprice.getText();
				eqtype = etype.getSelectedItem().toString();
				eqroomid = eroom.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("INSERT INTO EQUIPMENT VALUES(?,?,?,?,?)");
					pst.setString(1, eqid);
					pst.setString(2, eqname);
					pst.setString(3, eqprice);
					pst.setString(4, eqtype);
					pst.setString(5, eqroomid);
					pst.executeUpdate();
					table_load();
					eid.setText("");
					ename.setText("");
					eprice.setText("");
					etype.setSelectedItem(null);
					eroom.setSelectedItem(null);
					eid.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});
		btnNewButton.setBounds(570, 247, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eqid, eqname, eqprice, eqtype, eqroomid;
				eqid = eid.getText();
				eqname = ename.getText();
				eqprice = eprice.getText();
				eqtype = etype.getSelectedItem().toString();
				eqroomid = eroom.getSelectedItem().toString();
				try {
					pst = con.prepareStatement(
							"UPDATE EQUIPMENT set EQUIPMENT_NAME=?,EQUIPMENT_PRICE=?,EQUIPMENT_TYPE=?,ROOM_ID=? WHERE EQUIPMENT_ID =?");
					pst.setString(1, eqname);
					pst.setString(2, eqprice);
					pst.setString(3, eqtype);
					pst.setString(4, eqroomid);
					pst.setString(5, eqid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();
					eid.setText("");
					ename.setText("");
					eprice.setText("");
					etype.setSelectedItem(null);
					eroom.setSelectedItem(null);
					eid.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}
			}
		});
		btnUpdate.setBounds(570, 293, 117, 29);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String eqid = eid.getText();
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						pst = con.prepareStatement("DELETE FROM EQUIPMENT WHERE EQUIPMENT_ID=?");
						pst.setString(1, eqid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "INVALID OPERATION");
					}
					eid.setText("");
					ename.setText("");
					eprice.setText("");
					etype.setSelectedItem(null);
					eroom.setSelectedItem(null);
					eid.requestFocus();
					table_load();
				}
			}
		});
		btnDelete.setBounds(570, 340, 117, 29);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eid.setText("");
				ename.setText("");
				eprice.setText("");
				etype.setSelectedItem(null);
				eroom.setSelectedItem(null);
				eid.requestFocus();
			}
		});
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
		scrollPane.setBounds(40, 46, 658, 178);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				System.out.println(selectedIndex);
				eid.setText(model.getValueAt(selectedIndex, 0).toString());
				ename.setText(model.getValueAt(selectedIndex, 1).toString());
				eprice.setText(model.getValueAt(selectedIndex, 2).toString());
				etype.setSelectedItem(table.getValueAt(selectedIndex, 3));
				eroom.setSelectedItem(table.getValueAt(selectedIndex, 4));
			}
		});
		table.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object[] column = { "ID", "NAME", "PRICE", "TYPE", "ROOM ID" };
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblEquipmentRecord = new JLabel("Equipment Record");
		lblEquipmentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipmentRecord.setForeground(new Color(128, 0, 128));
		lblEquipmentRecord.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblEquipmentRecord.setBounds(54, 0, 650, 40);
		contentPane.add(lblEquipmentRecord);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_1.setBounds(0, 0, 746, 449);
		contentPane.add(lblNewLabel_1);

		Connect();
		table_load();

	}
}
