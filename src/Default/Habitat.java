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
		ArrayList<Pokemon> lista = h.getListaPokemonsHabitat();
		while(1>0) {
		for (Pokemon p : lista) {
			
			float probabilidad = p.getProbabilidadAparicion();
			
			Random rand = new Random();
			float r = rand.nextFloat();
			if(probabilidad<r) {
				return p;
			}
			}
			
			
		}
	}
	
	
	
	
}
