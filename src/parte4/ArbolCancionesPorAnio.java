package parte4;

import CasoPractico.Cancion;
import CasoPractico.SNode;
/**
 * 
 * @author Mario Vasile y David Simal
 * Clase con la que podremos crear un arbol para ener organizada todas nuestras canciones
 *
 */
public class ArbolCancionesPorAnio extends BSTree<String, Cancion> {

	/**
	 * 
	 * @param canciones, coleccion de canciones con la que vamos a inciar nuestro arbol binario de busqueda
	 * recorremos nuesta coleccion y vamos realizando el insert para ir llenando el arbol, en este caso nuestra
	 * key es el año, que sera por lo que ordenemos para balancear el arbol
	 */
	public ArbolCancionesPorAnio(ColeccionCanciones canciones){
		SNode<Cancion> aux=canciones.head;
		while(aux!=null){
			this.insert(aux.element.getFecha(),aux.element);
			aux=aux.next;
		}
	}
	
	/**
	 * Metodo que hace uso de la librería gráfica que se nos ha facilitado, y de esta forma damos un visionado general
	 * de como queda construido el arbol.
	 *
	 */
	public void dibujarArbol(){
		
		BSTreeView.draw(this);//método static
	}
	/**
	 * 
	 * @param nodo, desde el cual queremos empezar a mostrar el arbol , seria nuestro root
	 * Recorremos de forma recursiva toda nuestra estructura en arbol, como es binario solo tenemos dos opciones o derecha o izquierda.
	 * Nosotro lo recorremos de izquierda a derecha.
	 */
	public void verArbol(BSTNode<String, Cancion> nodo){
		System.out.print(" "+nodo.element.getTitulo()+" ");//Mostramos el primer nodo y cada uno de los siguientes
		if( nodo.hasLeft() )//si tiene un hijo a la izquirda
			verArbol(nodo.left);//nos llamamos y nos vamos por la izquierda
		if( nodo.hasRight() )// este caso es igual pero para la derecha
			verArbol(nodo.right);
	}
	/**
	 * 
	 * @param nodo, desde el cual queremos empezar a mostrar el arbol , seria nuestro root
	 * @param titulo, de la canción que estamos bucando
	 * @return devuelve verdadero si la encuentra , falso si no.
	 * Informa si existe una cancion en nuestro arbol.
	 */
	public boolean existeCancion(String titulo){
		return buscarCancion(root,titulo);
	}
	
	/**
	 *  
	 * @param nodo, busca en el mismo y en los hijos de este
	 * @param titulo, titulo del a cancion a buscar
	 * @return devuelve true si se encuentra la cancion, en caso contrario false
	 * Metodo privado que busca una cancion en un nodo y todos sus hijos
	 */
	private boolean buscarCancion(BSTNode<String, Cancion> nodo, String titulo){
	/*	boolean returnValue = false;
		if(nodo.element.getTitulo().equalsIgnoreCase(titulo)){
			returnValue = true;
		}
		
		if(returnValue == false){
			if(nodo.hasLeft()){
				returnValue = buscarCancion(nodo.left, titulo);
			}else{
				if(nodo.hasRight()){
					returnValue = buscarCancion(nodo.right, titulo);	
				}	
			}
		}
		
		
		return returnValue;*/

		if(nodo.element.getTitulo().equalsIgnoreCase(titulo))
			return true;
		
		if(nodo.hasLeft())
			if(buscarCancion(nodo.left, titulo)== false){
				if(nodo.hasRight()){
					return buscarCancion(nodo.right, titulo);
				}else{
					return false;
				}
			}else{
				return true;
			}
		return false;
		
	}

	/**
	 * 
	 * @param fecha1 fecha primera de filtro
	 * @param fecha2 fecha segunda de filtro
	 * @return devuelve una coleccion de canciones con todas las canciones que se encuentran entre las dos fechas
	 * recorremos nuestro arbol y creamos una lista con nuestas canciones, si no hay canciones, devuelve null
	 */
	public ColeccionCanciones cancionesEntreFechas(String fecha1,String fecha2){
		ColeccionCanciones canciones=new ColeccionCanciones();//Creamos nuesta coleccion

		int anioI=Integer.parseInt(fecha1);
		int anioF=Integer.parseInt(fecha2);
		if (anioI<anioF){//si las fechas son coerentes
			return cancionesEntreFechas(this.root,canciones,anioI,anioF);//llamamos a nuestro metodo por sobrecarga, privado y recursivo. 
		}else{
			System.out.println("la fecha fin es mayor a la fecha inicio...");
		}
		return null;
	}
	/**
	 * 
	 * @param nodo, desde el cual queremos empezar a mostrar el arbol , seria nuestro root
	 * @param canciones, colecionCanciones donde guardaremos nuestra lista
	 * @param inicio, año de inicio
	 * @param fin, año fin
	 * @return retorna nuesta coleccion decanciones
	 * Este metodo ha sido construido para simplificar un poco el anterior ,y para simplificar la llamada que debe hacer el programador
	 * de este modo solo llamamos al metodo con la fehca inicio y la fecha fin, que es lo lógico.
	 * El modo de recorrer el arbol es la misma forma que hemos hemos utilizado anteriormente 
	 */
	private ColeccionCanciones cancionesEntreFechas(BSTNode<String, Cancion> nodo,ColeccionCanciones canciones,int inicio,int fin){
		int fecha=Integer.parseInt(nodo.key);
		if(fecha>inicio && fecha< fin)
			canciones.addFirst(new SNode<Cancion>(nodo.element));
		if( nodo.hasLeft() )
			cancionesEntreFechas(nodo.left,canciones,inicio,fin);
		if( nodo.hasRight() )
			cancionesEntreFechas(nodo.right,canciones,inicio,fin);
		
		return canciones;
	}
	
}