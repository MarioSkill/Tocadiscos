package parte2;
import CasoPractico.SNode;
public class Stack<E> implements IStack<E>{

	public SNode<E> head;
	public int size;
	
	public Stack() {
		head = null;
		size=0;
	}
	
	public void push(E obj) {
		SNode<E> nodo = new SNode<E>(obj);
		nodo.next = head;
		head = nodo;
		size++;
	}

	public E pop() {
		if (head == null) {
			return null;
		} else {
			E borrado = head.element;
			head = head.next;
			size--;
			return borrado;
		}
	}

	public E top() { // top
		return head.element;
	}

	public boolean isEmpty() {
		return head == null;
	}

	
	public void removeIteAll() {
		while (!isEmpty()) pop();
	}
	

	public static void main(String[] args) {
		Stack<String> pila = new Stack<String>();
		pila.push("Hola");
		pila.push("Buenos días");
		
		System.out.println(pila.size);
		System.out.println(pila.top());
		pila.push("Adiós");
		
		System.out.println(pila.isEmpty());
	}
}
