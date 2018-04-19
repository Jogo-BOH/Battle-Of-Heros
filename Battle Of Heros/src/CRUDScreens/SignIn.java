package CRUDScreens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SignIn {

	public static JFrame frmSign;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frmSign.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSign = new JFrame();
		frmSign.setTitle("Battle Of Heros - Sign In");
		frmSign.setIconImage(Toolkit.getDefaultToolkit().getImage(SignIn.class.getResource("/Imgs/Screen/icon5.png")));
		frmSign.setBounds(100, 100, 450, 300);
		frmSign.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSign.getContentPane().setLayout(null);
		frmSign.setResizable(false);
		frmSign.setLocationRelativeTo(null);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(SignIn.class.getResource("/Imgs/Screen/gifBG3.gif")));
		lblBG.setBounds(0, 0, 444, 271);
		frmSign.getContentPane().add(lblBG);
	}
}