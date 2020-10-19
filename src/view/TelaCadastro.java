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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula;
	private JPasswordField tfSenha;
	private JButton btCadastro, btLimpar;
	private JComboBox<String> cbSerie;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblMatriculaCoordenador;
	private JTextField tfMatriculaCoor;
	private JButton btnRetornar;

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/fig/icon_projeto.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[167px,grow]", "[80px][grow][]"));
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[243px,grow][][5px][46px]", "[19px][25px][19px][25px][25px][25px][][][]"));

		lblNome = new JLabel("Nome completo");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNome, "cell 0 0 4 1,alignx center,aligny top");

		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNome.setColumns(30);
		panel.add(tfNome, "cell 0 1 4 1,alignx center,aligny top");

		JLabel lblUsurio = new JLabel("Matricula aluno");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblUsurio, "cell 0 2 4 1,alignx center,aligny top");

		tfMatricula = new JTextField();
		tfMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(tfMatricula, "cell 0 3 4 1,alignx center,aligny top");
		tfMatricula.setColumns(30);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblSenha, "flowx,cell 0 4 4 1,alignx center,aligny center");

		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfSenha.setColumns(30);
		panel.add(tfSenha, "cell 0 5 4 1,alignx center,aligny top");

		lblMatriculaCoordenador = new JLabel("Matricula coordenador");
		lblMatriculaCoordenador.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblMatriculaCoordenador, "cell 0 6 4 1,alignx center");

		tfMatriculaCoor = new JTextField();
		tfMatriculaCoor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfMatriculaCoor.setColumns(30);
		panel.add(tfMatriculaCoor, "cell 0 7 4 1,alignx center");

		JLabel lblNewLabel = new JLabel("   S\u00E9rie:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel, "flowx,cell 0 8,aligny center");

		cbSerie = new JComboBox<String>();
		cbSerie.setMaximumRowCount(7);
		cbSerie.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Selecione", "6\u00BA", "7\u00BA", "8\u00BA", "9\u00BA", "10\u00BA" }));
		cbSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(cbSerie, "cell 0 8 4 1,aligny top");

		JLabel lbLoginMSG = new JLabel("Novo usu\u00E1rio");
		lbLoginMSG.setHorizontalAlignment(SwingConstants.LEFT);
		lbLoginMSG.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lbLoginMSG, "flowx,cell 0 0,alignx center,aligny center");

		JLabel lbIcon = new JLabel("");
		try {
			lbIcon.setIcon(new ImageIcon(
					ImageIO.read(TelaCadastro.class.getResource("/fig/user_icon.png")).getScaledInstance(80, 80, 10)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(lbIcon, "cell 0 0,growy");

		btCadastro = new JButton("Cadastrar");
		btCadastro.setIcon(new ImageIcon(TelaCadastro.class.getResource("/fig/add_user.png")));
		btCadastro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btCadastro, "flowx,cell 0 2");

		btLimpar = new JButton("Limpar");
		btLimpar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/fig/clean.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btLimpar, "cell 0 2,alignx center,aligny center");
		
		btnRetornar = new JButton("Retornar");
		btnRetornar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/fig/icons8-retornar-24.png")));
		btnRetornar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnRetornar, "cell 0 2,alignx center,aligny center");
	}
	
	

	public JButton getBtnRetornar() {
		return btnRetornar;
	}

	public JTextField getTfMatricula() {
		return tfMatricula;
	}

	public void setTfMatricula(JTextField tfMatricula) {
		this.tfMatricula = tfMatricula;
	}

	public JPasswordField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(JPasswordField tfSenha) {
		this.tfSenha = tfSenha;
	}

	public JButton getBtCadastro() {
		return btCadastro;
	}

	public void setBtCadastro(JButton btCadastro) {
		this.btCadastro = btCadastro;
	}

	public JButton getBtLimpar() {
		return btLimpar;
	}

	public void setBtLimpar(JButton btLimpar) {
		this.btLimpar = btLimpar;
	}

	public JComboBox<String> getCbSerie() {
		return cbSerie;
	}

	public void setCbSerie(JComboBox<String> cbSerie) {
		this.cbSerie = cbSerie;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfMatriculaCoor() {
		return tfMatriculaCoor;
	}
	
}
