package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula;
	private JPasswordField tfSenha;
	private JButton btLogin, btCadastro, btLimpar;

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/fig/icon_projeto.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[167px,grow]", "[80px][grow][]"));
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "cell 0 1,grow");

		JLabel lblUsurio = new JLabel("Matricula");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblUsurio);

		tfMatricula = new JTextField();
		tfMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(tfMatricula);
		tfMatricula.setColumns(30);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblSenha);

		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfSenha.setColumns(30);
		panel.add(tfSenha);

		JLabel lbLoginMSG = new JLabel("Login de usu\u00E1rio");
		lbLoginMSG.setHorizontalAlignment(SwingConstants.LEFT);
		lbLoginMSG.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lbLoginMSG, "flowx,cell 0 0,alignx center,aligny center");

		JLabel lbIcon = new JLabel("");
		try {
			lbIcon.setIcon(new ImageIcon(
					ImageIO.read(TelaLogin.class.getResource("/fig/user_icon.png")).getScaledInstance(80, 80, 10)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(lbIcon, "cell 0 0,alignx right,aligny top");

		btLogin = new JButton("Logar");
		btLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/fig/login.png")));
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btLogin, "flowx,cell 0 2");

		btCadastro = new JButton("Cadastrar");
		btCadastro.setIcon(new ImageIcon(TelaLogin.class.getResource("/fig/add_user.png")));
		btCadastro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btCadastro, "cell 0 2");

		btLimpar = new JButton("Limpar");
		btLimpar.setIcon(new ImageIcon(TelaLogin.class.getResource("/fig/clean.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btLimpar, "cell 0 2,alignx center,aligny center");
	}

	public JTextField getTfUsuario() {
		return tfMatricula;
	}

	public JPasswordField getTfSenha() {
		return tfSenha;
	}

	public JButton getBtLogin() {
		return btLogin;
	}

	public JButton getBtCadastro() {
		return btCadastro;
	}

	public JButton getBtLimpar() {
		return btLimpar;
	}

}
