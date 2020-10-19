package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Formulario_respostaDAO;
import dao.ModulosDAO;
import dao.Troca_areaDAO;
import modelo.Formulario;
import modelo.Formulario_resposta;
import modelo.Modulos;
import modelo.Troca_area;
import view.FormularioVisualizacaoAluno;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaSobre;

public class FormularioCoordenadorController implements ActionListener {
	private Formulario_resposta formR;
	private FormularioVisualizacaoAluno telaForm;

	public FormularioCoordenadorController(Formulario f, FormularioVisualizacaoAluno fc) {
		this.formR = new Formulario_resposta();
		this.formR.setForm(f);
		this.telaForm = fc;
		this.telaForm.getSubmit().addActionListener(this);
		this.telaForm.getClean().addActionListener(this);
		this.telaForm.getMntmSair().addActionListener(this);
		this.telaForm.getMntmPginaInicial().addActionListener(this);
		this.telaForm.getMntmSobre().addActionListener(this);
		this.telaForm.getTextFieldNome().setText(formR.getForm().getAluno().getNome());
		this.telaForm.getTfSerie().setText(Integer.toString(formR.getForm().getAluno().getSerie()));
		this.telaForm.getTextFieldAreaEstagio().setText(formR.getForm().getArea_atual());
		this.telaForm.getTextFieldNovaArea().setText(formR.getForm().getArea_nova());
		this.telaForm.getTextFieldTelefone().setText(formR.getForm().getTelefone());
		this.telaForm.getTextAreaObservacoes().setText(formR.getForm().getObs());

		String data[] = formR.getForm().getData().split("-");
		int calcAno = Integer.parseInt(data[0]) - 2019;
		this.telaForm.getComboBoxAno().setSelectedIndex(calcAno + 1);
		this.telaForm.getComboBoxMes().setSelectedIndex(Integer.parseInt(data[1]));
		this.telaForm.getComboBoxDia().setSelectedIndex(Integer.parseInt(data[2]));

		if (!new Formulario_respostaDAO(formR).possuiParecer()) {
			this.telaForm.getTextFieldAreaAtual1().setEnabled(true);
			this.telaForm.getTextFieldAreaAtual2().setEnabled(true);
			this.telaForm.getTextFieldAreaTroca1().setEnabled(true);
			this.telaForm.getTextFieldAreaTroca2().setEnabled(true);
			this.telaForm.getTextFieldNroAlunosAreaAtual().setEnabled(true);
			this.telaForm.getTextFieldNroAlunosAreaAtual2().setEnabled(true);
			this.telaForm.getTextFieldVagasAreaAtual().setEnabled(true);
			this.telaForm.getTextFieldVagasAreaAtual2().setEnabled(true);
			this.telaForm.getTextFieldNroAlunosAreaTroca().setEnabled(true);
			this.telaForm.getTextFieldNroAlunosAreaTroca2().setEnabled(true);
			this.telaForm.getTextFieldVagasAreaTroca().setEnabled(true);
			this.telaForm.getTextFieldVagasAreaTroca2().setEnabled(true);
			this.telaForm.getTextAreaParecerAreasEnvolv().setEnabled(true);
			this.telaForm.getTextAreaParecerCoordernador().setEnabled(true);
			this.telaForm.getTable().setEnabled(true);
			this.telaForm.getSubmit().setVisible(true);
			this.telaForm.getClean().setVisible(true);
		} else {
			Troca_area ta = new Formulario_respostaDAO(formR).getFormRDAO();
			formR.setId(ta.getFormR().getId());
			Troca_area ta2 = new Formulario_respostaDAO(formR).getFormRDAO2(ta);
			ArrayList<Modulos> m = new ModulosDAO(new Modulos(formR)).getModulos();
			this.telaForm.getTextFieldAreaAtual1().setText(ta.getArea());
			this.telaForm.getTextFieldAreaAtual2().setText(ta2.getArea());
			this.telaForm.getTextFieldAreaTroca1().setText(ta.getTa().getArea());
			this.telaForm.getTextFieldAreaTroca2().setText(ta2.getTa().getArea());
			this.telaForm.getTextFieldNroAlunosAreaAtual().setText(String.valueOf(ta.getAlunos()));
			this.telaForm.getTextFieldNroAlunosAreaAtual2().setText(String.valueOf(ta2.getAlunos()));
			this.telaForm.getTextFieldVagasAreaAtual().setText(String.valueOf(ta.getVagas()));
			this.telaForm.getTextFieldVagasAreaAtual2().setText(String.valueOf(ta2.getVagas()));
			this.telaForm.getTextFieldNroAlunosAreaTroca().setText(String.valueOf(ta.getTa().getAlunos()));
			this.telaForm.getTextFieldNroAlunosAreaTroca2().setText(String.valueOf(ta2.getTa().getAlunos()));
			this.telaForm.getTextFieldVagasAreaTroca().setText(String.valueOf(ta.getTa().getVagas()));
			this.telaForm.getTextFieldVagasAreaTroca2().setText(String.valueOf(ta2.getTa().getVagas()));
			this.telaForm.getTextAreaParecerAreasEnvolv().setText(ta.getFormR().getParecer_areas());
			this.telaForm.getTextAreaParecerCoordernador().setText(ta.getFormR().getParacer_coord());
			int count = 0;
			for (Modulos obj : m) {
				this.telaForm.getTable().setValueAt(obj.getPeriodo(), count, 1);
				this.telaForm.getTable().setValueAt(obj.getArea(), count, 2);
				this.telaForm.getTable().setValueAt(obj.getArea_especifica(), count, 3);
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
					if (this.telaForm.getTable().getValueAt(i, j) == null)
						flag = false;
				}
			}
			if (!this.telaForm.getTextAreaParecerAreasEnvolv().getText().isEmpty()
					&& !this.telaForm.getTextAreaParecerCoordernador().getText().isEmpty()
					&& !this.telaForm.getTextFieldAreaAtual1().getText().isEmpty()
					&& !this.telaForm.getTextFieldAreaAtual2().getText().isEmpty()
					&& !this.telaForm.getTextFieldAreaTroca1().getText().isEmpty()
					&& !this.telaForm.getTextFieldAreaTroca2().getText().isEmpty()
					&& !this.telaForm.getTextFieldNroAlunosAreaAtual().getText().isEmpty()
					&& !this.telaForm.getTextFieldNroAlunosAreaAtual2().getText().isEmpty()
					&& !this.telaForm.getTextFieldVagasAreaAtual().getText().isEmpty()
					&& !this.telaForm.getTextFieldVagasAreaAtual2().getText().isEmpty()
					&& !this.telaForm.getTextFieldNroAlunosAreaTroca().getText().isEmpty()
					&& !this.telaForm.getTextFieldNroAlunosAreaTroca2().getText().isEmpty()
					&& !this.telaForm.getTextFieldVagasAreaTroca().getText().isEmpty()
					&& !this.telaForm.getTextFieldVagasAreaTroca2().getText().isEmpty() && flag) {
				formR.setParacer_coord(this.telaForm.getTextAreaParecerCoordernador().getText());
				formR.setParecer_areas(this.telaForm.getTextAreaParecerAreasEnvolv().getText());
				Formulario_respostaDAO formRDAO = new Formulario_respostaDAO(formR);
				ArrayList<ModulosDAO> modDAO = new ArrayList<ModulosDAO>();
				for (int i = 0; i < 7; i++) {
					modDAO.add(new ModulosDAO(new Modulos(formR, this.telaForm.getTable().getValueAt(i, 1).toString(),
							this.telaForm.getTable().getValueAt(i, 2).toString(),
							this.telaForm.getTable().getValueAt(i, 3).toString())));
				}
				int flag2 = formRDAO.insertformR();
				for (ModulosDAO obj : modDAO) {
					flag2 = obj.insertModulos();
				}
				try {
					int vat = Integer.parseInt(this.telaForm.getTextFieldVagasAreaTroca().getText());
					int nat = Integer.parseInt(this.telaForm.getTextFieldNroAlunosAreaTroca().getText());
					int va = Integer.parseInt(this.telaForm.getTextFieldVagasAreaAtual().getText());
					int na = Integer.parseInt(this.telaForm.getTextFieldNroAlunosAreaAtual().getText());
					int vat2 = Integer.parseInt(this.telaForm.getTextFieldVagasAreaTroca2().getText());
					int nat2 = Integer.parseInt(this.telaForm.getTextFieldNroAlunosAreaTroca2().getText());
					int va2 = Integer.parseInt(this.telaForm.getTextFieldVagasAreaAtual2().getText());
					int na2 = Integer.parseInt(this.telaForm.getTextFieldNroAlunosAreaAtual2().getText());
					if (flag2 != 0
							&& new Troca_areaDAO(new Troca_area(
									new Troca_area(formR, this.telaForm.getTextFieldAreaTroca1().getText(), vat, nat),
									formR, this.telaForm.getTextFieldAreaAtual1().getText(), va, na))
											.insertTrocaArea() != 0
							&& new Troca_areaDAO(new Troca_area(
									new Troca_area(formR, this.telaForm.getTextFieldAreaTroca2().getText(), vat2, nat2),
									formR, this.telaForm.getTextFieldAreaAtual2().getText(), va2, na2))
											.insertTrocaArea() != 0) {
						TelaMenu ma2 = new TelaMenu();
						ma2.setVisible(true);
						this.telaForm.dispose();
						ma2.setLocationRelativeTo(null);
						new MenuCoordenadorController(formR.getForm().getCoord(), ma2);
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
			this.telaForm.getTextFieldAreaAtual1().setText("");
			this.telaForm.getTextFieldAreaAtual2().setText("");
			this.telaForm.getTextFieldAreaTroca1().setText("");
			this.telaForm.getTextFieldAreaTroca2().setText("");
			this.telaForm.getTextFieldNroAlunosAreaAtual().setText("");
			this.telaForm.getTextFieldNroAlunosAreaAtual2().setText("");
			this.telaForm.getTextFieldVagasAreaAtual().setText("");
			this.telaForm.getTextFieldVagasAreaAtual2().setText("");
			this.telaForm.getTextFieldNroAlunosAreaTroca().setText("");
			this.telaForm.getTextFieldNroAlunosAreaTroca2().setText("");
			this.telaForm.getTextFieldVagasAreaTroca().setText("");
			this.telaForm.getTextFieldVagasAreaTroca2().setText("");
			this.telaForm.getTextAreaParecerAreasEnvolv().setText("");
			this.telaForm.getTextAreaParecerCoordernador().setText("");
			for (int i = 0; i < 7; i++) {
				for (int j = 1; j < 4; j++) {
					this.telaForm.getTable().setValueAt("", i, j);

				}
			}
		}

		if (e.getActionCommand().equals("Sair")) {
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);
			this.telaForm.dispose();

			JOptionPane.showMessageDialog(null, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu ma2 = new TelaMenu();
			ma2.setVisible(true);
			this.telaForm.dispose();
			ma2.setLocationRelativeTo(null);
			new MenuCoordenadorController(formR.getForm().getCoord(), ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

	}
}
