// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand
package Default;
import java.util.*;
import java.io.*;

public class App {
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
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
				System.out.println("Ingrese su apodo de jugador:");
				String nomJugador = s.nextLine(); //sobrescribir toda la información que haya en Registros.txt por la nueva.
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
		System.out.println("Bienvenido al SubMenu, ingrese una opcion");
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

		break;

		case "2":

		break;
		
		case "3":

		break;
		
		case "4":

		break;
		
		case "5":

		break;
		
		case "6":

		break;
		
		case "7":

		break;
		
		case "8":

		break;
		
		default:
			System.out.println("Ingrese una opcion nuevamente");
			System.out.println("");
		break;
			
		}

		} while (!opcion.equals("9"));// ejecutar mientras opcion sea distinto de 9	
	}		
}


