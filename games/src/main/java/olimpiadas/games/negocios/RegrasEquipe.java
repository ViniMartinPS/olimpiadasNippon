package olimpiadas.games.negocios;


import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.modelo.Equipe;

public class RegrasEquipe {
	
	public Equipe getEquipe(int id){
		return BaseDados.getEquipe(id);
	}
		

	
}
