package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import dao.FormularioDAO;
import modelo.Aluno;
import modelo.Formulario;
import view.TelaMenu;
import view.FormularioVisualizacaoAluno;
import view.Panel_Aluno_sem_Formularios;
import view.TelaFormulario;
import view.TelaLogin;
import view.TelaSobre;

public class MenuAlunoController implements ActionListener {
	private Aluno aluno;
	private TelaMenu ma;

	public MenuAlunoController(Aluno aluno, TelaMenu ma) {
		super();
		this.aluno = aluno;
		this.ma = ma;
		this.ma.getMntmSair().addActionListener(this);
		this.ma.getMntmPginaInicial().addActionListener(this);
		// this.ma.getMntmPerfil().addActionListener(this);
		this.ma.getMntmSobre().addActionListener(this);

		Formulario form = new Formulario();
		form.setAluno(aluno);
		FormularioDAO formDAO = new FormularioDAO(form);

		if (formDAO.possuiFormularioAluno()) {
			FormularioVisualizacaoAluno pva = new FormularioVisualizacaoAluno();
			pva.setLocationRelativeTo(null);
			pva.setVisible(true);
			this.ma.dispose();
			new FormularioVisualizacaoAlunoController(aluno, pva);

		} else {
			Panel_Aluno_sem_Formularios paF = new Panel_Aluno_sem_Formularios();
			paF.getBtCriarFormulário().addActionListener(this);
			this.ma.add(paF);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			aluno = null;
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);

			ma.dispose();
			JOptionPane.showMessageDialog(ma, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu ma2 = new TelaMenu();
			new MenuAlunoController(aluno, ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

		if (e.getActionCommand().equals("Criar formulário")) {
			TelaFormulario fa = new TelaFormulario();
			fa.setVisible(true);
			new FormularioCriacaoAlunoController(fa, aluno);
			fa.setLocationRelativeTo(null);
			this.ma.dispose();
		}

	}
}
