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

public class Find_Rmates extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField usn;
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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_Rmates frame = new Find_Rmates();
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
	public Find_Rmates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 52, 699, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USN :");
		lblNewLabel.setBounds(50, 19, 100, 16);
		panel.add(lblNewLabel);
		
		usn = new JTextField();
		usn.setBounds(179, 17, 209, 20);
		panel.add(usn);
		usn.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssusn;
				ssusn = usn.getText();
				try {
				pst = con.prepareStatement("SELECT s2.room_id,s2.USN,s2.student_name"
						+ " FROM STUDENT s1 "
						+ " JOIN ROOM r ON s1.ROOM_ID = r.ROOM_ID "
						+ " JOIN STUDENT s2 ON r.ROOM_ID = s2.ROOM_ID "
						+ " WHERE s1.USN = ? AND s2.USN != ?");
				pst.setString(1, ssusn);
				pst.setString(2, ssusn);
				rs = pst.executeQuery();
				
				DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
				tb1.getDataVector().removeAllElements();
				while (rs.next()) {
					tb1.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3)});
				
				
				}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\search_1.png"));
		btnNewButton.setBounds(398, 12, 89, 31);
		panel.add(btnNewButton);
		
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
		scrollPane.setBounds(37, 122, 699, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object[] column = {"ROOM ID","ROOMMATES USN","NAME"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblFindRoomates = new JLabel("Find Roomates");
		lblFindRoomates.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindRoomates.setForeground(new Color(128, 0, 128));
		lblFindRoomates.setFont(new Font("MV Boli", Font.BOLD, 35));
		lblFindRoomates.setBounds(70, 0, 650, 40);
		contentPane.add(lblFindRoomates);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 777, 449);
		contentPane.add(lblNewLabel_1);
		Connect();
	}
}
