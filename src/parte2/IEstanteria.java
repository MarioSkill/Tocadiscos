package parte2;

/**
 * 
 * @author Mario Vasile Y David Simal
 *	Interfaz de nuestra clase Estanteria 
 * @param <E>
 */
public interface IEstanteria<E> {
	
	public void addEtiqueta(String s,int n) ;

	public String remEtiqueta(int n);
	
	public CasoPractico.Disco remDisco(int n);

	public void addDisco(E obj,int n);

	

}
