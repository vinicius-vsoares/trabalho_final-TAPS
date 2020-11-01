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

public class PanelCoordenadorSemFormularios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelCoordenadorSemFormularios() {
		setLayout(null);

		JTextArea txtrSemFormulario = new JTextArea();
		txtrSemFormulario.setText("N\u00E3o existem formul\u00E1rios \r\npara serem analisados!");
		txtrSemFormulario.setEditable(false);
		txtrSemFormulario.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtrSemFormulario.setBackground(SystemColor.control);
		txtrSemFormulario.setBounds(173, 126, 256, 54);
		add(txtrSemFormulario);

		JLabel lblNewLabel = new JLabel("");
		try {
			lblNewLabel.setIcon(
					new ImageIcon(ImageIO.read(PanelCoordenadorSemFormularios.class.getResource("/fig/about.png"))
							.getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setBounds(62, 96, 143, 110);
		add(lblNewLabel);

	}
}
