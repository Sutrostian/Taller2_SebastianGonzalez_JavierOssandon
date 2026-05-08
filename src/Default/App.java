// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand
package Default;
import java.util.*;
import java.util.ArrayList;
import java.io.*;


public class App {
	private static Partida PartidaActual;
	private static ArrayList<Gimnasio> listaGimnasios;
	private static ArrayList<Pokemon> listapokemons;
	private static ArrayList<Habitat> listabiomas;
	private static Scanner s = new Scanner(System.in);
    private static Scanner lectorRegistros = null;
    private static Scanner LectorHabitats = null;
    private static Scanner LectorPokedex = null;
    private static Scanner LectorGimnasio = null;
    private static Scanner LectorAltoMando = null;
    

	public static void main(String[] args) {
		
		listabiomas = new ArrayList<Habitat>();
		listapokemons = new ArrayList<Pokemon>();
	    listaGimnasios	= new ArrayList<Gimnasio>();
	    
		
		
		
		lectorRegistros = CargarArchivo(lectorRegistros, "Registros.txt");
		LectorHabitats=CargarArchivo(LectorHabitats, "Habitats.txt");
		LectorPokedex=CargarArchivo(LectorPokedex, "Pokedex.txt");
		LectorGimnasio=CargarArchivo(LectorGimnasio, "Gimnasios.txt");
		LectorAltoMando=CargarArchivo(LectorAltoMando, "Alto Mando.txt");
		
		while(LectorHabitats.hasNextLine()) {
			String linea = LectorHabitats.nextLine();
			CargarHabitats(linea, listabiomas);
		}
		
		
		while(LectorPokedex.hasNextLine()) {
			String linea = LectorPokedex.nextLine();
			CargarPokemons(linea, listapokemons);	
		}
		
		while(LectorGimnasio.hasNextLine()) {
			String linea = LectorGimnasio.nextLine();
			CargarGym(linea, listaGimnasios);
		}
		
		
		cargarMenu();
		
	}

	private static void cargarMenu() {
		String opcion;
		do {
			System.out.println("Bienvenido al Menu, ingrese una opcion");
			System.out.println("");
			System.out.println("1. Continuar");
			System.out.println("2. Nueva partida");
			System.out.println("3. Salir");
			System.out.println("> ");

			opcion = s.nextLine();

			switch (opcion) {
			
			case "1":
				cargarSubMenu();						
			break;

			case "2":
				System.out.println("Ingrese su apodo de jugador");
				String nombre = s.nextLine();
				PartidaActual = new Partida(nombre);    
				System.out.println("Bienvenido "+PartidaActual.getNombreJugador()+"!!");//sobrescribir toda la información que haya en Registros.txt por la nueva.
				cargarSubMenu();

			break;
			
			case "3":
				System.out.println("Has Salido Con Exito.");
				break;
			
			default:
				System.out.println("Ingrese una opcion nuevamente");
				System.out.println("");
			break;
				
			}

		} while (!opcion.equals("3"));// ejecutar mientras opcion sea distinto de 3

	}

	private static void cargarSubMenu() {

		String opcion;
		do {
		System.out.println(PartidaActual.getNombreJugador()+" ¿Que Deseas Hacer?");
		System.out.println("");
		System.out.println("1. Revisar Equipo.");//Debe imprimir la información (nombre, tipo y suma de todas las estadísticas) de cada Pokémon que el jugador tenga en su equipo.
		System.out.println("2. Salir A Capturar.");//Debe mostrarle al usuario todas las zonas existentes para salir a capturar un Pokémon. Al seleccionar una zona, debe generarse un Pokémon aleatorio (que exista en esa zona) y el usuario tendrá dos opciones: 1) Capturar. 2) Huir. En caso de capturarlo, se debe añadir a su lista de Pokémon.
		System.out.println("3. Acceso Al PC (Cambiar Pokemon Del Equipo.");//Aquí se deben mostrar de manera numerada todos los Pokémon que el usuario haya capturado. Luego, el usuario tendrá dos opciones: 1) Cambiar Pokémon. 2) Salir. En caso de elegir cambiar un Pokémon, el usuario deberá elegir dos números para intercambiar sus lugares en la lista y así, por ejemplo, modificar su equipo.
		System.out.println("4. Retar Un Gimnasio.");//Aquí se deberán imprimir todos los gimnasios existentes y el estado de cada uno. El usuario podrá elegir ir a retar a uno (no puede retar a un gimnasio sin antes haber derrotado al anterior).
		System.out.println("5. Desafio Al Alto Mando.");//El usuario podrá retar al Alto Mando para coronarse como campeón, pero en esta parte hay ciertas restricciones.
		//Una vez ingresado a las batallas, se retará a cada oponente de manera consecutiva, sin poder regresar al menú para cambiar de equipo. Las únicas maneras de regresar al menú son siendo derrotado o rindiéndose. En cualquiera de los casos, el usuario regresará y, si desea retarlos de nuevo, deberá luchar contra todos otra vez (o sea, no se guarda el progreso en caso de haber derrotado a alguno previamente).
		System.out.println("6. Curar Pokemon.");//Se curarán todos los Pokémon debilitados, pasando su estado a 'Vivo'.
		System.out.println("7. Guardar.");//Se sobrescriben los datos en Registros.txt.
		System.out.println("8. Guardar Y Salir.");//Se guardan los datos y finaliza el programa.
		System.out.println("9. Volver Al Menu General");
		System.out.println("> ");

		opcion = s.nextLine();

		switch (opcion) {
		
		
		case "1":	
			PartidaActual.getEquipoCombatePokemon();
			
		break;

		case "2":
			System.out.println("Donde deseas ir a explorar?");
			for(int i = 0; i<listabiomas.size();i++) {
				System.out.println(i+") "+listabiomas.get(i));
			}
			int eleccion = Integer.parseInt(s.nextLine());
			Habitat HElegido = listabiomas.get(eleccion);
			Pokemon aparicion = HElegido.AparicionPokemon(HElegido);
			System.out.println("APARECIO UN "+aparicion.getNombrePokemon()+"!!!");
			System.out.println("Que deseas Hacer?");
			System.out.println("1) Capturar");
			System.out.println("2) Huir");
			eleccion = Integer.parseInt(s.nextLine());
			
			if(eleccion == 2) {
				System.out.println("Has Escapado!!");
				break;
			}
			if(eleccion == 1) {
				aparicion.FueCapturado(aparicion, PartidaActual);
				
		
			}
		
		break;
		
		case "3":
			System.out.println("Que Pokemons desea intercambiar?");
			PartidaActual.ListaPokemons();
			System.out.println("ingrese el primer Pokemon");
			int pos1 = Integer.parseInt(s.nextLine());
			System.out.println("ingrese el segundo pokemon");
			int pos2 = Integer.parseInt(s.nextLine());
			PartidaActual.IntercambiarPokemons(pos1, pos2);
			

		break;
		
		case "4":
			System.out.println("Que Gimnasio Deseas Desafiar?");
			PrintearGimnasios(listaGimnasios);
			eleccion = s.nextInt();
			Gimnasio Gym = listaGimnasios.get(eleccion);
		    Gimnasio GymAnterior = listaGimnasios.get(eleccion-1);
		    boolean Comprobar = true;
		    if(eleccion != 1) {
			Comprobar = Gym.ComprobarDesafio(Gym, GymAnterior,PartidaActual.getNombreJugador());
		    }
		    if(!Comprobar) {
		    	break;
		    }
		    ArrayList<Pokemon> EquipoCombate = PartidaActual.DeterminarEquipoActual();
		    
		    PartidaActual.getEquipoCombatePokemon();
		    
		    
			
		    
		    
			

		break;
		
		case "5":

		break;
		
		case "6":

		break;
		
		case "7":
			guardarPartida();
		break;
		
		case "8":
			guardarPartida();
			System.out.println("Saliendo...");
			System.exit(0);
		break;
		
		default:
			System.out.println("Ingrese una opcion nuevamente");
			System.out.println("");
		break;
			
		}

		} while (!opcion.equals("9"));// ejecutar mientras opcion sea distinto de 9	
	}
	
	
	private static void guardarPartida() {
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("Registros.txt"));
			
