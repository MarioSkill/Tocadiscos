package CasoPractico;

public interface ISList<E> {

	public boolean isEmpty() ;

	public SNode<E> first() ;

	public SNode<E> last() ;

	public void addFirst(SNode<E> newNodo) ;

	public void addLast(SNode<E> newNodo) ;

	public void addBefore(E e, SNode<E> newNodo) ;
	
	public void addAfter(E e, SNode<E> newNodo) ;
	
	public void removeFirst() ;
	
	public void removeLast() ;
	
	public void remove(E e) ;
	


}
	
	
	
	
