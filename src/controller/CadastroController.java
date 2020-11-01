package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.AlunoDAO;
import model.Aluno;
import view.TelaCadastro;
import view.TelaLogin;

public class CadastroController implements ActionListener {
	private TelaCadastro telaCadastro;

	public CadastroController(TelaCadastro telaCadastro) {
		super();
		this.telaCadastro = telaCadastro;
		this.telaCadastro.getBtCadastro().addActionListener(this);
		this.telaCadastro.getBtLimpar().addActionListener(this);
		this.telaCadastro.getBtnRetornar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpar")) {
			this.telaCadastro.getTfMatricula().setText("");
			this.telaCadastro.getTfSenha().setText("");
			this.telaCadastro.getCbSerie().setSelectedIndex(0);
			this.telaCadastro.getTfNome().setText("");
		}

		if (e.getActionCommand().equals("Retornar")) {
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);
			this.telaCadastro.dispose();
		}

		if (e.getActionCommand().equals("Cadastrar")) {
			if (!this.telaCadastro.getTfMatricula().getText().isEmpty()
					&& (!(this.telaCadastro.getTfSenha().getPassword().length == 0))
					&& this.telaCadastro.getCbSerie().getSelectedIndex() != 0
					&& !this.telaCadastro.getTfNome().getText().isEmpty()
					&& !this.telaCadastro.getTfMatriculaCoor().getText().isEmpty()) {
				Aluno aluno = new Aluno();
				aluno.setIdUsuario(this.telaCadastro.getTfMatricula().getText());
				aluno.setSenha(new String(this.telaCadastro.getTfSenha().getPassword()));
				String getItem = String.valueOf(this.telaCadastro.getCbSerie().getSelectedItem());
				char serie = getItem.charAt(0);
				aluno.setSerie(Character.getNumericValue(serie));
				aluno.setIdUsuario(this.telaCadastro.getTfMatricula().getText());
				aluno.setNome(this.telaCadastro.getTfNome().getText());
				aluno.setMatriculaCoordenador(this.telaCadastro.getTfMatriculaCoor().getText());
				AlunoDAO alDAO = new AlunoDAO(aluno);

				if (this.telaCadastro.getTfMatricula().getText().length() <= 11
						&& this.telaCadastro.getTfSenha().getPassword().length <= 11) {

					boolean matriculaNum = this.telaCadastro.getTfMatricula().getText().chars()
							.allMatch(Character::isDigit);
					if (matriculaNum) {

						if (aluno.getSenha().length() >= 3) {

							if (alDAO.validaMatricula()) {

								if (alDAO.validaCoordenador()) {
									alDAO.insertAluno();
									if (alDAO.isUsuario()) {
										JOptionPane.showMessageDialog(telaCadastro, "Aluno cadastrado com sucesso!",
												"Sucesso", JOptionPane.INFORMATION_MESSAGE);
										this.telaCadastro.setVisible(false);
										this.telaCadastro.dispose();
										TelaLogin tl = new TelaLogin();
										new LoginController(tl);
										tl.setVisible(true);
										tl.setLocationRelativeTo(null);
									} else {
										JOptionPane.showMessageDialog(telaCadastro, "Erro ao cadastrar aluno!", "Erro",
												JOptionPane.WARNING_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(telaCadastro,
											"Matricula de coordenador não encontrada!", "Erro",
											JOptionPane.WARNING_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(telaCadastro, "Matrícula já cadastrada!", "Erro",
										JOptionPane.WARNING_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(telaCadastro,
									"Senha fraca. Por favor utilize uma senha mais forte!", "Erro",
									JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(telaCadastro, "A matrícula é composta por somente números!",
								"Erro", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(telaCadastro, "Senha ou matrícula muito grande. Tente novamente!",
							"Erro", JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(telaCadastro, "Existem campos não preenchidos!", "Erro",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
