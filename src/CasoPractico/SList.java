package CasoPractico;
/**
 * Clase que implementa una lista simple enlazada. 
 * En esta clase, sólo se guarda la referencia al primer nodo
 * de la lista
 */
public class SList<E> implements ISList<E>{

	/**Es el primer nodo de la lista*/
	public SNode<E> head;
		
	/**Guarda el número de elementos de la lista*/
	public int size;
	
	/**Crea una lista vacía. Head debe ser null*/
	public SList() {
		head=null;
		size=0;
	}
	
	/**
	 * Método que devuelve true si la lista está vacía
	 * y false en otro caso.
	 * Complejidad O(1)
	 * @return
	 */
	public boolean isEmpty() {
		if (head==null) return true;
		else return false;
		//return (size==0);
	}

	// devuelve el primer nodo de la lista. Se produce un error si la lista est� vac�o.

	public SNode<E> first() {
		return head;
	}

    // devuelve el �ltimo nodo de la lista. Se produce un error si la lista est� vac�o.
	
	public SNode<E> last() {
		if (isEmpty()){
			System.out.println("la lista est� vacia!!!");
			return null; //salimos del método
		}
		SNode<E> aux=head;
			while (aux.next!=null) {
				aux=aux.next;
			}
			return aux;
	}

	/**
	 * ESte método inserta el nodo newNodo al principio de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public void addFirst(SNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		//El primer nodo actual ahora será el segundo
		newNodo.next=head;
		//Ahora hacemos que el primer nodo sea newNodo
		head=newNodo;
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	/**
	 * 
	 * Este método inserta el nodo newNodo al final de la lista.
	 * Complejidad O(n), porque el número de instrucciones a ejecutar 
	 * depende del número de nodos (n), que debemos visitar. 
	 * @param newNodo nodo a insertr
	 */
	public void addLast(SNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		if (isEmpty()) addFirst(newNodo);
		else {
			SNode<E> aux=head;
			while (aux.next!=null) {
				aux=aux.next;
			}
			//hemos llegado al último nodo, ahora su referencia next 
			//debe ser newNodo
			aux.next=newNodo;
			//newNodo.next debe ser nulo, porque es el final de la lista
			newNodo.next=null;
			//incrementamos el tamaño
			size++;	
		}	
	}

	/** agregar el nuevo nodo antes del nodo que contiene el elemento e.
	 * Complejidad O(n)
	 */
	
	public void addBefore(E e, SNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		if (head.element==e){
			addFirst (newNodo);
		} else {
		SNode<E> aux=head;
		while (aux!=null && aux.next.element!=e) {
			aux=aux.next;
		}
		SNode<E> aux2=aux.next;
		aux.next = newNodo;
		newNodo.next=aux2;
		size++;
		}
		
	}

	/** agregar el nuevo nodo justo despu�s del nodo que contiene el elemento e.
	  * Complejidad O(n)
	  */
	
	public void addAfter(E e, SNode<E> newNodo) {
		if (newNodo==null) {
			System.out.println("El nodo es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		SNode<E> aux=head;
		while (aux.element!=e && aux.next!=null) {
		aux=aux.next;
		}
		if (aux.next == null){
			addLast (newNodo);
		} else {
		SNode<E> aux2=aux.next;
		aux.next = newNodo;
		newNodo.next=aux2;
		}
		size++;
		
	}
	
	/**
	 * Borra el primer elemento de la lista. 
	 * Complejidad O(1).
	 */
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		SNode<E> oldFirst=head;
		//head debe pasar a ser el siguiente nodo. 
		head=head.next;
		//disminuimos el tamaño de la lista
		size--;
		oldFirst.next=null;
	}
	
	/**
	 * Borra el último nodo de la lista.
	 * Debemos recorrer la lista hasta encontrar el penúltimo nodo
	 * cuya propiedad next ahora deberá pasar a ser null 
	 * Complejidad O(n), porque el número de operaciones depende del
	 * tamaño de la lista (ya que debemos visitar sus n nodos).
	 */
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return; //salimos del método
		}
		
		SNode<E> ultimo=head;
		SNode<E> penultimo=null;
		//Recorremos la lista hasta encontrar el último nodo
		while (ultimo.next!=null) {
			penultimo=ultimo;
			ultimo=ultimo.next;
		}
		
		if (penultimo==null) {
			/*Quiere decir que la lista solo tenía un nodo.
			head debe ser null, porque estamos borrando el 
			único nodo que tenía.*/
			head=null;
		} else {
			//La lista tiene dos o más elementos
			penultimo.next=null;
		}
		size--;
	}
	
	
	/**
	 * removes all nodes whose element is equals to e
	 * @param e
	 */
	public void remove(E e) {
		SNode<E> aux=head;
		SNode<E> ant=null;
		if (isEmpty()) {
			return;
		}
		while (aux!=null) {
			if (aux.element!=e) {
			} else {
				if (ant!=null) {
					ant.next=aux.next;
					size--;
				}
			}
			ant=aux;
			aux=aux.next;
		}
			
		}

	/**Recorre los elementos de la lista y los muestra*/
	public void show() {
		SNode<E> aux=head;
		while (aux!=null) {
			System.out.println(aux.element + ",");
			aux=aux.next;
		}
		System.out.println();
	}
	

	
	/**
	 * El método main nos permite crear una lista
	 * @param args
	 */
	public static void main(String args[]) {
		SList<Integer> lista=new SList<Integer>();
		//Vamos a guardar 10 elementos
		for (int i=0; i<=9; i++) {
			//Creamos un nodo con el valor i, y que su next sea null 
			lista.addFirst(new SNode<Integer>(i));
		}
		lista.show();

		lista.addAfter(3, new SNode<Integer>(15));
		lista.addBefore(3, new SNode<Integer>(25));
		lista.remove(7);
		lista.show();
		System.out.println(lista.size);
		lista.removeFirst();
		lista.removeLast();
	
	
	

	
	}
	}
	
	
	
	
