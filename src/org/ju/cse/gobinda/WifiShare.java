package org.ju.cse.gobinda;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WifiShare extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;

	private static JTextArea infoTextArea;

	public static void initialize() {
		new WifiShare().setVisible(true);
	}

	public WifiShare() {
		super();
		setTitle("Wifi Creator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 432);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnStart = new JButton("SET");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = userNameTextField.getText().trim();
				String password = passwordTextField.getText().trim();
				ComputerManager.setUsernamePassword(username, password);
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnStart.setBounds(281, 11, 133, 103);
		contentPane.add(btnStart);

		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		userNameTextField.setColumns(10);
		userNameTextField.setBounds(10, 11, 261, 46);
		userNameTextField.setToolTipText("set username here");
		contentPane.add(userNameTextField);

		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(10, 68, 261, 46);
		passwordTextField.setToolTipText("set password here");
		contentPane.add(passwordTextField);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 125, 690, 2);
		contentPane.add(separator);

		JButton btnStart_1 = new JButton("ON");
		btnStart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComputerManager.makeSharingOn();
			}
		});
		btnStart_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnStart_1.setBounds(424, 11, 133, 103);
		contentPane.add(btnStart_1);

		JButton btnOff = new JButton("OFF");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComputerManager.makeSharingOff();
			}
		});
		btnOff.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnOff.setBounds(567, 11, 133, 103);
		contentPane.add(btnOff);

		JPanel panel = new JPanel();
		panel.setBounds(10, 138, 690, 254);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		infoTextArea = new JTextArea();
		infoTextArea.setToolTipText("show direction or output here");
		infoTextArea.setFont(new Font("Tahoma", Font.PLAIN, 25));
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		infoTextArea.setEditable(false);
		scrollPane.setViewportView(infoTextArea);

		StringBuilder initialInfo = new StringBuilder();
		initialInfo.append("How to use this software\n\n");
		initialInfo.append("1. set up username and password.\n");
		initialInfo.append("2. make it off.\n");
		initialInfo.append("3. make it on.\n");
		initialInfo.append("4. enjoy.\n\n");

		initialInfo.append("NB: if you do not set the username and password then");
		initialInfo.append("it will start the wifi using previous username and password.\n");

		infoTextArea.setText(initialInfo.toString());
	}

	public static void showInformation(String message) {
		infoTextArea.setText(message);
	}

}
