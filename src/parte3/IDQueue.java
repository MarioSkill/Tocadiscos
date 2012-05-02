package parte3;

public interface IDQueue<E> {

	public boolean isEmpty() ;

	public  void addFirst(E e) ;
	
	public  void addLast(E e) ;
	
	public E removeFirst() ;

	public E removeLast() ;
	
	public E first() ;

	public E last() ;
	
	
}
