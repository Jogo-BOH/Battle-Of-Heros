package MainScreens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import CRUDScreens.RegisterUser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StoryMode implements Runnable{

	public static JFrame frmStory;
	
	static Player pPS = null;
	public static Thread tarefa;
	public static int paum = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoryMode window = new StoryMode();
					window.frmStory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoryMode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStory = new JFrame();
		frmStory.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tarefa = new Thread(StoryMode.this);
				tarefa.start();
				paum = 3;
			}
			@Override
			public void windowClosed(WindowEvent arg0) {
				frmStory.dispose();
				tarefa.stop();
			}
		});
		frmStory.setTitle("Battle Of Heros - Story Mode");
		frmStory.setIconImage(Toolkit.getDefaultToolkit().getImage(StoryMode.class.getResource("/Imgs/Screen/icon5.png")));
		frmStory.setResizable(false);
		frmStory.setBounds(100, 100, 347, 247);
		frmStory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStory.getContentPane().setLayout(null);
		
		JButton btnCreate = new JButton("Create Save File");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStory.setVisible(false);
				RegisterUser.main(null);
			}
		});
		btnCreate.setFocusable(false);
		btnCreate.setBackground(new Color(0,0,128,250));
		btnCreate.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBounds(10, 80, 320, 58);
		frmStory.getContentPane().add(btnCreate);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSignIn.setFocusable(false);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnSignIn.setBackground(new Color(0,0,128,250));
		btnSignIn.setBounds(10, 11, 320, 58);
		frmStory.getContentPane().add(btnSignIn);
		
		JButton btnVoltar = new JButton("Back");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStory.dispose();
				ModePick.main(null);
				tarefa.stop();
			}
		});
		btnVoltar.setFocusable(false);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnVoltar.setBackground(new Color(0,0,128,250));
		btnVoltar.setBounds(10, 149, 320, 58);
		frmStory.getContentPane().add(btnVoltar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setFocusable(false);
		lblBG.setIcon(new ImageIcon(StoryMode.class.getResource("/GIFbg1.gif")));
		lblBG.setBounds(0, 0, 341, 218);
		frmStory.getContentPane().add(lblBG);
		frmStory.setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(paum==3){
			try {
				FileInputStream fileInputStream = new FileInputStream("Odd.mp3");
				Player player = new Player(fileInputStream);
				pPS = player;
				pPS.play();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(JavaLayerException e1) {
				e1.printStackTrace();
			}
			}
	}
}
