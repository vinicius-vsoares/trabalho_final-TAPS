package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.io.IOException;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaSobre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaSobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobre.class.getResource("/fig/about.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(78, 0, 283, 129);
		contentPane.add(label);

		JTextArea txtrSoftwareDesenvolvidoPara = new JTextArea();
		txtrSoftwareDesenvolvidoPara.setText(
				"Software desenvolvido para a discplina de Programa\u00E7\u00E3o Orientada a \r\nObjetos II.\r\nDesenvolvido por: \r\n\tRodrigo Seger\r\n\tGuilherme Nique\r\n\tJos\u00E9 Linch\r\n\tVin\u00EDcius Soares\r\n\tJ\u00FAlio Schr\u00F6der\r\n\tPedro Rodrigues\r\n\r\nUniversidade Federal de Ci\u00EAncias da Sa\u00FAde de Porto Alegre - 2019");
		txtrSoftwareDesenvolvidoPara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrSoftwareDesenvolvidoPara.setEditable(false);
		txtrSoftwareDesenvolvidoPara.setBackground(SystemColor.menu);
		txtrSoftwareDesenvolvidoPara.setBounds(10, 136, 430, 194);
		contentPane.add(txtrSoftwareDesenvolvidoPara);

		JLabel label_1 = new JLabel("");
		try {
			label_1.setIcon(new ImageIcon(ImageIO.read(TelaSobre.class.getResource("/fig/informatica-biomedica.png"))
					.getScaledInstance(270, 100, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label_1.setBounds(78, 0, 283, 129);
		contentPane.add(label_1);
	}

}
