package MainScreens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerChoose {

	private JFrame frmCS;
	private JButton btnAoyama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerChoose window = new PlayerChoose();
					window.frmCS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerChoose() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCS = new JFrame();
		frmCS.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Programa\u00E7\u00E3o\\BNH PROJECT\\Imgs BNH\\Screen\\icon5.png"));
		frmCS.setTitle("Battle of Heros - Character Select");
		frmCS.setBounds(new Rectangle(0, 0, 1000, 0));
		frmCS.setBounds(100, 100, 814, 630);
		frmCS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCS.getContentPane().setLayout(null);
		frmCS.setLocationRelativeTo(null);
		
		JLabel lblChosen = new JLabel("");
		lblChosen.setBounds(0, 0, 350, 591);
		frmCS.getContentPane().add(lblChosen);
		lblChosen.setVisible(true);
		lblChosen.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pnlBtn = new JPanel();
		pnlBtn.setBounds(370, 0, 418, 580);
		frmCS.getContentPane().add(pnlBtn);
		pnlBtn.setLayout(null);
		pnlBtn.setBackground(new Color(0,0,0,0));
		
		JButton btnAsui = new JButton("");
		btnAsui.setToolTipText("Tsuyu Asui");
		btnAsui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Asui Imgs/as_c.png")));
			}
		});
		btnAsui.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/asuibtn.png")));
		btnAsui.setFocusable(false);
		btnAsui.setBounds(0, 11, 72, 71);
		pnlBtn.add(btnAsui);
		
		btnAoyama = new JButton("");
		btnAoyama.setToolTipText("Yuga Aoyama");
		btnAoyama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Aoyama Imgs/ao_c2.png")));
			}
		});
		btnAoyama.setBackground(new Color(240,240,240));
		btnAoyama.setForeground(Color.BLACK);
		btnAoyama.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/aoyamabtn.png")));
		btnAoyama.setFocusable(false);
		btnAoyama.setBounds(82, 11, 72, 71);
		pnlBtn.add(btnAoyama);
		
		JButton btnBakugo = new JButton("");
		btnBakugo.setToolTipText("Katsuki Bakugo");
		btnBakugo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Bakugo Imgs/bkg_pos_c.png")));
			}
		});
		btnBakugo.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/bakugobtn.png")));
		btnBakugo.setFocusable(false);
		btnBakugo.setBounds(164, 11, 72, 71);
		pnlBtn.add(btnBakugo);
		
		JButton btnIida = new JButton("");
		btnIida.setToolTipText("Tenya Iida");
		btnIida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Iida Imgs/id_slct.png")));
			}
		});
		btnIida.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/iidabtn.png")));
		btnIida.setFocusable(false);
		btnIida.setBounds(246, 11, 72, 71);
		pnlBtn.add(btnIida);
		
		JButton btnIzuku = new JButton("");
		btnIzuku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Izuku Imgs/izk_2c.png")));
			}
		});
		btnIzuku.setToolTipText("Izuku Midoriya");
		btnIzuku.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/izukubtn.png")));
		btnIzuku.setFocusable(false);
		btnIzuku.setBounds(326, 11, 72, 71);
		pnlBtn.add(btnIzuku);
		
		JButton btnOjiro = new JButton("");
		btnOjiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Ojiro Imgs/ojr_c2.png")));
			}
		});
		btnOjiro.setToolTipText("Mashirao Ojiro");
		btnOjiro.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/ojirobtn.png")));
		btnOjiro.setFocusable(false);
		btnOjiro.setBounds(0, 93, 72, 71);
		pnlBtn.add(btnOjiro);
		
		JButton btnSato = new JButton("");
		btnSato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Sato Imgs/sto_c.png")));
			}
		});
		btnSato.setToolTipText("Rikido Sato");
		btnSato.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/satobtn.png")));
		btnSato.setFocusable(false);
		btnSato.setBounds(82, 93, 72, 71);
		pnlBtn.add(btnSato);
		
		JButton btnShoji = new JButton("");
		btnShoji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Shoji Imgs/shj_c.png")));

			}
		});
		btnShoji.setToolTipText("Mezo Shoji");
		btnShoji.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/shojiBtn.png")));
		btnShoji.setFocusable(false);
		btnShoji.setBounds(164, 93, 72, 71);
		pnlBtn.add(btnShoji);
		
		JButton btnTokoyami = new JButton("");
		btnTokoyami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Tokoyami Imgs/tky_c.png")));

			}
		});
		btnTokoyami.setToolTipText("Fumikage Tokoyami");
		btnTokoyami.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/tokoyamibtn.png")));
		btnTokoyami.setFocusable(false);
		btnTokoyami.setBounds(246, 93, 72, 71);
		pnlBtn.add(btnTokoyami);
		
		JButton btnUraraka = new JButton("");
		btnUraraka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Ochaco Imgs/urk_c.png")));
			}
		});
		btnUraraka.setToolTipText("Ochaco Uraraka");
		btnUraraka.setIcon(new ImageIcon(PlayerChoose.class.getResource("/unlockedBtn/ochacobtn.png")));
		btnUraraka.setFocusable(false);
		btnUraraka.setBounds(326, 93, 72, 71);
		pnlBtn.add(btnUraraka);
		
		JButton btnAshido = new JButton("");
		btnAshido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Mina Imgs/min_c.png")));
			}
		});
		btnAshido.setToolTipText("Mina Ashido");
		btnAshido.setFocusable(false);
		btnAshido.setBounds(0, 175, 72, 71);
		pnlBtn.add(btnAshido);
		
		JButton btnHagakure = new JButton("");
		btnHagakure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Hagakure Imgs/hgk_c2.png")));
			}
		});
		btnHagakure.setToolTipText("Toru Hagakure");
		btnHagakure.setFocusable(false);
		btnHagakure.setBounds(82, 175, 72, 71);
		pnlBtn.add(btnHagakure);
		
		JButton btnJiro = new JButton("");
		btnJiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Jirou Imgs/jir_c1.png")));
			}
		});
		btnJiro.setToolTipText("Kyoka Jiro");
		btnJiro.setFocusable(false);
		btnJiro.setBounds(164, 175, 72, 71);
		pnlBtn.add(btnJiro);
		
		JButton btnKoda = new JButton("");
		btnKoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Kouda Imgs/koj_c.png")));
			}
		});
		btnKoda.setToolTipText("Koji Koda");
		btnKoda.setFocusable(false);
		btnKoda.setBounds(246, 175, 72, 71);
		pnlBtn.add(btnKoda);
		
		JButton btnSero = new JButton("");
		btnSero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon(PlayerChoose.class.getResource("/Imgs/Student Imgs/ClassA imgs/Sero Imgs/sro_c.png")));
			}
		});
		btnSero.setToolTipText("Hanta Sero");
		btnSero.setFocusable(false);
		btnSero.setBounds(326, 175, 72, 71);
		pnlBtn.add(btnSero);
		
		JButton btnShiozaki = new JButton("");
		btnShiozaki.setToolTipText("Ibara Shiozaki");
		btnShiozaki.setFocusable(false);
		btnShiozaki.setBounds(0, 257, 72, 71);
		pnlBtn.add(btnShiozaki);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setBounds(0, 339, 72, 71);
		pnlBtn.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setFocusable(false);
		btnNewButton_7.setBounds(0, 421, 72, 71);
		pnlBtn.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setFocusable(false);
		btnNewButton_8.setBounds(0, 503, 72, 71);
		pnlBtn.add(btnNewButton_8);
		
		JButton btnNatsu = new JButton("");
		btnNatsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChosen.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\ntu2.png"));
			}
		});
		btnNatsu.setToolTipText("Natsu Dragneel");
		btnNatsu.setFocusable(false);
		btnNatsu.setBounds(326, 503, 72, 71);
		pnlBtn.add(btnNatsu);
		
		JLabel lblBGCS = new JLabel("");
		lblBGCS.setBounds(0, 0, 984, 591);
		frmCS.getContentPane().add(lblBGCS);
		lblBGCS.setIcon(new ImageIcon("D:\\Programa\u00E7\u00E3o\\BNH PROJECT\\Imgs BNH\\Screen\\gifBG3.gif"));
	}
}