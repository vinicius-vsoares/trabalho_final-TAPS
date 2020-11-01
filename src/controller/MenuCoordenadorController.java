package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.FormularioDAO;
import model.Aluno;
import model.Coordenador;
import model.Formulario;
import view.TelaMenu;
import view.FormularioVisualizacaoAluno;
import view.PanelCoordenadorFormularios;
import view.PanelCoordenadorSemFormularios;
import view.TelaLogin;
import view.TelaSobre;

public class MenuCoordenadorController implements ActionListener {
	private Coordenador coordenador;
	private TelaMenu telaMenu;

	public MenuCoordenadorController(Coordenador coordenador, TelaMenu telaMenu) {
		super();
		this.coordenador = coordenador;
		this.telaMenu = telaMenu;
		this.telaMenu.getMntmSair().addActionListener(this);
		this.telaMenu.getMntmPginaInicial().addActionListener(this);
		// this.ma.getMntmPerfil().addActionListener(this);
		this.telaMenu.getMntmSobre().addActionListener(this);

		Formulario formulario = new Formulario();
		FormularioDAO formularioDAO = new FormularioDAO(formulario);
		formulario.setCoordenador(coordenador);
		if (formularioDAO.possuiFormularioCoordenador()) {
			PanelCoordenadorFormularios panelCoordenadorFormularios = new PanelCoordenadorFormularios();
			ArrayList<Aluno> a = formularioDAO.retornaFormularioAluno();
			for (Aluno obj : a) {
				panelCoordenadorFormularios.lModel.addElement("Formulario de " + obj.getNome());
			}
			panelCoordenadorFormularios.listFormulario.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (formulario.getAluno() == null) {
						formulario.setAluno(a.get(panelCoordenadorFormularios.listFormulario.getSelectedIndex()));
						Formulario formularioAux = formularioDAO.getFormulario(formulario.getAluno());
						formularioAux.setCoordenador(formulario.getCoordenador());
						FormularioVisualizacaoAluno formularioVisualizacaoAluno = new FormularioVisualizacaoAluno();
						@SuppressWarnings("unused")
						FormularioCoordenadorController fcc = new FormularioCoordenadorController(formularioAux, formularioVisualizacaoAluno);
						formularioVisualizacaoAluno.setLocationRelativeTo(null);
						formularioVisualizacaoAluno.setVisible(true);
						telaMenu.dispose();
					}
				}
			});
			this.telaMenu.add(panelCoordenadorFormularios);
		} else {
			PanelCoordenadorSemFormularios psf = new PanelCoordenadorSemFormularios();
			this.telaMenu.add(psf);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			coordenador = null;
			TelaLogin tl = new TelaLogin();
			tl.setVisible(true);
			tl.setLocationRelativeTo(null);
			new LoginController(tl);

			telaMenu.dispose();
			JOptionPane.showMessageDialog(telaMenu, "Sua sessão foi encerrada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getActionCommand().equals("Página inicial")) {
			TelaMenu ma2 = new TelaMenu();
			new MenuCoordenadorController(coordenador, ma2);
		}

		if (e.getActionCommand().equals("Sobre")) {
			TelaSobre ts = new TelaSobre();
			ts.setVisible(true);
			ts.setLocationRelativeTo(null);
		}

	}

}
