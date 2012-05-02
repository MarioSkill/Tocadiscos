package CasoPractico;
public class Cancion {
	public enum Genero {CLASICA, POP, ROCK, JAZZ, DANCE , OTROS }
	
	private Interprete interprete;
	private String titulo;
	private Genero genero;
	private String fecha;
	private boolean esDirecto;
	private int duracion;
	
	public Cancion(Interprete interprete, String titulo, Genero genero, String fecha, boolean esDirecto, int duracion){
		
		this.interprete = interprete;
		this.titulo = titulo;
		this.genero = genero;
		this.fecha = fecha;
		this.esDirecto = esDirecto;
		this.duracion = duracion;
	}
	public Cancion (Cancion element){
		this.interprete = element.getInterprete();
		this.titulo = element.getTitulo();
		this.genero = element.genero;
		this.fecha = element.getFecha();
		this.esDirecto = element.getDirecto();
		this.duracion = element.getDuracion();
	}
	
	// Getters
	public Interprete getInterprete(){
		return this.interprete;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public Genero getGenero(){
		return this.genero;
	}
	
	public String getFecha(){
		return this.fecha;
	}
	
	public boolean getDirecto(){
		return this.esDirecto;
	}
	
	public int getDuracion(){
		return this.duracion;
	}
	
	// Setters
	public void setInterprete(Interprete interpreter){
		this.interprete = interpreter;
	}
	
	public void setTitulo(String title){
		this.titulo = title;
	}
	
	public void setGenero(Genero gender){
		this.genero = gender;
	}
	
	public void setFecha(String date){
		this.fecha = date;
	}
	
	public void setDirecto(boolean direct){
		this.esDirecto = direct;
	}
	
	public void setDuracion(int duration){
		this.duracion = duration;
	}
	
	public String toString(){
		return interprete.toString() + ", " + titulo.toString() + ", " + genero.toString();
	}
}