			bw.write(PartidaActual.getNombreJugador()+";"+PartidaActual.getCantidadMedallas());
			bw.newLine();
			
			ArrayList<Pokemon> equipoActual = PartidaActual.DeterminarEquipoActual();
			
			for(Pokemon p : equipoActual) {
				
				bw.write(p.getNombrePokemon()+";"+p.getEstado());
				bw.newLine();
			}
			
			bw.close();
			
			System.out.println("Datos guardados correctamente");
			
		}catch(Exception e) {
			
			System.out.println("Error al guardar");
		}
	}

	private static Scanner CargarArchivo(Scanner scanner,String direccion) {
		try {
			File file1 = new File(direccion);
			scanner = new Scanner(file1);
			
			return scanner;
		
			}catch(Exception e) {
				System.out.println("Error al leer el archivo de la direccion"+ direccion);
				
			}
		return null;
		
		
	}
	
	private static void CargarPokemons(String linea,ArrayList<Pokemon> lista){
		String Atributos[] = linea.split(";");
		Pokemon pokemon = new Pokemon(Atributos[0],Atributos[1], Float.parseFloat(Atributos[2]), Integer.parseInt(Atributos[3]), Integer.parseInt(Atributos[4]), Integer.parseInt((Atributos[5])), Integer.parseInt(Atributos[6]), Integer.parseInt(Atributos[7]), Integer.parseInt(Atributos[8]),Atributos[9]);
		lista.add(pokemon);
		String habitatpokemon = pokemon.getHabitat();
		for (Habitat H : listabiomas) {
			if(H.getNombre().equals(habitatpokemon)){
				H.AñadirAlBioma(pokemon);
			}
			
			
			
			
		}
	}
	
	private static void CargarHabitats(String linea,ArrayList<Habitat> lista) {
		Habitat H = new Habitat(linea);
		lista.add(H);
	}
	
	
	private static void CargarGym(String Linea,ArrayList<Gimnasio> lista) {
		
		String[] Atributos = Linea.split(";");
		Gimnasio G = new Gimnasio(Atributos[0], Atributos[1], Atributos[2],Integer.parseInt(Atributos[3]));
	    lista.add(G);
	    
	    for (int i = 4; i < Atributos.length; i++) {
	    	if(Atributos[i] != null) {
	    		Pokemon PokemonAñadir = EncontrarPokemonNombre(Atributos[i], listapokemons);
	  
	    		
	    	
	    	}
			
		}
	    
	    
	
	}
	
	
	private static Pokemon EncontrarPokemonNombre(String nombre,ArrayList<Pokemon>listPokemons) {
		Pokemon encontrado = null;
		for (Pokemon p : listPokemons) {
			if(nombre.equals(p.getNombrePokemon())){
				encontrado = p;
			}
			
		}
		return encontrado;
		
	}
	
	
	private static void PrintearGimnasios(ArrayList<Gimnasio> lista) {
		int contador = 1;
		System.out.println("Que lider deseas retar?");
		for (Gimnasio g : lista) {
			String nombre = g.getNumerogym();
			String jefe = g.getLider();
			System.out.println(contador+".-) "+jefe+" Estado: "+g.getEstado());
			contador++;
		}	
	}
	
}


