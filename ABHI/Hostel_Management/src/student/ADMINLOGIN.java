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
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 603, 29);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(86, 89, 423, 201);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel usr = new JLabel("USERNAME :");
		usr.setFont(new Font("Times New Roman", Font.BOLD, 16));
		usr.setBounds(24, 64, 122, 16);
		panel.add(usr);

		JLabel pwd = new JLabel("PASSWORD :");
		pwd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pwd.setBounds(24, 133, 122, 16);
		panel.add(pwd);

		username = new JTextField();
		username.setBounds(130, 59, 264, 29);
		panel.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1_2.setBackground(new Color(0, 255, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(-42, 10, 544, 16);
		panel.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("LOGIN");
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
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(187, 167, 117, 29);
		panel.add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(130, 128, 264, 29);
		panel.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ABHIJITH_MALLYA\\Desktop\\sahyadri2.jpg"));
		lblNewLabel_1.setBounds(6, 40, 572, 332);
		contentPane.add(lblNewLabel_1);
	}
}
