package modelo;

public class Formulario_resposta {

	private long id;
	private Formulario form;
	private String paracer_coord;
	private String parecer_areas;

	public Formulario_resposta() {
		super();
	}

	public Formulario_resposta(long id, Formulario form, String paracer_coord, String parecer_areas) {
		super();
		this.id = id;
		this.form = form;
		this.paracer_coord = paracer_coord;
		this.parecer_areas = parecer_areas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Formulario getForm() {
		return form;
	}

	public void setForm(Formulario form) {
		this.form = form;
	}

	public String getParacer_coord() {
		return paracer_coord;
	}

	public void setParacer_coord(String paracer_coord) {
		this.paracer_coord = paracer_coord;
	}

	public String getParecer_areas() {
		return parecer_areas;
	}

	public void setParecer_areas(String parecer_areas) {
		this.parecer_areas = parecer_areas;
	}

}
