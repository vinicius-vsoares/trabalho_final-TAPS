package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Usuario;

public class UsuarioDAO {
	private Conexao conexaoBD;
	private Usuario usuario;

	public UsuarioDAO(Usuario usuario) {
		conexaoBD = new Conexao();
		this.usuario = usuario;
	}

	public UsuarioDAO() {
		conexaoBD = new Conexao();
	}

	public Usuario login() {
		conexaoBD.getConexaoBD();
		String query = "select * from Usuario where matricula ='" + usuario.getIdUsuario() + "' and senha='"
				+ usuario.getSenha() + "';";
		try {
			ResultSet resultSet = conexaoBD.getCon().prepareStatement(query).executeQuery();
			resultSet.next();

			if (resultSet.getRow() == 1) {
				usuario.setNome(resultSet.getString("nome"));
				return usuario;
			} else {
				usuario = null;
			}
			return usuario;
		} catch (SQLException e) {
			return null;
		} finally {
			conexaoBD.close();
		}
	}
	
	
	public Aluno getAluno() {
		conexaoBD.getConexaoBD();
		Aluno aluno = new Aluno();
		String query = "select * from Aluno where matricula_aluno ='" + usuario.getIdUsuario() 
				+ "';";
		try {
			ResultSet resultSet = conexaoBD.getCon().prepareStatement(query).executeQuery();
			resultSet.next();

			if (resultSet.getRow() == 1) {
				aluno.setSerie(Integer.parseInt(resultSet.getString("serie")));
				aluno.setMatriculaCoordenador(resultSet.getString("matricula_coord"));
				return aluno;
			} else {
				aluno = null;
			}
			return aluno;
		} catch (SQLException e) {
			return null;
		} finally {
			conexaoBD.close();
		}
	}

}
