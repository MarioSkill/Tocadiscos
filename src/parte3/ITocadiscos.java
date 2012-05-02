package parte3;
import CasoPractico.Cancion;
import CasoPractico.Disco;
import CasoPractico.ISList;

public interface ITocadiscos {
	public boolean estaEjePinchado();
	public void pincharEje();
	public void despincharEje(); 
	public boolean estaEjeVacio(); 
	public boolean estaEjeLleno(); 
	public boolean estaPlatoArrancado(); 
	public void arrancarPlato();
	public void pararPlato();
	public void fijarRpmPlato (Disco.Velocidad rpm);
	public Disco.Velocidad obtenerRpmPlato();
	public void ponerDiscoEnEje (Disco disco, int nombreCara);
	public void dejarCaerDiscoDeEje(); 
	public ISList<Disco> quitarDiscosDelPlato();
	public boolean estaAgujaAparcada(); 
	public void aparcarAguja();
	public void desaparcarAguja();
	public boolean estaAgujaBajada();
	public void subirAguja(); 
	public void bajarAguja();
	public void fijarPosicionAguja(float posicion); // 0-100%
	public Disco obtenerDiscoCima(); 
	public int obtenerNombreCaraCima();
	public Cancion obtenerCancionSonando();
}
