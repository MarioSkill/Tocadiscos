package parte3;

import CasoPractico.Cancion;
import CasoPractico.Disco;
import CasoPractico.SList;
import CasoPractico.Disco.Velocidad;
import CasoPractico.ISList;

public class Tocadisco implements ITocadiscos {

	private Plato plato = new Plato();
	private Aguja aguja = new Aguja();
	private Eje eje = new Eje();
	
	public Tocadisco(){
		plato.pincharEje(eje);
		eje.pincharEnPlato(plato);
	}

	
	public boolean estaEjePinchado() {
		return eje.estaPinchado();
	}

	
	public void pincharEje() {
		if (estaEjePinchado()==false){
			plato.pincharEje(eje);
		}
	}

	
	public void despincharEje() {
		if (plato.estaVacio()){
			plato.quitarEje();
		}
	}

	
	public boolean estaEjeVacio() {
		return eje.estaVacio();
	}

	
	public boolean estaEjeLleno() {
		return eje.estaLleno();
	}

	
	public boolean estaPlatoArrancado() {
		return plato.estaArrancado();
	}

	
	public void arrancarPlato() {
		if (estaPlatoArrancado() == false && plato.obtenerDisco().getRMP() == plato.obtenerRpm()){
			plato.arrancar();
		}
		
	}

	
	public void pararPlato() {
		if(aguja.estaBajada() == false){
			aguja.bajar();
		}
		plato.parar();
	}

	
	public void fijarRpmPlato(Velocidad rpm) {
		if (aguja.estaBajada() == false){
			plato.fijarRpm(rpm);
		}
	}

	
	public Velocidad obtenerRpmPlato() {
		return plato.obtenerRpm();
	}

	
	public void ponerDiscoEnEje(Disco disco, int nombreCara) {
		eje.ponerdisco(disco, nombreCara);		
	}

	
	public void dejarCaerDiscoDeEje() {
		if(plato.tieneEje()==true){
			if(aguja.estaAparcada() == false){
				aguja.aparcar();
			}
			eje.dejarCaerDisco();
		}
	}

	
	public ISList<Disco> quitarDiscosDelPlato() {
		SList<Disco> listaDiscos = null;
		if(estaPlatoArrancado()==false && eje.estaVacio() == true && aguja.estaAparcada() == true){
			listaDiscos = (SList<Disco>) plato.quitarDiscos();
		}else{
			System.out.println("no se pueden quitar los discos en este momento, primero debes apagar el tocadiscos y aparcar la aguja");
		}
		return listaDiscos;
	}

	
	public boolean estaAgujaAparcada() {
		return aguja.estaAparcada();
	}

	
	public void aparcarAguja() {
		aguja.aparcar();
	}

	
	public void desaparcarAguja() {
		plato.arrancar();
		aguja.desaparcar();
	}

	
	public boolean estaAgujaBajada() {
		return aguja.estaBajada();
	}

	
	public void subirAguja() {
		aguja.subir();
	}

	
	public void bajarAguja() {
		if(plato.estaArrancado() == true){
			aguja.bajar();
		}
	}

	
	public void fijarPosicionAguja(float posicion) {
		if (aguja.estaBajada()==true){
			aguja.subir();
		}
		aguja.fijarPosicion(posicion);
	}

	
	public Disco obtenerDiscoCima() {
		return plato.obtenerDisco();
	}

	
	public int obtenerNombreCaraCima() {
		return plato.obtenerNombreCara();
	}

	
	public Cancion obtenerCancionSonando() {
		return plato.obtenerDisco().getCara(plato.obtenerNombreCara()).needlePlaced((int)aguja.obtenerPosicion());			
	}
}