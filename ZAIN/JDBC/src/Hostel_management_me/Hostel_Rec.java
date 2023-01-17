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

public class Hostel_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField hid;
	private JTextField hloc;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abhijith", "abhijith");
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
			pst = con.prepareStatement("SELECT HOSTEL_ID , HOSTEL_LOCATION , HOSTEL_NAME FROM HOSTEL ORDER BY HOSTEL_ID");
			rs = pst.executeQuery();
			//DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			//tb1.getDataVector().removeAllElements();
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });
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
		
		JLabel lblNewLabel = new JLabel("Hostel ID :");
		lblNewLabel.setBounds(20, 29, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblP = new JLabel("Hostel Name :");
		lblP.setBounds(20, 110, 84, 16);
		panel.add(lblP);
		
		hid = new JTextField();
		hid.setBounds(200, 24, 253, 26);
		panel.add(hid);
		hid.setColumns(10);
		
		hloc = new JTextField();
		hloc.setColumns(10);
		hloc.setBounds(200, 61, 253, 26);
		panel.add(hloc);
		
		JLabel lblName_1 = new JLabel("Location :");
		lblName_1.setBounds(20, 69, 61, 16);
		panel.add(lblName_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BOYS", "GIRLS", "STAFF"}));
		comboBox.setBounds(200, 107, 253, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hostelid, hostellocation,hosteltype;
				hostelid = hid.getText();
				hostellocation = hloc.getText();
				hosteltype = comboBox.getSelectedItem().toString();
		//-----------
				try {
					pst = con.prepareStatement("INSERT INTO HOSTEL VALUES(?,?,?)");
					pst.setString(1, hostelid);
					pst.setString(2, hosteltype);
					pst.setString(3, hostellocation);
					pst.executeUpdate();
					table_load();
					hid.setText("");
					hloc.setText("");
					comboBox.setSelectedItem(null);
					hid.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}
				
				
		//------------------		
			}
		});
		
		btnNewButton.setBounds(570, 247, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hostelid, hostellocation,hosteltype;
				hostelid = hid.getText();
				hostellocation = hloc.getText();
				hosteltype = comboBox.getSelectedItem().toString();
				try {
					pst = con.prepareStatement(
							"UPDATE HOSTEL set HOSTEL_NAME=?,HOSTEL_LOCATION=? where HOSTEL_ID =?");
					pst.setString(1, hosteltype);
					pst.setString(2, hostellocation);
					pst.setString(3, hostelid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();
					hid.setText("");
					hloc.setText("");
					comboBox.setSelectedItem(null);
					hid.requestFocus();

				}

				catch (SQLException e1) {
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
				
				String hostelid = hid.getText();
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						pst = con.prepareStatement("DELETE FROM HOSTEL WHERE HOSTEL_ID=?");
						pst.setString(1, hostelid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "INVALID OPERATION");
					}
					hid.setText("");
					hloc.setText("");
					comboBox.setSelectedItem(null);
					hid.requestFocus();
					table_load();
				
				}
				
				
			}
		});
		btnDelete.setBounds(570, 340, 117, 29);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hid.setText("");
				hloc.setText("");
				comboBox.setSelectedItem(null);
				hid.requestFocus();
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
		scrollPane.setBounds(40, 44, 678, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				System.out.println(selectedIndex);
				hid.setText(model.getValueAt(selectedIndex, 0).toString());
				hloc.setText(model.getValueAt(selectedIndex, 1).toString());
			    comboBox.setSelectedItem(table.getValueAt(selectedIndex,2));
				System.out.println("Selected index :: "+selectedIndex);
				
				
				
			}
		});
		table.setBackground(new Color(255, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"Hostel ID", "Location", "Hostel Name"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"HOSTEL ID", "LOCATION", "TYPE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(155);
		table.getColumnModel().getColumn(1).setPreferredWidth(328);
		table.getColumnModel().getColumn(2).setPreferredWidth(149);
		scrollPane.setViewportView(table);
		
		JLabel lblHostelRecord = new JLabel("Hostel Record");
		lblHostelRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblHostelRecord.setForeground(new Color(128, 0, 128));
		lblHostelRecord.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblHostelRecord.setBounds(68, 0, 650, 40);
		contentPane.add(lblHostelRecord);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 746, 449);
		contentPane.add(lblNewLabel_1);
		Connect();
		table_load();
	}
}

