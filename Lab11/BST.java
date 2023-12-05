import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	public BNode<E> root;
	public BST() {
		this.root = null;
	}


	public void printCurrent() {
		System.out.println(root.getData());
	}



	// Add element e into BST
	public void add(E e) {
		root = addHelper(e, root);
	}

	private BNode<E> addHelper(E e, BNode<E> current) {


		if(current == null) {
			current = new BNode<E>(e);
			return current;
		}
		BNode<E> left = current.getLeft();
		BNode<E> right = current.getRight();
		if(e.compareTo(current.getData()) < 0) {
			left = addHelper(e, left);
			current.setLeft(left);
		} else {
			right = addHelper(e, right);
			current.setRight(right);;

		}

		return current;
	}




	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for(E e : col) {
			add(e);
		}
	}




	// compute the depth of a node in BST
	public int depth(E node) {
		int result = 0;
		BNode<E> newRoot = root;
		result = this.depthHelper(node, result, newRoot);
		return result;
	}


	private int depthHelper(E e, int count, BNode<E> root){
		if(root == null) return -1;
		while(root != null) {
			if(e.compareTo(root.getData()) == 0) {
				System.out.println("found: " + root.getData());
				return count;
			} else if(e.compareTo(root.getData()) < 0) {
				System.out.println("smaller");
				return this.depthHelper(e, ++count, root.getLeft());
			} else {
				System.out.println("bigger");
				return this.depthHelper(e, ++count, root = root.getRight());
			}
		}

		return count;
	}


	// compute the height of BST
	public int height() {
		if(this.root == null) return 0;
		else{
			BNode<E> node = root;
			return heightHelper(node);
		}
	}


	private int heightHelper(BNode<E> root) {
		if (root == null) {
			return 0;
		}

		int lefth = heightHelper(root.getLeft());
		int righth = heightHelper(root.getRight());

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}

	// Compute total nodes in BST
	public int size() {
		// TODO
		if(root == null) return 0;
		else {
			BNode<E> node = root;
			return sizeHelper(node) + 1;
		}
	}
	private int sizeHelper(BNode<E> node) {
		if(node == null) return -1;

		int left = 1 + sizeHelper(node.getLeft());
		int right = 1 + sizeHelper(node.getRight());

		return left + right;
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		// TODO

		if(root == null) return false;
		else {
			BNode<E> node = root;
			return containsHelper(e, node);
		}
	}

	private boolean containsHelper(E e, BNode<E> current) {
		if(current == null) return false;

		if(e.compareTo(current.getData()) == 0) return true;

		if(e.compareTo(current.getData()) < 0) {
			return containsHelper(e, current.getLeft());
		} else {
			return containsHelper(e, current.getRight());
		}
	}

	// Find the minimum element in BST
	public E findMin() {
		if(root == null) return null;
		else {
			BNode<E> node = root;
			return findMinHelper(node);
		}
	}


	private E findMinHelper(BNode<E> node) {
		if(node.getLeft() == null)	return node.getData();
		return findMinHelper(node.getLeft());
	}

	// Find the maximum element in BST
	public E findMax() {
		if(root == null) return null;
		else {
			BNode<E> node = root;
			return findMaxHelper(node);
		}
	}

	private E findMaxHelper(BNode<E> node) {
		if(node.getRight() == null)	return node.getData();
		return findMinHelper(node.getRight());
	}


	// Remove element e from BST
	public boolean remove(E e) {
		if(root == null) return false;
		else {
			BNode<E> node = root;
			root = removeHelper(e, node);
			return true;
		}
	}

	private BNode<E> removeHelper(E e, BNode<E> node) {
		if(node == null) return node;
		else {
			if(e.compareTo(node.getData()) > 0) {
				node.setRight(removeHelper(e, node.getRight()));
			} else if(e.compareTo(node.getData()) < 0) {
				node.setLeft(removeHelper(e, node.getLeft()));
			} else {
				BNode<E> left = node.getLeft();
				BNode<E> right = node.getRight();

				if(left == null || right == null) {
					node = left == null ? right : left;
				} else {
					node.setData(findMaxHelper(left));
					node.setRight(removeHelper(e, right));
				}
			}
			return node;
		}
	}
	// get the descendants of a node
	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		BNode<E> node = findNode(root, data);

		if (node != null) {
			collectDescendants(node, descendantsList);
		}

		return descendantsList;
	}

	private BNode<E> findNode(BNode<E> current, E data) {
		if (current == null || current.getData().equals(data)) {
			return current;
		}

		int compareResult = data.compareTo(current.getData());

		if (compareResult < 0) {
			return findNode(current.getLeft(), data);
		} else {
			return findNode(current.getRight(), data);
		}
	}
	private void collectDescendants(BNode<E> node, List<E> descendantsList) {
		if (node != null) {
			collectDescendants(node.getLeft(), descendantsList);
			descendantsList.add(node.getData());
			collectDescendants(node.getRight(), descendantsList);
		}
	}

	
	public List<E> ancestors(E data) {
        List<E> ancestorsList = new ArrayList<>();
        if(!contains(data)) {
			return ancestorsList;
		}
        findAncestors(root, data, ancestorsList);
        return ancestorsList;
    }

    private void findAncestors(BNode<E> node, E data, List<E> ancestorsList) {
        if (node == null || node.getData().equals(data)) {
            return;
        } else {
        	int i = data.compareTo(node.getData());
        	if(i > 0) {
        		findAncestors(node.getRight(), data, ancestorsList);
        	}else {
        		findAncestors(node.getLeft(), data, ancestorsList);
        	}
        	ancestorsList.add(node.getData());
        }
    }

	
    public void inorder() {
        inorderTraversal(root);
        System.out.println(); // For a new line after displaying the tree
    }

    private void inorderTraversal(BNode<E> node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversal(node.getRight());
        }
    }
	
 // Display BST using pre-order traversal
    public void preorder() {
        preorderTraversal(root);
        System.out.println(); // For a new line after displaying the tree
    }

    private void preorderTraversal(BNode<E> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }
    
    public void postorder() {
        postorderTraversal(root);
        System.out.println(); // For a new line after displaying the tree
    }

    private void postorderTraversal(BNode<E> node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
    
}
