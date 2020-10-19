package classesDeTeste;


import dao.AlunoDAO;
import dao.CoordenadorDAO;
import modelo.Aluno;
import modelo.Coordenador;
import modelo.Usuario;

public class Teste {
	public static void main(String[] args) {
		Coordenador o = new Coordenador("562384","Coord","123"); 
		new CoordenadorDAO(o).insertCoord();
		Coordenador o2 = new Coordenador("456322","Coord2","123"); 
		new CoordenadorDAO(o2).insertCoord();
	}
}
