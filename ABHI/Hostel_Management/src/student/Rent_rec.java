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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rent_rec extends JFrame {

	private JPanel contentPane;
	private JTextField rent_title;
	private JTextField rent_amount;
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
			sql_connection rv = new sql_connection();
			rv.Connect_sql();
			rs = rv.display_sql("SELECT * FROM RENT");
			DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
			tb1.getDataVector().removeAllElements();
			table.clearSelection();
			//System.out.println(rs.wasNull());
			while (rs.next()) {
				tb1.addRow(new String[] { rs.getString(1), rs.getString(2)});
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
					Rent_rec frame = new Rent_rec();
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
	public Rent_rec() {
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

		JLabel lblP = new JLabel("Amount:");
		lblP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblP.setBounds(93, 82, 93, 46);
		panel.add(lblP);

		rent_title = new JTextField();
		rent_title.setColumns(10);
		rent_title.setBounds(200, 28, 253, 46);
		panel.add(rent_title);

		rent_amount = new JTextField();
		rent_amount.setColumns(10);
		rent_amount.setBounds(200, 84, 253, 47);
		panel.add(rent_amount);

		JLabel lblName_1 = new JLabel("Rent Title:");
		lblName_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblName_1.setBounds(95, 28, 78, 46);
		panel.add(lblName_1);

		JButton RENT_ADD = new JButton("ADD");
		RENT_ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r_title, r_amount;
	
				r_title = rent_title.getText();
				r_amount = rent_amount.getText();
				sql_connection rv= new sql_connection();
				try {rv.Connect_sql();
					pst = con.prepareStatement("INSERT INTO RENT VALUES(?,?)");
					pst.setString(1, r_title);
					pst.setString(2, r_amount);
					pst.executeUpdate();
					table_load();
					rent_title.setText("");
					rent_amount.setText("");
					rent_title.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});

		RENT_ADD.setBounds(570, 247, 117, 29);
		contentPane.add(RENT_ADD);

		JButton RENT_UPDATE = new JButton("UPDATE");
		RENT_UPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  r_title, r_amount;		
				r_title = rent_title.getText();
				r_amount = rent_amount.getText();
				sql_connection rv = new sql_connection();
				rv.Connect_sql();				
				try {
					pst = con.prepareStatement("UPDATE RENT SET RENT_AMOUNT=? WHERE RENT_TITLE=?");
					pst.setString(1, r_amount);
					pst.setString(2, r_title);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();
					rent_title.setText("");
					rent_amount.setText("");
					rent_title.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "INVALID OPERATION");
				}

			}
		});
		RENT_UPDATE.setBounds(570, 293, 117, 29);
		contentPane.add(RENT_UPDATE);

		JButton RENT_DELETE = new JButton("DELETE");
		RENT_DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rtitle = rent_title.getText();
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						pst = con.prepareStatement("DELETE FROM RENT WHERE RENT_TITLE=?");
						pst.setString(1, rtitle);
						pst.executeUpdate();
						table_load();
						JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "INVALID OPERATION");
					}
					rent_title.setText("");
					rent_amount.setText("");
					rent_title.requestFocus();
					table_load();

				}
			}
		});
		RENT_DELETE.setBounds(570, 340, 117, 29);
		contentPane.add(RENT_DELETE);

		JLabel lblNewLabel_1 = new JLabel("RENT RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);

		JButton RENT_CLEAR = new JButton("CLEAR");
		RENT_CLEAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rent_title.setText("");
				rent_amount.setText("");
				rent_title.requestFocus();
				
				
			}
		});
		RENT_CLEAR.setBounds(570, 380, 117, 29);
		contentPane.add(RENT_CLEAR);

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
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(40, 43, 678, 193);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				System.out.println(selectedIndex);
				rent_title.setText(model.getValueAt(selectedIndex, 0).toString());
				rent_amount.setText(model.getValueAt(selectedIndex, 1).toString());
			}

		});
		table.setBackground(new Color(255, 255, 255));
		model = new DefaultTableModel();
		Object[] column = { "Rent ID", "Rent Title", "Amount" };
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"RENT TITLE", "RENT AMOUNT"
			}
		));
		scrollPane.setViewportView(table);
		Connect();
		table_load();

	}
}
