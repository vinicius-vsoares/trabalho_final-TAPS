package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;
import modelo.Usuario;

public class UsuarioDAO {
	private Conexao conn;
	private Usuario usuario;

	public UsuarioDAO(Usuario usuario) {
		conn = new Conexao();
		this.usuario = usuario;
	}

	public UsuarioDAO() {
		conn = new Conexao();
	}

	public Usuario login() {
		conn.getConexao();
		String query = "select * from Usuario where matricula ='" + usuario.getId_usuario() + "' and senha='"
				+ usuario.getSenha() + "';";
		try {
			ResultSet res = conn.getCon().prepareStatement(query).executeQuery();
			res.next();

			if (res.getRow() == 1) {
				usuario.setNome(res.getString("nome"));
				return usuario;
			} else {
				usuario = null;
			}
			return usuario;
		} catch (SQLException e) {
			return null;
		} finally {
			conn.close();
		}
	}
	
	
	public Aluno getAluno() {
		conn.getConexao();
		Aluno aluno = new Aluno();
		String query = "select * from Aluno where matricula_aluno ='" + usuario.getId_usuario() 
				+ "';";
		try {
			ResultSet res = conn.getCon().prepareStatement(query).executeQuery();
			res.next();

			if (res.getRow() == 1) {
				aluno.setSerie(Integer.parseInt(res.getString("serie")));
				aluno.setMatricula_coord(res.getString("matricula_coord"));
				return aluno;
			} else {
				aluno = null;
			}
			return aluno;
		} catch (SQLException e) {
			return null;
		} finally {
			conn.close();
		}
	}

}
