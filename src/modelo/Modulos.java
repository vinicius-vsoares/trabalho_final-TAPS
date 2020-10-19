package modelo;

public class Modulos {

	private long id;
	private Formulario_resposta formR;
	private String periodo;
	private String area;
	private String area_especifica;

	public Modulos(long id, Formulario_resposta formR, String periodo, String area, String area_especifica) {
		super();
		this.id = id;
		this.formR = formR;
		this.periodo = periodo;
		this.area = area;
		this.area_especifica = area_especifica;
	}

	public Modulos(Formulario_resposta formR, String periodo, String area, String area_especifica) {
		this.formR = formR;
		this.periodo = periodo;
		this.area = area;
		this.area_especifica = area_especifica;
	}

	public Modulos(Formulario_resposta formR) {
		this.formR = formR;
	}

	public Formulario_resposta getFormR() {
		return formR;
	}

	public void setFormR(Formulario_resposta formR) {
		this.formR = formR;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea_especifica() {
		return area_especifica;
	}

	public void setArea_especifica(String area_especifica) {
		this.area_especifica = area_especifica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
