package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Panel_Aluno_sem_Formularios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1334202141921121823L;
	JButton btCriarFormulário;
	/**
	 * Create the panel.
	 */
	public Panel_Aluno_sem_Formularios() {
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(94, 126, 80, 80);
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Panel_Aluno_sem_Formularios.class.getResource("/fig/adicionar.png")).getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Voc\u00EA n\u00E3o possui formul\u00E1rios!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 35, 382, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblNewLabel_1);
		add(lblNewLabel);
		
	    btCriarFormulário = new JButton("Criar formul\u00E1rio");
	    btCriarFormulário.setBounds(191, 149, 185, 37);
		btCriarFormulário.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(btCriarFormulário);

	}
	public JButton getBtCriarFormulário() {
		return btCriarFormulário;
	}
	
	

}
