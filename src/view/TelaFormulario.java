package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class TelaFormulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JLabel lblreaDoEstgio;
	private JTextField textArea;
	private JLabel lblNovarea;
	private JLabel lblComeamdoEm;
	private JComboBox<?> comboBoxDia;
	private JComboBox<?> comboBoxMes;
	private JComboBox<?> comboBoxAno;
	private JTextField textNovaArea;
	private JLabel lblTelefone;
	private JTextField textTelefone;
	private JLabel lblOutrasObservaes;
	private JLabel label;
	private Button Submit;
	private Button Clean;
	private JScrollPane scrollPane;
	private JTextArea Obs;
	private JMenuBar menuBar;
	private JMenuItem mntmSair,mntmPginaInicial, mntmSobre;
	private JTextField tfSerie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFormulario frame = new TelaFormulario();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFormulario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFormulario.class.getResource("/fig/icon_projeto.png")));
		setTitle("FORMUL\u00C1RIO PARA SOLICITA\u00C7\u00C3O DE TROCA DE M\u00D3DULO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][][][][grow][]"));
		
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
		
		JLabel lblNome = new JLabel("Nome: ");
		contentPane.add(lblNome, "flowx,cell 0 0,alignx leading");
		
		JLabel lblSrie = new JLabel("S\u00E9rie: ");
		contentPane.add(lblSrie, "flowx,cell 0 1,alignx leading");
		
		String[] items = {" ","1","2","3","4","5","6","7","8","9","10"};
		String [] dia = {" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
				"24","25","26","27","28","29","30","31"};
		String[] mes = {" ","Janeiro","Fevereiro","Março", "Abril", "Maio", "Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		String[] ano = {" ", "2019","2020","2021","2022","2023","2024", "2025"};
		
		lblComeamdoEm = new JLabel("Come\u00E7ando em:");
		contentPane.add(lblComeamdoEm, "flowx,cell 0 2");
		
		comboBoxDia = new JComboBox<Object>(dia);
		contentPane.add(comboBoxDia, "cell 0 2");
		
		comboBoxMes = new JComboBox<Object>(mes);
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {" ", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		contentPane.add(comboBoxMes, "cell 0 2");
		
		comboBoxAno = new JComboBox<Object>(ano);
		contentPane.add(comboBoxAno, "cell 0 2");
		
		textNome = new JTextField();
		contentPane.add(textNome, "cell 0 0,growx");
		textNome.setColumns(10);
		
		tfSerie = new JTextField();
		tfSerie.setEditable(false);
		contentPane.add(tfSerie, "cell 0 1");
		tfSerie.setColumns(5);
		
		lblreaDoEstgio = new JLabel("\u00C1rea do Est\u00E1gio: ");
		contentPane.add(lblreaDoEstgio, "cell 0 1,alignx trailing");
		
		textArea = new JTextField();
		contentPane.add(textArea, "cell 0 1,growx");
		textArea.setColumns(10);
		
		lblNovarea = new JLabel("Nova \u00C1rea: ");
		contentPane.add(lblNovarea, "flowx,cell 0 3,alignx leading");
		
		textNovaArea = new JTextField();
		contentPane.add(textNovaArea, "cell 0 3,growx");
		textNovaArea.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		contentPane.add(lblTelefone, "flowx,cell 0 4");
		
		textTelefone = new JTextField();
		contentPane.add(textTelefone, "cell 0 4");
		textTelefone.setColumns(10);
		
		label = new JLabel("                  ||                  ");
		contentPane.add(label, "cell 0 4");
		
		lblOutrasObservaes = new JLabel("Outras Observa\u00E7\u00F5es do Aluno:");
		contentPane.add(lblOutrasObservaes, "cell 0 4");
		
		Obs = new JTextArea();
		
		scrollPane = new JScrollPane(Obs);
		contentPane.add(scrollPane, "cell 0 5,grow");
		
		Clean = new Button("Limpar");
		contentPane.add(Clean, "flowx,cell 0 6,alignx trailing");
		
		Submit = new Button("Enviar");
		contentPane.add(Submit, "cell 0 6,alignx trailing");
		textNome.setEnabled(false);
		textNome.setEditable(false);
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}



	public JTextField getTfSerie() {
		return tfSerie;
	}

	public JTextField getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextField textArea) {
		this.textArea = textArea;
	}

	public JComboBox<?> getComboBoxDia() {
		return comboBoxDia;
	}

	public void setComboBoxDia(JComboBox<?> comboBoxDia) {
		this.comboBoxDia = comboBoxDia;
	}

	public JComboBox<?> getComboBoxMes() {
		return comboBoxMes;
	}

	public void setComboBoxMes(JComboBox<?> comboBoxMes) {
		this.comboBoxMes = comboBoxMes;
	}

	public JComboBox<?> getComboBoxAno() {
		return comboBoxAno;
	}

	public void setComboBoxAno(JComboBox<?> comboBoxAno) {
		this.comboBoxAno = comboBoxAno;
	}

	public JTextField getTextNovaArea() {
		return textNovaArea;
	}

	public void setTextNovaArea(JTextField textNovaArea) {
		this.textNovaArea = textNovaArea;
	}

	public JTextField getTextTelefone() {
		return textTelefone;
	}

	public void setTextTelefone(JTextField textTelefone) {
		this.textTelefone = textTelefone;
	}

	public Button getSubmit() {
		return Submit;
	}

	public void setSubmit(Button submit) {
		Submit = submit;
	}

	public Button getClean() {
		return Clean;
	}

	public void setClean(Button clean) {
		Clean = clean;
	}

	public JTextArea getObs() {
		return Obs;
	}

	public void setObs(JTextArea obs) {
		Obs = obs;
	}

	public JLabel getLblreaDoEstgio() {
		return lblreaDoEstgio;
	}

	public JLabel getLblNovarea() {
		return lblNovarea;
	}

	public JLabel getLblComeamdoEm() {
		return lblComeamdoEm;
	}

	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	public JLabel getLblOutrasObservaes() {
		return lblOutrasObservaes;
	}

	public JLabel getLabel() {
		return label;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public JMenuItem getMntmSair() {
		return mntmSair;
	}

	public JMenuItem getMntmPginaInicial() {
		return mntmPginaInicial;
	}

	public JMenuItem getMntmSobre() {
		return mntmSobre;
	}
	
	

	

}