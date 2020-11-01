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
			limparCampos(telaLogin);
		}
		if (e.getActionCommand().equals("Cadastrar")) {

			TelaCadastro telaCadastro = new TelaCadastro();
			cadastro(telaLogin, telaCadastro);
		}

		if (e.getActionCommand().equals("Logar")) {
			if (!this.telaLogin.getTfUsuario().getText().isEmpty()
					&& (!(this.telaLogin.getTfSenha().getPassword().length == 0))) {
				if (!this.telaLogin.getTfUsuario().getText().isEmpty()
						&& (!(this.telaLogin.getTfSenha().getPassword().length == 0))) {

					Usuario usuarioLogin = new Usuario();
					logar(usuarioLogin, telaLogin);

				} else {
					JOptionPane.showMessageDialog(telaLogin, "Senha ou matricula incorreto!", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(telaLogin, "Existem campos vazios!", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void limparCampos(TelaLogin telaLogin) {
		telaLogin.getTfUsuario().setText("");
		telaLogin.getTfSenha().setText("");
	}

	public void cadastro(TelaLogin telaLogin, TelaCadastro telaCadastro) {
		telaLogin.setVisible(false);
		telaLogin.dispose();
		new CadastroController(telaCadastro);
		telaCadastro.setVisible(true);
		telaCadastro.setLocationRelativeTo(null);
	}

	public Usuario logar(Usuario usuarioLogin, TelaLogin telaLogin2) {
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
		}
		return usuario;
	}

}
