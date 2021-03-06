package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	private String host = "localhost";
	private String db = "projeto";
	private String user = "root";
	private String password = "";
	private int port = 3306;
	private String url = String.format("jdbc:mysql://%s:%d/%s", this.host, this.port, this.db);
	private Connection conexaoBD;

	public Conexao() {
	}

	public int execute(String query) {
		int id = 0;
		ResultSet res = null;
		this.getConexaoBD();
		try {
			PreparedStatement p = this.conexaoBD.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			p.execute();
			res = p.getGeneratedKeys();
			if (res.next()) {
				id = res.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.close();
		}
		return id;
	}

	public ResultSet select(String query) {
		ResultSet res = null;
		this.getConexaoBD();
		try {
			res = this.conexaoBD.prepareStatement(query).executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.close();
		}
		return res;
	}

	public void getConexaoBD() {
		try {
			this.conexaoBD = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		if (this.conexaoBD != null) {
			try {
				// this.con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				this.conexaoBD = null;
			}
		}
	}

	public Connection getCon() {
		return conexaoBD;
	}

	public void setCon(Connection con) {
		this.conexaoBD = con;
	}

}
