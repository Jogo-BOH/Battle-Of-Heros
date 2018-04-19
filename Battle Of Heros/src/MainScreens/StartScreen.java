//COMPLETE

package MainScreens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartScreen extends ModePick implements Runnable{

	private JFrame frmBOH;
	static Player pPS = null;
	Thread tarefa;
	int paum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frmBOH.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBOH = new JFrame();
		frmBOH.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
					tarefa = new Thread(StartScreen.this);
					tarefa.start();
					paum = 0;
			}
			@Override
			public void windowClosed(WindowEvent e) {
				pPS.close();
				tarefa.stop();
			}
		});
		frmBOH.setResizable(false);
		frmBOH.setIconImage(Toolkit.getDefaultToolkit().getImage(StartScreen.class.getResource("/Imgs/Screen/icon5.png")));
		frmBOH.setTitle("Battle of Heroes");
		frmBOH.setBounds(100, 100, 606, 330);
		frmBOH.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBOH.getContentPane().setLayout(null);
		
		JLayeredPane lyrHome = new JLayeredPane();
		lyrHome.setBounds(0, 0, 600, 300);
		frmBOH.getContentPane().add(lyrHome);
		
		JLabel lblHomeBG = new JLabel("");
		lblHomeBG.setBounds(0, 0, 600, 300);
		lyrHome.add(lblHomeBG);
		lblHomeBG.setIcon(new ImageIcon(StartScreen.class.getResource("/Imgs/Screen/hs4.jpg")));
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pPS.close();
				frmBOH.dispose();
				ModePick.main(null);
				paum = 1;
			}
		});
		
		btnStart.setBounds(new Rectangle(201, 212, 0, 0));
		btnStart.setFocusable(false);
		lyrHome.setLayer(btnStart, 1);
		btnStart.setBounds(204, 212, 197, 77);
		lyrHome.add(btnStart);
		btnStart.setBackground(new Color(255, 215, 0));
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
		frmBOH.setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(paum==0) {
			try {
				FileInputStream fileInputStream = new FileInputStream("PeaceSign.mp3");
				Player player = new Player(fileInputStream);
				pPS = player;
				pPS.play();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
	
}