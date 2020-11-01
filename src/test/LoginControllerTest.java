package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import dao.CoordenadorDAO;
import model.Coordenador;
import model.Usuario;
import view.TelaCadastro;
import view.TelaLogin;

public class LoginControllerTest {
	@Test
	public void deveLimparCampos() {
		TelaLogin telaLogin = new TelaLogin();
		LoginController loginController = new LoginController(telaLogin);
		telaLogin.getTfUsuario().setText("Teste");
		telaLogin.getTfSenha().setText("Teste");

		loginController.limparCampos(telaLogin);

		boolean teste;
		if (telaLogin.getTfUsuario().getText().isEmpty() && telaLogin.getTfSenha().getPassword().length == 0) {
			teste = true;
		} else
			teste = false;

		assertEquals(true, teste);
	}

	@Test
	public void abreTelaCadastro() {
		TelaLogin telaLogin = new TelaLogin();
		LoginController loginController = new LoginController(telaLogin);
		TelaCadastro telaCadastro = new TelaCadastro();
		telaLogin.setVisible(true);

		boolean teste;
		loginController.cadastro(telaLogin, telaCadastro);

		if (!telaLogin.isVisible() && telaCadastro.isVisible()) {
			teste = true;
		} else
			teste = false;

		assertEquals(true, teste);
	}

	@Test
	public void deveLogar() {
		TelaLogin telaLogin = new TelaLogin();
		LoginController loginController = new LoginController(telaLogin);
		Coordenador coordenador = new Coordenador("123485", "coordenador_teste", "123");
		new CoordenadorDAO(coordenador).insertCoordenador();

		Usuario usuarioLogin = new Usuario();
		telaLogin.getTfUsuario().setText("123485");
		telaLogin.getTfSenha().setText("123");
		usuarioLogin.setIdUsuario(telaLogin.getTfUsuario().getText());
		usuarioLogin.setSenha(new String(telaLogin.getTfSenha().getPassword()));

		Usuario usuario = loginController.logar(usuarioLogin, telaLogin);
		boolean teste;

		if (usuario.getNome().equals("coordenador_teste")) {
			teste = true;
		} else
			teste = false;

		assertEquals(true, teste);
	}
}
