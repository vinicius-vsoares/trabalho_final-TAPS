package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.AlunoDAO;
import modelo.Aluno;
import view.TelaCadastro;
import view.TelaLogin;

public class CadastroController implements ActionListener {
	private TelaCadastro tc;

	public CadastroController(TelaCadastro tc) {
		super();
		this.tc = tc;
		this.tc.getBtCadastro().addActionListener(this);
		this.tc.getBtLimpar().addActionListener(this);
		this.tc.getBtnRetornar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpar")) {
			this.tc.getTfMatricula().setText("");
			this.tc.getTfSenha().setText("");
			this.tc.getCbSerie().setSelectedIndex(0);
			this.tc.getTfNome().setText("");
		}

		if (e.getActionCommand().equals("Retornar")) {
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);
			this.tc.dispose();
		}

		if (e.getActionCommand().equals("Cadastrar")) {
			if (!this.tc.getTfMatricula().getText().isEmpty() && (!(this.tc.getTfSenha().getPassword().length == 0))
					&& this.tc.getCbSerie().getSelectedIndex() != 0 && !this.tc.getTfNome().getText().isEmpty()
					&& !this.tc.getTfMatriculaCoor().getText().isEmpty()) {
				Aluno aluno = new Aluno();
				aluno.setId_usuario(this.tc.getTfMatricula().getText());
				aluno.setSenha(new String(this.tc.getTfSenha().getPassword()));
				String aux = String.valueOf(this.tc.getCbSerie().getSelectedItem());
				char aux2 = aux.charAt(0);
				aluno.setSerie(Character.getNumericValue(aux2));
				aluno.setId_usuario(this.tc.getTfMatricula().getText());
				aluno.setNome(this.tc.getTfNome().getText());
				aluno.setMatricula_coord(this.tc.getTfMatriculaCoor().getText());
				AlunoDAO alDAO = new AlunoDAO(aluno);

				if (this.tc.getTfMatricula().getText().length() <= 11
						&& this.tc.getTfSenha().getPassword().length <= 11) {

					boolean matriculaNum = this.tc.getTfMatricula().getText().chars().allMatch(Character::isDigit);
					if (matriculaNum) {

						if (aluno.getSenha().length() >= 3) {

							if (alDAO.validaMatricula()) {

								if (alDAO.validaCoordenador()) {
									alDAO.insertAluno();
									if (alDAO.isUsuario()) {
										JOptionPane.showMessageDialog(tc, "Aluno cadastrado com sucesso!", "Sucesso",
												JOptionPane.INFORMATION_MESSAGE);
										this.tc.setVisible(false);
										this.tc.dispose();
										TelaLogin tl = new TelaLogin();
										new LoginController(tl);
										tl.setVisible(true);
										tl.setLocationRelativeTo(null);
									} else {
										JOptionPane.showMessageDialog(tc, "Erro ao cadastrar aluno!", "Erro",
												JOptionPane.WARNING_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(tc, "Matricula de coordenador não encontrada!",
											"Erro", JOptionPane.WARNING_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(tc, "Matrícula já cadastrada!", "Erro",
										JOptionPane.WARNING_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(tc, "Senha fraca. Por favor utilize uma senha mais forte!",
									"Erro", JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(tc, "A matrícula é composta por somente números!", "Erro",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(tc, "Senha ou matrícula muito grande. Tente novamente!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(tc, "Existem campos não preenchidos!", "Erro",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
