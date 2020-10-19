package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.FormularioDAO;
import dao.Formulario_respostaDAO;
import dao.ModulosDAO;
import modelo.Aluno;
import modelo.Formulario;
import modelo.Formulario_resposta;
import modelo.Modulos;
import modelo.Troca_area;
import view.FormularioVisualizacaoAluno;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaSobre;

public class FormularioVisualizacaoAlunoController implements ActionListener {
	private Aluno alu;
	private FormularioVisualizacaoAluno pva;

	public FormularioVisualizacaoAlunoController(Aluno alu, FormularioVisualizacaoAluno pva) {
		super();
		this.alu = alu;
		this.pva = pva;

		this.pva.getMntmSair().addActionListener(this);
		this.pva.getMntmPginaInicial().addActionListener(this);
		this.pva.getMntmSobre().addActionListener(this);
		
		
		FormularioDAO formDAO = new FormularioDAO();
		Formulario form = formDAO.getForm(alu);
		
		this.pva.getTextFieldNome().setText(form.getAluno().getNome());
		this.pva.getTfSerie().setText(Integer.toString(form.getAluno().getSerie()));
		this.pva.getTextFieldAreaEstagio().setText(form.getArea_atual());
		this.pva.getTextFieldNovaArea().setText(form.getArea_nova());
		this.pva.getTextFieldTelefone().setText(form.getTelefone());
		this.pva.getTextAreaObservacoes().setText(form.getObs());
		
		String data[] = form.getData().split("-");
		int calcAno = Integer.parseInt(data[0]) - 2019;
		this.pva.getComboBoxAno().setSelectedIndex(calcAno+1);
		this.pva.getComboBoxMes().setSelectedIndex(Integer.parseInt(data[1]));
		this.pva.getComboBoxDia().setSelectedIndex(Integer.parseInt(data[2]));
		Formulario_resposta formR = new Formulario_resposta();
		formR.setForm(form);
		Troca_area ta = new Formulario_respostaDAO(formR).getFormRDAO();
		formR.setId(ta.getFormR().getId());
		Troca_area ta2 = new Formulario_respostaDAO(formR).getFormRDAO2(ta);
		ArrayList<Modulos> m = new ModulosDAO(new Modulos(formR)).getModulos();
		this.pva.getTextFieldAreaAtual1().setText(ta.getArea());
		this.pva.getTextFieldAreaAtual2().setText(ta2.getArea());
		this.pva.getTextFieldAreaTroca1().setText(ta.getTa().getArea());
		this.pva.getTextFieldAreaTroca2().setText(ta2.getTa().getArea());
		this.pva.getTextFieldNroAlunosAreaAtual().setText(String.valueOf(ta.getAlunos()));
		this.pva.getTextFieldNroAlunosAreaAtual2().setText(String.valueOf(ta2.getAlunos()));
		this.pva.getTextFieldVagasAreaAtual().setText(String.valueOf(ta.getVagas()));
		this.pva.getTextFieldVagasAreaAtual2().setText(String.valueOf(ta2.getVagas()));
		this.pva.getTextFieldNroAlunosAreaTroca().setText(String.valueOf(ta.getTa().getAlunos()));
		this.pva.getTextFieldNroAlunosAreaTroca2().setText(String.valueOf(ta2.getTa().getAlunos()));
		this.pva.getTextFieldVagasAreaTroca().setText(String.valueOf(ta.getTa().getVagas()));
		this.pva.getTextFieldVagasAreaTroca2().setText(String.valueOf(ta2.getTa().getVagas()));
		this.pva.getTextAreaParecerAreasEnvolv().setText(ta.getFormR().getParecer_areas());
		this.pva.getTextAreaParecerCoordernador().setText(ta.getFormR().getParacer_coord());
		int count = 0;
		for (Modulos obj : m) {
			this.pva.getTable().setValueAt(obj.getPeriodo(), count, 1);
			this.pva.getTable().setValueAt(obj.getArea(), count, 2);
			this.pva.getTable().setValueAt(obj.getArea_especifica(), count, 3);
			count++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			alu = null;
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);
			this.pva.dispose();

			JOptionPane.showMessageDialog(null, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu ma2 = new TelaMenu();
			ma2.setVisible(true);
			this.pva.dispose();
			ma2.setLocationRelativeTo(null);
			new MenuAlunoController(alu, ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

	}

}
