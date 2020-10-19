package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PanelAguarde extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAguarde() {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(49, 0, 128, 300);
		label.setIcon(new ImageIcon(PanelAguarde.class.getResource("/fig/clock.png")));
		add(label);
		
		JLabel lblAguarde = new JLabel("AGUARDE    ");
		lblAguarde.setBounds(204, 0, 246, 300);
		lblAguarde.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblAguarde);

	}
	
	

}
