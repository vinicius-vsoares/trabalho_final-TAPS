package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Aluno;
import modelo.Formulario;
import modelo.Usuario;

public class FormularioDAO {
	private Conexao conn;
	private Formulario form;

	public FormularioDAO() {
		conn = new Conexao();
	}

	public FormularioDAO(Formulario form) {
		conn = new Conexao();
		this.form = form;
	}

	public boolean insertForm() {
		try {
			int id = conn.execute(
					"insert into Formulario(telefone,area_atual,area_nova,data_ini,data,obs,matricula_aluno,matricula_coord) values('"
							+ form.getTelefone() + "','" + form.getArea_atual() + "','" + form.getArea_nova() + "','"
							+ form.getData_ini() + "','" + form.getData() + "','" + form.getObs() + "','"
							+ form.getAluno().getId_usuario() + "','" + form.getAluno().getMatricula_coord() + "');");
			form.setId(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ResultSet selectForm(String s) {
		return conn.select("select * from Formulario f" + s);
	}

	public void setForm(Formulario form) {
		this.form = form;
	}

	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

	public boolean possuiFormularioAluno() {
		conn.getConexao();
		String query = "select count(id_form) as 'count' from Formulario where matricula_aluno ='"
				+ form.getAluno().getId_usuario() + "';";
		int linhas = 0;
		try {

			ResultSet res = conn.getCon().prepareStatement(query).executeQuery();
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

	public boolean possuiFormularioCoordenador() {
		conn.getConexao();
		String query = "select count(id_form) as 'count' from Formulario where matricula_coord ='"
				+ form.getCoord().getId_usuario() +"';";
		int linhas = 0;
		try {
			ResultSet res = conn.getCon().prepareStatement(query).executeQuery();
			if (res.next())
				linhas = Integer.parseInt(res.getString("count"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (linhas >= 1)
			return true;
		else
			return false;
	}

	public ArrayList<Aluno> retornaAlunoForm() {
		ArrayList<Aluno> a = new ArrayList<>();
		conn.getConexao();
		String query = "select nome,matricula,serie from Usuario u,Formulario f,Aluno a where f.matricula_aluno = u.matricula and f.matricula_coord = '"
				+ form.getCoord().getId_usuario() + "' and u.matricula = a.matricula_aluno;";
		ResultSet res = conn.select(query);
		try {
			while (res.next()) {
				Aluno au = new Aluno();
				au.setNome(res.getString("nome"));
				au.setId_usuario(res.getString("matricula"));
				au.setSerie(res.getInt("serie"));
				a.add(au);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public Formulario getForm(Aluno aluno) {
		form = new Formulario();
		conn.getConexao();
		String query = "select * from Formulario where matricula_aluno ='" + aluno.getId_usuario() + "';";
		try {
			ResultSet res = conn.getCon().prepareStatement(query).executeQuery();
			res.next();

			form.setAluno(aluno);
			form.setId(res.getLong("id_form"));
			form.setArea_atual(res.getString("area_atual"));
			form.setArea_nova(res.getString("area_nova"));
			form.setData_ini(res.getString("data_ini"));
			form.setData(res.getString("data_ini"));
			form.setObs(res.getString("obs"));
			form.setTelefone(res.getString("telefone"));
			return form;

		} catch (SQLException e) {
			return null;
		} finally {
			conn.close();
		}
	}

}
