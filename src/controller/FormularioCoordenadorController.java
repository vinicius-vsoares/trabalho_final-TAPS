package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.FormularioRespostaDAO;
import dao.ModulosDAO;
import dao.TrocaAreaDAO;
import model.Formulario;
import model.FormularioResposta;
import model.Modulos;
import model.TrocaArea;
import view.FormularioVisualizacaoAluno;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaSobre;

public class FormularioCoordenadorController implements ActionListener {
	private FormularioResposta formularioResposta;
	private FormularioVisualizacaoAluno telaFormulario;

	public FormularioCoordenadorController(Formulario formulario,
			FormularioVisualizacaoAluno formularioVisualizacaoAluno) {
		this.formularioResposta = new FormularioResposta();
		this.formularioResposta.setFormulario(formulario);
		this.telaFormulario = formularioVisualizacaoAluno;
		this.telaFormulario.getSubmit().addActionListener(this);
		this.telaFormulario.getClean().addActionListener(this);
		this.telaFormulario.getMntmSair().addActionListener(this);
		this.telaFormulario.getMntmPginaInicial().addActionListener(this);
		this.telaFormulario.getMntmSobre().addActionListener(this);
		this.telaFormulario.getTextFieldNome().setText(formularioResposta.getFormulario().getAluno().getNome());
		this.telaFormulario.getTfSerie()
				.setText(Integer.toString(formularioResposta.getFormulario().getAluno().getSerie()));
		this.telaFormulario.getTextFieldAreaEstagio().setText(formularioResposta.getFormulario().getAreaAtual());
		this.telaFormulario.getTextFieldNovaArea().setText(formularioResposta.getFormulario().getNovaArea());
		this.telaFormulario.getTextFieldTelefone().setText(formularioResposta.getFormulario().getTelefone());
		this.telaFormulario.getTextAreaObservacoes().setText(formularioResposta.getFormulario().getObservacao());

		String data[] = formularioResposta.getFormulario().getData().split("-");
		int calcAno = Integer.parseInt(data[0]) - 2019;
		this.telaFormulario.getComboBoxAno().setSelectedIndex(calcAno + 1);
		this.telaFormulario.getComboBoxMes().setSelectedIndex(Integer.parseInt(data[1]));
		this.telaFormulario.getComboBoxDia().setSelectedIndex(Integer.parseInt(data[2]));

		if (!new FormularioRespostaDAO(formularioResposta).possuiParecer()) {
			this.telaFormulario.getTextFieldAreaAtual1().setEnabled(true);
			this.telaFormulario.getTextFieldAreaAtual2().setEnabled(true);
			this.telaFormulario.getTextFieldAreaTroca1().setEnabled(true);
			this.telaFormulario.getTextFieldAreaTroca2().setEnabled(true);
			this.telaFormulario.getTextFieldNroAlunosAreaAtual().setEnabled(true);
			this.telaFormulario.getTextFieldNroAlunosAreaAtual2().setEnabled(true);
			this.telaFormulario.getTextFieldVagasAreaAtual().setEnabled(true);
			this.telaFormulario.getTextFieldVagasAreaAtual2().setEnabled(true);
			this.telaFormulario.getTextFieldNroAlunosAreaTroca().setEnabled(true);
			this.telaFormulario.getTextFieldNroAlunosAreaTroca2().setEnabled(true);
			this.telaFormulario.getTextFieldVagasAreaTroca().setEnabled(true);
			this.telaFormulario.getTextFieldVagasAreaTroca2().setEnabled(true);
			this.telaFormulario.getTextAreaParecerAreasEnvolv().setEnabled(true);
			this.telaFormulario.getTextAreaParecerCoordernador().setEnabled(true);
			this.telaFormulario.getTable().setEnabled(true);
			this.telaFormulario.getSubmit().setVisible(true);
			this.telaFormulario.getClean().setVisible(true);
		} else {
			TrocaArea ta = new FormularioRespostaDAO(formularioResposta).getFormRespostaDAO();
			formularioResposta.setIdFormulario(ta.getFormularioResposta().getIdFormulario());
			TrocaArea ta2 = new FormularioRespostaDAO(formularioResposta).getFormRDAO2(ta);
			ArrayList<Modulos> m = new ModulosDAO(new Modulos(formularioResposta)).getModulos();
			this.telaFormulario.getTextFieldAreaAtual1().setText(ta.getArea());
			this.telaFormulario.getTextFieldAreaAtual2().setText(ta2.getArea());
			this.telaFormulario.getTextFieldAreaTroca1().setText(ta.getTrocaArea().getArea());
			this.telaFormulario.getTextFieldAreaTroca2().setText(ta2.getTrocaArea().getArea());
			this.telaFormulario.getTextFieldNroAlunosAreaAtual().setText(String.valueOf(ta.getAlunos()));
			this.telaFormulario.getTextFieldNroAlunosAreaAtual2().setText(String.valueOf(ta2.getAlunos()));
			this.telaFormulario.getTextFieldVagasAreaAtual().setText(String.valueOf(ta.getVagas()));
			this.telaFormulario.getTextFieldVagasAreaAtual2().setText(String.valueOf(ta2.getVagas()));
			this.telaFormulario.getTextFieldNroAlunosAreaTroca().setText(String.valueOf(ta.getTrocaArea().getAlunos()));
			this.telaFormulario.getTextFieldNroAlunosAreaTroca2()
					.setText(String.valueOf(ta2.getTrocaArea().getAlunos()));
			this.telaFormulario.getTextFieldVagasAreaTroca().setText(String.valueOf(ta.getTrocaArea().getVagas()));
			this.telaFormulario.getTextFieldVagasAreaTroca2().setText(String.valueOf(ta2.getTrocaArea().getVagas()));
			this.telaFormulario.getTextAreaParecerAreasEnvolv().setText(ta.getFormularioResposta().getParecerAreas());
			this.telaFormulario.getTextAreaParecerCoordernador()
					.setText(ta.getFormularioResposta().getParacerCoordenador());
			int count = 0;
			for (Modulos obj : m) {
				this.telaFormulario.getTable().setValueAt(obj.getPeriodo(), count, 1);
				this.telaFormulario.getTable().setValueAt(obj.getAreaGeral(), count, 2);
				this.telaFormulario.getTable().setValueAt(obj.getAreaEspecifica(), count, 3);
				count++;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Enviar")) {
			boolean flag = true;
			for (int i = 0; i < 7; i++) {
				for (int j = 1; j < 4; j++) {
					if (this.telaFormulario.getTable().getValueAt(i, j) == null)
						flag = false;
				}
			}
			if (!this.telaFormulario.getTextAreaParecerAreasEnvolv().getText().isEmpty()
					&& !this.telaFormulario.getTextAreaParecerCoordernador().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldAreaAtual1().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldAreaAtual2().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldAreaTroca1().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldAreaTroca2().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldNroAlunosAreaAtual().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldNroAlunosAreaAtual2().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldVagasAreaAtual().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldVagasAreaAtual2().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldNroAlunosAreaTroca().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldNroAlunosAreaTroca2().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldVagasAreaTroca().getText().isEmpty()
					&& !this.telaFormulario.getTextFieldVagasAreaTroca2().getText().isEmpty() && flag) {
				formularioResposta
						.setParacerCoordenador(this.telaFormulario.getTextAreaParecerCoordernador().getText());
				formularioResposta.setParecerAreas(this.telaFormulario.getTextAreaParecerAreasEnvolv().getText());
				FormularioRespostaDAO formRDAO = new FormularioRespostaDAO(formularioResposta);
				ArrayList<ModulosDAO> modDAO = new ArrayList<ModulosDAO>();
				for (int i = 0; i < 7; i++) {
					modDAO.add(new ModulosDAO(
							new Modulos(formularioResposta, this.telaFormulario.getTable().getValueAt(i, 1).toString(),
									this.telaFormulario.getTable().getValueAt(i, 2).toString(),
									this.telaFormulario.getTable().getValueAt(i, 3).toString())));
				}
				int flag2 = formRDAO.insertFormularioResposta();
				for (ModulosDAO obj : modDAO) {
					flag2 = obj.insertModulos();
				}
				try {
					int vat = Integer.parseInt(this.telaFormulario.getTextFieldVagasAreaTroca().getText());
					int nat = Integer.parseInt(this.telaFormulario.getTextFieldNroAlunosAreaTroca().getText());
					int va = Integer.parseInt(this.telaFormulario.getTextFieldVagasAreaAtual().getText());
					int na = Integer.parseInt(this.telaFormulario.getTextFieldNroAlunosAreaAtual().getText());
					int vat2 = Integer.parseInt(this.telaFormulario.getTextFieldVagasAreaTroca2().getText());
					int nat2 = Integer.parseInt(this.telaFormulario.getTextFieldNroAlunosAreaTroca2().getText());
					int va2 = Integer.parseInt(this.telaFormulario.getTextFieldVagasAreaAtual2().getText());
					int na2 = Integer.parseInt(this.telaFormulario.getTextFieldNroAlunosAreaAtual2().getText());
					if (flag2 != 0
							&& new TrocaAreaDAO(new TrocaArea(
									new TrocaArea(formularioResposta,
											this.telaFormulario.getTextFieldAreaTroca1().getText(), vat, nat),
									formularioResposta, this.telaFormulario.getTextFieldAreaAtual1().getText(), va, na))
											.insertTrocaArea() != 0
							&& new TrocaAreaDAO(new TrocaArea(
									new TrocaArea(formularioResposta,
											this.telaFormulario.getTextFieldAreaTroca2().getText(), vat2, nat2),
									formularioResposta, this.telaFormulario.getTextFieldAreaAtual2().getText(), va2,
									na2)).insertTrocaArea() != 0) {
						TelaMenu ma2 = new TelaMenu();
						ma2.setVisible(true);
						this.telaFormulario.dispose();
						ma2.setLocationRelativeTo(null);
						new MenuCoordenadorController(formularioResposta.getFormulario().getCoordenador(), ma2);
						JOptionPane.showMessageDialog(null, "Formulário cadastrado com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao inserir. Tente novamente!", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
							"Existem campos preenchidos incorretamente\n(Exemplo: letras no lugar de numeros)!", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Existem campos não preenchidos!", "Erro",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

		if (e.getActionCommand().equals("Limpar")) {
			this.telaFormulario.getTextFieldAreaAtual1().setText("");
			this.telaFormulario.getTextFieldAreaAtual2().setText("");
			this.telaFormulario.getTextFieldAreaTroca1().setText("");
			this.telaFormulario.getTextFieldAreaTroca2().setText("");
			this.telaFormulario.getTextFieldNroAlunosAreaAtual().setText("");
			this.telaFormulario.getTextFieldNroAlunosAreaAtual2().setText("");
			this.telaFormulario.getTextFieldVagasAreaAtual().setText("");
			this.telaFormulario.getTextFieldVagasAreaAtual2().setText("");
			this.telaFormulario.getTextFieldNroAlunosAreaTroca().setText("");
			this.telaFormulario.getTextFieldNroAlunosAreaTroca2().setText("");
			this.telaFormulario.getTextFieldVagasAreaTroca().setText("");
			this.telaFormulario.getTextFieldVagasAreaTroca2().setText("");
			this.telaFormulario.getTextAreaParecerAreasEnvolv().setText("");
			this.telaFormulario.getTextAreaParecerCoordernador().setText("");
			for (int i = 0; i < 7; i++) {
				for (int j = 1; j < 4; j++) {
					this.telaFormulario.getTable().setValueAt("", i, j);

				}
			}
		}

		if (e.getActionCommand().equals("Sair")) {
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
			new MenuCoordenadorController(formularioResposta.getFormulario().getCoordenador(), ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

	}
}
