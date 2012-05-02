package parte4;

import java.util.ArrayList;

public interface IBSTree<K extends Comparable<K>, E>{
	
	public BSTNode<K,E> getRoot() ;

	public void insert(K key, E elem);

	public BSTNode<K, E> search (K k);
	
	public void remove(K k);
	
	public ArrayList<E> preorderNodes();

	public ArrayList<E> preorderNodes(BSTNode<K, E> node);

}
