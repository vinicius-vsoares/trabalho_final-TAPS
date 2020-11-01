package model;

public class Modulos {

	private long idFormulario;
	private FormularioResposta formularioResposta;
	private String periodo;
	private String areaGeral;
	private String areaEspecifica;

	public Modulos(long id, FormularioResposta formR, String periodo, String area, String area_especifica) {
		super();
		this.idFormulario = id;
		this.formularioResposta = formR;
		this.periodo = periodo;
		this.areaGeral = area;
		this.areaEspecifica = area_especifica;
	}

	public Modulos(FormularioResposta formularioResposta, String periodo, String areaGeral, String areaEspecifica) {
		this.formularioResposta = formularioResposta;
		this.periodo = periodo;
		this.areaGeral = areaGeral;
		this.areaEspecifica = areaEspecifica;
	}

	public Modulos(FormularioResposta formR) {
		this.formularioResposta = formR;
	}

	public FormularioResposta getFormularioResposta() {
		return formularioResposta;
	}

	public void setFormularioResposta(FormularioResposta formularioResposta) {
		this.formularioResposta = formularioResposta;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getAreaGeral() {
		return areaGeral;
	}

	public void setAreaGeral(String areaGeral) {
		this.areaGeral = areaGeral;
	}

	public String getAreaEspecifica() {
		return areaEspecifica;
	}

	public void setAreaEspecifica(String areaEspecifica) {
		this.areaEspecifica = areaEspecifica;
	}

	public long getId() {
		return idFormulario;
	}

	public void setId(long id) {
		this.idFormulario = id;
	}

}
