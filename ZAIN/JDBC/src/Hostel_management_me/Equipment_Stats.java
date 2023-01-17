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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Equipment_Stats extends JFrame {

	private JPanel contentPane;
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
		panel.setBounds(37, 51, 699, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hostel ID :");
		lblNewLabel.setBounds(50, 19, 100, 16);
		panel.add(lblNewLabel);
		
		JLabel lblRoomId = new JLabel("Room ID :");
		lblRoomId.setBounds(362, 20, 88, 16);
		panel.add(lblRoomId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 16, 177, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(460, 16, 177, 22);
		panel.add(comboBox_1);
		
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
		table.setBackground(new Color(154, 207, 208));
		model = new DefaultTableModel();
		Object[] column = {" EID","ETYPE","ENAME","EPRICE"} ;
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
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 777, 449);
		contentPane.add(lblNewLabel_1);
	}
}
