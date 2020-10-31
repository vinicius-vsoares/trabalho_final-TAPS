package view;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Panel_Coordenador_Formularios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8781439275721681828L;
	public JList<String> listForm;
	public DefaultListModel<String> lModel;
	public Panel_Coordenador_Formularios() {
		
		setLayout(null);
		lModel = new DefaultListModel<>();
		listForm = new JList<>(lModel);
		listForm.setCellRenderer(new Panel_Coordenador_Formularios_Renderer());
		listForm.setFont(new Font("Tahoma", Font.BOLD, 16));
		listForm.setBounds(10, 11, 430, 278);
		JScrollPane scrollPane = new JScrollPane(listForm);
		scrollPane.setBounds(10, 11, 430, 278);
		add(scrollPane);
	}
}
