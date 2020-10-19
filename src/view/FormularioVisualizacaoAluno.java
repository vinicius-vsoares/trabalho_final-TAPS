package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class FormularioVisualizacaoAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldAreaEstagio;
	private JTextField textFieldNovaArea;
	private JTextField textFieldTelefone;
	private JTextField textFieldAreaAtual1;
	private JTextField textFieldAreaAtual2;
	private JTextField textFieldAreaTroca1;
	private JTable table;
	private JTextField textFieldAreaTroca2;
	private JTextField textFieldVagasAreaTroca2;
	private JTextField textFieldVagasAreaTroca;
	private JTextField textFieldVagasAreaAtual2;
	private JTextField textFieldVagasAreaAtual;
	private JTextField textFieldNroAlunosAreaAtual;
	private JTextField textFieldNroAlunosAreaAtual2;
	private JTextField textFieldNroAlunosAreaTroca;
	private JTextField textFieldNroAlunosAreaTroca2;
	private JMenuItem mntmSair,mntmPginaInicial, mntmSobre;
    private JComboBox<?> comboBoxDia,comboBoxAno,comboBoxMes;
    private JTextArea textAreaParecerAreasEnvolv;
    private JTextArea textAreaParecerCoordernador;
    private JTextArea textAreaObservacoes;
    private JTextField tfSerie;
    private Button Submit,Clean;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioVisualizacaoAluno frame = new FormularioVisualizacaoAluno();
					frame.setVisible(true);
					frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioVisualizacaoAluno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioVisualizacaoAluno.class.getResource("/fig/icon_projeto.png")));
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("FORMUL\u00C1RIO PARA SOLICITA\u00C7\u00C3O DE TROCA DE M\u00D3DULO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 500);
			
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][90px:n,fill][][120px:120px][][][][][][][][][][][][90px:n,grow][][90px:n][]"));
		
		JLabel lblNome = new JLabel("Nome:");
		panel.add(lblNome, "flowx,cell 0 0");
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		panel.add(textFieldNome, "cell 0 0,growx");
		textFieldNome.setColumns(10);
		
		JLabel lblSrie = new JLabel("S\u00E9rie:");
		panel.add(lblSrie, "flowx,cell 0 1");
		
		String[] items = {" ","1","2","3","4","5","6","7","8","9","10"};
		String [] dia = {" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
				"24","25","26","27","28","29","30","31"};
		String[] mes = {" ","Janeiro","Fevereiro","Março", "Abril", "Maio", "Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		String[] ano = {" ", "2019","2020","2021","2022","2023","2024", "2025"};
		
		tfSerie = new JTextField();
		tfSerie.setEditable(false);
		panel.add(tfSerie, "cell 0 1");
		tfSerie.setColumns(5);
		
		JLabel lblreaDoEstgio = new JLabel("\u00C1rea do Est\u00E1gio:");
		panel.add(lblreaDoEstgio, "cell 0 1");
		
		textFieldAreaEstagio = new JTextField();
		textFieldAreaEstagio.setEditable(false);
		panel.add(textFieldAreaEstagio, "cell 0 1,growx");
		textFieldAreaEstagio.setColumns(10);
		
		JLabel lblComeandoEm = new JLabel("Come\u00E7ando em");
		panel.add(lblComeandoEm, "flowx,cell 0 2");
		
		 comboBoxDia = new JComboBox<Object>(dia);
		 comboBoxDia.setEnabled(false);
		panel.add(comboBoxDia, "cell 0 2");
		
		comboBoxMes = new JComboBox<Object>(mes);
		comboBoxMes.setEnabled(false);
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {" ", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		panel.add(comboBoxMes, "cell 0 2");
		
		comboBoxAno = new JComboBox<Object>(ano);
		comboBoxAno.setEnabled(false);
		panel.add(comboBoxAno, "cell 0 2");
		
		JLabel lblNovarea = new JLabel("Nova \u00C1rea:");
		panel.add(lblNovarea, "flowx,cell 0 3");
		
		textFieldNovaArea = new JTextField();
		textFieldNovaArea.setEditable(false);
		panel.add(textFieldNovaArea, "cell 0 3,growx");
		textFieldNovaArea.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		panel.add(lblTelefone, "flowx,cell 0 4");
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setEditable(false);
		panel.add(textFieldTelefone, "cell 0 4");
		textFieldTelefone.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, "cell 0 5,grow");
		
		textAreaObservacoes = new JTextArea();
		textAreaObservacoes.setEditable(false);
		scrollPane_1.setViewportView(textAreaObservacoes);
		
		JLabel lblGradeDe = new JLabel("\uF076\tGrade de Est\u00E1gios do Doutorando:          ");
		lblGradeDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblGradeDe, "cell 0 6");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel.add(scrollPane_2, "cell 0 7,grow");
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", null, null, null},
				{"2", null, null, null},
				{"3", null, null, null},
				{"4", null, null, null},
				{"5", null, null, null},
				{"6", null, null, null},
				{"7", null, null, null},
			},
			new String[] {
				"M\u00F3dulo", "Per\u00EDodo", "\u00C1rea", "\u00C1rea Espec\u00EDfica (Med.Interna)"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(169);
		scrollPane_2.setViewportView(table);
		
		JLabel label_1 = new JLabel("\uF076\t\u00C1rea Atual do Aluno:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(label_1, "cell 0 8");
		
		JLabel label_2 = new JLabel("1)");
		panel.add(label_2, "flowx,cell 0 9");
		
		JLabel lblVagastotalDo = new JLabel("Vagas (total do M\u00F3dulo): ");
		panel.add(lblVagastotalDo, "flowx,cell 0 10");
		
		JLabel label_3 = new JLabel("2)");
		panel.add(label_3, "flowx,cell 0 11");
		
		JLabel lblVagastotalDo_1 = new JLabel("Vagas (total do M\u00F3dulo): ");
		panel.add(lblVagastotalDo_1, "flowx,cell 0 12");
		
		textFieldAreaAtual1 = new JTextField();
		textFieldAreaAtual1.setEnabled(false);
		panel.add(textFieldAreaAtual1, "cell 0 9,growx");
		textFieldAreaAtual1.setColumns(10);
		
		textFieldAreaAtual2 = new JTextField();
		textFieldAreaAtual2.setEnabled(false);
		panel.add(textFieldAreaAtual2, "cell 0 11,growx");
		textFieldAreaAtual2.setColumns(10);
		
		JLabel label_4 = new JLabel("\uF076\t\u00C1rea escolhida para troca:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(label_4, "cell 0 13");
		
		JLabel label_5 = new JLabel("1)");
		panel.add(label_5, "flowx,cell 0 14");
		
		textFieldAreaTroca1 = new JTextField();
		textFieldAreaTroca1.setEnabled(false);
		panel.add(textFieldAreaTroca1, "cell 0 14,growx");
		textFieldAreaTroca1.setColumns(10);
		
		JLabel label_6 = new JLabel("Vagas (total do M\u00F3dulo): ");
		panel.add(label_6, "flowx,cell 0 15");
		
		JLabel label_7 = new JLabel("2)");
		panel.add(label_7, "flowx,cell 0 16");
		
		JLabel label_8 = new JLabel("Vagas (total do M\u00F3dulo): ");
		panel.add(label_8, "flowx,cell 0 17");
		
		textFieldAreaTroca2 = new JTextField();
		textFieldAreaTroca2.setEnabled(false);
		panel.add(textFieldAreaTroca2, "cell 0 16,growx");
		textFieldAreaTroca2.setColumns(10);
		
		textFieldVagasAreaTroca2 = new JTextField();
		textFieldVagasAreaTroca2.setEnabled(false);
		panel.add(textFieldVagasAreaTroca2, "cell 0 17,growx");
		textFieldVagasAreaTroca2.setColumns(10);
		
		textFieldVagasAreaTroca = new JTextField();
		textFieldVagasAreaTroca.setEnabled(false);
		panel.add(textFieldVagasAreaTroca, "cell 0 15,growx");
		textFieldVagasAreaTroca.setColumns(10);
		
		textFieldVagasAreaAtual2 = new JTextField();
		textFieldVagasAreaAtual2.setEnabled(false);
		textFieldVagasAreaAtual2.setColumns(10);
		panel.add(textFieldVagasAreaAtual2, "cell 0 12,growx");
		
		textFieldVagasAreaAtual = new JTextField();
		textFieldVagasAreaAtual.setEnabled(false);
		textFieldVagasAreaAtual.setColumns(10);
		panel.add(textFieldVagasAreaAtual, "cell 0 10,growx");
		
		JLabel lblNmeroDeAlunos = new JLabel("N\u00FAmero de Alunos:");
		panel.add(lblNmeroDeAlunos, "cell 0 17");
		
		JLabel label_9 = new JLabel("N\u00FAmero de Alunos:");
		panel.add(label_9, "cell 0 15");
		
		JLabel label = new JLabel("N\u00FAmero de Alunos:");
		panel.add(label, "cell 0 12");
		
		JLabel label_10 = new JLabel("N\u00FAmero de Alunos:");
		panel.add(label_10, "cell 0 10");
		
		textFieldNroAlunosAreaAtual = new JTextField();
		textFieldNroAlunosAreaAtual.setEnabled(false);
		panel.add(textFieldNroAlunosAreaAtual, "cell 0 10,growx");
		textFieldNroAlunosAreaAtual.setColumns(10);
		
		textFieldNroAlunosAreaAtual2 = new JTextField();
		textFieldNroAlunosAreaAtual2.setEnabled(false);
		panel.add(textFieldNroAlunosAreaAtual2, "cell 0 12,growx");
		textFieldNroAlunosAreaAtual2.setColumns(10);
		
		textFieldNroAlunosAreaTroca = new JTextField();
		textFieldNroAlunosAreaTroca.setEnabled(false);
		panel.add(textFieldNroAlunosAreaTroca, "cell 0 15,growx");
		textFieldNroAlunosAreaTroca.setColumns(10);
		
		textFieldNroAlunosAreaTroca2 = new JTextField();
		textFieldNroAlunosAreaTroca2.setEnabled(false);
		panel.add(textFieldNroAlunosAreaTroca2, "cell 0 17,growx");
		textFieldNroAlunosAreaTroca2.setColumns(10);
		
		JLabel lblParecerDasreas = new JLabel("\uF076\tParecer das \u00E1reas envolvidas:");
		lblParecerDasreas.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblParecerDasreas, "cell 0 18");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel.add(scrollPane_3, "cell 0 19,grow");
		
		 textAreaParecerAreasEnvolv = new JTextArea();
		textAreaParecerAreasEnvolv.setEnabled(false);
		scrollPane_3.setViewportView(textAreaParecerAreasEnvolv);
		
		JLabel lblNewLabel = new JLabel("\uF076\tParecer do Coordenador do Curso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel, "cell 0 20");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel.add(scrollPane_4, "cell 0 21,grow");
		
		 textAreaParecerCoordernador = new JTextArea();
		textAreaParecerCoordernador.setEnabled(false);
		scrollPane_4.setViewportView(textAreaParecerCoordernador);
		
		JLabel lblOutrasObservaesDo = new JLabel("Outras observa\u00E7\u00F5es do aluno:");
		panel.add(lblOutrasObservaesDo, "cell 0 4,alignx trailing");
		Clean = new Button("Limpar");
		Clean.setName("Limpar");
		panel.add(Clean, "cell 0 22");
		Clean.setVisible(false);
		
		Submit = new Button("Enviar");
		Submit.setName("Enviar");
		panel.add(Submit, "cell 0 22");
		Submit.setVisible(false);
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldAreaEstagio() {
		return textFieldAreaEstagio;
	}

	public JTextField getTextFieldNovaArea() {
		return textFieldNovaArea;
	}

	public JTextField getTextFieldTelefone() {
		return textFieldTelefone;
	}

	public JTextField getTextFieldAreaAtual1() {
		return textFieldAreaAtual1;
	}

	public JTextField getTextFieldAreaAtual2() {
		return textFieldAreaAtual2;
	}

	public JTextField getTextFieldAreaTroca1() {
		return textFieldAreaTroca1;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTextFieldAreaTroca2() {
		return textFieldAreaTroca2;
	}

	public JTextField getTextFieldVagasAreaTroca2() {
		return textFieldVagasAreaTroca2;
	}

	public JTextField getTextFieldVagasAreaTroca() {
		return textFieldVagasAreaTroca;
	}

	public JTextField getTextFieldVagasAreaAtual2() {
		return textFieldVagasAreaAtual2;
	}

	public JTextField getTextFieldVagasAreaAtual() {
		return textFieldVagasAreaAtual;
	}

	public JTextField getTextFieldNroAlunosAreaAtual() {
		return textFieldNroAlunosAreaAtual;
	}

	public JTextField getTextFieldNroAlunosAreaAtual2() {
		return textFieldNroAlunosAreaAtual2;
	}

	public JTextField getTextFieldNroAlunosAreaTroca() {
		return textFieldNroAlunosAreaTroca;
	}

	public JTextField getTextFieldNroAlunosAreaTroca2() {
		return textFieldNroAlunosAreaTroca2;
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

	public JComboBox<?> getComboBoxDia() {
		return comboBoxDia;
	}

	public JComboBox<?> getComboBoxAno() {
		return comboBoxAno;
	}

	public JComboBox<?> getComboBoxMes() {
		return comboBoxMes;
	}

	public JTextArea getTextAreaParecerAreasEnvolv() {
		return textAreaParecerAreasEnvolv;
	}

	public JTextArea getTextAreaParecerCoordernador() {
		return textAreaParecerCoordernador;
	}

	public JTextArea getTextAreaObservacoes() {
		return textAreaObservacoes;
	}

	public JTextField getTfSerie() {
		return tfSerie;
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
	
	
}
