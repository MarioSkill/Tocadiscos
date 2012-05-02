package parte4;

import java.util.ArrayList;

public class BSTree<K extends Comparable<K>, E> implements IBSTree<K, E> {
	BSTNode<K, E> root;

	// int size;

	public BSTree() {
		this.root = null;
		// this.size = 0;
	}

	public BSTree(BSTNode<K, E> node) {
		this.root = node;
		// this.size = 1;
	}

	public BSTNode<K, E> getRoot() {
		return this.root;
	}

	public void insert(K key, E elem) {
		BSTNode<K, E> newNode = new BSTNode<K, E>(key, elem);
		if (this.root == null) {
			this.root = newNode;
			// this.size++;
			return;
		}
		insert(newNode, this.root);
	}

	private void insert(BSTNode<K, E> newNode, BSTNode<K, E> node) {
		K key = newNode.key;
		// Descomentar estas líneas para NO permitir duplicados
		// if (key.compareTo(node.key) == 0) {
		// System.out
		// .println("Ya hay un elemento con esta clave, no podemos a�adir otro");
		// return;
		// } else
		if (key.compareTo(node.key) < 0) {
			if (node.left == null) {
				node.left = newNode;
				newNode.parent = node;
				// this.size++;
				return;
			} else {
				insert(newNode, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = newNode;
				newNode.parent = node;
				// this.size++;
				return;
			} else {
				insert(newNode, node.right);
			}
		}
	}

	public BSTNode<K, E> search(K key) {
		return search(this.root, key);
	}

	private BSTNode<K, E> search(BSTNode<K, E> node, K key) {
		if (node == null) {
			return null;
		}
		if (node.key.compareTo(key) == 0) {
			return node;
		} else {
			if (node.key.compareTo(key) < 0) {
				return search(node.right, key);
			} else {
				return search(node.left, key);
			}
		}
	}

	public void remove(K key) {
		if (this.root == null) {
			System.out
					.println("El árbol está vacío, no podemos eliminar el nodo deseado");
			return;
		}
		this.root = remove(key, this.root);
	}

	private BSTNode<K, E> remove(K key, BSTNode<K, E> node) {
		if (node == null) {
			System.out
					.println("No existe la clave, así que no eliminamos nada");
			return null;
		}
		if (key.equals(node.key)) {
			if (!node.hasLeft() && !node.hasRight()) {
				return null;
			}
			if (!node.hasLeft()) {
				node.right.parent = node.parent;
				return node.right;
			}
			if (!node.hasRight()) {
				node.left.parent = node.parent;
				return node.left;
			}
			// Buscar el mayor de la rama izquierda
			BSTNode<K, E> mayorIzq = node.left;
			while (mayorIzq.hasRight()) {
				mayorIzq = mayorIzq.right;
			}
			// Borrar este elemento de la rama izquierda
			BSTNode<K, E> ramaIzq = remove(mayorIzq.key, node.left);
			BSTNode<K, E> ramaDer = node.right;
			// Dejar todo colgando de este
			mayorIzq.parent = node.parent;
			mayorIzq.left = ramaIzq;
			if (ramaIzq != null)
				ramaIzq.parent = mayorIzq;
			mayorIzq.right = ramaDer;
			if (ramaDer != null)
				ramaDer.parent = mayorIzq;
			// Y lo devuelvo
			return mayorIzq;
		}
		if (key.compareTo(node.key) < 0) {
			node.left = remove(key, node.left);
			return node;
		} else {
			node.right = remove(key, node.right);
			return node;
		}
	}

	public ArrayList<E> preorderNodes() {
		return preorderNodes(this.root);
	}

	public ArrayList<E> preorderNodes(BSTNode<K, E> node) {
		ArrayList<E> preorderList = new ArrayList<E>();
		preorderNodes(node, preorderList);
		return preorderList;
	}

	private void preorderNodes(BSTNode<K, E> node, ArrayList<E> preorderList) {
		if (node == null)
			return;
		preorderList.add(node.element);
		// System.out.print(node.element + ", ");
		preorderNodes(node.left, preorderList);
		preorderNodes(node.right, preorderList);
	}

	/*
	 * Comprobar si cada nodo tiene bien fijado el padre
	 */

	// private void checkParents() {
	// if (this.root != null && this.root.parent != null)
	// System.out.println("checkParents: Error en root");
	// checkParents(this.root);
	// }
	//
	// private void checkParents(BSTNode<K, E> node) {
	// if (node == null)
	// return;
	// if (node.hasLeft() && node.left.parent != node)
	// System.out.println("checkParents: Error en node.left de "
	// + node.key);
	// if (node.hasRight() && node.right.parent != node)
	// System.out.println("checkParents: Error en node.right de "
	// + node.key);
	// checkParents(node.left);
	// checkParents(node.right);
	// }

	public static void main(String args[]) {

		BSTree<Integer, String> bstree = new BSTree<Integer, String>();

		// bstree.insert(new BSTNode<Integer, String>(19, "Ana"));
		// bstree.insert(new BSTNode<Integer, String>(12, "Juan"));
		// bstree.insert(new BSTNode<Integer, String>(16, "Maria"));
		// bstree.insert(new BSTNode<Integer, String>(23, "Jose"));
		// bstree.insert(new BSTNode<Integer, String>(20, "Elena"));
		// bstree.insert(new BSTNode<Integer, String>(34, "Paco"));

		bstree.insert(19, "19");
		bstree.insert(12, "12");
		bstree.insert(16, "16");
		bstree.insert(23, "23");
		bstree.insert(20, "20");
		bstree.insert(34, "34");

		bstree.remove(19);
		// bstree.remove(16);

		// bstree.checkParents();

		BSTreeView.draw(bstree);

		ArrayList<String> preorderList = bstree.preorderNodes(bstree.root);
		System.out.println(preorderList);

	}

}
