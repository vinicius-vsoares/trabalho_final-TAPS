package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Coordenador;

public class CoordenadorDAO {
	private Conexao conn;
	private Coordenador coord;

	public CoordenadorDAO(Coordenador coord) {
		conn = new Conexao();
		this.coord = coord;
	}

	public CoordenadorDAO() {
		conn = new Conexao();
	}

	public void insertCoord() {
		conn.execute("insert into Usuario(matricula,nome,senha) values('" + coord.getId_usuario() + "','"
				+ coord.getNome() + "','" + coord.getSenha() + "');");
		conn.execute("insert into Coordenador(matricula_coord) values(" + coord.getId_usuario() + ");");
	}

	public ResultSet selectCoord(String s) {
		return conn.select("select * from coordenador c" + s);
	}

	public boolean isCoord() {
		conn.getConexao();
		String query = "select count(matricula_coord) as 'count' from Coordenador where matricula ='"
				+ coord.getId_usuario() + "';";
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

	public Coordenador getCoord() {
		return coord;
	}

	public void setCoord(Coordenador coord) {
		this.coord = coord;
	}

	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

}
