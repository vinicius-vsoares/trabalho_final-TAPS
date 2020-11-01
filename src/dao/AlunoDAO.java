package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;

public class AlunoDAO {
	private Conexao conexaoBD;
	private Aluno aluno;

	public AlunoDAO(Aluno aluno) {
		conexaoBD = new Conexao();
		this.aluno = aluno;
	}

	public AlunoDAO() {
		conexaoBD = new Conexao();
	}

	public void insertAluno() {
		conexaoBD.execute("insert into Usuario(matricula,nome,senha) values('" + aluno.getIdUsuario() + "','"
				+ aluno.getNome() + "','" + aluno.getSenha() + "');");
		conexaoBD.execute("insert into Aluno(matricula_aluno,serie,matricula_coord) values('" + aluno.getIdUsuario()
				+ "'," + aluno.getSerie() + ",'" + aluno.getMatriculaCoordenador() + "');");

	}

	public boolean validaMatricula() {
		conexaoBD.getConexaoBD();
		String query = "select count(matricula) as 'count' from Usuario where matricula ='" + aluno.getIdUsuario()
				+ "';";
		int linhas = 0;
		try {

			ResultSet resultSet = conexaoBD.getCon().prepareStatement(query).executeQuery();
			if (resultSet.next())
				linhas = Integer.parseInt(resultSet.getString("count"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (linhas == 1)
			return false;
		else
			return true;
	}

	public boolean validaCoordenador() {
		String query = "select count(matricula_coord) as 'count' from Coordenador where matricula_coord ='"
				+ aluno.getMatriculaCoordenador() + "';";
		int linhas = 0;
		try {

			ResultSet res = conexaoBD.getCon().prepareStatement(query).executeQuery();
			if (res.next())
				linhas = Integer.parseInt(res.getString("count"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (linhas == 0)
			return false;
		else
			return true;
	}

	public boolean isUsuario() {
		conexaoBD.getConexaoBD();
		String query = "select count(matricula) as 'count' from Usuario where matricula ='" + aluno.getIdUsuario()
				+ "';";
		int linhas = 0;
		try {

			ResultSet resultSet = conexaoBD.getCon().prepareStatement(query).executeQuery();
			if (resultSet.next())
				linhas = Integer.parseInt(resultSet.getString("count"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (linhas == 1)
			return true;
		else
			return false;
	}

	public ResultSet selectAluno(String s) {
		return conexaoBD.select("select * from aluno a" + s);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Conexao getConexaoBD() {
		return conexaoBD;
	}

	public void setConexaoBD(Conexao conexao) {
		this.conexaoBD = conexao;
	}

}
