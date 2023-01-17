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

public class Payment_Stats extends JFrame {

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
					"SELECT s.USN,s.student_name, r.ROOM_TYPE, SUM(rt.RENT_AMOUNT - COALESCE(p.PAYMENT_AMOUNT, 0)) AS \"Pending Fee\" "
					+ " FROM STUDENT s "
					+ " JOIN ROOM r ON s.ROOM_ID = r.ROOM_ID "
					+ " JOIN RENT rt ON r.RENT_TITLE = rt.RENT_TITLE "
					+ " LEFT JOIN (SELECT RENT_TITLE, SUM(PAYMENT_AMOUNT) as PAYMENT_AMOUNT, USN FROM PAYMENT group by RENT_TITLE, USN) p ON r.RENT_TITLE = p.RENT_TITLE AND s.USN = p.USN "
					+ " GROUP BY s.USN, r.ROOM_TYPE,s.student_name ORDER BY USN ");
			rs = pst.executeQuery();
			System.out.println(rs);
			DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			tb1.getDataVector().removeAllElements();
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)});
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
					Payment_Stats frame = new Payment_Stats();
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
	public Payment_Stats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		scrollPane.setBounds(37, 72, 699, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object[] column = {"USN","NAME","ROOM TYPE","PENDING AMOUNT"} ;
	
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		Connect();table_load();
		
		JLabel lblPaymentStats = new JLabel("PENDING FEE LIST");
		lblPaymentStats.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPaymentStats.setForeground(new Color(128, 0, 128));
		lblPaymentStats.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblPaymentStats.setBounds(69, 0, 650, 40);
		contentPane.add(lblPaymentStats);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 777, 449);
		contentPane.add(lblNewLabel_1);
		
	}
}
