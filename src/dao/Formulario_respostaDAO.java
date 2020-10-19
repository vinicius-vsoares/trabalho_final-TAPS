package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Formulario_resposta;
import modelo.Troca_area;

public class Formulario_respostaDAO {
	private Conexao conn;
	private Formulario_resposta formR;

	public Formulario_respostaDAO() {
		conn = new Conexao();
	}

	public Formulario_respostaDAO(Formulario_resposta formR) {
		conn = new Conexao();
		this.formR = formR;
	}

	public int insertformR() {
		int id = conn
				.execute("insert into Formulario_resposta(parecer_coord,parecer_areas,id_form,matricula_coord) values('"
						+ formR.getParacer_coord() + "','" + formR.getParecer_areas() + "'," + formR.getForm().getId()
						+ ",'" + formR.getForm().getCoord().getId_usuario() + "');");
		formR.setId(id);
		return id;
	}

	public ResultSet selectformR(String s) {
		return conn.select("select * from formulario_resposta fr" + s);
	}

	public boolean possuiParecer() {
		String query = "select count(id_form) as 'count' from Formulario_resposta where matricula_coord ='"
				+ formR.getForm().getCoord().getId_usuario() + "' and id_form=" + formR.getForm().getId() + ";";
		int linhas = 0;
		ResultSet res = conn.select(query);
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
	public Troca_area getFormRDAO() {
		Troca_area ta = new Troca_area();
		ta.setFormR(new Formulario_resposta());
		ta.setTa(new Troca_area());
		String query = "select * from Formulario_resposta rp, troca_area ta where rp.id_formrp = ta.id_formrp and rp.id_form ="+formR.getForm().getId()+";";
		ResultSet res = conn.select(query);
		try {
			if(res.next()) {
				ta.getFormR().setParacer_coord(res.getString("parecer_coord"));
				ta.getFormR().setParecer_areas(res.getString("parecer_areas"));
				ta.getFormR().setId(res.getLong("id_formrp"));
				ta.setAlunos(res.getInt("n_alunos"));
				ta.setArea(res.getString("area"));
				ta.setVagas(res.getInt("vagas"));
				ta.setId(res.getLong("id_troca"));
			}
			query = "select * from troca_area ta where ta.id_troca_area="+ta.getId()+";";
			res = conn.select(query);
			if(res.next()) {
				ta.getTa().setAlunos(res.getInt("n_alunos"));
				ta.getTa().setArea(res.getString("area"));
				ta.getTa().setVagas(res.getInt("vagas"));
				ta.getTa().setId(res.getLong("id_troca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ta;
	}
	public Troca_area getFormRDAO2(Troca_area t) {
		Troca_area ta = new Troca_area();
		ta.setFormR(new Formulario_resposta());
		ta.setTa(new Troca_area());
		String query = "select * from Formulario_resposta rp, troca_area ta where rp.id_formrp = ta.id_formrp and rp.id_form ="+formR.getForm().getId()+" and ta.id_troca !="+t.getId()+" and ta.id_troca!="+t.getTa().getId()+";";
		ResultSet res = conn.select(query);
		try {
			if(res.next()) {
				ta.getFormR().setParacer_coord(res.getString("parecer_coord"));
				ta.getFormR().setParecer_areas(res.getString("parecer_areas"));
				ta.getFormR().setId(res.getLong("id_formrp"));
				ta.setAlunos(res.getInt("n_alunos"));
				ta.setArea(res.getString("area"));
				ta.setVagas(res.getInt("vagas"));
				ta.setId(res.getLong("id_troca"));
			}
			query = "select * from troca_area ta where ta.id_troca_area="+ta.getId()+";";
			res = conn.select(query);
			if(res.next()) {
				ta.getTa().setAlunos(res.getInt("n_alunos"));
				ta.getTa().setArea(res.getString("area"));
				ta.getTa().setVagas(res.getInt("vagas"));
				ta.getTa().setId(res.getLong("id_troca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ta;
	}
	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

	public Formulario_resposta getFormR() {
		return formR;
	}

	public void setFormR(Formulario_resposta formR) {
		this.formR = formR;
	}

}
