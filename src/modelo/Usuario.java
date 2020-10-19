package modelo;

public class Usuario {
	private String id_usuario;
	private String nome;
	private String senha;
	public Usuario(String id_usuario, String nome, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}


}
