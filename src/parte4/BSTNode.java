package parte4;


import java.util.ArrayList;

public class BSTNode<K extends Comparable<K>, E> {
	K key;
	E element;
	BSTNode<K,E> parent;
	BSTNode<K,E> left;
	BSTNode<K,E> right;

	public K getKey() {
		return this.key;
	}

	public E getElement() {
		return this.element;
	}

	public BSTNode<K, E> getParent() {
		return this.parent;
	}

	public BSTNode<K, E> getLeft() {
		return this.left;
	}

	public BSTNode<K, E> getRight() {
		return this.right;
	}

	public BSTNode(K k, E e){
		this.parent=null;
		this.left=null;
		this.right=null;
		this.key = k;
		this.element=e;
	}
	
	public BSTNode(BSTNode<K,E> p, BSTNode<K,E> l,
			BSTNode<K,E> r, E e, K k) {
		this.parent = p;
		this.left = l;
		this.right = r;
		this.key = k;
		this.element = e;
	}


	public boolean hasLeft(){
		if(this.left!=null){
			return true;
		}
		return false;
	}
	public boolean hasRight(){
		if(this.right!=null){
			return true;
		}
		return false;
	}

	public boolean isInternal(){
		if(this.left==null && this.right==null){
			return false;
		}
		return true;
	}
	public boolean isExternal(){
		if(this.left==null && this.right==null){
			return true;
		}
		return false;
	}
	public BSTNode<K,E> root(){
		if(this.parent==null){
			return this;
		}
		else{
			return this.parent.root();
		}
	}
	
	public boolean isRoot(){
		if(this.parent==null){
			return true;
		}
		else{
			return false;
		}
	}

	public ArrayList<BSTNode<K, E>> children() {
		ArrayList<BSTNode<K, E>> child=new ArrayList<BSTNode<K, E>>();
		if (hasLeft()) child.add(this.left);
		if (hasRight()) child.add(this.right);
		return child;
	}

}
