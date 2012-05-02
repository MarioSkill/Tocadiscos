package parte3;

public interface IAguja {
	public boolean estaAparcada();
	public void aparcar(); 
	public void desaparcar(); 
	public boolean estaBajada();
	public void subir(); 
	public void bajar(); 
	public void fijarPosicion(float posicion); // 0-100%
	public float obtenerPosicion(); // 0-100%
}
