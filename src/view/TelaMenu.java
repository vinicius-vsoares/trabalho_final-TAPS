package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class TelaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmSair,mntmPginaInicial, mntmSobre;

	/**
	 * Create the frame.
	 */
	public TelaMenu() {
		setResizable(false);
		setTitle("P\u00E1gina inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenu.class.getResource("/fig/icon_projeto.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		try {
			mnMenu.setIcon(new ImageIcon(ImageIO.read(TelaMenu.class.getResource("/fig/menu_icon.png")).getScaledInstance(13, 13, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuBar.add(mnMenu);
		
		mntmPginaInicial = new JMenuItem("P\u00E1gina inicial");
		try {
			mntmPginaInicial.setIcon(new ImageIcon(ImageIO.read(TelaMenu.class.getResource("/fig/homepage.png")).getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mntmPginaInicial.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmPginaInicial);
		
		
		mntmSair = new JMenuItem("Sair");
		try {
			mntmSair.setIcon(new ImageIcon(ImageIO.read(TelaMenu.class.getResource("/fig/exit.png")).getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mntmSair.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmSair);
		
		mntmSobre = new JMenuItem("Sobre");
		try {
			mntmSobre.setIcon(new ImageIcon(ImageIO.read(TelaMenu.class.getResource("/fig/about.png")).getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mntmSobre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

//	public JMenuItem getMntmPerfil() {
//		return mntmPerfil;
//	}

	public JMenuItem getMntmPginaInicial() {
		return mntmPginaInicial;
	}

	public JMenuItem getMntmSobre() {
		return mntmSobre;
	}
	
	

	
}
