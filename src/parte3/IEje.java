package parte3;

import CasoPractico.Disco;

public interface IEje {
	void pincharEnPlato(IPlato plato);
	void quitarDePlato(); 
	void ponerdisco(Disco disco, int nombreCara);
	void dejarCaerDisco(); 
	boolean estaPinchado();
	boolean estaLleno();
	boolean estaVacio();

}
