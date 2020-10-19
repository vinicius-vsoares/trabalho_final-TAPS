package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;

public class AlunoDAO {
	private Conexao conn;
	private Aluno aluno;

	public AlunoDAO(Aluno aluno) {
		conn = new Conexao();
		this.aluno = aluno;
	}

	public AlunoDAO() {
		conn = new Conexao();
	}

	public void insertAluno() {
		conn.execute("insert into Usuario(matricula,nome,senha) values('" + aluno.getId_usuario() + "','"
				+ aluno.getNome() + "','" + aluno.getSenha() + "');");
		conn.execute("insert into Aluno(matricula_aluno,serie,matricula_coord) values('" + aluno.getId_usuario() + "',"
				+ aluno.getSerie() + ",'" + aluno.getMatricula_coord() + "');");

	}

	public boolean validaMatricula() {
		conn.getConexao();
		String query = "select count(matricula) as 'count' from Usuario where matricula ='" + aluno.getId_usuario()
				+ "';";
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
			return false;
		else
			return true;
	}

	public boolean validaCoordenador() {
		String query = "select count(matricula_coord) as 'count' from Coordenador where matricula_coord ='"
				+ aluno.getMatricula_coord() + "';";
		int linhas = 0;
		try {

			ResultSet res = conn.getCon().prepareStatement(query).executeQuery();
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
		conn.getConexao();
		String query = "select count(matricula) as 'count' from Usuario where matricula ='" + aluno.getId_usuario()
				+ "';";
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

	public ResultSet selectAluno(String s) {
		return conn.select("select * from aluno a" + s);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

}
