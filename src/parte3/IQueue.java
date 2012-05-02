package parte3;

public interface IQueue<E> {
	
	public E dequeue() ;
		
	public void enqueue(E e) ;

	public E front() ;

	public boolean isEmpty() ;
	
}
