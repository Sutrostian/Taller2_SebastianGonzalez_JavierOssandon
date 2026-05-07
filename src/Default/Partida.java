package Default;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	private String NombreJugador;
	private ArrayList<Pokemon> EquipoPokemon;
	private Pokemon[] EquipoPokemonActual;
	
	
	/**
	 * @param nombreJugador
	 * @param equipoPokemon
	 */
	public Partida(String nombreJugador) {
		super();
		NombreJugador = nombreJugador;
		EquipoPokemon = new ArrayList<Pokemon>();
		EquipoPokemonActual = new Pokemon[6];
		
	}
	public String getNombreJugador() {
		return NombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		NombreJugador = nombreJugador;
	}
	public void getEquipoPokemon() {
		if(EquipoPokemon.size() == 0) {
			System.out.println("Aun no tienes ningun Pokemon, Vamos ve a atraparlos :)");
			
		}else {
			for (int i = 0; i < EquipoPokemon.size(); i++) {
				Pokemon p = EquipoPokemon.get(i);
				System.out.println((i+1)+".-"+p);
				
				
			}
		}
		
		
	
	}
	
	public void getEquipoCombatePokemon() {
		
			for (int i = 0; i < 6; i++) {
				Pokemon p = EquipoPokemonActual[i];
				System.out.println((i+1)+".-"+p);
				
				
			
		}
		
		
	
	}
	
	
	
	public void setEquipoPokemon(ArrayList<Pokemon> equipoPokemon) {
		EquipoPokemon = equipoPokemon;
	}
	
	public void AñadirPokemonAlEquipo(Pokemon p){
		EquipoPokemon.add(p);
		System.out.println("el pokemon "+p+" ha sido añadido al equipo");
		
		
	}
	
   public void ListaPokemons() {
	   for (int i = 0; i < EquipoPokemon.size(); i++) {
		   Pokemon pokemon = EquipoPokemon.get(i);
		System.out.println(i+".-"+pokemon.getNombrePokemon());
		System.out.println("Estadisticas del pokemon:");
		System.out.println("Atk: "+pokemon.getATK());
		System.out.println("Df: "+pokemon.getDF());
		System.out.println("EsAtk: "+pokemon.getESATK());
		System.out.println("EsDf: "+pokemon.getESDF());
		System.out.println("Speed: "+pokemon.getVEL());
		System.out.println("HP: "+pokemon.getVida());
		System.out.println("Tipo: "+pokemon.getTipo());
	}
   }
   public void IntercambiarPokemons(int pos1,int pos2) {
	   
	   Pokemon pokemon1 = EquipoPokemon.get(pos1);
	   Pokemon pokemon2 = EquipoPokemon.get(pos2);
	   Pokemon Aux = pokemon1;
	   EquipoPokemon.set(pos1, pokemon2);
	   EquipoPokemon.set(pos2, Aux);
	   System.out.println("Intercambiados con exito");
	   
   }

   
   public boolean SimularCombate(String Enemigo,ArrayList<Pokemon> EquipoPokemon, ArrayList<Pokemon> Equipoenemigo) {
	   Scanner s = new Scanner(System.in);
	   Boolean VictoriaDeCombate = false;
	   boolean OponenteDerrotado = false;
	   boolean AcaboElCombate = false;
	   int Contador = 0;
	   Pokemon PokemonActual = EquipoPokemon.get(0);
	   while(!AcaboElCombate) {
		  
		   Pokemon PokemonEnemigo = Equipoenemigo.get(Contador);
		   System.out.println(Enemigo+" Saca a "+ PokemonEnemigo);
		   System.out.println(NombreJugador+" Saca a "+ PokemonActual);
		   
		   String eleccion = "0";
		   System.out.println("-----------------------------------------");
		   System.out.println("¿Que deseas hacer?");
		   System.out.println("1) Atacar");
		   System.out.println("2) Cambiar De Pokemon");
		   System.out.println("3) Rendirse");
		   
		   eleccion = s.nextLine();
		   switch(eleccion){
		   case "1":
			   System.out.println(PokemonActual.getNombrePokemon()+"--->"+PokemonActual.getEstadisticasTotales());
			   System.out.println(PokemonEnemigo.getNombrePokemon()+"--->"+PokemonEnemigo.getEstadisticasTotales());
			   
			   
			   if(PokemonActual.getEstadisticasTotales()>PokemonEnemigo.getEstadisticasTotales()) {
				   System.out.println(PokemonActual.getNombrePokemon()+" Gano El Combate");
				   break;
				   
			   }
			   if(PokemonActual.getEstadisticasTotales()<PokemonEnemigo.getEstadisticasTotales()) {
				   System.out.println(PokemonActual.getNombrePokemon()+"Perdio El Combate");
				   PokemonActual.setVida(0);
				   VictoriaDeCombate = false;
				   break;
				    
				   
			   }
		   }
		   
		 
		   
		   
		   
	   }
	   return VictoriaDeCombate;
	   
   }
   /////
   public ArrayList<Pokemon> DeterminarEquipoActual() {
	   ArrayList<Pokemon> hola = new ArrayList<Pokemon>();
	   
	   for (int i = 0; i < EquipoPokemonActual.length; i++) {
		   if(EquipoPokemonActual[i] != null) {
			   EquipoPokemonActual[i] = null;
		   }
		
	}
	   for (int i = 0; i < EquipoPokemonActual.length; i++) {
		   EquipoPokemonActual[i] = EquipoPokemon.get(i);
	}
	   for (int i = 0; i < EquipoPokemonActual.length; i++) {
		   hola.add(EquipoPokemonActual[i]);
		
	}
	
		return hola;
	
   }
  
   
   
}
