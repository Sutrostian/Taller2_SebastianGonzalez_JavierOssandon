package Default;
import java.util.ArrayList;
public class Partida {
	private String NombreJugador;
	private ArrayList<Pokemon> EquipoPokemon;
	
	/**
	 * @param nombreJugador
	 * @param equipoPokemon
	 */
	public Partida(String nombreJugador) {
		super();
		NombreJugador = nombreJugador;
		EquipoPokemon = new ArrayList<Pokemon>();
		
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

  
   
   
}
