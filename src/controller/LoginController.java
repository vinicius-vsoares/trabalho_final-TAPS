package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import model.Aluno;
import model.Coordenador;
import model.Usuario;
import view.TelaMenu;
import view.TelaCadastro;
import view.TelaLogin;

public class LoginController implements ActionListener {
	private TelaLogin telaLogin;

	public LoginController(TelaLogin telaLogin) {
		super();
		this.telaLogin = telaLogin;
		this.telaLogin.getBtLimpar().addActionListener(this);
		this.telaLogin.getBtCadastro().addActionListener(this);
		this.telaLogin.getBtLogin().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpar")) {
			this.telaLogin.getTfUsuario().setText("");
			this.telaLogin.getTfSenha().setText("");
		}
		if (e.getActionCommand().equals("Cadastrar")) {
			this.telaLogin.setVisible(false);
			this.telaLogin.dispose();
			TelaCadastro telaCadastro = new TelaCadastro();
			new CadastroController(telaCadastro);
			telaCadastro.setVisible(true);
			telaCadastro.setLocationRelativeTo(null);
		}

		if (e.getActionCommand().equals("Logar")) {
			if (!this.telaLogin.getTfUsuario().getText().isEmpty()
					&& (!(this.telaLogin.getTfSenha().getPassword().length == 0))) {
				if (!this.telaLogin.getTfUsuario().getText().isEmpty()
						&& (!(this.telaLogin.getTfSenha().getPassword().length == 0))) {

					Usuario usuarioLogin = new Usuario();
					usuarioLogin.setIdUsuario(this.telaLogin.getTfUsuario().getText());
					usuarioLogin.setSenha(new String(this.telaLogin.getTfSenha().getPassword()));

					UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioLogin);
					Usuario usuario = usuarioDAO.login();
					TelaMenu telaMenu = new TelaMenu();
					telaMenu.setVisible(true);
					telaMenu.setLocationRelativeTo(null);
					telaLogin.dispose();

					if (usuario != null) {
						Aluno aluno = usuarioDAO.getAluno();
						if (aluno != null) {
							aluno.setIdUsuario(usuario.getIdUsuario());
							aluno.setNome(usuario.getNome());
							aluno.setSenha(usuario.getSenha());

							new MenuAlunoController(aluno, telaMenu);

						} else {

							// login coordenador

							Coordenador coordenador = new Coordenador();
							coordenador.setIdUsuario(usuario.getIdUsuario());
							coordenador.setNome(usuario.getNome());
							coordenador.setSenha(usuario.getSenha());

							new MenuCoordenadorController(coordenador, telaMenu);
						}

					} else {
						JOptionPane.showMessageDialog(telaLogin, "Senha ou matricula incorreto!", "Erro",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(telaLogin, "Existem campos vazios!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}

}
