package Default;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	private String NombreJugador;
	private ArrayList<String> cantidadMedallas;
	private ArrayList<Pokemon> EquipoPokemon;
	private Pokemon[] EquipoPokemonActual;
	private TablaTipos TablaEfectividad;
	
	/**
	 * @param nombreJugador
	 * @param equipoPokemon
	 */
	public Partida(String nombreJugador) {
		super();
		NombreJugador = nombreJugador;
		EquipoPokemon = new ArrayList<Pokemon>();
		EquipoPokemonActual = new Pokemon[6];
		cantidadMedallas = new ArrayList<String>();
		TablaEfectividad = new TablaTipos();
		
		
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
	
	public void IntercambioEquipoCombate() {
		
		
		for (int i = 0; i < 6; i++) {
			
		 Pokemon p = EquipoPokemonActual[i];
	}}
	
	
	public void getEquipoCombatePokemon() {

		for (int i = 0; i < 6; i++) {
			
			Pokemon p = EquipoPokemonActual[i];
			
			if(p == null) {
				System.out.println((i+1)+".- Espacio Vacio");
			}else {
				System.out.println((i+1)+".-"+p);
			}
		}
	}
		
	public void setEquipoPokemon(ArrayList<Pokemon> equipoPokemon) {
		EquipoPokemon = equipoPokemon;
	}
	
	public void AñadirPokemonAlEquipo(Pokemon p){

		EquipoPokemon.add(p);

		for(int i = 0; i < EquipoPokemonActual.length; i++) {
			
			if(EquipoPokemonActual[i] == null) {
				
				EquipoPokemonActual[i] = p;
				break;
			}
		}

		System.out.println("El pokemon "+p+" ha sido añadido al equipo");
		System.out.println("");
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

		EquipoPokemon.set(pos1, pokemon2);
		EquipoPokemon.set(pos2, pokemon1);

		ActualizarEquipoCombate();

		System.out.println("Intercambiados con exito");
	}

   
   public boolean SimularCombate(String Enemigo,ArrayList<Pokemon> EquipoPokemon, ArrayList<Pokemon> Equipoenemigo,Partida partida,Gimnasio	Gym) {
	   Scanner s = new Scanner(System.in);
	   Boolean VictoriaDeCombate = false;
	   boolean OponenteDerrotado = false;
	   boolean AcaboElCombate = false;
	   
	 
	   Pokemon PokemonActual = EquipoPokemon.get(0);
	   Pokemon PokemonEnemigo = Equipoenemigo.get(0);
	   
	   System.out.println(Enemigo+" Saca a "+ PokemonEnemigo.getNombrePokemon());
	   System.out.println(NombreJugador+" Saca a "+ PokemonActual.getNombrePokemon()+"Stats :"+PokemonActual.getEstadisticasTotales());
	   int FINAL = Equipoenemigo.size();
	   
	   
	   
	   while(!AcaboElCombate) {
		   if(Equipoenemigo.size() == 0) {
			   AcaboElCombate = true;
			   VictoriaDeCombate = true;
			   break;
		   }
		   
		   
		   PokemonEnemigo = Equipoenemigo.get(0);
		   
		   
		   
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
			   
			   double EstadisticasAliado = PokemonActual.getEstadisticasTotales();
			   double EstadisticasEnemigo = PokemonEnemigo.getEstadisticasTotales();
			   
			   
			   
			   double NuevaEstadisticasAliado = EstadisticasAliado*TablaTipos.calcularEfectividad(PokemonActual, PokemonEnemigo);
			   double NuevaEstadisticasEnemigo = EstadisticasEnemigo*TablaTipos.calcularEfectividad(PokemonEnemigo, PokemonActual);
			   
			   System.out.println("Nuevas Estadisticas "+PokemonActual.getNombrePokemon()+"--->"+NuevaEstadisticasAliado);
			   System.out.println("Nuevas Estadisticas "+PokemonEnemigo.getNombrePokemon()+"--->"+NuevaEstadisticasEnemigo);
			   
			   
			   
			   
			   if(NuevaEstadisticasAliado>NuevaEstadisticasEnemigo) {
				   System.out.println(PokemonActual.getNombrePokemon()+" Gano El Combate");
				   Equipoenemigo.remove(PokemonEnemigo);
				   FINAL--;
				   if(FINAL == 0) {
					   
					   VictoriaDeCombate = true;
					   AcaboElCombate = true;
					   
				   }
				   break;
				   
			   }
			   if(NuevaEstadisticasAliado<NuevaEstadisticasEnemigo) {
				   System.out.println(PokemonActual.getNombrePokemon()+" Perdio El Combate");
				   PokemonActual.setVida(0);
				   PokemonActual.setEstado("Derrotado");
				   
			
				   boolean RemplazoValido = false;
				   while(!RemplazoValido) {
					   int vivos = 0;
					   for (Pokemon pokemon : EquipoPokemon) {
						   if(pokemon.getEstado().equals("vivo")) {
							   vivos++;
						   }
						
					}
					   if(vivos == 0) {
						   System.out.println("Todos Tus Pokemons Han Sido Derrotados, Has Sido Derrotado");
						   return false;
					   }
					   System.out.println("Selecciona Otro Pokemon Para Continuar El Combate: ");
					   partida.getEquipoCombatePokemon();
					   String EleccionRemplazo = s.nextLine();
					   if(EquipoPokemon.get(Integer.parseInt(EleccionRemplazo)-1).getEstado().equals("vivo")) {
							  PokemonActual = EquipoPokemon.get(Integer.parseInt(EleccionRemplazo)-1);
							  System.out.println(NombreJugador+" Saca a "+ PokemonActual.getNombrePokemon()+"Stats: "+PokemonActual.getEstadisticasTotales());
							  System.out.println(Enemigo+" Tiene a "+ PokemonEnemigo);
							  RemplazoValido = true;
							  }
					   if(EquipoPokemon.get(Integer.parseInt(EleccionRemplazo)-1).getEstado().equals("Derrotado")) {
						   
						   
								  System.out.println("El Pokemon Esta Fuera De Combate...");
							  }
					   
					   
					   
					   
				   }
				   
				   VictoriaDeCombate = false;
				   
				   break;
				   
				   
				   
			   }
		  case "2":
			  System.out.println("Selecciona El Pokemon Para El Combate");
			  partida.getEquipoCombatePokemon();
			  String EleccionCombate = s.nextLine();
			  
			  
			  if(EquipoPokemon.get(Integer.parseInt(EleccionCombate)-1).getEstado().equals("vivo")) {
			  PokemonActual = EquipoPokemon.get(Integer.parseInt(EleccionCombate)-1);
			  System.out.println(NombreJugador+" Saca a "+ PokemonActual.getNombrePokemon()+"Stats: "+PokemonActual.getEstadisticasTotales());
			  System.out.println(Enemigo+" Tiene a "+ PokemonEnemigo);
			  }else{
				  System.out.println("El Pokemon Esta Fuera De Combate...");
			  }
			  break;
		  case "3":
			  System.out.println("Estas seguro de rendirte?");
			  System.out.println("1.-) Si");
			  System.out.println("2.-) No");
			  int Rendirse = s.nextInt();
			  if(Rendirse == 1) {
				  
				  AcaboElCombate = true;
				  
				  break;
			  }
			  
		   }
		   
		   if(VictoriaDeCombate){
			   System.out.println("Has Vencido Al Maestro Pokemon Del Gimnasio!!!");
			   System.out.println("Ahora Estas Mas Cerca De Ser El Mejor Maestro Pokemon De Todos");
			   Gym.setEstado("Derrotado");
			   
			   
			   
		   }
		   
		 
		   
		   
		   
	   }
	   return VictoriaDeCombate;
	   
   }
   /////
   public ArrayList<Pokemon> DeterminarEquipoActual() {

		ArrayList<Pokemon> equipoActual = new ArrayList<Pokemon>();

		for(int i = 0; i < EquipoPokemonActual.length; i++) {

			if(EquipoPokemonActual[i] != null) {
				equipoActual.add(EquipoPokemonActual[i]);
			}
		}

		return equipoActual;
	
	}
   public ArrayList<String> getCantidadMedallas() {
	   String texto = "";
	   if(cantidadMedallas.size() != 0) {
	   for (String s : cantidadMedallas) {
		   texto = texto+";"+s;
		
	}}
	   
	   
	return cantidadMedallas;
   }
   
   
   
   
   public void AñadirPokemonEquipoActual(Pokemon p) {

		for(int i = 0; i < EquipoPokemonActual.length; i++) {
			
			if(EquipoPokemonActual[i] == null) {
				
				EquipoPokemonActual[i] = p;
				break;
			}
		}
	}
   
   public void CurarPokemons() {

		for(Pokemon p : EquipoPokemon) {

			if(p.getEstado().equals("Debilitado")) {

				p.setEstado("Vivo");
			}
		}

		System.out.println("Todos los pokemons debilitados han sido curados");
		System.out.println("");
	}
   public void setEstadoMedallas(String Lider,ArrayList<Gimnasio> ListaDeGym){
	   for (Gimnasio g : ListaDeGym) {
		if(Lider.equals(g.getLider())){
			g.setEstado("Derrotado");
			
		}
		   
	}
	   
	   
	   
	   
   }
   public String GuardarGimnasiosDerrotados(ArrayList<Gimnasio> ListaGym) {
	   String texto = "";
	   for (Gimnasio g : ListaGym) {
		if(g.getEstado().equals("Derrotado")) {
			texto = texto+";";
			texto = texto+g.getLider();
		}
		   
	}
	   
	   
	   return texto; 
	   
   }
   
   public void ActualizarEquipoCombate() {

		for(int i = 0; i < EquipoPokemonActual.length; i++) {

			EquipoPokemonActual[i] = null;
		}

		for(int i = 0; i < EquipoPokemon.size() && i < 6; i++) {

			EquipoPokemonActual[i] = EquipoPokemon.get(i);
		}
	}
   
   
   
}
