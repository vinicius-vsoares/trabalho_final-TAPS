package controller;

import view.TelaLogin;

public class Main {

	public static void main(String[] args) {
		TelaLogin telaLogin = new TelaLogin();
		telaLogin.setVisible(true);
		telaLogin.setLocationRelativeTo(null);

		new LoginController(telaLogin);
	}

}
