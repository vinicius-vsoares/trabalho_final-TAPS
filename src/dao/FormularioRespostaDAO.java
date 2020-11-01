package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.FormularioResposta;
import model.TrocaArea;

public class FormularioRespostaDAO {
	private Conexao conexaoBD;
	private FormularioResposta formularioResposta;

	public FormularioRespostaDAO() {
		conexaoBD = new Conexao();
	}

	public FormularioRespostaDAO(FormularioResposta formularioResposta) {
		conexaoBD = new Conexao();
		this.formularioResposta = formularioResposta;
	}

	public int insertFormularioResposta() {
		int idFormulario = conexaoBD
				.execute("insert into Formulario_resposta(parecer_coord,parecer_areas,id_form,matricula_coord) values('"
						+ formularioResposta.getParacerCoordenador() + "','" + formularioResposta.getParecerAreas()
						+ "'," + formularioResposta.getFormulario().getIdFormulario() + ",'"
						+ formularioResposta.getFormulario().getCoordenador().getIdUsuario() + "');");
		formularioResposta.setIdFormulario(idFormulario);
		return idFormulario;
	}

	public ResultSet selectFormularioResposta(String s) {
		return conexaoBD.select("select * from formulario_resposta fr" + s);
	}

	public boolean possuiParecer() {
		String query = "select count(id_form) as 'count' from Formulario_resposta where matricula_coord ='"
				+ formularioResposta.getFormulario().getCoordenador().getIdUsuario() + "' and id_form="
				+ formularioResposta.getFormulario().getIdFormulario() + ";";
		int linhas = 0;
		ResultSet res = conexaoBD.select(query);
		try {
			if (res.next())
				linhas = Integer.parseInt(res.getString("count"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (linhas == 1)
			return true;
		else
			return false;
	}

	public TrocaArea getFormRespostaDAO() {
		TrocaArea area1 = new TrocaArea();
		area1.setFormularioResposta(new FormularioResposta());
		area1.setTrocaArea(new TrocaArea());
		String query = "select * from Formulario_resposta rp, troca_area ta where rp.id_formrp = ta.id_formrp and rp.id_form ="
				+ formularioResposta.getFormulario().getIdFormulario() + ";";
		ResultSet res = conexaoBD.select(query);
		try {
			if (res.next()) {
				area1.getFormularioResposta().setParacerCoordenador(res.getString("parecer_coord"));
				area1.getFormularioResposta().setParecerAreas(res.getString("parecer_areas"));
				area1.getFormularioResposta().setIdFormulario(res.getLong("id_formrp"));
				area1.setAlunos(res.getInt("n_alunos"));
				area1.setArea(res.getString("area"));
				area1.setVagas(res.getInt("vagas"));
				area1.setIdFormulario(res.getLong("id_troca"));
			}
			query = "select * from troca_area ta where ta.id_troca_area=" + area1.getIdFormulario() + ";";
			res = conexaoBD.select(query);
			if (res.next()) {
				area1.getTrocaArea().setAlunos(res.getInt("n_alunos"));
				area1.getTrocaArea().setArea(res.getString("area"));
				area1.getTrocaArea().setVagas(res.getInt("vagas"));
				area1.getTrocaArea().setIdFormulario(res.getLong("id_troca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return area1;
	}

	public TrocaArea getFormRDAO2(TrocaArea trocaArea) {
		TrocaArea area2 = new TrocaArea();
		area2.setFormularioResposta(new FormularioResposta());
		area2.setTrocaArea(new TrocaArea());
		String query = "select * from Formulario_resposta rp, troca_area ta where rp.id_formrp = ta.id_formrp and rp.id_form ="
				+ formularioResposta.getFormulario().getIdFormulario() + " and ta.id_troca !="
				+ trocaArea.getIdFormulario() + " and ta.id_troca!=" + trocaArea.getTrocaArea().getIdFormulario() + ";";
		ResultSet res = conexaoBD.select(query);
		try {
			if (res.next()) {
				area2.getFormularioResposta().setParacerCoordenador(res.getString("parecer_coord"));
				area2.getFormularioResposta().setParecerAreas(res.getString("parecer_areas"));
				area2.getFormularioResposta().setIdFormulario(res.getLong("id_formrp"));
				area2.setAlunos(res.getInt("n_alunos"));
				area2.setArea(res.getString("area"));
				area2.setVagas(res.getInt("vagas"));
				area2.setIdFormulario(res.getLong("id_troca"));
			}
			query = "select * from troca_area ta where ta.id_troca_area=" + area2.getIdFormulario() + ";";
			res = conexaoBD.select(query);
			if (res.next()) {
				area2.getTrocaArea().setAlunos(res.getInt("n_alunos"));
				area2.getTrocaArea().setArea(res.getString("area"));
				area2.getTrocaArea().setVagas(res.getInt("vagas"));
				area2.getTrocaArea().setIdFormulario(res.getLong("id_troca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return area2;
	}

	public Conexao getConexaoBD() {
		return conexaoBD;
	}

	public void setConn(Conexao conexaoBD) {
		this.conexaoBD = conexaoBD;
	}

	public FormularioResposta getFormularioResposta() {
		return formularioResposta;
	}

	public void setFormR(FormularioResposta formularioResposta) {
		this.formularioResposta = formularioResposta;
	}

}
