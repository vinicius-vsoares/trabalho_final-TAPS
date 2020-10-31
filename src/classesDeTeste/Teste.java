package classesDeTeste;


import dao.CoordenadorDAO;
import modelo.Coordenador;

public class Teste {
	public static void main(String[] args) {
		Coordenador o = new Coordenador("562384","Coord","123"); 
		new CoordenadorDAO(o).insertCoord();
		Coordenador o2 = new Coordenador("456322","Coord2","123"); 
		new CoordenadorDAO(o2).insertCoord();
	}
}
