package modelo;

import java.sql.Date;

public class Formulario {
	private long id;
	private Aluno aluno;
	private Coordenador coord;
	private String telefone;
	private String area_atual;
	private String area_nova;
	private String data;
	private String data_ini;
	private String obs;

	public Formulario(Aluno aluno, String telefone, String area_atual, String area_nova, String data, String data_ini,
			String obs) {
		super();
		this.aluno = aluno;
		this.telefone = telefone;
		this.area_atual = area_atual;
		this.area_nova = area_nova;
		this.data = data;
		this.data_ini = data_ini;
		this.obs = obs;
	}

	public Coordenador getCoord() {
		return coord;
	}

	public void setCoord(Coordenador coord) {
		this.coord = coord;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getArea_atual() {
		return area_atual;
	}

	public void setArea_atual(String area_atual) {
		this.area_atual = area_atual;
	}

	public String getArea_nova() {
		return area_nova;
	}

	public void setArea_nova(String area_nova) {
		this.area_nova = area_nova;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData_ini() {
		return data_ini;
	}

	public void setData_ini(String data2) {
		this.data_ini = data2;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Formulario() {
		super();
	}


}
