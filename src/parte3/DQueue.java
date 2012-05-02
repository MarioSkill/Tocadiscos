package parte3;

/**
 * Dqueue implementada como una lista doble enlazada.
 * Dqueue vs DList
 * 1) Dqueue no tiene los métodos remove, addAfter, addBefore.
 * 2) En Dqueue los métodos removeFirst y removeLast deben devolver el valor del Nodo, 
 * mientras que en DList  estos métodos no devuelve nada.
 * @author isegura
 * @param <E>
 */

public class DQueue<E> implements IDQueue<E>{

	/**Nodo centinela cuyo propiedad next apunta al primer nodo de la lista*/
	public DNode<E> header;
	
	/**Nodo centinela cuyo propiedad prev apunta al último nodo de la lista*/
	public DNode<E> tailer;
	public  int size;
	
	
	/**
	 * Devuelve true si la lista está vacía, false en otro caso.
	 * @return
	 */
	public boolean isEmpty() {
		return (size==0);
	}

	/**
	 * Crea una lista vacía. Para ello 
	 * inicializa los dos nodos centinelas
	 */
	public DQueue() {
		header=new DNode<E>();
		tailer=new DNode<E>();
		//Se apuntan el uno al otro
		header.next=tailer;
		tailer.prev=header;
		size=0;
	}
	
	/**
	 * ESte método inserta el nodo newNodo al principio de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void addFirst(E e) {
		if (e==null) {
			System.out.println("El elemento es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		DNode<E> newNodo=new DNode<E> (e);
		DNode<E> oldFirst=header.next;
		//El nuevo nodo deberá apuntar al primer nodo de la lista
		newNodo.next=oldFirst;
		oldFirst.prev=newNodo;
		//Ahora hacemos que el primer nodo sea newNodo
		header.next=newNodo;
		newNodo.prev=header;
		
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	
	/**
	 * ESte método inserta el nodo newNodo al final de la lista.
	 * Complejidad O(1), porque el método ejecuta un número constante de instrucciones.
	 * @param newNodo
	 */
	public  void addLast(E e) {
		if (e==null) {
			System.out.println("El elemento es nulo, no podemos insertarlo!!!");
			return; //salimos del método
		}
		
		DNode<E> newNodo=new DNode<E> (e);
		DNode<E> oldLast=tailer.prev;
		oldLast.next=newNodo;
		newNodo.prev=oldLast;
		newNodo.next=tailer;
		tailer.prev=newNodo;
		
		//Incrementamos el tamaño de la lista
		size++;
		
	}
	
	
	/**
	 * Borra el primer elemento de la lista. 
	 * Complejidad O(1).
	 */
	public E removeFirst() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return null; //salimos del método
		}
		
		DNode<E> oldFirst=header.next;
		E value=oldFirst.element;
		DNode<E> newPrimero=oldFirst.next;
		//primerNodo debe pasar a ser el siguiente nodo. 
		header.next=newPrimero;
		newPrimero.prev=header;
		size--;
		return value;
	}

	/**
	 * Borra el último nodo de la lista. 
	 * Complejidad O(1).
	 */
	public E removeLast() {
		if (isEmpty()) {
			System.out.println("La lista ya está vacia!!!");
			return null; //salimos del método
		}
		
		DNode<E> oldLast=tailer.prev;
		E value=oldLast.element;
		DNode<E> newLast=oldLast.prev;
		tailer.prev=newLast;
		newLast.next=tailer;
		size--;
		return value;
	}
	
	
	public E first() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		return header.next.element;
	}

	public E last() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		return tailer.prev.element;
	}
	
	/**Recorre los elementos de la lista y los muestra*/
	public void show() {
		DNode<E> aux=header.next;
		while (aux!=tailer) {
			System.out.print(aux.element+",");
			aux=aux.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DQueue<String> cola = new DQueue<String>();
		cola.addFirst("Hola");
		cola.addFirst("Buenos d�as");
		cola.addFirst("Adi�s");
		System.out.println(cola.first());
		System.out.println(cola.last());
		System.out.println(cola.size);
		System.out.println(cola.isEmpty());
	}

	
	
}
