package CasoPractico;
/**
 * Autores: David Simal (100292642) y Mario Vasile (100292688)
 * Fecha: Marzo de 2012
 * Descripcion: Esta clase contiene todos y metodos para aceder y modificar los atributos
 * de esta clase. Asi como completa funcionalidad.
 */


public class Disco {
	public enum Velocidad {
		LENTO(33), MEDIO(45), RAPIDO(78);

		private int tipo;

		private Velocidad (int c) {
			tipo = c;
		}

		public int getCode() {
			return tipo;
		}
	} 
	
	private Cara[] cara;
	private Velocidad rpm;
	private Interprete interprete;
	private String titulo;
	private String fecha;
	
	public Disco(Velocidad rev, Interprete interpreter, String title, String date){
		this.rpm = rev;
		cara = new Cara[2];
		cara[0] = new Cara();
		cara[1] = new Cara();
		this.interprete = interpreter;
		this.titulo = title;
		this.fecha = date;
	}
	
	
	// Getters
	public Cara getCara(int nCara){
		Cara returnCara = null;
		if (nCara < cara.length){
			returnCara = cara[nCara];
		}
		return returnCara;
	}
	
	public Velocidad getRMP(){
		return this.rpm;
	}
	
	public Interprete getInterprete(){
		return this.interprete;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	public String getFecha(){
		return this.fecha;
	}
	
	// Setters
	public void setRMP(Velocidad newRPM){
		this.rpm = newRPM;
	}
	
	public void setInterprete(Interprete interpreter){
		this.interprete = interpreter;
	}
	
	public void setTitulo(String title){
		this.titulo = title;
	}
	public void setFecha(String date){
		this.fecha = date;
	}
	
	public boolean hasSongTitle(String title){
		int longCaras = cara.length;
		boolean titleFound = false;
		
		// Recorremos las caras en busca del titulo
		SNode<Cancion> aux = null; 
		for(int i = 0; i < longCaras; i++){
			aux = cara[i].first();
			while(!titleFound){
				if(aux.next == null && aux.element.getTitulo().equals(title)){
					titleFound = true;
				}
			}
			// titleFound => (aux == null) V (∃title en cara[i])
			
			if(aux == null){
				titleFound = false;
			}else{
				i = longCaras;
			}
		}
				
		return titleFound;
	}
	
	public void addCancion(Cancion song, int side){
		// Si la cancion no es nula Y insertamos en una cara valida
		if (song != null && side < cara.length){
			// Añadimos la cancion al final
			SNode<Cancion> nodo = new SNode<Cancion>(song);
			cara[side].addLast(nodo);
		}
	}
	
	public void removeCancion(Cancion song, int side){
		if (song != null && side < cara.length){
			cara[side].remove(song);
		}
	}
	
	public String toString(){
		return titulo.toString() + " " + fecha.toString() + " " + interprete.toString();
	}
}
