package MainScreens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModePick implements Runnable{

	JFrame frmMode;
	static Player pPS2= null;
	Thread tarefa;
	boolean btnAtivo = false;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPanel pnlSM;
	private JPanel pnlVS;
	int paum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModePick window = new ModePick();
					window.frmMode.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public ModePick() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmMode = new JFrame();
		frmMode.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tarefa = new Thread(ModePick.this);
				while(paum==0) {
					tarefa.start();
					paum = 1;
				}
			}
			@Override
			public void windowClosed(WindowEvent arg0) {
				tarefa.stop();
			}
		});
		frmMode.setIconImage(Toolkit.getDefaultToolkit().getImage(ModePick.class.getResource("/Imgs/Screen/icon5.png")));
		frmMode.setTitle("Battle of Heroes - Mode Select");
		frmMode.setBounds(new Rectangle(0, 0, 600, 300));
		frmMode.setResizable(false);
		frmMode.setBounds(100, 100, 606, 327);
		frmMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMode.getContentPane().setLayout(null);
		layeredPane.setBounds(0, 0, 600, 298);
		frmMode.getContentPane().add(layeredPane);
		frmMode.setLocationRelativeTo(null);
		
		pnlSM = new JPanel();
		pnlSM.setVisible(false);
		pnlSM.setBounds(10, 11, 288, 276);
		layeredPane.add(pnlSM);
		pnlSM.setBackground(new Color(179,0,0,175));
		layeredPane.setLayer(pnlSM, 1);
		pnlSM.setLayout(null);
		
		JLabel lblDescSM1 = new JLabel("Dive into the world of");
		lblDescSM1.setBounds(34, 5, 219, 25);
		lblDescSM1.setForeground(Color.WHITE);
		pnlSM.add(lblDescSM1);
		layeredPane.setLayer(lblDescSM1, 2);
		lblDescSM1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDescSM2 = new JLabel("Heros as Izuku Midoriya!");
		lblDescSM2.setBounds(18, 35, 252, 25);
		lblDescSM2.setForeground(Color.WHITE);
		pnlSM.add(lblDescSM2);
		layeredPane.setLayer(lblDescSM2, 2);
		lblDescSM2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDescSM3 = new JLabel("Train with the number");
		lblDescSM3.setBounds(30, 65, 227, 25);
		lblDescSM3.setForeground(Color.WHITE);
		pnlSM.add(lblDescSM3);
		layeredPane.setLayer(lblDescSM3, 2);
		lblDescSM3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDescSM4 = new JLabel("1 Hero: All-Might\r\n!");
		lblDescSM4.setBounds(54, 95, 180, 25);
		lblDescSM4.setForeground(Color.WHITE);
		pnlSM.add(lblDescSM4);
		layeredPane.setLayer(lblDescSM4, 2);
		lblDescSM4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDescSM5 = new JLabel("Grow to become a");
		lblDescSM5.setBounds(52, 125, 183, 25);
		lblDescSM5.setForeground(Color.WHITE);
		pnlSM.add(lblDescSM5);
		layeredPane.setLayer(lblDescSM5, 2);
		lblDescSM5.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDescSM6 = new JLabel("strong Hero!");
		lblDescSM6.setBounds(81, 155, 126, 25);
		lblDescSM6.setForeground(Color.WHITE);
		pnlSM.add(lblDescSM6);
		layeredPane.setLayer(lblDescSM6, 2);
		lblDescSM6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		pnlVS = new JPanel();
		pnlVS.setVisible(false);
		pnlVS.setBounds(10, 11, 288, 276);
		layeredPane.add(pnlVS);
		pnlVS.setBackground(new Color(179,0,0,175));
		layeredPane.setLayer(pnlVS, 1);
		pnlVS.setLayout(null);
		
		JLabel lblDescVS1 = new JLabel("Battle against CPU's");
		lblDescVS1.setBounds(42, 5, 203, 25);
		lblDescVS1.setForeground(Color.WHITE);
		pnlVS.add(lblDescVS1);
		lblDescVS1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDescVS2 = new JLabel("or against your friends");
		lblDescVS2.setBounds(29, 35, 230, 25);
		lblDescVS2.setForeground(Color.WHITE);
		lblDescVS2.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlVS.add(lblDescVS2);
		
		JLabel lblDescVS3 = new JLabel("in VS mode!");
		lblDescVS3.setBounds(83, 65, 121, 25);
		lblDescVS3.setForeground(Color.WHITE);
		lblDescVS3.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlVS.add(lblDescVS3);
		
		JLabel lblDescVS4 = new JLabel("Choose any Hero available");
		lblDescVS4.setBounds(11, 95, 266, 25);
		lblDescVS4.setForeground(Color.WHITE);
		lblDescVS4.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlVS.add(lblDescVS4);
		
		JLabel lblDescVS5 = new JLabel("and fight against others");
		lblDescVS5.setBounds(23, 125, 242, 25);
		lblDescVS5.setForeground(Color.WHITE);
		lblDescVS5.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlVS.add(lblDescVS5);
		
		JLabel lblDescVS6 = new JLabel("for 1st place!");
		lblDescVS6.setBounds(77, 155, 133, 25);
		lblDescVS6.setForeground(Color.WHITE);
		lblDescVS6.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlVS.add(lblDescVS6);
		
		JButton btnSM = new JButton("Story Mode");
		btnSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMode.dispose();
				StoryMode.main(null);
				pPS2.close();
				tarefa.stop();
			}
		});
		btnSM.setForeground(Color.WHITE);
		btnSM.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnSM.setFocusable(false);
		btnSM.setBackground(new Color(179,0,0,250));
		layeredPane.setLayer(btnSM, 2);
		btnSM.setBounds(338, 11, 252, 58);
		layeredPane.add(btnSM);
		
		JButton btnVS = new JButton("VS Mode");
		btnVS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		layeredPane.setLayer(btnVS, 2);
		btnVS.setForeground(Color.WHITE);
		btnVS.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnVS.setFocusable(false);
		btnVS.setBackground(new Color(179, 0, 0, 250));
		btnVS.setBounds(338, 117, 252, 58);
		layeredPane.add(btnVS);
		
		JButton btnOP = new JButton("One Player");
		btnOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMode.setVisible(false);
				PlayerChoose.main(null);
			}
		});
		btnOP.setFocusable(false);
		btnOP.setVisible(false);
		btnOP.setForeground(Color.WHITE);
		btnOP.setFont(new Font("Segoe Print", Font.BOLD, 20));
		layeredPane.setLayer(btnOP, 1);
		btnOP.setBounds(92, 11, 416, 73);
		layeredPane.add(btnOP);
		btnOP.setBackground(new Color(179,0,0,250));
		
		JButton btnTP = new JButton("Two Player");
		btnTP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		layeredPane.setLayer(btnTP, 1);
		btnTP.setVisible(false);
		btnTP.setForeground(Color.WHITE);
		btnTP.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnTP.setFocusable(false);
		btnTP.setBackground(new Color(179, 0, 0, 250));
		btnTP.setBounds(92, 110, 416, 73);
		layeredPane.add(btnTP);
		
		JButton btnBack = new JButton("Back");
		btnBack.setVisible(false);
		layeredPane.setLayer(btnBack, 1);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnBack.setFocusable(false);
		btnBack.setBackground(new Color(179, 0, 0, 250));
		btnBack.setBounds(92, 214, 416, 73);
		layeredPane.add(btnBack);
		
		JLabel lblSM = new JLabel("");
		lblSM.setVisible(false);
		layeredPane.setLayer(lblSM, 1);
		lblSM.setIcon(new ImageIcon(ModePick.class.getResource("/Imgs/Screen/sm.png")));
		lblSM.setBounds(24, 11, 288, 276);
		layeredPane.add(lblSM);
		
				JLabel lblVS = new JLabel("");
				lblVS.setVisible(false);
				lblVS.setIcon(new ImageIcon(ModePick.class.getResource("/Imgs/Screen/vs.png")));
				layeredPane.setLayer(lblVS, 1);
				lblVS.setBounds(24, 11, 288, 276);
				layeredPane.add(lblVS);
				
				JLabel lblBGMS = new JLabel("");
				lblBGMS.setIcon(new ImageIcon(ModePick.class.getResource("/Imgs/Screen/gifBG3.gif")));
				lblBGMS.setBounds(0, 0, 600, 298);
				layeredPane.add(lblBGMS);
				
				JPanel pnlDef = new JPanel();
				pnlDef.setBackground(new Color(179,0,0,175));
				layeredPane.setLayer(pnlDef, 2);
				pnlDef.setBounds(10, 11, 288, 276);
				layeredPane.add(pnlDef);
				pnlDef.setLayout(null);
		
		btnSM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlVS.setVisible(false);
				lblVS.setVisible(false);
				pnlSM.setVisible(true);
				lblSM.setVisible(true);
				pnlDef.setVisible(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnAtivo == false) {
					pnlSM.setVisible(false);
					lblSM.setVisible(false);
					pnlVS.setVisible(false);
					lblVS.setVisible(false);
					pnlDef.setVisible(true);
				}
			}
		});
		
		
		btnVS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlSM.setVisible(false);
				lblSM.setVisible(false);
				pnlVS.setVisible(true);
				lblVS.setVisible(true);
				pnlDef.setVisible(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnAtivo == false) {
					pnlSM.setVisible(false);
					lblSM.setVisible(false);
					pnlVS.setVisible(false);
					lblVS.setVisible(false);
					pnlDef.setVisible(true);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAtivo = true;
				pnlSM.setVisible(false);
				lblSM.setVisible(false);
				pnlVS.setVisible(false);
				lblVS.setVisible(false);
				pnlDef.setVisible(false);
				btnSM.setVisible(false);
				btnVS.setVisible(false);
				
				btnOP.setVisible(true);
				btnTP.setVisible(true);
				btnBack.setVisible(true);
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnAtivo == false) {
					pnlDef.setVisible(true);
				}
					btnSM.setVisible(true);
					btnVS.setVisible(true);
				
					btnOP.setVisible(false);
					btnTP.setVisible(false);
					btnBack.setVisible(false);
					btnAtivo =  false;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnAtivo = false;
			}
		});
		
	}


	@Override
	public void run() {
		while(true) {
			try {
				FileInputStream fileInputStream = new FileInputStream("PeaceSign.mp3");
				Player player2 = new Player(fileInputStream);	
				pPS2 = player2;
				pPS2.play();			
			} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			}catch(JavaLayerException e2) {
					e2.printStackTrace();
			}	
		}		
	}
}