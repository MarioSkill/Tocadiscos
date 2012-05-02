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

	@Override
	public boolean estaEjePinchado() {
		return eje.estaPinchado();
	}

	@Override
	public void pincharEje() {
		if (estaEjePinchado()==false){
			plato.pincharEje(eje);
		}
	}

	@Override
	public void despincharEje() {
		if (plato.estaVacio()){
			plato.quitarEje();
		}
	}

	@Override
	public boolean estaEjeVacio() {
		return eje.estaVacio();
	}

	@Override
	public boolean estaEjeLleno() {
		return eje.estaLleno();
	}

	@Override
	public boolean estaPlatoArrancado() {
		return plato.estaArrancado();
	}

	@Override
	public void arrancarPlato() {
		if (estaPlatoArrancado() == false && plato.obtenerDisco().getRMP() == plato.obtenerRpm()){
			plato.arrancar();
		}
		
	}

	@Override
	public void pararPlato() {
		if(aguja.estaBajada() == false){
			aguja.bajar();
		}
		plato.parar();
	}

	@Override
	public void fijarRpmPlato(Velocidad rpm) {
		if (aguja.estaBajada() == false){
			plato.fijarRpm(rpm);
		}
	}

	@Override
	public Velocidad obtenerRpmPlato() {
		return plato.obtenerRpm();
	}

	@Override
	public void ponerDiscoEnEje(Disco disco, int nombreCara) {
		eje.ponerdisco(disco, nombreCara);		
	}

	@Override
	public void dejarCaerDiscoDeEje() {
		if(plato.tieneEje()==true){
			if(aguja.estaAparcada() == false){
				aguja.aparcar();
			}
			eje.dejarCaerDisco();
		}
	}

	@Override
	public ISList<Disco> quitarDiscosDelPlato() {
		SList<Disco> listaDiscos = null;
		if(estaPlatoArrancado()==false && eje.estaVacio() == true && aguja.estaAparcada() == true){
			listaDiscos = (SList<Disco>) plato.quitarDiscos();
		}else{
			System.out.println("no se pueden quitar los discos en este momento, primero debes apagar el tocadiscos y aparcar la aguja");
		}
		return listaDiscos;
	}

	@Override
	public boolean estaAgujaAparcada() {
		return aguja.estaAparcada();
	}

	@Override
	public void aparcarAguja() {
		aguja.aparcar();
	}

	@Override
	public void desaparcarAguja() {
		plato.arrancar();
		aguja.desaparcar();
	}

	@Override
	public boolean estaAgujaBajada() {
		return aguja.estaBajada();
	}

	@Override
	public void subirAguja() {
		aguja.subir();
	}

	@Override
	public void bajarAguja() {
		if(plato.estaArrancado() == true){
			aguja.bajar();
		}
	}

	@Override
	public void fijarPosicionAguja(float posicion) {
		if (aguja.estaBajada()==true){
			aguja.subir();
		}
		aguja.fijarPosicion(posicion);
	}

	@Override
	public Disco obtenerDiscoCima() {
		return plato.obtenerDisco();
	}

	@Override
	public int obtenerNombreCaraCima() {
		return plato.obtenerNombreCara();
	}

	@Override
	public Cancion obtenerCancionSonando() {
		return plato.obtenerDisco().getCara(plato.obtenerNombreCara()).needlePlaced((int)aguja.obtenerPosicion());			
	}
}
