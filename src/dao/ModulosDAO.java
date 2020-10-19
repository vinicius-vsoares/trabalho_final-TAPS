package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Modulos;

public class ModulosDAO {
	private Conexao conn;
	private Modulos modu;

	public ModulosDAO() {
		conn = new Conexao();
	}

	public ModulosDAO(Modulos modu) {
		conn = new Conexao();
		this.modu = modu;
	}

	public int insertModulos() {
		return conn.execute("insert into modulos(area,area_especifica,periodo,id_formrp) values('" + modu.getArea() + "','"
				+ modu.getArea_especifica() + "','" + modu.getPeriodo() +"',"+modu.getFormR().getId()+ ");");
	}
	public ArrayList<Modulos> getModulos(){
		ArrayList<Modulos> m = new ArrayList<Modulos>();
		String query = "select * from modulos m where m.id_formrp ="+modu.getFormR().getId()+";";
		ResultSet res = conn.select(query);
		try {
			while (res.next()) {
				m.add(new Modulos(res.getLong("id_mod"),modu.getFormR(),res.getString("periodo"), res.getString("area"), res.getString("area_especifica")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public ResultSet selectModu(String s) {
		return conn.select("select * from modulos m" + s);
	}

	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

	public Modulos getModu() {
		return modu;
	}

	public void setModu(Modulos modu) {
		this.modu = modu;
	}
	
}
