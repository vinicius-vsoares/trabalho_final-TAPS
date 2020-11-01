package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.FormularioDAO;
import dao.FormularioRespostaDAO;
import dao.ModulosDAO;
import model.Aluno;
import model.Formulario;
import model.FormularioResposta;
import model.Modulos;
import model.TrocaArea;
import view.FormularioVisualizacaoAluno;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaSobre;

public class FormularioVisualizacaoAlunoController implements ActionListener {
	private Aluno aluno;
	private FormularioVisualizacaoAluno formularioVisualizacaoAluno;

	public FormularioVisualizacaoAlunoController(Aluno aluno, FormularioVisualizacaoAluno formularioVisualizacaoAluno) {
		super();
		this.aluno = aluno;
		this.formularioVisualizacaoAluno = formularioVisualizacaoAluno;

		this.formularioVisualizacaoAluno.getMntmSair().addActionListener(this);
		this.formularioVisualizacaoAluno.getMntmPginaInicial().addActionListener(this);
		this.formularioVisualizacaoAluno.getMntmSobre().addActionListener(this);

		FormularioDAO formularioDAO = new FormularioDAO();
		Formulario formulario = formularioDAO.getFormulario(aluno);

		this.formularioVisualizacaoAluno.getTextFieldNome().setText(formulario.getAluno().getNome());
		this.formularioVisualizacaoAluno.getTfSerie().setText(Integer.toString(formulario.getAluno().getSerie()));
		this.formularioVisualizacaoAluno.getTextFieldAreaEstagio().setText(formulario.getAreaAtual());
		this.formularioVisualizacaoAluno.getTextFieldNovaArea().setText(formulario.getNovaArea());
		this.formularioVisualizacaoAluno.getTextFieldTelefone().setText(formulario.getTelefone());
		this.formularioVisualizacaoAluno.getTextAreaObservacoes().setText(formulario.getObservacao());

		String data[] = formulario.getData().split("-");
		int calcAno = Integer.parseInt(data[0]) - 2019;
		this.formularioVisualizacaoAluno.getComboBoxAno().setSelectedIndex(calcAno + 1);
		this.formularioVisualizacaoAluno.getComboBoxMes().setSelectedIndex(Integer.parseInt(data[1]));
		this.formularioVisualizacaoAluno.getComboBoxDia().setSelectedIndex(Integer.parseInt(data[2]));
		FormularioResposta formularioResposta = new FormularioResposta();
		formularioResposta.setFormulario(formulario);
		TrocaArea trocaArea1 = new FormularioRespostaDAO(formularioResposta).getFormRespostaDAO();
		formularioResposta.setIdFormulario(trocaArea1.getFormularioResposta().getIdFormulario());
		TrocaArea trocaArea2 = new FormularioRespostaDAO(formularioResposta).getFormRDAO2(trocaArea1);
		ArrayList<Modulos> modulos = new ModulosDAO(new Modulos(formularioResposta)).getModulos();
		this.formularioVisualizacaoAluno.getTextFieldAreaAtual1().setText(trocaArea1.getArea());
		this.formularioVisualizacaoAluno.getTextFieldAreaAtual2().setText(trocaArea2.getArea());
		this.formularioVisualizacaoAluno.getTextFieldAreaTroca1().setText(trocaArea1.getTrocaArea().getArea());
		this.formularioVisualizacaoAluno.getTextFieldAreaTroca2().setText(trocaArea2.getTrocaArea().getArea());
		this.formularioVisualizacaoAluno.getTextFieldNroAlunosAreaAtual()
				.setText(String.valueOf(trocaArea1.getAlunos()));
		this.formularioVisualizacaoAluno.getTextFieldNroAlunosAreaAtual2()
				.setText(String.valueOf(trocaArea2.getAlunos()));
		this.formularioVisualizacaoAluno.getTextFieldVagasAreaAtual().setText(String.valueOf(trocaArea1.getVagas()));
		this.formularioVisualizacaoAluno.getTextFieldVagasAreaAtual2().setText(String.valueOf(trocaArea2.getVagas()));
		this.formularioVisualizacaoAluno.getTextFieldNroAlunosAreaTroca()
				.setText(String.valueOf(trocaArea1.getTrocaArea().getAlunos()));
		this.formularioVisualizacaoAluno.getTextFieldNroAlunosAreaTroca2()
				.setText(String.valueOf(trocaArea2.getTrocaArea().getAlunos()));
		this.formularioVisualizacaoAluno.getTextFieldVagasAreaTroca()
				.setText(String.valueOf(trocaArea1.getTrocaArea().getVagas()));
		this.formularioVisualizacaoAluno.getTextFieldVagasAreaTroca2()
				.setText(String.valueOf(trocaArea2.getTrocaArea().getVagas()));
		this.formularioVisualizacaoAluno.getTextAreaParecerAreasEnvolv()
				.setText(trocaArea1.getFormularioResposta().getParecerAreas());
		this.formularioVisualizacaoAluno.getTextAreaParecerCoordernador()
				.setText(trocaArea1.getFormularioResposta().getParacerCoordenador());
		int count = 0;
		for (Modulos obj : modulos) {
			this.formularioVisualizacaoAluno.getTable().setValueAt(obj.getPeriodo(), count, 1);
			this.formularioVisualizacaoAluno.getTable().setValueAt(obj.getAreaGeral(), count, 2);
			this.formularioVisualizacaoAluno.getTable().setValueAt(obj.getAreaEspecifica(), count, 3);
			count++;
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
			this.formularioVisualizacaoAluno.dispose();

			JOptionPane.showMessageDialog(null, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu telaMenu = new TelaMenu();
			telaMenu.setVisible(true);
			this.formularioVisualizacaoAluno.dispose();
			telaMenu.setLocationRelativeTo(null);
			new MenuAlunoController(aluno, telaMenu);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre telaSobre = new TelaSobre();
			telaSobre.setVisible(true);
			telaSobre.setLocationRelativeTo(null);
		}

	}

}
