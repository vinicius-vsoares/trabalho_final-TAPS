package test;


import dao.CoordenadorDAO;
import model.Coordenador;

public class Teste {
	public static void main(String[] args) {
		Coordenador coordenador1 = new Coordenador("562384","Coord","123"); 
		new CoordenadorDAO(coordenador1).insertCoord();
		Coordenador coordenador2 = new Coordenador("456322","Coord2","123"); 
		new CoordenadorDAO(coordenador2).insertCoord();
	}
}
