package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;
import model.Formulario;

public class FormularioDAO {
	private Conexao conexaoBD;
	private Formulario formulario;

	public FormularioDAO() {
		conexaoBD = new Conexao();
	}

	public FormularioDAO(Formulario form) {
		conexaoBD = new Conexao();
		this.formulario = form;
	}

	public boolean insertFormulario() {
		try {
			int id = conexaoBD.execute(
					"insert into Formulario(telefone,area_atual,area_nova,data_ini,data,obs,matricula_aluno,matricula_coord) values('"
							+ formulario.getTelefone() + "','" + formulario.getAreaAtual() + "','" + formulario.getNovaArea() + "','"
							+ formulario.getDataInicio() + "','" + formulario.getData() + "','" + formulario.getObservacao() + "','"
							+ formulario.getAluno().getIdUsuario() + "','" + formulario.getAluno().getMatriculaCoordenador() + "');");
			formulario.setIdFormulario(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ResultSet selectFormulario(String s) {
		return conexaoBD.select("select * from Formulario f" + s);
	}

	public void setFormulario(Formulario form) {
		this.formulario = form;
	}

	public Conexao getConexaoBD() {
		return conexaoBD;
	}

	public void setConexaoBD(Conexao conn) {
		this.conexaoBD = conn;
	}

	public boolean alunoPossuiFormulario() {
		conexaoBD.getConexaoBD();
		String query = "select count(id_form) as 'count' from Formulario where matricula_aluno ='"
				+ formulario.getAluno().getIdUsuario() + "';";
		int linhas = 0;
		try {

			ResultSet res = conexaoBD.getCon().prepareStatement(query).executeQuery();
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
		conexaoBD.getConexaoBD();
		String query = "select count(id_form) as 'count' from Formulario where matricula_coord ='"
				+ formulario.getCoordenador().getIdUsuario() +"';";
		int linhas = 0;
		try {
			ResultSet res = conexaoBD.getCon().prepareStatement(query).executeQuery();
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

	public ArrayList<Aluno> retornaFormularioAluno() {
		ArrayList<Aluno> arrayListAluno = new ArrayList<>();
		conexaoBD.getConexaoBD();
		String query = "select nome,matricula,serie from Usuario u,Formulario f,Aluno a where f.matricula_aluno = u.matricula and f.matricula_coord = '"
				+ formulario.getCoordenador().getIdUsuario() + "' and u.matricula = a.matricula_aluno;";
		ResultSet resultSet = conexaoBD.select(query);
		try {
			while (resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(resultSet.getString("nome"));
				aluno.setIdUsuario(resultSet.getString("matricula"));
				aluno.setSerie(resultSet.getInt("serie"));
				arrayListAluno.add(aluno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListAluno;
	}

	public Formulario getFormulario(Aluno aluno) {
		formulario = new Formulario();
		conexaoBD.getConexaoBD();
		String query = "select * from Formulario where matricula_aluno ='" + aluno.getIdUsuario() + "';";
		try {
			ResultSet resultSet = conexaoBD.getCon().prepareStatement(query).executeQuery();
			resultSet.next();

			formulario.setAluno(aluno);
			formulario.setIdFormulario(resultSet.getLong("id_form"));
			formulario.setAreaAtual(resultSet.getString("area_atual"));
			formulario.setNovaArea(resultSet.getString("area_nova"));
			formulario.setDataInicio(resultSet.getString("data_ini"));
			formulario.setData(resultSet.getString("data_ini"));
			formulario.setObservacao(resultSet.getString("obs"));
			formulario.setTelefone(resultSet.getString("telefone"));
			return formulario;

		} catch (SQLException e) {
			return null;
		} finally {
			conexaoBD.close();
		}
	}

}
