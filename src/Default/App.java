// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package Default;

import java.util.*;
import java.util.ArrayList;
import java.io.*;

public class App {
	private static Partida PartidaActual;
	private static ArrayList<Gimnasio> listaGimnasios;
	private static ArrayList<Pokemon> listapokemons;
	private static ArrayList<Habitat> listabiomas;
	private static ArrayList<Gimnasio> AltoMando;
	private static Scanner s = new Scanner(System.in);
	private static Scanner lectorRegistros = null;
	private static Scanner LectorHabitats = null;
	private static Scanner LectorPokedex = null;
	private static Scanner LectorGimnasio = null;
	private static Scanner LectorAltoMando = null;

	public static void main(String[] args) {

		listabiomas = new ArrayList<Habitat>();
		listapokemons = new ArrayList<Pokemon>();
		listaGimnasios = new ArrayList<Gimnasio>();
		AltoMando = new ArrayList<Gimnasio>();

		lectorRegistros = CargarArchivo(lectorRegistros, "Registros.txt");
		LectorHabitats = CargarArchivo(LectorHabitats, "Habitats.txt");
		LectorPokedex = CargarArchivo(LectorPokedex, "Pokedex.txt");
		LectorGimnasio = CargarArchivo(LectorGimnasio, "Gimnasios.txt");
		LectorAltoMando = CargarArchivo(LectorAltoMando, "Alto Mando.txt");

		while (LectorHabitats.hasNextLine()) {
			String linea = LectorHabitats.nextLine();
			CargarHabitats(linea, listabiomas);
		}

		while (LectorPokedex.hasNextLine()) {
			String linea = LectorPokedex.nextLine();
			CargarPokemons(linea, listapokemons);
		}

		while (LectorGimnasio.hasNextLine()) {
			String linea = LectorGimnasio.nextLine();
			CargarGym(linea, listaGimnasios);
		}

		while (LectorAltoMando.hasNextLine()) {
			String linea = LectorAltoMando.nextLine();
			CargarAltoMando(linea, AltoMando);

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
			System.out.print("> ");

			opcion = s.nextLine();

			switch (opcion) {

			case "1":
				cargarPartida();
				if (PartidaActual != null) {
					cargarSubMenu();
				}
				break;

			case "2":
				System.out.println("Ingrese su apodo de jugador");
				String nombre = s.nextLine();
				PartidaActual = new Partida(nombre);
				System.out.println("Bienvenido " + PartidaActual.getNombreJugador() + "!!");// sobrescribir toda la
																							// información que haya en
																							// Registros.txt por la
																							// nueva.
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
			System.out.println(PartidaActual.getNombreJugador() + " ¿Que Deseas Hacer?");
			System.out.println("");
			System.out.println("1. Revisar Equipo.");// Debe imprimir la información (nombre, tipo y suma de todas las
														// estadísticas) de cada Pokémon que el jugador tenga en su
														// equipo.
			System.out.println("2. Salir A Capturar.");// Debe mostrarle al usuario todas las zonas existentes para
														// salir a capturar un Pokémon. Al seleccionar una zona, debe
														// generarse un Pokémon aleatorio (que exista en esa zona) y el
														// usuario tendrá dos opciones: 1) Capturar. 2) Huir. En caso de
														// capturarlo, se debe añadir a su lista de Pokémon.
			System.out.println("3. Acceso Al PC (Cambiar Pokemon Del Equipo.");// Aquí se deben mostrar de manera
																				// numerada todos los Pokémon que el
																				// usuario haya capturado. Luego, el
																				// usuario tendrá dos opciones: 1)
																				// Cambiar Pokémon. 2) Salir. En caso de
																				// elegir cambiar un Pokémon, el usuario
																				// deberá elegir dos números para
																				// intercambiar sus lugares en la lista
																				// y así, por ejemplo, modificar su
																				// equipo.
			System.out.println("4. Retar Un Gimnasio.");// Aquí se deberán imprimir todos los gimnasios existentes y el
														// estado de cada uno. El usuario podrá elegir ir a retar a uno
														// (no puede retar a un gimnasio sin antes haber derrotado al
														// anterior).
			System.out.println("5. Desafio Al Alto Mando.");// El usuario podrá retar al Alto Mando para coronarse como
															// campeón, pero en esta parte hay ciertas restricciones.
			// Una vez ingresado a las batallas, se retará a cada oponente de manera
			// consecutiva, sin poder regresar al menú para cambiar de equipo. Las únicas
			// maneras de regresar al menú son siendo derrotado o rindiéndose. En cualquiera
			// de los casos, el usuario regresará y, si desea retarlos de nuevo, deberá
			// luchar contra todos otra vez (o sea, no se guarda el progreso en caso de
			// haber derrotado a alguno previamente).
			System.out.println("6. Curar Pokemon.");// Se curarán todos los Pokémon debilitados, pasando su estado a
													// 'Vivo'.
			System.out.println("7. Guardar.");// Se sobrescriben los datos en Registros.txt.
			System.out.println("8. Guardar Y Salir.");// Se guardan los datos y finaliza el programa.
			System.out.print("> ");

			opcion = s.nextLine();

			switch (opcion) {

			case "1":
				PartidaActual.getEquipoCombatePokemon();
				break;

			case "2":
				System.out.println("");
				System.out.println("Donde deseas ir a explorar?");
				System.out.println("");
				System.out.println("Zonas disponibles:");
				System.out.println("");

				for (int i = 0; i < listabiomas.size(); i++) {

					System.out.println((i + 1) + ") " + listabiomas.get(i).getNombre());
				}

				System.out.println((listabiomas.size() + 1) + ") Volver al menu.");
				System.out.print("> ");

				int eleccion;

				try {

					eleccion = Integer.parseInt(s.nextLine());

				} catch (Exception e) {

					System.out.println("Entrada invalida");
					System.out.println("");
					break;
				}

				if (eleccion < 1 || eleccion > listabiomas.size() + 1) {

					System.out.println("Opcion invalida.");
					System.out.println("");
					break;
				}

				if (eleccion == listabiomas.size() + 1) {
					break;
				}

				Habitat HElegido = listabiomas.get(eleccion - 1);

				Pokemon aparicion = HElegido.AparicionPokemon(HElegido);

				System.out.println("");

				System.out.println("APARECIO UN " + aparicion.getNombrePokemon() + "!!!");
				System.out.println("");
				System.out.println("Que deseas Hacer?");
				System.out.println("1) Capturar");
				System.out.println("2) Huir");
				System.out.print("> ");

				try {

					eleccion = Integer.parseInt(s.nextLine());

				} catch (Exception e) {

					System.out.println("Entrada invalida");
					System.out.println("");
					break;
				}

				if (eleccion == 2) {

					System.out.println("Has Escapado!!");
					System.out.println("");
					break;
				}

				else if (eleccion == 1) {

					aparicion.FueCapturado(aparicion, PartidaActual);
					System.out.println("");
				}

				else {

					System.out.println("Opcion invalida");
					System.out.println("");
				}

				break;

			case "3":

				if (PartidaActual.getTodosLosPokemons().size() == 0) {

					System.out.println("No tienes Pokemon para intercambiar");
					System.out.println("");
					break;
				}

				try {

					System.out.println("¿Que Pokemons deseas intercambiar?");
					PartidaActual.ListaPokemons();

					System.out.println("Ingrese el primer Pokemon");
					int pos1 = Integer.parseInt(s.nextLine());

					System.out.println("Ingrese el segundo Pokemon");
					int pos2 = Integer.parseInt(s.nextLine());

					int max = PartidaActual.getTodosLosPokemons().size();

					if (pos1 < 1 || pos1 > max || pos2 < 1 || pos2 > max) {

						System.out.println("Posicion invalida");
						System.out.println("");
						break;
					}

					PartidaActual.IntercambiarPokemons(pos1 - 1, pos2 - 1);

				} catch (Exception e) {

					System.out.println("Entrada invalida");
					System.out.println("");
				}

				break;

			case "4":
				System.out.println("Que Gimnasio Deseas Desafiar?");
				PrintearGimnasios(listaGimnasios);
				try {

					eleccion = Integer.parseInt(s.nextLine());

				} catch (Exception e) {

					System.out.println("Entrada invalida");
					System.out.println("");
					break;
				}

				if (eleccion < 1 || eleccion > listaGimnasios.size()) {

					System.out.println("Gimnasio invalido");
					System.out.println("");
					break;
				}
				Gimnasio Gym = listaGimnasios.get(eleccion - 1);
				Gimnasio GymAnterior = null;
				boolean Comprobar = true;
				if (Gym.getEstado().equals("Derrotado")) {
					System.out.println("Ya eres el Maestro Pokemon De Este Gimnasio");

					break;
				}

				if (eleccion != 1) {
					GymAnterior = listaGimnasios.get(eleccion - 2);
					Comprobar = Gym.ComprobarDesafio(Gym, GymAnterior, PartidaActual.getNombreJugador());
				}
				if (!Comprobar) {
					break;
				}

				if (!PartidaActual.TienePokemons()) {

					System.out.println("No tienes Pokemon para combatir.");
					System.out.println("");
					break;
				}

				if (!PartidaActual.TienePokemonVivos()) {

					System.out.println("Todos tus Pokemon estan debilitados.");
					System.out.println("Debes curarlos antes de combatir.");
					System.out.println("");
					break;
				}

				ArrayList<Pokemon> EquipoCombate = PartidaActual.DeterminarEquipoActual();
				PartidaActual.SimularCombate(Gym.getLider(), EquipoCombate, Gym.getEquipoEnemigo(), PartidaActual, Gym);

				break;

			case "5":
				boolean Desafio = ComprobarDesafioAltoMando(listaGimnasios);
				if (!Desafio) {
					break;
				}
				System.out.println("A Quien Desafiaras?");
				PrintearGimnasios(AltoMando);
				int Seleccion;

				try {

					Seleccion = Integer.parseInt(s.nextLine());

				} catch (Exception e) {

					System.out.println("Entrada invalida");
					System.out.println("");
					break;
				}
				if (Seleccion < 1 || Seleccion > AltoMando.size()) {

					System.out.println("Oponente invalido");
					System.out.println("");
					break;
				}
				Gimnasio Jefe = AltoMando.get(Seleccion - 1);
				Gimnasio JefeAnterior = null;
				boolean DesafioValido = true;
				if (Jefe.getEstado().equals("Derrotado")) {
					System.out.println("Ya Has Derrotado A Este Jefe Del Alto Mando");
					break;
				}
				if (Seleccion != 1) {
					JefeAnterior = AltoMando.get(Seleccion - 2);
					DesafioValido = Jefe.ComprobarDesafio(Jefe, JefeAnterior, PartidaActual.getNombreJugador());
				}
				if (!DesafioValido) {
					break;
				}

				if (!PartidaActual.TienePokemons()) {

					System.out.println("No tienes Pokemon para combatir.");
					System.out.println("");
					break;
				}

				if (!PartidaActual.TienePokemonVivos()) {

					System.out.println("Todos tus Pokemon estan debilitados.");
					System.out.println("Debes curarlos antes de combatir.");
					System.out.println("");
					break;
				}

				ArrayList<Pokemon> EquipoDesafio = PartidaActual.DeterminarEquipoActual();

				PartidaActual.SimularCombate(Jefe.getLider(), EquipoDesafio, Jefe.getEquipoEnemigo(), PartidaActual,
						Jefe);

				break;

			case "6":
				PartidaActual.CurarPokemons();
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

	private static void cargarPartida() {

		try {

			Scanner lector = new Scanner(new File("Registros.txt"));

			String primeraLinea = lector.nextLine();
			String[] datosJugador = primeraLinea.split(";");

			String nombreJugador = datosJugador[0];
			PartidaActual = new Partida(nombreJugador);

			for (int i = 1; i < datosJugador.length; i++) {

				PartidaActual.setEstadoMedallas(datosJugador[i], listaGimnasios);

			}

			while (lector.hasNextLine()) {

				String linea = lector.nextLine();
				String[] datosPokemon = linea.split(";");

				String nombrePokemon = datosPokemon[0];
				String estado = datosPokemon[1];

				Pokemon base = EncontrarPokemonNombre(nombrePokemon, listapokemons);
				Pokemon p = new Pokemon(base);

				if (p != null) {

					p.setEstado(estado);

					PartidaActual.AñadirPokemonAlEquipo(p);
				}
			}

			lector.close();

			System.out.println("Partida cargada correctamente");
			System.out.println("");

		} catch (Exception e) {

			System.out.println("Error al cargar partida");
			System.out.println("");
		}
	}

	private static void guardarPartida() {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("Registros.txt"));

			bw.write(PartidaActual.getNombreJugador() + PartidaActual.GuardarGimnasiosDerrotados(listaGimnasios));
			bw.newLine();

			ArrayList<Pokemon> todosLosPokemons = PartidaActual.getTodosLosPokemons();

			for (Pokemon p : todosLosPokemons) {

				bw.write(p.getNombrePokemon() + ";" + p.getEstado());
				bw.newLine();
			}

			bw.close();

			System.out.println("Datos guardados correctamente");

		} catch (Exception e) {

			System.out.println("Error al guardar");
		}
	}

	private static Scanner CargarArchivo(Scanner scanner, String direccion) {
		try {
			File file1 = new File(direccion);
			scanner = new Scanner(file1);

			return scanner;

		} catch (Exception e) {
			System.out.println("Error al leer el archivo de la direccion" + direccion);

		}
		return null;

	}

	private static void CargarPokemons(String linea, ArrayList<Pokemon> lista) {
		String Atributos[] = linea.split(";");
		Pokemon pokemon = new Pokemon(Atributos[0], Atributos[1], Float.parseFloat(Atributos[2]),
				Integer.parseInt(Atributos[3]), Integer.parseInt(Atributos[4]), Integer.parseInt((Atributos[5])),
				Integer.parseInt(Atributos[6]), Integer.parseInt(Atributos[7]), Integer.parseInt(Atributos[8]),
				Atributos[9]);
		lista.add(pokemon);
		String habitatpokemon = pokemon.getHabitat();
		for (Habitat H : listabiomas) {
			if (H.getNombre().equals(habitatpokemon)) {
				H.AñadirAlBioma(pokemon);
			}

		}
	}

	private static void CargarHabitats(String linea, ArrayList<Habitat> lista) {
		Habitat H = new Habitat(linea);
		lista.add(H);
	}

	private static void CargarGym(String Linea, ArrayList<Gimnasio> lista) {

		String[] Atributos = Linea.split(";");

		Gimnasio G = new Gimnasio(Atributos[0], Atributos[1], Atributos[2], Integer.parseInt(Atributos[3]));

		lista.add(G);

		for (int i = 4; i < Atributos.length; i++) {

			if (Atributos[i] != null) {

				Pokemon PokemonAñadir = EncontrarPokemonNombre(Atributos[i].trim(), listapokemons);

				G.AñadirPokemonGym(PokemonAñadir); // para añadir el pokemon a la lista del gym
			}
		}
	}

	private static Pokemon EncontrarPokemonNombre(String nombre, ArrayList<Pokemon> listPokemons) {
		Pokemon encontrado = null;
		for (Pokemon p : listPokemons) {
			if (nombre.equals(p.getNombrePokemon())) {
				encontrado = p;
			}

		}
		return encontrado;

	}

	private static void PrintearGimnasios(ArrayList<Gimnasio> lista) {
		int contador = 1;
		System.out.println("Que lider deseas retar?");
		System.out.println(contador);
		for (Gimnasio g : lista) {

			String nombre = g.getNumerogym();
			String jefe = g.getLider();
			System.out.println(contador + ".-) " + jefe + " Estado: " + g.getEstado());
			contador++;
		}
	}

	private static void CargarAltoMando(String Linea, ArrayList<Gimnasio> AltoMando) {
		String[] Atributos = Linea.split(";");
		Gimnasio g = new Gimnasio(Atributos[0], Atributos[1], "Sin derrotar", (Atributos.length) - 1);

		AltoMando.add(g);
		for (int i = 2; i < Atributos.length; i++) {
			Pokemon PokemonAñadir = EncontrarPokemonNombre(Atributos[i].trim(), listapokemons);
			g.AñadirPokemonGym(PokemonAñadir);

		}

	}

	private static boolean ComprobarDesafioAltoMando(ArrayList<Gimnasio> listagym) {
		boolean PuedeDesafiar = false;
		int GimnasiosSinDerrotar = 0;
		for (Gimnasio g : listagym) {
			if (g.getEstado().equals("Sin derrotar")) {
				GimnasiosSinDerrotar++;
			}
		}
		if (GimnasiosSinDerrotar != 0) {
			System.out.println("Aun No Puedes Desafiar Al Alto Mando");
			System.out.println("Te Quedan Gimnasios Por Derrotar");
		}
		if (GimnasiosSinDerrotar == 0) {
			System.out.println("Has Derrotado A Todos Los Gimnasios Pokemon");
			System.out.println("El Alto Mando Te Permitira Combatir Contra Ellos");
			PuedeDesafiar = true;
		}
		return PuedeDesafiar;
	}
}

/*
 * Pauta de Evaluación Puntaje Total Máximo: 120 puntos
 * 
 * 1. Persistencia de Datos y Archivos (20 puntos)
 * 
 * [8 pts] Lectura inicial: Carga correctamente los datos de Habitats.txt,
 * Pokedex.txt, Gimnasios.txt y AltoMando.txt al iniciar el programa sin errores
 * de parseo ni caídas.
 * 
 * [6 pts] Carga de partida: La opción "Continuar" lee correctamente
 * Registros.txt, identificando el apodo del jugador, sus medallas y el estado
 * ('Vivo' o 'Debilitado') de cada Pokémon que posee.
 * 
 * [6 pts] Guardado de partida: Las opciones "Guardar" y "Guardar y Salir"
 * sobrescriben Registros.txt manteniendo el formato exacto original para
 * futuras lecturas exitosas.
 * 
 * 
 * 2. Lógica de Colecciones y POO (20 puntos)
 * 
 * [8 pts] Modelado de Clases: Crea clases cohesivas (Ej: Pokemon, Gimnasio,
 * etc.) con sus respectivos atributos privados y métodos, demostrando un uso
 * correcto de la abstracción y el encapsulamiento.
 * 
 * [6 pts] Uso de Colecciones: Utiliza ArrayList o LinkedList para manejar el
 * equipo del jugador, el inventario del PC y las listas de Pokémon por zona de
 * forma dinámica y eficiente.
 * 
 * [6 pts] Tabla de Efectividad: Implementa correctamente la matriz
 * bidimensional (double[][]) para la tabla de tipos, y la consulta
 * correctamente sin usar múltiples if-else anidados.
 * 
 * 
 * 3. Mecánicas de Juego (30 puntos)
 * 
 * [8 pts] Captura Aleatoria: Al explorar una zona, el sistema genera un Pokémon
 * aleatorio respetando estrictamente sus porcentajes (%) de aparición.
 * 
 * [8 pts] Combate (Stats y Tipos): El sistema calcula al ganador sumando las
 * estadísticas y aplicando correctamente el multiplicador de la Tabla de Tipos
 * (x2 o x0.5) según corresponda.
 * 
 * [7 pts] Gestión de Equipo y PC: Permite visualizar e intercambiar de forma
 * fluida los Pokémon entre el equipo principal (primeros 6) y el resto
 * almacenado en el PC, sin generar duplicados.
 * 
 * [7 pts] Restricciones de Batalla: Respeta reglas clave: - Pokémon
 * 'Debilitados' no pueden pelear. - Avance progresivo en los Gimnasios (no
 * saltar líderes). - Combate consecutivo (sin acceso al PC) en el Alto Mando.
 * 
 * 
 * 4. Control de Errores y Robustez (15 puntos)
 * 
 * [5 pts] Estructura de código: Mantiene un código limpio y ordenado,
 * respetando convenciones de Java (CamelCase) y utilizando nombres de variables
 * descriptivos y no genéricos.
 * 
 * [5 pts] Validación de Entradas: El programa utiliza bloques try-catch o
 * validaciones con Scanner para evitar errores de InputMismatchException (ej.
 * ingresar una letra en vez de un número en los menús).
 * 
 * [5 pts] Navegación de Menús: Los menús fluyen correctamente, permitiendo usar
 * las opciones de rendirse o volver atrás sin atrapar al usuario en bucles
 * infinitos.
 * 
 * 
 * 5. Diagramas y Entregables (15 puntos)
 * 
 * [8 pts] Diagrama de Clases: Entrega un diagrama en formato PDF en la raíz del
 * repositorio que representa fielmente el código construido (atributos, métodos
 * y relaciones entre clases).
 * 
 * [7 pts] Modelo de Dominio: Entrega un modelo conceptual claro en formato PDF
 * que abstrae el problema planteado, diferenciándose del diagrama de clases
 * (sin tipos de datos ni firmas de métodos).
 * 
 * 
 * 6. Uso de GitHub (20 puntos)
 * 
 * [20 pts] Uso correcto: Estructura correcta del repositorio, commits
 * frecuentes, buena documentación.
 */
