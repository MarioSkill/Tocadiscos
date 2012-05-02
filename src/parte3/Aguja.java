package parte3;

public class Aguja implements IAguja {

	private float fltPosicion;
	private boolean estaAbajo;
	
	public Aguja(){
		fltPosicion = -1;
		estaAbajo = false;
	}
	
	
	@Override
	public boolean estaAparcada() {
		boolean returnValue = false;
		if(obtenerPosicion() < 0){
			returnValue = true;
		}
		return returnValue;
	}

	@Override
	public void aparcar() {
		fltPosicion = -1;
	}

	@Override
	public void desaparcar() {
		fltPosicion = 0;
	}

	@Override
	public boolean estaBajada() {
		boolean returnValue = false;
		if(obtenerPosicion() > 0 && estaAbajo == true){
			returnValue = true;
		}
		return returnValue;
	}

	@Override
	public void subir() {
		estaAbajo = true;
	}

	@Override
	public void bajar() {
		estaAbajo = false;
	}

	@Override
	public void fijarPosicion(float posicion) {
		if(posicion >= (float) 0 && posicion <= (float) 100){
			fltPosicion = posicion;
		}
	}

	@Override
	public float obtenerPosicion() {
		return fltPosicion;
	}

}
