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
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Rooms_Record extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField roomid;
	private JTable table;
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
			pst = con.prepareStatement("SELECT * FROM ROOM");
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

		JPanel panel = new JPanel();
		panel.setBounds(30, 234, 545, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		JComboBox roomfloor = new JComboBox();
		roomfloor.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		roomfloor.setBounds(258, 43, 177, 22);
		panel.add(roomfloor);

		JComboBox roomtype = new JComboBox();
		roomtype.setModel(new DefaultComboBoxModel(new String[] { "SINGLE", "DOUBLE", "TRIPLE", "QUADRUPLE" }));
		roomtype.setBounds(258, 76, 177, 22);
		panel.add(roomtype);

		sql_connection rv = new sql_connection();

		JComboBox roomhostel = new JComboBox();
		ResultSet rs = rv.display_sql("select HOSTEL_ID FROM HOSTEL ");
		try {
			while (rs.next()) {
				roomhostel.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		roomhostel.setBounds(258, 139, 177, 22);
		panel.add(roomhostel);

		JComboBox roomcategory = new JComboBox();
		rs = rv.display_sql("select RENT_TITLE FROM RENT ");
		try {
			while (rs.next()) {
				roomcategory.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		roomcategory.setBounds(258, 109, 177, 22);
		panel.add(roomcategory);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String rid, rfloor, rtype, rcategory, rhostel;
				rid = roomid.getText();
				rfloor = roomfloor.getSelectedItem().toString();
				rtype = roomtype.getSelectedItem().toString();
				rcategory = roomcategory.getSelectedItem().toString();
				rhostel = roomhostel.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("INSERT INTO ROOM VALUES(?,?,?,?,?)");
					pst.setString(1, rid);
					pst.setString(2, rfloor);
					pst.setString(3, rtype);
					pst.setString(4, rcategory);
					pst.setString(5, rhostel);
					pst.executeUpdate();
					table_load();
					roomid.setText("");
					roomfloor.setSelectedItem(null);
					roomtype.setSelectedItem(null);
					roomcategory.setSelectedItem(null);
					roomhostel.setSelectedItem(null);
					roomid.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});
		btnNewButton.setBounds(586, 242, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rid, rfloor, rtype, rcategory, rhostel;
				rid = roomid.getText();
				rfloor = roomfloor.getSelectedItem().toString();
				rtype = roomtype.getSelectedItem().toString();
				rcategory = roomcategory.getSelectedItem().toString();
				rhostel = roomhostel.getSelectedItem().toString();
				try {
					pst = con.prepareStatement(
							"UPDATE ROOM set ROOM_FLOOR=?,ROOM_TYPE=?,RENT_TITLE=?,HOSTEL_ID=? where ROOM_ID =?");
					pst.setString(1, rfloor);
					pst.setString(2, rtype);
					pst.setString(3, rcategory);
					pst.setString(4, rhostel);
					pst.setString(5, rid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();
					roomid.setText("");
					roomfloor.setSelectedItem(null);
					roomtype.setSelectedItem(null);
					roomcategory.setSelectedItem(null);
					roomhostel.setSelectedItem(null);
					roomid.requestFocus();

				}

				catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});
		btnUpdate.setBounds(586, 297, 117, 29);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rid = roomid.getText();
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						pst = con.prepareStatement("DELETE FROM ROOM WHERE ROOM_ID=?");
						pst.setString(1, rid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "INVALID OPERATION");
					}
					roomid.setText("");
					roomfloor.setSelectedItem(null);
					roomtype.setSelectedItem(null);
					roomcategory.setSelectedItem(null);
					roomhostel.setSelectedItem(null);
					roomid.requestFocus();

					table_load();

				}

			}
		});
		btnDelete.setBounds(586, 396, 117, 29);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				roomid.setText("");
				roomfloor.setSelectedItem(null);
				roomtype.setSelectedItem(null);
				roomcategory.setSelectedItem(null);
				roomhostel.setSelectedItem(null);
				roomid.requestFocus();
			}

		});
		btnClear.setBounds(586, 350, 117, 29);
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

		JLabel lblNewLabel = new JLabel("Room ID :");
		lblNewLabel.setBounds(32, 14, 73, 22);
		panel.add(lblNewLabel);

		JLabel lblRoomfloor = new JLabel("Room Floor :");
		lblRoomfloor.setBounds(32, 43, 73, 22);
		panel.add(lblRoomfloor);

		JLabel lblRoomtype = new JLabel("Room Type :");
		lblRoomtype.setBounds(32, 76, 73, 22);
		panel.add(lblRoomtype);

		roomid = new JTextField();
		roomid.setColumns(10);
		roomid.setBounds(258, 15, 177, 20);
		panel.add(roomid);

		JLabel lblRId = new JLabel("Rent Category :");
		lblRId.setBounds(32, 108, 73, 22);
		panel.add(lblRId);

		JLabel lblHostelId = new JLabel("Hostel ID :");
		lblHostelId.setBounds(32, 139, 73, 22);
		panel.add(lblHostelId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 51, 705, 169);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				System.out.println(selectedIndex);
				roomid.setText(model.getValueAt(selectedIndex, 0).toString());
				roomfloor.setSelectedItem(table.getValueAt(selectedIndex, 1));
				roomtype.setSelectedItem(table.getValueAt(selectedIndex, 2));
				roomcategory.setSelectedItem(table.getValueAt(selectedIndex, 3));
				roomhostel.setSelectedItem(table.getValueAt(selectedIndex, 4));
			}
		});
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] column = { "ID", "FLOOR", "TYPE", "RENT", "HID" };
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblRoomRecord = new JLabel("Room Record");
		lblRoomRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomRecord.setForeground(new Color(128, 0, 128));
		lblRoomRecord.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblRoomRecord.setBounds(75, 0, 650, 40);
		contentPane.add(lblRoomRecord);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 746, 474);
		contentPane.add(lblNewLabel_1);
		Connect();
		table_load();
	}
}
