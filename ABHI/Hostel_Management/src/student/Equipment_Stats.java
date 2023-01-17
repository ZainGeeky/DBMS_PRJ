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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Equipment_Stats extends JFrame {

	private JPanel contentPane;
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
			System.out.println("connected");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
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
					Equipment_Stats frame = new Equipment_Stats();
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
	public Equipment_Stats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(37, 51, 699, 87);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hostel ID :");
		lblNewLabel.setBounds(50, 19, 100, 16);
		panel.add(lblNewLabel);

		JLabel lblRoomId = new JLabel("Room ID :");
		lblRoomId.setBounds(362, 20, 88, 16);
		panel.add(lblRoomId);

		JComboBox hostel_id = new JComboBox();
		hostel_id.setBounds(139, 16, 177, 22);
		panel.add(hostel_id);

		JComboBox room_id = new JComboBox();
		room_id.setBounds(460, 16, 177, 22);
		panel.add(room_id);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hid,rid;
				hid = hostel_id.getSelectedItem().toString();
				rid = room_id.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("SELECT EQUIPMENT_ID,EQUIPMENT_NAME,EQUIPMENT_PRICE,EQUIPMENT_TYPE\r\n"
							+ "FROM EQUIPMENT\r\n"
							+ "JOIN ROOM ON EQUIPMENT.ROOM_ID = ROOM.ROOM_ID\r\n"
							+ "JOIN HOSTEL ON ROOM.HOSTEL_ID = HOSTEL.HOSTEL_ID\r\n"
							+ "WHERE HOSTEL.HOSTEL_ID =? AND ROOM.ROOM_ID =?");
					pst.setString(1, hid);
					pst.setString(2, rid);
					rs = pst.executeQuery();
					
					DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
					tb1.getDataVector().removeAllElements();
					while (rs.next()) {
						tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)});
					
					
					}
					}catch (SQLException e1) {
						e1.printStackTrace();
					}			
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(284, 56, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
			}
		});
		btnNewButton_1.setBounds(407, 56, 85, 21);
		panel.add(btnNewButton_1);
		sql_connection rv = new sql_connection();
		ResultSet rs = rv.display_sql("select HOSTEL_ID FROM HOSTEL ");
		try {
			while (rs.next()) {
				hostel_id.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		hostel_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hid;
				int hostelIndex = hostel_id.getSelectedIndex();
				hid = hostel_id.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("select DISTINCT(ROOM_ID) FROM ROOM WHERE HOSTEL_ID=? ");
					pst.setString(1, hid);
					ResultSet rs = pst.executeQuery();
					try {
						room_id.removeAllItems();
						while (rs.next()) {
							room_id.addItem(rs.getString(1));
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

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stats f1 = new Stats();
				f1.setVisible(true);

			}
		});
		btnBack.setBounds(10, 11, 117, 29);
		contentPane.add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 148, 699, 275);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object[] column = { " EID", "ETYPE", "ENAME", "EPRICE" };
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblEquipmentStats = new JLabel("Equipment Stats");
		lblEquipmentStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipmentStats.setForeground(new Color(128, 0, 128));
		lblEquipmentStats.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblEquipmentStats.setBounds(71, 0, 650, 40);
		contentPane.add(lblEquipmentStats);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(
				"D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 777, 449);
		contentPane.add(lblNewLabel_1);
		Connect();
	}
}
