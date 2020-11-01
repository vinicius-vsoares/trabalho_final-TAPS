package model;

public class TrocaArea {

	private TrocaArea trocaArea;
	private FormularioResposta formularioResposta;
	private long idFormulario;
	private String areaSolicitada;
	private int quantidadeVagas;
	private int quantidadeAlunos;

	public TrocaArea(TrocaArea trocaArea, FormularioResposta formularioResposta, String areaSolicitada, int vagas,
			int alunos) {
		super();
		this.trocaArea = trocaArea;
		this.formularioResposta = formularioResposta;
		this.areaSolicitada = areaSolicitada;
		this.quantidadeVagas = vagas;
		this.quantidadeAlunos = alunos;
	}

	public TrocaArea(FormularioResposta formularioResposta, String areaGeral, int vagas, int alunos) {
		super();
		this.formularioResposta = formularioResposta;
		this.areaSolicitada = areaGeral;
		this.quantidadeVagas = vagas;
		this.quantidadeAlunos = alunos;
	}

	public TrocaArea() {
		// TODO Auto-generated constructor stub
	}

	public FormularioResposta getFormularioResposta() {
		return formularioResposta;
	}

	public void setFormularioResposta(FormularioResposta formularioResposta) {
		this.formularioResposta = formularioResposta;
	}

	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long id) {
		this.idFormulario = id;
	}

	public TrocaArea getTrocaArea() {
		return trocaArea;
	}

	public void setTrocaArea(TrocaArea trocaArea) {
		this.trocaArea = trocaArea;
	}

	public String getArea() {
		return areaSolicitada;
	}

	public void setArea(String area) {
		this.areaSolicitada = area;
	}

	public int getVagas() {
		return quantidadeVagas;
	}

	public void setVagas(int vagas) {
		this.quantidadeVagas = vagas;
	}

	public int getAlunos() {
		return quantidadeAlunos;
	}

	public void setAlunos(int alunos) {
		this.quantidadeAlunos = alunos;
	}

}
