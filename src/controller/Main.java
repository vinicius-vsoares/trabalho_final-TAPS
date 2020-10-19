package controller;

import view.TelaLogin;

public class Main {

	public static void main(String[] args) {
		TelaLogin tl = new TelaLogin();
		tl.setVisible(true);
		tl.setLocationRelativeTo(null);

		new LoginController(tl);
	}

}
