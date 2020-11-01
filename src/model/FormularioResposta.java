package model;

public class FormularioResposta {

	private long idFormulario;
	private Formulario formulario;
	private String paracerCoordenador;
	private String parecerAreas;

	public FormularioResposta() {
		super();
	}

	public FormularioResposta(long idFormulario, Formulario formulario, String paracerCoordenador,
			String parecerAreas) {
		super();
		this.idFormulario = idFormulario;
		this.formulario = formulario;
		this.paracerCoordenador = paracerCoordenador;
		this.parecerAreas = parecerAreas;
	}

	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public String getParacerCoordenador() {
		return paracerCoordenador;
	}

	public void setParacerCoordenador(String paracerCoordenador) {
		this.paracerCoordenador = paracerCoordenador;
	}

	public String getParecerAreas() {
		return parecerAreas;
	}

	public void setParecerAreas(String parecerAreas) {
		this.parecerAreas = parecerAreas;
	}

}
