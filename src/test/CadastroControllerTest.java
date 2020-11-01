package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.CadastroController;
import model.Aluno;
import view.TelaCadastro;

public class CadastroControllerTest {
	@Test
	public void limparCampos() {
		TelaCadastro telaCadastro = new TelaCadastro();
		CadastroController cadastroController = new CadastroController(telaCadastro);
		telaCadastro.getTfMatricula().setText("101010");
		telaCadastro.getTfSenha().setText("123teste");
		telaCadastro.getCbSerie().setSelectedIndex(4);
		telaCadastro.getTfNome().setText("teste");

		cadastroController.limpar(telaCadastro);

		boolean teste;
		if (telaCadastro.getTfMatricula().getText().isEmpty() && telaCadastro.getTfSenha().getPassword().length == 0
				&& telaCadastro.getCbSerie().getSelectedIndex() == 0 && telaCadastro.getTfNome().getText().isEmpty()) {
			teste = true;
		} else
			teste = false;

		assertEquals(true, teste);
	}

	@Test
	public void insercaoDeUsuario() {
		Aluno aluno = new Aluno();
		TelaCadastro telaCadastro = new TelaCadastro();
		CadastroController cadastroController = new CadastroController(telaCadastro);
		aluno.setIdUsuario("99999999");
		aluno.setSenha("testeadmin");
		aluno.setSerie(8);
		aluno.setNome("teste_user");
		aluno.setMatriculaCoordenador("562384");

		boolean teste = cadastroController.insereAluno(aluno);

		assertEquals(true, teste);
	}

	@Test
	public void matriculaJaCadastrada() {
		Aluno aluno = new Aluno();
		TelaCadastro telaCadastro = new TelaCadastro();
		CadastroController cadastroController = new CadastroController(telaCadastro);
		aluno.setIdUsuario("99999999");
		aluno.setSenha("testeadmin");
		aluno.setSerie(8);
		aluno.setNome("teste_user");
		aluno.setMatriculaCoordenador("562384");

		boolean teste = cadastroController.insereAluno(aluno);

		assertEquals(false, teste);
	}
}
