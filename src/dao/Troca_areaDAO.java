package dao;

import java.sql.ResultSet;

import modelo.Troca_area;

public class Troca_areaDAO {
	private Conexao conn;
	private Troca_area trocaA;

	public Troca_areaDAO() {
		conn = new Conexao();
	}

	public Troca_areaDAO(Troca_area trocaA) {
		conn = new Conexao();
		this.trocaA = trocaA;
	}

	public int insertTrocaArea() {
		int id = conn.execute("insert into troca_area(n_alunos,vagas,area,id_formrp) values(" + trocaA.getAlunos() + "," + trocaA.getVagas()
				+ ",'" + trocaA.getArea() +"',"+trocaA.getFormR().getId()+ ")");
		trocaA.setId(id);
		this.insertTrocaAreaDesejada();
		return id;
	}
	public void insertTrocaAreaDesejada() {
		conn.execute("insert into troca_area(n_alunos,vagas,area,id_formrp,id_troca_area) values(" + trocaA.getTa().getAlunos() + "," + trocaA.getTa().getVagas()
				+ ",'" + trocaA.getTa().getArea() +"',"+trocaA.getFormR().getId()+","+trocaA.getId()+ ")");
	}
	public ResultSet selectTrocaArea(String s) {
		return conn.select("select * from troca_area ta" + s);
	}

	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

	public Troca_area getTrocaA() {
		return trocaA;
	}

	public void setTrocaA(Troca_area trocaA) {
		this.trocaA = trocaA;
	}
	
}
