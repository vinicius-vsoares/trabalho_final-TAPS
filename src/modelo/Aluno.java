package modelo;

public class Aluno extends Usuario {
	private String matricula_coord;
	private int serie;

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(String id_usuario, String nome, String senha, String matricula_coord, int serie) {
		super(id_usuario, nome, senha);
		this.matricula_coord = matricula_coord;
		this.serie = serie;
	}



	public String getMatricula_coord() {
		return matricula_coord;
	}

	public void setMatricula_coord(String matricula_coord) {
		this.matricula_coord = matricula_coord;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

}
