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

public class Payment_Rec extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField pamount;
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
					"SELECT payment_id,usn,rent_title,payment_amount,TO_CHAR(payment_date,'DD MONTH YY ') from payment order by payment_date");
			rs = pst.executeQuery();
			System.out.println(rs);
			DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			tb1.getDataVector().removeAllElements();
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)});
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
					Payment_Rec frame = new Payment_Rec();
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
	public Payment_Rec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 50, 699, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment ID :");
		lblNewLabel.setBounds(60, 21, 100, 16);
		panel.add(lblNewLabel);
		
		pid = new JTextField();
		pid.setBounds(130, 17, 202, 26);
		panel.add(pid);
		pid.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Student USN :");
		lblName_1.setBounds(45, 61, 100, 16);
		panel.add(lblName_1);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(394, 21, 84, 16);
		panel.add(lblAmount);
		
		JLabel lblDescription = new JLabel("Rent Title :");
		lblDescription.setBounds(394, 61, 84, 16);
		panel.add(lblDescription);
		
		pamount = new JTextField();
		pamount.setColumns(10);
		pamount.setBounds(466, 16, 202, 26);
		panel.add(pamount);
		//select rent_title from room r, student s where r.room_id=s.room_id and s.usn='4SF20CI014' ; 
		JComboBox pusn = new JComboBox();
		JComboBox prtitle = new JComboBox();
		sql_connection rv = new sql_connection();
		ResultSet rs = rv.display_sql("select usn FROM student ");
		try {
			while (rs.next()) {
				pusn.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		pusn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usn;
				int hostelIndex = pusn.getSelectedIndex();
				usn =  pusn.getSelectedItem().toString();
				try {
					pst = con.prepareStatement("select rent_title from room r, student s where r.room_id=s.room_id and s.usn=? ");
					pst.setString(1, usn);
					ResultSet rs = pst.executeQuery();
					try {prtitle.removeAllItems();
						while (rs.next()) {
							prtitle.addItem(rs.getString(1));
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

		
		pusn.setBounds(130, 56, 202, 26);
		panel.add(pusn);
		
		
		prtitle.setBounds(466, 54, 202, 26);
		panel.add(prtitle);
		
		JButton btnNewButton = new JButton("PAY");
		btnNewButton.setBounds(290, 88, 117, 29);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pay_id,pay_usn,pay_rtitle,pay_amount;
				pay_id = pid.getText();
				System.out.println(pay_id);
				pay_amount = pamount.getText();
				System.out.println(pay_amount);
				pay_usn= pusn.getSelectedItem().toString();
				System.out.println(pay_usn);
				pay_rtitle = prtitle.getSelectedItem().toString();
				System.out.println(pay_rtitle);
				try {
					pst = con.prepareStatement("insert into PAYMENT VALUES(?,?,?,?,sysdate)");
					pst.setString(1, pay_id);
					pst.setString(2, pay_usn);
					pst.setString(3, pay_rtitle);
					pst.setString(4, pay_amount);
					pst.executeQuery();
					table_load();
					pid.setText("");
					pamount.setText("");
				//	pusn.setSelectedItem(null);
				//	prtitle.setSelectedItem(null);
					pid.requestFocus();
					System.out.println(pay_id+pay_usn+pay_rtitle+pay_amount);

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}
				
				
				
				
				
			}
		});
		
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
		scrollPane.setBounds(51, 202, 699, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object[] column = {"PAYMENT ID", "USN","RENT TITLE" ,"AMOUNT","DATE"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblPaymentRecord = new JLabel("Payment Record");
		lblPaymentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentRecord.setForeground(new Color(128, 0, 128));
		lblPaymentRecord.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblPaymentRecord.setBounds(87, 0, 650, 40);
		contentPane.add(lblPaymentRecord);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_1.setBounds(0, 0, 777, 449);
		contentPane.add(lblNewLabel_1);

		Connect();
		table_load();
	}
}
