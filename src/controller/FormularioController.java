package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import dao.FormularioDAO;
import modelo.Aluno;
import modelo.Formulario;
import view.TelaFormulario;

public class FormularioController implements ActionListener {
	private Formulario form;
	private TelaFormulario telaForm;
	private Aluno alu;
	
	
	public FormularioController(TelaFormulario telaForm, Aluno alu) {
		super();
		this.alu = alu;
		this.telaForm = telaForm;
		this.form = null;
		this.telaForm.getSubmit().addActionListener(this);
		this.telaForm.getClean().addActionListener(this);
	}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Enviar")) {
			new Date(this.telaForm.getComboBoxMes().getSelectedIndex(), this.telaForm.getComboBoxDia().getSelectedIndex(), this.telaForm.getComboBoxAno().getSelectedIndex());
//			this.form.setData_ini((java.sql.Date) data);
			//this.form.setData((java.sql.Date) new Date());
			this.form.setObs(this.telaForm.getObs().getText());
			this.form.setArea_nova(this.telaForm.getTextNovaArea().getText());
			this.form.setTelefone(this.telaForm.getTextTelefone().getText());
			this.telaForm.getTextNome().setText(this.alu.getNome());
			//this.telaForm.getComboBoxSerie().setSelectedIndex(this.alu.getSerie()+1);
			new FormularioDAO(this.form).insertForm();		
		}
		
		if(e.getActionCommand().equals("Limpar")) {
			this.telaForm.getComboBoxAno().setSelectedIndex(0);
			this.telaForm.getComboBoxDia().setSelectedIndex(0);
			this.telaForm.getComboBoxMes().setSelectedIndex(0);
			//this.telaForm.getComboBoxSerie().setSelectedIndex(0);
			this.telaForm.getTextNome().setText("");
			this.telaForm.getTextArea().setText("");
			this.telaForm.getTextNovaArea().setText("");
			this.telaForm.getTextTelefone().setText("");
			this.telaForm.getObs().setText("");
		}
	}

}
