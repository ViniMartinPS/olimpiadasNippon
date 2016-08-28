package olimpiadas.games.banco;

import java.util.ArrayList;
import java.util.HashMap;

import olimpiadas.games.modelo.Campeonato;
import olimpiadas.games.modelo.Equipe;
import olimpiadas.games.modelo.Jogo;

public class BaseDados {

	static public Equipe equipe1;
	static public Equipe equipe2;
	static public Equipe equipe3;
	
	static public Jogo jogo12;
	static public Jogo jogo13;
	static public Jogo jogo23;
	
	public static void inicialize(){
		/*
		equipe1 = new Equipe();
		ArrayList<String> jogadores1 = new ArrayList<String>();
		jogadores1.add("Player 1 Equipe 1");
		jogadores1.add("Player 2 Equipe 1");
		jogadores1.add("Player 3 Equipe 1");
		equipe1.setJogadores(jogadores1);
		equipe1.setNome("Equipe1");
		
		createEquipe(equipe1);
		
		equipe2 = new Equipe();
		ArrayList<String> jogadores2 = new ArrayList<String>();
		jogadores2.add("Player 1 Equipe 2");
		jogadores2.add("Player 2 Equipe 2");
		jogadores2.add("Player 3 Equipe 2");
		equipe2.setJogadores(jogadores2);
		equipe2.setNome("Equipe2");
		
		createEquipe(equipe2);
		
		equipe3 = new Equipe();
		ArrayList<String> jogadores3 = new ArrayList<String>();
		jogadores3.add("Player 1 Equipe 3");
		jogadores3.add("Player 2 Equipe 3");
		jogadores3.add("Player 3 Equipe 3");
		equipe3.setJogadores(jogadores3);
		equipe3.setNome("Equipe3");
		
		createEquipe(equipe3);
		
		jogo12 = new Jogo();
		jogo12.setEquipe1(equipe1);
		jogo12.setEquipe2(equipe2);
		jogo12.setEsporte("esporte1");
		jogo12.setPlacarEqp1(1);
		jogo12.setPlacarEqp2(2);
		jogo12.setStatus("FECHADO");
		
		createJogo(jogo12);
		
		jogo13 = new Jogo();
		jogo13.setEquipe1(equipe1);
		jogo13.setEquipe2(equipe2);
		jogo13.setEsporte("esporte2");
		jogo13.setPlacarEqp1(2);
		jogo13.setPlacarEqp2(2);
		jogo13.setStatus("ABERTO");
		
		createJogo(jogo13);
		
		jogo23 = new Jogo();
		jogo23.setEquipe1(equipe1);
		jogo23.setEquipe2(equipe2);
		jogo23.setEsporte("esporte3");
		//jogo23.setPlacarEqp1(0);
		//jogo23.setPlacarEqp2(0);
		jogo23.setStatus("NAO-INICIADO");
		
		createJogo(jogo23);
		*/
	}
	
	public static void createEquipe(Equipe equipe){
		BancoEquipe.id.add(BancoEquipe.id.size() + 1);
		BancoEquipe.nomeEquipe.add(equipe.getNome());
		BancoEquipe.jogadores.add(equipe.getJogadores());
	}
	
	public static Equipe getEquipe(int id){
		
		for (int i = 0;i <BancoEquipe.id.size();i++){
			if (BancoEquipe.id.get(i) == id){
				Equipe equipe = new Equipe();
				equipe.setNome(BancoEquipe.nomeEquipe.get(i));
				equipe.setId(BancoEquipe.id.get(i));
				equipe.setJogadores(BancoEquipe.jogadores.get(i));
				return equipe;
			}
		}
		return null;		
	}
	
	public static void createJogo(Jogo jogo){
		BaseJogo.equipe1.add(jogo.getEquipe1().getId());
		BaseJogo.equipe2.add(jogo.getEquipe2().getId());
		BaseJogo.esporte.add(jogo.getEsporte());
		BaseJogo.id.add(BaseJogo.id.size() + 1);
		BaseJogo.local.add(jogo.getLocal());
		BaseJogo.placarEqp1.add(jogo.getPlacarEqp1());
		BaseJogo.placarEqp2.add(jogo.getPlacarEqp2());
	}
	
	public static Jogo getJogo(int id){
		for (int i = 0;i <BancoEquipe.id.size(); i++){
			if (BaseJogo.id.get(i) == id ){
				Jogo jogo = new Jogo();
				jogo.setEquipe1(getEquipe(BaseJogo.equipe1.get(i)));
				jogo.setEquipe2(getEquipe(BaseJogo.equipe2.get(i)));
				jogo.setEsporte(BaseJogo.esporte.get(i));	
				jogo.setLocal(BaseJogo.local.get(i));
				jogo.setPlacarEqp1(BaseJogo.placarEqp1.get(i));
				jogo.setPlacarEqp2(BaseJogo.placarEqp2.get(i));
				return jogo;
			}
		}
		return null;
	}

		

