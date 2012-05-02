package parte3;

import CasoPractico.Disco;

public class Eje extends DQueue<IPlato> implements IEje  {
	
	
	
	private IPlato plato=new Plato();
	
	public void pincharEnPlato(IPlato plato) {
		this.plato=plato;
	}

	public void quitarDePlato() {
		this.plato=null;
	}

	public void ponerdisco(Disco disco, int nombreCara) {
		//Plato plato =new Plato();
		plato.ponerDisco(disco, nombreCara);
		this.addFirst(plato);
	}

	public void dejarCaerDisco() {
		this.removeLast();
	}

	public boolean estaPinchado() {
		if(plato!=null)
			return true;
		
		return false;
	}

	public boolean estaLleno() {
		if(size==5){
			return true;
		}
		return false;
	}

	public boolean estaVacio() {
		if(size==0){
			return true;
		}
		return false;
	}

}
