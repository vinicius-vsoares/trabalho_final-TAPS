package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import modelo.Aluno;
import modelo.Coordenador;
import modelo.Usuario;
import view.TelaMenu;
import view.TelaCadastro;
import view.TelaLogin;

public class LoginController implements ActionListener {
	private TelaLogin tl;

	public LoginController(TelaLogin tl) {
		super();
		this.tl = tl;
		this.tl.getBtLimpar().addActionListener(this);
		this.tl.getBtCadastro().addActionListener(this);
		this.tl.getBtLogin().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpar")) {
			this.tl.getTfUsuario().setText("");
			this.tl.getTfSenha().setText("");
		}
		if (e.getActionCommand().equals("Cadastrar")) {
			this.tl.setVisible(false);
			this.tl.dispose();
			TelaCadastro tc = new TelaCadastro();
			new CadastroController(tc);
			tc.setVisible(true);
			tc.setLocationRelativeTo(null);
		}

		if (e.getActionCommand().equals("Logar")) {
			if (!this.tl.getTfUsuario().getText().isEmpty() && (!(this.tl.getTfSenha().getPassword().length == 0))) {
				if (!this.tl.getTfUsuario().getText().isEmpty()
						&& (!(this.tl.getTfSenha().getPassword().length == 0))) {

					Usuario usuarioLogin = new Usuario();
					usuarioLogin.setId_usuario(this.tl.getTfUsuario().getText());
					usuarioLogin.setSenha(new String(this.tl.getTfSenha().getPassword()));

					UsuarioDAO usDAO = new UsuarioDAO(usuarioLogin);
					Usuario usuario = usDAO.login();

					if (usuario != null) {
						Aluno aluno = usDAO.getAluno();
						if (aluno != null) {
							aluno.setId_usuario(usuario.getId_usuario());
							aluno.setNome(usuario.getNome());
							aluno.setSenha(usuario.getSenha());

							TelaMenu ma = new TelaMenu();
							ma.setVisible(true);
							ma.setLocationRelativeTo(null);
							tl.dispose();
							new MenuAlunoController(aluno, ma);

						} else {

							// login coordenador

							Coordenador coordenador = new Coordenador();
							coordenador.setId_usuario(usuario.getId_usuario());
							coordenador.setNome(usuario.getNome());
							coordenador.setSenha(usuario.getSenha());

							TelaMenu mn = new TelaMenu();
							mn.setVisible(true);
							mn.setLocationRelativeTo(null);
							tl.dispose();
							new MenuCoordenadorController(coordenador, mn);

						}

					} else {
						JOptionPane.showMessageDialog(tl, "Senha ou matricula incorreto!", "Erro",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(tl, "Existem campos vazios!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}

}
