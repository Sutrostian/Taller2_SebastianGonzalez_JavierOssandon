package Default;
import java.util.ArrayList;



public class Gimnasio {
	private String numerogym;
	private String Lider;
	private String Estado;
	private int CantidadPokemons;
	private ArrayList<Pokemon> pokemonsgym;
	/**
	 * @param numerogym
	 * @param lider
	 * @param estado
	 * @param cantidadPokemons
	 * @param pokemonsgym
	 */
	public Gimnasio(String numerogym, String lider, String estado, int cantidadPokemons) {
		super();
		this.numerogym = numerogym;
		Lider = lider;
		Estado = estado;
		CantidadPokemons = cantidadPokemons;
		pokemonsgym = new ArrayList<Pokemon>();
		
	}
	
	public ArrayList<Pokemon> getEquipoEnemigo(){
		return pokemonsgym;
	}
	
	
	public void AñadirPokemonGym(Pokemon P) {
		pokemonsgym.add(P);
	}


	public String getNumerogym() {
		return numerogym;
	}


	public void setNumerogym(String numerogym) {
		this.numerogym = numerogym;
	}


	public String getLider() {
		return Lider;
	}


	public void setLider(String lider) {
		Lider = lider;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public int getCantidadPokemons() {
		return CantidadPokemons;
	}


	public void setCantidadPokemons(int cantidadPokemons) {
		CantidadPokemons = cantidadPokemons;
	}


	public ArrayList<Pokemon> getPokemonsgym() {
		return pokemonsgym;
	}


	public void setPokemonsgym(ArrayList<Pokemon> pokemonsgym) {
		this.pokemonsgym = pokemonsgym;
	}
	
	
	public boolean ComprobarDesafio(Gimnasio GymEleccion, Gimnasio GymAnterior,String NombreJugador) {
		String estado1 = GymEleccion.getEstado();
		
		String estado2 = GymAnterior.getEstado();
		if(estado1.equals("Derrotado")){
		  System.out.println("Ya eres el maestro pokemon de este gimnasio");
		  return false;
		  
		 
		}
		if(estado1.equals("Sin derrotar")) {
			if(estado2.equals("Sin derrotar")) {
				System.out.println("¡Alto ahí "+NombreJugador+" Vas muy rapido! Necesitas derrotar a los gimnasios anteriores antes de avanzar");
				return false;
				
			}
			if(estado2.equals("Derrotado")) {
				System.out.println("Desafiando al gimnasio: "+GymEleccion);
				return true;
			}
				
			
		}
		return false;
	}
	
	

}