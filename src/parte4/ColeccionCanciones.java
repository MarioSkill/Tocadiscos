package parte4;

import CasoPractico.Cancion;
import CasoPractico.Cara;
import CasoPractico.ColeccionDiscos;
import CasoPractico.Disco;
import CasoPractico.Interprete;
import CasoPractico.SList;
import CasoPractico.SNode;

public class ColeccionCanciones extends SList<Cancion> {
	//Un constructor que cree la lista a partir de una colección de discos.
	/**
	 * 
	 * @param discos, coleccion de discos que recorreremos para crear una coleccion de canciones
	 * Recorre todos nuestros discos por sus dos cara para crear una lista de canciones
	 */
	public ColeccionCanciones(ColeccionDiscos discos){
		SNode<Disco> disco= discos.head;//Empezamos en el primer disco
		SNode<Cancion> cancion;
		Cara cara;
		int c=0;//cara "A" por defecto
		while ( disco!=null ){
			cara=disco.element.getCara(c);//obtenmos las canciones de la cara
			cancion=cara.head;
			while(cancion!=null){
				this.addFirst(new SNode<Cancion>(cancion.element));//vamos insertando en la lista
				cancion=cancion.next;
				
			}
			if (c==0){
				c=1;//recorremos la otra cara
			}else{
				disco=disco.next;//cuando hemos visitado las dos caras pasamos al siguiente disco
				c=0;//empezamos por la cara "A" de nuevo
			}
		}
	}
	/**
	 * Contructor creado para poder crear una coleccion vacia e ir llenandola por nosotros mismo
	 */
	public ColeccionCanciones(){
		
	}
	
	/**
	 * Con este metodo recorremos toda nuestra collecion y la va sacando por pantalla. 
	 */
	public void show(){
		SNode<Cancion> cancion = head;
		while(cancion != null){
			System.out.println(cancion.element.toString());
			cancion=cancion.next;
		}
	}
	/**
	 * 
	 * @param interprete, insertamos en una lista todas las canciones de este interprete
	 * @return devolvemos una lista de canciones.
	 * Recorremos nuestra coleccion e insertamos en una nueva lista las canciones que cumplan con el requisito 
	 * de filtrado, si no hay ninguna devuelve null.
	 */
	public  SList<Cancion> cancionesPorInterprete(Interprete interprete){
		SList<Cancion> canciones=new SList<Cancion>();
		SNode<Cancion> cancion = head;
		while(cancion != null){
			if (cancion.element.getInterprete().equals(interprete)){
				canciones.addFirst(new SNode<Cancion>(cancion.element));
			}
		}
		return canciones;
	}
}
