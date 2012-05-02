package parte4;

import CasoPractico.Cancion;
import CasoPractico.SNode;

public class ArbolCancionesPorTitulo extends BSTree<String, Cancion> {


	public ArbolCancionesPorTitulo(ColeccionCanciones col){
		if(col != null){
			SNode<Cancion> aux = col.first();
			while(aux!=null){
				this.insert(aux.element.getTitulo(), aux.element);
				aux = aux.next;
			}
		}
	}
	
	public void dibujarArbol(){
		BSTreeView.draw(this);
	}
	
	public boolean existeCancion(String cancion){
		return buscarCancion(this.root, cancion);
	}
	
	private boolean buscarCancion(BSTNode<String, Cancion> nodo, String titulo){
		boolean returnValue = false;
		if(nodo.element.getTitulo().equalsIgnoreCase(titulo)){
			returnValue = true;
		}
		
		if(returnValue == false){
			if(buscarCancion(nodo.left, titulo) == false){
				returnValue = buscarCancion(nodo.left, titulo);
			}else{
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	public ColeccionCanciones cancionesEntreFechas(String anio1,String anio2){
		ColeccionCanciones canciones=new ColeccionCanciones();
		
		int anioI=Integer.parseInt(anio1);
		int anioF=Integer.parseInt(anio2);
		if(anioI>anioF){
			int aux = anioI;
			anioI = anioF;
			anioF = aux;
		}
		return cancionesEntreFechas(this.root,canciones,anioI,anioF);
	}
	
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
