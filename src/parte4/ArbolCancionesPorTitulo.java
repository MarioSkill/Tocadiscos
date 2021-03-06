package parte4;

import CasoPractico.Cancion;
import CasoPractico.SNode;

public class ArbolCancionesPorTitulo extends BSTree<String, Cancion> {
	/**
	 *  Constructor que recibe como parametro una coleccion de canciones y crea el arbol  
	 */
	public ArbolCancionesPorTitulo(ColeccionCanciones col){
		if(col != null){
			SNode<Cancion> aux = col.first();
			while(aux!=null){
				this.insert(aux.element.getTitulo(), aux.element);
				aux = aux.next;
			}
		}
	}
	
	/**
	 *  Dibuja el arbol con la clase que se ha facilitado a tal efecto.
	 */
	public void dibujarArbol(){
		BSTreeView.draw(this);
	}
	/**
	 * 
	 * @param nodo, desde el cual queremos empezar a mostrar el arbol , seria nuestro root
	 * Recorremos de forma recursiva toda nuestra estructura en arbol, como es binario solo tenemos dos opciones o derecha o izquierda.
	 * Nosotro lo recorremos de izquierda a derecha.
	 */
	public void verArbol(BSTNode<String, Cancion> nodo){
		System.out.println(nodo.element.getTitulo());//Mostramos el primer nodo y cada uno de los siguientes
		if( nodo.hasLeft() )//si tiene un hijo a la izquirda
			verArbol(nodo.left);//nos llamamos y nos vamos por la izquierda
		if( nodo.hasRight() )// este caso es igual pero para la derecha
			verArbol(nodo.right);
	}
	
	/**
	 * 
	 * @param cancion, titulo de la cancion a buscar
	 * @return devuelve true si se encuentra la cancion, en caso contrario false
	 *  Comprueba si existe una cancion
	 */
	public boolean existeCancion(String cancion){
		return buscarCancion(this.root, cancion);
	}
	
	/**
	 *  
	 * @param nodo, busca en el mismo y en los hijos de este
	 * @param titulo, titulo del a cancion a buscar
	 * @return devuelve true si se encuentra la cancion, en caso contrario false
	 * Metodo privado que busca una cancion en un nodo y todos sus hijos
	 */
	private boolean buscarCancion(BSTNode<String, Cancion> nodo, String titulo){
		boolean returnValue = false;
		if(nodo.element.getTitulo().equalsIgnoreCase(titulo)){
			returnValue = true;
		}
		
		if(returnValue == false){
			if(nodo.hasLeft()){
				buscarCancion(nodo.left, titulo);
			}else{
				if(nodo.hasRight()){
					buscarCancion(nodo.right, titulo);	
				}	
			}
		}
		return returnValue;
	}
	
	/** 
	 * 
	 * @param fecha1, fecha inicio del periodo
	 * @param fecha2, fecha fin del periodo
	 * @return devuelve una coleccion de canciones con las canciones que estan entre las dos fechas
	 * 
	 * Busca las canciones que estan entre dos fechas
	 */
	public ColeccionCanciones cancionesEntreFechas(String fecha1,String fecha2){
		ColeccionCanciones canciones=new ColeccionCanciones();
		String anio1=fecha1;
		String anio2=fecha2;
		
		int anioI=Integer.parseInt(anio1);
		int anioF=Integer.parseInt(anio2);
		if(anioI>anioF){
			int aux = anioI;
			anioI = anioF;
			anioF = aux;
		}
		return cancionesEntreFechas(this.root,canciones,anioI,anioF);
	}
	
	// Metodo privado que busca las canciones que estan entre 2 fechas
	private ColeccionCanciones cancionesEntreFechas(BSTNode<String, Cancion> nodo,ColeccionCanciones canciones,int inicio,int fin){
		int fecha=Integer.parseInt(nodo.element.getFecha());
		if(fecha>inicio && fecha< fin)
			canciones.addFirst(new SNode<Cancion>(nodo.element));
		if( nodo.hasLeft() )
			cancionesEntreFechas(nodo.left,canciones,inicio,fin);
		if( nodo.hasRight() )
			cancionesEntreFechas(nodo.right,canciones,inicio,fin);
		
		return canciones;
	}
}
