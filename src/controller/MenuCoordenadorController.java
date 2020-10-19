package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.cj.xdevapi.Result;

import dao.FormularioDAO;
import modelo.Aluno;
import modelo.Coordenador;
import modelo.Formulario;
import view.TelaMenu;
import view.FormularioVisualizacaoAluno;
import view.Panel_Coordenador_Formularios;
import view.Panel_Coordenador_sem_Formularios;
import view.TelaLogin;
import view.TelaSobre;

public class MenuCoordenadorController implements ActionListener {
	private Coordenador co;
	private TelaMenu mn;

	public MenuCoordenadorController(Coordenador co, TelaMenu mn) {
		super();
		this.co = co;
		this.mn = mn;
		this.mn.getMntmSair().addActionListener(this);
		this.mn.getMntmPginaInicial().addActionListener(this);
		// this.ma.getMntmPerfil().addActionListener(this);
		this.mn.getMntmSobre().addActionListener(this);

		Formulario form = new Formulario();
		FormularioDAO formDAO = new FormularioDAO(form);
		form.setCoord(co);
		if (formDAO.possuiFormularioCoordenador()) {
			Panel_Coordenador_Formularios pcf = new Panel_Coordenador_Formularios();
			ArrayList<Aluno> a = formDAO.retornaAlunoForm();
			for (Aluno obj : a) {
				pcf.lModel.addElement("Formulario de " + obj.getNome());
			}
			pcf.listForm.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (form.getAluno() == null) {
						form.setAluno(a.get(pcf.listForm.getSelectedIndex()));
						Formulario f = formDAO.getForm(form.getAluno());
						f.setCoord(form.getCoord());
						FormularioVisualizacaoAluno fc = new FormularioVisualizacaoAluno();
						FormularioCoordenadorController fcc = new FormularioCoordenadorController(f, fc);
						fc.setLocationRelativeTo(null);
						fc.setVisible(true);
						mn.dispose();
					}
				}
			});
			this.mn.add(pcf);
		} else {
			Panel_Coordenador_sem_Formularios psf = new Panel_Coordenador_sem_Formularios();
			this.mn.add(psf);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			co = null;
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);

			mn.dispose();
			JOptionPane.showMessageDialog(mn, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu ma2 = new TelaMenu();
			new MenuCoordenadorController(co, ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

	}

}
