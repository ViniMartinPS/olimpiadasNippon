package olimpiadas.games.negocios;

import java.util.ArrayList;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.modelo.Jogo;

public class RegrasJogo {
	
	
	public ArrayList<Jogo> getAllJogos(){
		return BaseDados.getAllJogos();
	}

}
