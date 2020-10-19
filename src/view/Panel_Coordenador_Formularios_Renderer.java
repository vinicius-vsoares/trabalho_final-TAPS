package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class Panel_Coordenador_Formularios_Renderer extends DefaultListCellRenderer{

	public Component getListCellRendererComponent(JList list,Object value,int index,boolean iss,boolean chf){
	        
	    super.getListCellRendererComponent(list, value, index, iss, chf);
	    
	    if(index%2 == 0) {
	    	setBackground(Color.GRAY);
	    }
	    setBorder(BorderFactory.createLineBorder(Color.black));
	    ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/fig/icon_projeto.png")).getScaledInstance(24, 24, 1));
	    setIcon(imageIcon);
		return this;
    }
}
	

