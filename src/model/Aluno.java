package model;

public class Aluno extends Usuario {
	private String matriculaCoordenador;
	private int serie;

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(String idUsuario, String nome, String senha, String matriculaCoordenador, int serie) {
		super(idUsuario, nome, senha);
		this.matriculaCoordenador = matriculaCoordenador;
		this.serie = serie;
	}

	public String getMatriculaCoordenador() {
		return matriculaCoordenador;
	}

	public void setMatriculaCoordenador(String matriculaCoordenador) {
		this.matriculaCoordenador = matriculaCoordenador;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

}
