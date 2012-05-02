package parte3;

import CasoPractico.Disco;
import CasoPractico.ISList;

public interface IPlato {
	public void arrancar(); 
	public void parar(); 
	public boolean estaArrancado();
	public void fijarRpm(Disco.Velocidad rpm);
	public Disco.Velocidad obtenerRpm(); 
	public void ponerDisco(Disco disco, int nombreCara);
	public ISList<Disco> quitarDiscos();
	public boolean estaVacio();
	public boolean tieneEje(); 
	public void pincharEje(Eje eje); 
	public void quitarEje(); 
	public Disco obtenerDisco();
	public int obtenerNombreCara();
}
