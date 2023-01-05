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

public class Rooms_Record extends JFrame {

	private JPanel contentPane;
	private JTextField RID;
	private JTextField RFLR;
	private JTextField RTYP;
	private JTextField RSUSN;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;

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
		panel.setBounds(38, 52, 293, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(18, 34, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("FLOOR :");
		lblName.setBounds(18, 62, 61, 16);
		panel.add(lblName);
		
		JLabel lblP = new JLabel("TYPE :");
		lblP.setBounds(18, 90, 84, 16);
		panel.add(lblP);
		
		JLabel lblEmail = new JLabel("STUDENT USN :");
		lblEmail.setBounds(18, 118, 97, 16);
		panel.add(lblEmail);
		
		RID = new JTextField();
		RID.setBounds(112, 29, 164, 26);
		panel.add(RID);
		RID.setColumns(10);
		
		RFLR = new JTextField();
		RFLR.setColumns(10);
		RFLR.setBounds(112, 57, 164, 26);
		panel.add(RFLR);
		
		RTYP = new JTextField();
		RTYP.setColumns(10);
		RTYP.setBounds(112, 85, 164, 26);
		panel.add(RTYP);
		
		RSUSN = new JTextField();
		RSUSN.setColumns(10);
		RSUSN.setBounds(112, 113, 164, 26);
		panel.add(RSUSN);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed( ActionEvent e) {
				
				
				
				model.addRow(row);
				row[0]=RID.getText();
				row[1]=RFLR.getText();
				row[2]=RTYP.getText();
				row[3]=RSUSN.getText();
				
				
				
				RID.setText("");
				RFLR.setText("");
				RTYP.setText("");
				RSUSN.setText("");
				
			
			}
		});
		btnNewButton.setBounds(38, 273, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(214, 273, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(214, 314, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("ROOMS RECORD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(0, 17, 758, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(38, 314, 117, 29);
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
		scrollPane.setBounds(363, 52, 377, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(154, 207, 208));
		model = new DefaultTableModel();
		Object[] column = {"ID", "FLOOR", "TYPE", "STD USN"} ;
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
