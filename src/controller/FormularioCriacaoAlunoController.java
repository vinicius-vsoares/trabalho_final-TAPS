package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.FormularioDAO;
import model.Aluno;
import model.Formulario;
import view.TelaFormulario;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaSobre;

public class FormularioCriacaoAlunoController implements ActionListener {
	private Formulario formulario;
	private TelaFormulario telaFormulario;
	private FormularioDAO formularioDAO;
	private Aluno aluno;

	public FormularioCriacaoAlunoController(TelaFormulario telaFormulario, Aluno aluno) {
		super();
		this.aluno = aluno;
		this.telaFormulario = telaFormulario;
		this.formulario = null;
		this.telaFormulario.getSubmit().addActionListener(this);
		this.telaFormulario.getClean().addActionListener(this);
		this.telaFormulario.getMntmSair().addActionListener(this);
		this.telaFormulario.getMntmPginaInicial().addActionListener(this);
		this.telaFormulario.getMntmSobre().addActionListener(this);

		this.telaFormulario.getTextNome().setText(aluno.getNome());
		this.telaFormulario.getTfSerie().setText(Integer.toString(aluno.getSerie()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Enviar")) {
			if (!this.telaFormulario.getTextArea().getText().isEmpty()
					&& !this.telaFormulario.getObs().getText().isEmpty()
					&& !this.telaFormulario.getTextTelefone().getText().isEmpty()
					&& this.telaFormulario.getComboBoxAno().getSelectedIndex() != 0
					&& this.telaFormulario.getComboBoxDia().getSelectedIndex() != 0
					&& this.telaFormulario.getComboBoxMes().getSelectedIndex() != 0
					&& !this.telaFormulario.getTextNovaArea().getText().isEmpty()) {

				String dia = Integer.toString(this.telaFormulario.getComboBoxDia().getSelectedIndex());
				String mes = Integer.toString(this.telaFormulario.getComboBoxMes().getSelectedIndex());
				String ano = this.telaFormulario.getComboBoxAno().getSelectedItem().toString();

				formulario = new Formulario();
				String data = ano + "-" + mes + "-" + dia;

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				System.out.println(data);
				System.out.println(dateFormat.format(date));
				this.formulario.setDataInicio(data);
				this.formulario.setData(dateFormat.format(date));
				this.formulario.setAreaAtual(this.telaFormulario.getTextArea().getText());
				this.formulario.setObservacao(this.telaFormulario.getObs().getText());
				this.formulario.setNovaArea(this.telaFormulario.getTextNovaArea().getText());
				this.formulario.setTelefone(this.telaFormulario.getTextTelefone().getText());
				this.formulario.setAluno(aluno);

				formularioDAO = new FormularioDAO(this.formulario);
				if (formularioDAO.insertForm()) {
					TelaMenu telaMenu = new TelaMenu();
					telaMenu.setVisible(true);
					this.telaFormulario.dispose();
					telaMenu.setLocationRelativeTo(null);
					new MenuAlunoController(aluno, telaMenu);
					JOptionPane.showMessageDialog(null, "Formulário cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao inserir. Tente novamente!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Existem campos não preenchidos!", "Erro",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

		if (e.getActionCommand().equals("Limpar")) {
			this.telaFormulario.getComboBoxAno().setSelectedIndex(0);
			this.telaFormulario.getComboBoxDia().setSelectedIndex(0);
			this.telaFormulario.getComboBoxMes().setSelectedIndex(0);
			this.telaFormulario.getTextNome().setText("");
			this.telaFormulario.getTextArea().setText("");
			this.telaFormulario.getTextNovaArea().setText("");
			this.telaFormulario.getTextTelefone().setText("");
			this.telaFormulario.getObs().setText("");
		}

		if (e.getActionCommand().equals("Sair")) {
			aluno = null;
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);
			this.telaFormulario.dispose();

			JOptionPane.showMessageDialog(null, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu ma2 = new TelaMenu();
			ma2.setVisible(true);
			this.telaFormulario.dispose();
			ma2.setLocationRelativeTo(null);
			new MenuAlunoController(aluno, ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

	}

}
