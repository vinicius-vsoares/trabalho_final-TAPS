package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import dao.FormularioDAO;
import model.Aluno;
import model.Formulario;
import view.TelaFormulario;

public class FormularioController implements ActionListener {
	private Formulario formulario;
	private TelaFormulario telaFormulario;
	private Aluno aluno;

	public FormularioController(TelaFormulario telaFormulario, Aluno aluno) {
		super();
		this.aluno = aluno;
		this.telaFormulario = telaFormulario;
		this.formulario = null;
		this.telaFormulario.getSubmit().addActionListener(this);
		this.telaFormulario.getClean().addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Enviar")) {
			new Date(this.telaFormulario.getComboBoxMes().getSelectedIndex(),
					this.telaFormulario.getComboBoxDia().getSelectedIndex(),
					this.telaFormulario.getComboBoxAno().getSelectedIndex());
//			this.form.setData_ini((java.sql.Date) data);
			// this.form.setData((java.sql.Date) new Date());
			this.formulario.setObservacao(this.telaFormulario.getObs().getText());
			this.formulario.setNovaArea(this.telaFormulario.getTextNovaArea().getText());
			this.formulario.setTelefone(this.telaFormulario.getTextTelefone().getText());
			this.telaFormulario.getTextNome().setText(this.aluno.getNome());
			// this.telaForm.getComboBoxSerie().setSelectedIndex(this.alu.getSerie()+1);
			new FormularioDAO(this.formulario).insertForm();
		}

		if (e.getActionCommand().equals("Limpar")) {
			this.telaFormulario.getComboBoxAno().setSelectedIndex(0);
			this.telaFormulario.getComboBoxDia().setSelectedIndex(0);
			this.telaFormulario.getComboBoxMes().setSelectedIndex(0);
			// this.telaForm.getComboBoxSerie().setSelectedIndex(0);
			this.telaFormulario.getTextNome().setText("");
			this.telaFormulario.getTextArea().setText("");
			this.telaFormulario.getTextNovaArea().setText("");
			this.telaFormulario.getTextTelefone().setText("");
			this.telaFormulario.getObs().setText("");
		}
	}

}
