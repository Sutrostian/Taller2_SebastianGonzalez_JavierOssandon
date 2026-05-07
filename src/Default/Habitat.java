package Default;
import java.util.ArrayList;
import java.util.Random;
public class Habitat {
	private String Nombre;
	private ArrayList<Pokemon> ListaPokemonsHabitat;
	/**
	 * @param nombre
	 * @param listaPokemons
	 */
	public Habitat(String nombre) {
		super();
		Nombre = nombre;
		ListaPokemonsHabitat = new ArrayList<Pokemon>();
		
	}	
	
	public void AñadirAlBioma(Pokemon p) {
		ListaPokemonsHabitat.add(p);
		
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public ArrayList<Pokemon> getListaPokemonsHabitat() {
		
		return ListaPokemonsHabitat;
	}

	public void setListaPokemonsHabitat(ArrayList<Pokemon> listaPokemonsHabitat) {
		ListaPokemonsHabitat = listaPokemonsHabitat;
	}
	
	public void ConsultarPokemonsZona(Habitat h) {
		
		System.out.println(h.getListaPokemonsHabitat());
		
	}

	@Override
	public String toString() {
		return Nombre;
	}
	
	public Pokemon AparicionPokemon(Habitat h) {
		//Los comentarios aqui seran para explicar el razonamiento detras del spawn de los pokemons
		//lo primero que tenemos que saber es que la probabilidad de spawn de los pokemons en el bioma deben sumar 1
		//por lo tanto usaremos probabilidad acumulada para determinar el pokemon que spawnea
		//el razonamiento es el siguiente:
		//generamos un numero random digamos que el numero que dio es 0.9
		//iniciamos nuestra probabilidad acummulada en 0
		//pokemon 1 tiene probabilidad de aparecer de 0.5
		//nuestra probabilidad acumulada sera 0 +0.5 
		//ahora verificaremos si r<=Pacumulada diremos que ese es nuestro pokemon que spawnea en este caso no aparece
		//entonces veremos el siguiente pokemon
		//diremos pokemon 2 tiene probabilidad de 0.2
		//probabilidad acumulada = 0.5+0.2 = 0.7
		//como nuestro random era 0.75 y r no es menor que p acumulado revisamos el siguiente pokemon
		//diremos pokemon 3 tiene probabilidad de 0.3
		//ahora como nuestro p acumulado es 1
		// r<pacumulado 
		//este sera el pokemon que spawnea.
		
		ArrayList<Pokemon> lista = h.getListaPokemonsHabitat();//aqui obtenemos nuestra lista del habitat
		Random rand = new Random();//nota para seba, el random funciona como un scanner por asi decirlo entonces creamos nuestro generador de randoms
		float r = rand.nextFloat();//esta sera la variable que guarde el numero random
		float PAcumulada = 0; 
		Pokemon aparicion = null;
		for (Pokemon p : lista) {
			PAcumulada = PAcumulada + p.getProbabilidadAparicion();
			if(r <= PAcumulada) {
				aparicion = p;
				break;
				
			}
		}
		return aparicion;
		
		
		
		
		
		
		
		
	
			
			
		
	}
	
	
	
	
}
