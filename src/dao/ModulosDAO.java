package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modulos;

public class ModulosDAO {
	private Conexao conexaoBD;
	private Modulos modulos;

	public ModulosDAO() {
		conexaoBD = new Conexao();
	}

	public ModulosDAO(Modulos modulos) {
		conexaoBD = new Conexao();
		this.modulos = modulos;
	}

	public int insertModulos() {
		return conexaoBD.execute("insert into modulos(area,area_especifica,periodo,id_formrp) values('" + modulos.getAreaGeral() + "','"
				+ modulos.getAreaEspecifica() + "','" + modulos.getPeriodo() +"',"+modulos.getFormularioResposta().getIdFormulario()+ ");");
	}
	public ArrayList<Modulos> getModulos(){
		ArrayList<Modulos> arrayListModulos = new ArrayList<Modulos>();
		String query = "select * from modulos m where m.id_formrp ="+modulos.getFormularioResposta().getIdFormulario()+";";
		ResultSet resultSet = conexaoBD.select(query);
		try {
			while (resultSet.next()) {
				arrayListModulos.add(new Modulos(resultSet.getLong("id_mod"),modulos.getFormularioResposta(),resultSet.getString("periodo"), resultSet.getString("area"), resultSet.getString("area_especifica")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListModulos;
	}
	public ResultSet selectModulos(String s) {
		return conexaoBD.select("select * from modulos m" + s);
	}

	public Conexao getConexao() {
		return conexaoBD;
	}

	public void setConn(Conexao conexao) {
		this.conexaoBD = conexao;
	}

	public Modulos getModulos2() {
		return modulos;
	}

	public void setModulos(Modulos modulos) {
		this.modulos = modulos;
	}
	
}
