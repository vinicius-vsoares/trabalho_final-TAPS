package dao;

import java.sql.ResultSet;

import model.TrocaArea;

public class TrocaAreaDAO {
	private Conexao conexaoBD;
	private TrocaArea trocaArea;

	public TrocaAreaDAO() {
		conexaoBD = new Conexao();
	}

	public TrocaAreaDAO(TrocaArea trocaA) {
		conexaoBD = new Conexao();
		this.trocaArea = trocaA;
	}

	public int insertTrocaArea() {
		int idFormulario = conexaoBD.execute("insert into troca_area(n_alunos,vagas,area,id_formrp) values("
				+ trocaArea.getAlunos() + "," + trocaArea.getVagas() + ",'" + trocaArea.getArea() + "',"
				+ trocaArea.getFormularioResposta().getIdFormulario() + ")");
		trocaArea.setIdFormulario(idFormulario);
		this.insertTrocaAreaDesejada();
		return idFormulario;
	}

	public void insertTrocaAreaDesejada() {
		conexaoBD.execute("insert into troca_area(n_alunos,vagas,area,id_formrp,id_troca_area) values("
				+ trocaArea.getTrocaArea().getAlunos() + "," + trocaArea.getTrocaArea().getVagas() + ",'"
				+ trocaArea.getTrocaArea().getArea() + "'," + trocaArea.getFormularioResposta().getIdFormulario() + ","
				+ trocaArea.getIdFormulario() + ")");
	}

	public ResultSet selectTrocaArea(String s) {
		return conexaoBD.select("select * from troca_area ta" + s);
	}

	public Conexao getConexao() {
		return conexaoBD;
	}

	public void setConexao(Conexao conexaoBD) {
		this.conexaoBD = conexaoBD;
	}

	public TrocaArea getTrocaArea() {
		return trocaArea;
	}

	public void setTrocaA(TrocaArea trocaArea) {
		this.trocaArea = trocaArea;
	}

}