	public static ArrayList<Jogo> getAllJogos(){
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();

		for (int i = 0;i<BaseJogo.id.size() ; i++){
			Jogo jogo = new Jogo();
			jogo.setEquipe1(getEquipe(BaseJogo.equipe1.get(i)));
			jogo.setEquipe2(getEquipe(BaseJogo.equipe2.get(i)));
			jogo.setEsporte(BaseJogo.esporte.get(i));	
			jogo.setLocal(BaseJogo.local.get(i));
			jogo.setPlacarEqp1(BaseJogo.placarEqp1.get(i));
			jogo.setPlacarEqp2(BaseJogo.placarEqp2.get(i));
			jogos.add(jogo);
		}
		
		return jogos;
	}
	
	public static void createCampeonato(String nome, String esporte){
		BaseCampeonato.id.add(BaseCampeonato.id.size() + 1);
		BaseCampeonato.esporte.add(esporte);
		BaseCampeonato.grupo1.add(new HashMap<Integer,Integer>());
		BaseCampeonato.grupo2.add(new HashMap<Integer, Integer>());
		BaseCampeonato.jogosGrupo1.add(new ArrayList<Integer>());
		BaseCampeonato.jogosGrupo2.add(new ArrayList<Integer>());
		BaseCampeonato.nome.add(nome);
	}
	
	public static void insereEquipeCampeonato(int idEquipe, int idCampeonato, int grupo){
		for (int i = 0; i>BaseCampeonato.id.size(); i++){
			if  (BaseCampeonato.id.get(i) == idCampeonato){
				if (grupo ==1){
					BaseCampeonato.grupo1.get(i).put(idEquipe, 0);
				} else if (grupo ==2){
					BaseCampeonato.grupo2.get(i).put(idEquipe, 0);
				}
			}
		}
		
		
	}
	
	public static void insereJogoCampeonato(int idJogo, int idCampeonato, int grupo){
		for (int i = 0; i>BaseCampeonato.id.size(); i++){
			if  (BaseCampeonato.id.get(i) == idCampeonato){
				if (grupo ==1){
					BaseCampeonato.jogosGrupo1.get(i).add(idJogo);
				} else if (grupo ==2){
					BaseCampeonato.jogosGrupo2.get(i).add(idJogo);
				}
			}
		}
	}
	
	public static void atualizaPlacarJogo(int idJogo, int placarEqp1, int placarEqp2 , int idCampeonato){
		for (int i = 0; i>BaseCampeonato.id.size(); i++){
			if  (BaseCampeonato.id.get(i) == idCampeonato){
				for (int j = 0 ; j< BaseCampeonato.grupo1.get(i).size() ; j++){
					if (BaseCampeonato.jogosGrupo1.get(i).contains(idJogo)){
						getJogo(idJogo).setPlacarEqp1(placarEqp1);
						getJogo(idJogo).setPlacarEqp2(placarEqp2);
					}
					else if (BaseCampeonato.jogosGrupo2.get(i).contains(idJogo)){
						getJogo(idJogo).setPlacarEqp1(placarEqp1);
						getJogo(idJogo).setPlacarEqp2(placarEqp2);
					}
				}
			}
		}
	}
	
	public static void atualizaClassificacao(int idCampeonato){
		
	}
	
	public static void atualizaStatusJogo(String status, int idJogo){
		getJogo(idJogo).setStatus(status);
	}
	
	public static ArrayList<Campeonato> getCampeonatos (){
		ArrayList<Campeonato> listaCampeonatos = new ArrayList<Campeonato>();
		for (int i = 0 ; i<BaseCampeonato.id.size() ; i++){
			Campeonato campeonato = new Campeonato();
			campeonato.setEsporte(BaseCampeonato.esporte.get(i));
			campeonato.setGrupo1(BaseCampeonato.grupo1.get(i));
			campeonato.setGrupo2(BaseCampeonato.grupo2.get(i));
			campeonato.setId(BaseCampeonato.id.get(i));
			campeonato.setJogosGrupo1(BaseCampeonato.jogosGrupo1.get(i));
			campeonato.setJogosGrupo2(BaseCampeonato.jogosGrupo2.get(i));
			campeonato.setNome(BaseCampeonato.nome.get(i));
			listaCampeonatos.add(campeonato);
		}
		return listaCampeonatos;
	}
	
	public static void insereJogador(String nome, int idEquipe){
		getEquipe(idEquipe).setNome(nome);
	}
	
	public static Campeonato getCampeonato(int idCampeonato){
		for (int i = 0 ; i<BaseCampeonato.id.size() ; i++){
			if (BaseCampeonato.id.get(i) == idCampeonato){
			Campeonato campeonato = new Campeonato();
			campeonato.setEsporte(BaseCampeonato.esporte.get(i));
			campeonato.setGrupo1(BaseCampeonato.grupo1.get(i));
			campeonato.setGrupo2(BaseCampeonato.grupo2.get(i));
			campeonato.setId(BaseCampeonato.id.get(i));
			campeonato.setJogosGrupo1(BaseCampeonato.jogosGrupo1.get(i));
			campeonato.setJogosGrupo2(BaseCampeonato.jogosGrupo2.get(i));
			campeonato.setNome(BaseCampeonato.nome.get(i));
			return campeonato;
			}
			
		}
		return null;
	}
	
	public static ArrayList<Equipe> getEquipes(){
		return null;
	}
	
}
