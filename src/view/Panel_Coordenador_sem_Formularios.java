package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.io.IOException;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Panel_Coordenador_sem_Formularios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Panel_Coordenador_sem_Formularios() {
		setLayout(null);
		
		JTextArea txtrNoExistemFormulrios = new JTextArea();
		txtrNoExistemFormulrios.setText("N\u00E3o existem formul\u00E1rios \r\npara serem analisados!");
		txtrNoExistemFormulrios.setEditable(false);
		txtrNoExistemFormulrios.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtrNoExistemFormulrios.setBackground(SystemColor.control);
		txtrNoExistemFormulrios.setBounds(173, 126, 256, 54);
		add(txtrNoExistemFormulrios);
		
		JLabel lblNewLabel = new JLabel("");
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Panel_Coordenador_sem_Formularios.class.getResource("/fig/about.png")).getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setBounds(62, 96, 143, 110);
		add(lblNewLabel);

	}
}
