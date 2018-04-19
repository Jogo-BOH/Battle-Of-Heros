package CRUDScreens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

import CRUD.CRUDUser;
import CRUD.User;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import MainScreens.StoryMode;
import MainScreens.StartScreen;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

public class RegisterUser {

	public static JFrame frmCadastro;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JTextField tfPassword;
	private JTextField tfConfirm;
	
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser window = new RegisterUser();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frmCadastro.dispose();
				StoryMode.frmStory.dispose();
			}
		});
		frmCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterUser.class.getResource("/Imgs/Screen/icon5.png")));
		frmCadastro.setTitle("Battle Of Heros - Create Save File");
		frmCadastro.setResizable(false);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.setBounds(100, 100, 450, 273);
		frmCadastro.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		lblUsername.setBounds(10, 14, 78, 14);
		frmCadastro.getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		lblEmail.setBounds(10, 62, 51, 14);
		frmCadastro.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		lblPassword.setBounds(10, 110, 84, 14);
		frmCadastro.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(10, 158, 151, 14);
		frmCadastro.getContentPane().add(lblConfirmPassword);
		
		tfUsername = new JTextField();
		tfUsername.setToolTipText("");
		tfUsername.setBounds(98, 11, 336, 20);
		frmCadastro.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setToolTipText("");
		tfEmail.setColumns(10);
		tfEmail.setBounds(71, 59, 363, 20);
		frmCadastro.getContentPane().add(tfEmail);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(104, 107, 330, 20);
		frmCadastro.getContentPane().add(tfPassword);
		
		tfConfirm = new JTextField();
		tfConfirm.setColumns(10);
		tfConfirm.setBounds(171, 155, 263, 20);
		frmCadastro.getContentPane().add(tfConfirm);
		
		btnSalvar = new JButton("Save");
		btnSalvar.setFocusable(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfPassword.getText().equals(tfConfirm.getText())) {
					User user = new User();
					user.setNome(tfUsername.getText().toString());
					user.setEmail(tfEmail.getText().toString());
					user.setSenha(tfPassword.getText().toString());
					CRUDUser insert = new CRUDUser();
					insert.InsertUser(user);
					JOptionPane.showMessageDialog(null, "User registered with success!");
					btnLimpar.doClick();
				}else {
					JOptionPane.showMessageDialog(null, "Password could not be confirmed!");
				}
			}
		});
		btnSalvar.setBackground(new Color(0,0,128,250));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnSalvar.setBounds(306, 186, 128, 47);
		frmCadastro.getContentPane().add(btnSalvar);
		
		btnVoltar = new JButton("Back");
		btnVoltar.setFocusable(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastro.setVisible(false);
				StoryMode.frmStory.setVisible(true);
			}
		});
		btnVoltar.setBackground(new Color(0,0,128,250));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnVoltar.setBounds(10, 186, 128, 47);
		frmCadastro.getContentPane().add(btnVoltar);
		
		btnLimpar = new JButton("Clear");
		btnLimpar.setFocusable(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfUsername.setText(null);
				tfEmail.setText(null);
				tfPassword.setText(null);
				tfConfirm.setText(null);
			}
		});
		btnLimpar.setBackground(new Color(0,0,128,250));
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnLimpar.setBounds(160, 186, 128, 47);
		frmCadastro.getContentPane().add(btnLimpar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setForeground(Color.LIGHT_GRAY);
		lblBG.setIcon(new ImageIcon(RegisterUser.class.getResource("/GIFbg1.gif")));
		lblBG.setBounds(0, 0, 444, 244);
		frmCadastro.getContentPane().add(lblBG);
		frmCadastro.setLocationRelativeTo(null);
	}
	
}