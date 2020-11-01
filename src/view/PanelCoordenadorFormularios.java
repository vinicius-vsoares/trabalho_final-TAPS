package view;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;

public class PanelCoordenadorFormularios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8781439275721681828L;
	public JList<String> listFormulario;
	public DefaultListModel<String> lModel;

	public PanelCoordenadorFormularios() {

		setLayout(null);
		lModel = new DefaultListModel<>();
		listFormulario = new JList<>(lModel);
		listFormulario.setCellRenderer(new PanelCoordenadorFormulariosRender());
		listFormulario.setFont(new Font("Tahoma", Font.BOLD, 16));
		listFormulario.setBounds(10, 11, 430, 278);
		JScrollPane scrollPane = new JScrollPane(listFormulario);
		scrollPane.setBounds(10, 11, 430, 278);
		add(scrollPane);
	}
}
