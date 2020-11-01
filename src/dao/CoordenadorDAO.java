package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Coordenador;

public class CoordenadorDAO {
	private Conexao conexaoBD;
	private Coordenador coordenador;

	public CoordenadorDAO(Coordenador coordenador) {
		conexaoBD = new Conexao();
		this.coordenador = coordenador;
	}

	public CoordenadorDAO() {
		conexaoBD = new Conexao();
	}

	public void insertCoord() {
		conexaoBD.execute("insert into Usuario(matricula,nome,senha) values('" + coordenador.getIdUsuario() + "','"
				+ coordenador.getNome() + "','" + coordenador.getSenha() + "');");
		conexaoBD.execute("insert into Coordenador(matricula_coord) values(" + coordenador.getIdUsuario() + ");");
	}

	public ResultSet selectCoord(String s) {
		return conexaoBD.select("select * from coordenador c" + s);
	}

	public boolean isCoord() {
		conexaoBD.getConexaoBD();
		String query = "select count(matricula_coord) as 'count' from Coordenador where matricula ='"
				+ coordenador.getIdUsuario() + "';";
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

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public Conexao getConexao() {
		return conexaoBD;
	}

	public void setConexao(Conexao conexao) {
		this.conexaoBD = conexao;
	}

}
