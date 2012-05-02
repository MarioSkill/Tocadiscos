package parte3;

import parte2.Stack;
import CasoPractico.Disco;
import CasoPractico.Disco.Velocidad;
import CasoPractico.ISList;
import CasoPractico.SList;
import CasoPractico.SNode;

public class Plato extends Stack<Disco> implements IPlato {
	
	public Plato(){
		this.estado=0;
		this.eje=null;
		this.cara=0;
		this.rpm=null;
	}

	private int estado;
	private Disco.Velocidad rpm;
	private Eje eje;
	private int cara;
	
	public void arrancar() {
		this.estado=1;
	}

	public void parar() {
		this.estado=0;
	}

	public boolean estaArrancado() {
		if (estado==1)
			return true;
		
		return false;
	}

	public void fijarRpm(Velocidad rpm) {
		this.rpm=rpm;
		
	}

	public Velocidad obtenerRpm() {
		return this.rpm;
	}

	public void ponerDisco(Disco disco, int nombreCara) {
		this.cara=nombreCara;
		this.push(disco);
	}

	public ISList<Disco> quitarDiscos() {
		ISList<Disco> coleccion=new SList<Disco>();
		
		while (size!=0){
			coleccion.addFirst(new SNode<Disco>(this.pop()));
		}
		
		return coleccion;
	}

	public boolean estaVacio() {
		if (size==0)
			return true;
		
		return false;
	}

	public boolean tieneEje() {
		if (eje!=null)
			return true;
		
		return false;
	}

	public void pincharEje(Eje eje) {
		this.eje=eje;
	}

	public void quitarEje() {
		this.eje=null;
	}

	public Disco obtenerDisco() {
		return this.top();
	}

	public int obtenerNombreCara() {
		return this.cara;
	}

}
