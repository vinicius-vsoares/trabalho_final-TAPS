package model;

public class Formulario {
	private long idFormulario;
	private Aluno aluno;
	private Coordenador coordenador;
	private String telefone;
	private String areaAtual;
	private String novaArea;
	private String data;
	private String dataInicio;
	private String observacao;

	public Formulario(Aluno aluno, String telefone, String areaAtual, String novaArea, String data, String dataInicio,
			String observacao) {
		super();
		this.aluno = aluno;
		this.telefone = telefone;
		this.areaAtual = areaAtual;
		this.novaArea = novaArea;
		this.data = data;
		this.dataInicio = dataInicio;
		this.observacao = observacao;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getAreaAtual() {
		return areaAtual;
	}

	public void setAreaAtual(String areaAtual) {
		this.areaAtual = areaAtual;
	}

	public String getNovaArea() {
		return novaArea;
	}

	public void setNovaArea(String area_nova) {
		this.novaArea = area_nova;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
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
