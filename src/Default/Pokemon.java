package Default;
import java.util.Random;
public class Pokemon {
	private String nombrePokemon;
	private String habitat;
	private float ProbabilidadAparicion;
	private int vida;
	private int ATK;
	private int DF;
	private int ESATK;
	private int ESDF;
	private int VEL;
	private int EstadisticasTotales;
	private String Tipo;
	private String Estado;
	/**
	 * @param nombrePokemon
	 * @param habitat
	 * @param probabilidadAparicion
	 * @param vida
	 * @param aTK
	 * @param dF
	 * @param eSATK
	 * @param eSDF
	 * @param vEL
	 * @param tipo
	 */
	public Pokemon(String nombrePokemon, String habitat, float probabilidadAparicion, int vida, int aTK, int dF,
			int eSATK, int eSDF, int vEL, String tipo) {
		super();
		this.nombrePokemon = nombrePokemon;
		this.habitat = habitat;
		ProbabilidadAparicion = probabilidadAparicion;
		this.vida = vida;
		ATK = aTK;
		DF = dF;
		ESATK = eSATK;
		ESDF = eSDF;
		VEL = vEL;
		Tipo = tipo;
		EstadisticasTotales = vida+aTK+dF+eSATK+eSDF+vEL;
		String Estado = "vivo";
	}
	@Override
	public String toString() {
		return nombrePokemon+"|"+Tipo+"|"+"Stats Totales: "+EstadisticasTotales;
	}
	public String getNombrePokemon() {
		return nombrePokemon;
	}
	public void setNombrePokemon(String nombrePokemon) {
		this.nombrePokemon = nombrePokemon;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public float getProbabilidadAparicion() {
		return ProbabilidadAparicion;
	}
	public void setProbabilidadAparicion(float probabilidadAparicion) {
		ProbabilidadAparicion = probabilidadAparicion;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getATK() {
		return ATK;
	}
	public void setATK(int aTK) {
		ATK = aTK;
	}
	public int getDF() {
		return DF;
	}
	public void setDF(int dF) {
		DF = dF;
	}
	public int getESATK() {
		return ESATK;
	}
	public void setESATK(int eSATK) {
		ESATK = eSATK;
	}
	public int getESDF() {
		return ESDF;
	}
	public void setESDF(int eSDF) {
		ESDF = eSDF;
	}
	public int getVEL() {
		return VEL;
	}
	public void setVEL(int vEL) {
		VEL = vEL;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	

	public void FueCapturado(Pokemon p, Partida partida) {
		Random rand = new Random();
		float r1 = rand.nextFloat();
		Random randm = new Random();
		float r2 = rand.nextFloat();
		if(r1<r2*2) {
			System.out.println("El Pokemon "+p.getNombrePokemon()+" ha sido capturado!!!");
			partida.AñadirPokemonAlEquipo(p);
		
			
		}
		if(r1>r2) {
			System.out.println("el pokemon se ah escapado");
		}
		
	}
	
	
	
	
	
	
	
	

}
