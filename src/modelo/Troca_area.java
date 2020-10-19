package modelo;

public class Troca_area {

	private Troca_area ta;
	private Formulario_resposta formR;
	private long id;
	private String area;
	private int vagas;
	private int alunos;

	public Troca_area(Troca_area ta, Formulario_resposta formR, String area, int vagas, int alunos) {
		super();
		this.ta = ta;
		this.formR = formR;
		this.area = area;
		this.vagas = vagas;
		this.alunos = alunos;
	}

	public Troca_area(Formulario_resposta formR, String area, int vagas, int alunos) {
		super();
		this.formR = formR;
		this.area = area;
		this.vagas = vagas;
		this.alunos = alunos;
	}

	public Troca_area() {
		// TODO Auto-generated constructor stub
	}

	public Formulario_resposta getFormR() {
		return formR;
	}

	public void setFormR(Formulario_resposta formR) {
		this.formR = formR;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Troca_area getTa() {
		return ta;
	}

	public void setTa(Troca_area ta) {
		this.ta = ta;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}

}
