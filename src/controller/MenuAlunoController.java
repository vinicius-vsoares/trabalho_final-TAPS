package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import dao.FormularioDAO;
import model.Aluno;
import model.Formulario;
import view.TelaMenu;
import view.FormularioVisualizacaoAluno;
import view.PanelAlunoSemFormularios;
import view.TelaFormulario;
import view.TelaLogin;
import view.TelaSobre;

public class MenuAlunoController implements ActionListener {
	private Aluno aluno;
	private TelaMenu telaMenu;

	public MenuAlunoController(Aluno aluno, TelaMenu telaMenu) {
		super();
		this.aluno = aluno;
		this.telaMenu = telaMenu;
		this.telaMenu.getMntmSair().addActionListener(this);
		this.telaMenu.getMntmPginaInicial().addActionListener(this);
		// this.ma.getMntmPerfil().addActionListener(this);
		this.telaMenu.getMntmSobre().addActionListener(this);

		Formulario formulario = new Formulario();
		formulario.setAluno(aluno);
		FormularioDAO formularioDAO = new FormularioDAO(formulario);

		if (formularioDAO.alunoPossuiFormulario()) {
			FormularioVisualizacaoAluno formularioVisualizacaoAluno = new FormularioVisualizacaoAluno();
			formularioVisualizacaoAluno.setLocationRelativeTo(null);
			formularioVisualizacaoAluno.setVisible(true);
			this.telaMenu.dispose();
			new FormularioVisualizacaoAlunoController(aluno, formularioVisualizacaoAluno);
		} else {
			PanelAlunoSemFormularios panelAlunoSemFormularios = new PanelAlunoSemFormularios();
			panelAlunoSemFormularios.getBtCriarFormulário().addActionListener(this);
			this.telaMenu.add(panelAlunoSemFormularios);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			aluno = null;
			TelaLogin telaLogin = new TelaLogin();
			telaLogin.setVisible(true);
			telaLogin.setLocationRelativeTo(null);
			new LoginController(telaLogin);

			telaMenu.dispose();
			JOptionPane.showMessageDialog(telaMenu, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu telaMenu = new TelaMenu();
			new MenuAlunoController(aluno, telaMenu);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre telaSobre = new TelaSobre();
			telaSobre.setVisible(true);
			telaSobre.setLocationRelativeTo(null);
		}

		if (e.getActionCommand().equals("Criar formulário")) {
			TelaFormulario telaCriacaoFormulario = new TelaFormulario();
			telaCriacaoFormulario.setVisible(true);
			new FormularioCriacaoAlunoController(telaCriacaoFormulario, aluno);
			telaCriacaoFormulario.setLocationRelativeTo(null);
			this.telaMenu.dispose();
		}

	}
}
