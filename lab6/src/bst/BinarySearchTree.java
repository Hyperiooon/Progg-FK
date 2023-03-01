package bst;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree<E> {
	BinaryNode<E> root; // Används också i BSTVisaulizer
	int size; // Används också i BSTVisaulizer
	private Comparator<E> comparator;

	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		this.comparator = (a, b) -> ((Comparable<E>) a).compareTo(b);
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified
	 * comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		BinaryNode<E> node = new BinaryNode<E>(x);
		if (root == null) {
			root = node;
			size++;
			return true;
		}
		return addRec(root, node);
	}

	private boolean addRec(BinaryNode<E> parent, BinaryNode<E> node) {
	
		int compare = comparator.compare(parent.element, node.element);

		if (compare == 0)
			return false;
		if (compare > 0) {
			if (parent.left == null) {
				parent.left = node;
				size++;
				return true;
			} else
				return addRec(parent.left, node);
		}
		if (compare < 0) {
			if (parent.right == null) {
				parent.right = node;
				size++;
				return true;
			} else
				return addRec(parent.right, node);
		}
		return false;
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		if (root == null) {
			return 0;
		} else {
			return heightRec(root);	
		}
	}

	private int heightRec(BinaryNode<E> rot) {
		if (rot.left == null && rot.right == null) {
			return 1;
		}

		int nbr1 = 0;
		int nbr2 = 0;
		if (rot.left != null) {
			nbr1 = heightRec(rot.left);
		}
		if (rot.right != null) {
			nbr2 = heightRec(rot.right);
		}

		return 1+Math.max(nbr1, nbr2);
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}

	private void print(BinaryNode<E> n) {
		if (n != null) {
			print(n.left);
			System.out.println(n.element);
			print(n.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> list = new ArrayList<E>();
		if(root == null) return;
		else {
			size = 0;
			toArray(root, list);
			root = buildTree(list, 0, list.size()-1);
		}
		/**ArrayList<E> sorted = new ArrayList<E>();
		toArray(root, sorted);
		clear();
		buildTree(sorted, 0, sorted.size()-1);
		*/
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n != null) {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
	}

	/*
	 * Builds a complete tree from the elements from position first to last in the
	 * list sorted. Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (last < first) {
            return null;
        }
        int middleIndex = (first + last) / 2;
        BinaryNode<E> middle = new BinaryNode<E>(sorted.get(middleIndex));
        middle.left = buildTree(sorted, first, middleIndex - 1);
        middle.right = buildTree(sorted, middleIndex + 1, last);
        return middle;
    }
	/**
		BinaryNode<E> middle = new BinaryNode<E>(sorted.get((first+last)/2));
		for(int i = (first+last)/2; i>0; i--){
			add(sorted.get(i));
		
		}
		for(int i = (first+last)/2; i<=last; i++){
			add(sorted.get(i));
		}
		return middle;
	} */

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		BSTVisualizer bstv = new BSTVisualizer("Rubrik", 300, 300);
		bst.add(1);
		bst.add(2);
		bst.add(6);
		bst.add(9);
		bst.add(0);
		bst.add(7);
		bst.add(17);
		bst.add(8);
		bst.add(12);
		//bst.rebuild();
		bstv.drawTree(bst);
		/**ArrayList<Integer> lista = new ArrayList<Integer>();
		bst.toArray(bst.root, lista);
		for (Integer nbr:lista) {
			System.out.println(nbr);
		}*/
	}

}
