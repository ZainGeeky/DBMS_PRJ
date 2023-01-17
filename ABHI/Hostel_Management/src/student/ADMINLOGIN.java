package student;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class ADMINLOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMINLOGIN frame = new ADMINLOGIN();
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
	public ADMINLOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 202, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("HOSTEL MANAGEMENT");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 6, 609, 29);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(58, 46, 495, 305);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel usr = new JLabel("USERNAME :");
		usr.setForeground(new Color(138, 43, 226));
		usr.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		usr.setBounds(47, 97, 122, 16);
		panel.add(usr);

		JLabel pwd = new JLabel("PASSWORD :");
		pwd.setForeground(new Color(148, 0, 211));
		pwd.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		pwd.setBounds(47, 166, 122, 16);
		panel.add(pwd);

		username = new JTextField();
		username.setBounds(153, 92, 264, 29);
		panel.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_1_2.setBackground(new Color(0, 255, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("MV Boli", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(69, 24, 363, 43);
		panel.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(username.getText().equals("admin")&&password.getText().equals("admin"))
				{
					JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
				MENU frame = new MENU();
				dispose();
				frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "INVALID USERNAME/PASSWORD");
					username.setText("");
					password.setText("");
					username.requestFocus();
					
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(username.getText().equals("admin")&&password.getText().equals("admin"))
				{
					JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
				MENU frame = new MENU();
				dispose();
				frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "INVALID USERNAME/PASSWORD");
					username.setText("");
					password.setText("");
					username.requestFocus();
					
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		btnNewButton.setBounds(210, 200, 117, 29);
		panel.add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(153, 161, 264, 29);
		panel.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector copy.jpg"));
		lblNewLabel_2.setBounds(0, 0, 495, 305);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\HOSTEL_DBMS\\GALLERY\\colorful-holographic-gradient-background-design-vector.jpg"));
		lblNewLabel_1.setBounds(0, 0, 609, 384);
		contentPane.add(lblNewLabel_1);
	}
}
