import java.util.List;

public class BSTTest {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();

		// Test adding elements
		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(35);
		bst.add(70);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);


		int s = bst.root.getData();
		System.out.println(s);
		s = bst.root.getRight().getData();
		System.out.println(s);
		s = bst.root.getRight().getRight().getData();
		System.out.println(s);
		s = bst.root.getData();
		System.out.println(s);

		// Test depth calculation
		//System.out.println("Depth of 50: " + bst.depth(50)); // Expected output: 0
		System.out.println("Depth of 30: " + bst.depth(30)); // Expected output: 1
		System.out.println("Depth of 70: " + bst.depth(70)); // Expected output: 1
		System.out.println("Depth of 20: " + bst.depth(20)); // Expected output: 2
		System.out.println("Depth of 40: " + bst.depth(40)); // Expected output: 2
		System.out.println("Depth of 60: " + bst.depth(60)); // Expected output: 2
		System.out.println("Depth of 80: " + bst.depth(80)); // Expected output: 2
		System.out.println("Depth of 100: " + bst.depth(100)); // Expected output: -1 (not found)

		int treeHeight = bst.height();

		// Print the height of the BST
		System.out.println("Height of the BST: " + treeHeight);


		int treeSize = bst.size();

		// Print the size of the BST
		System.out.println("Size of the BST: " + treeSize);



		// Check if elements are present in the BST
		System.out.println("Does BST contain 50? " + bst.contains(50)); // Should print true
		System.out.println("Does BST contain 90? " + bst.contains(90)); // Should print false
		System.out.println("Does BST contain 40? " + bst.contains(40)); // Should print true

		// Find the minimum element in the BST
		Integer minElement = bst.findMin();

		if (minElement != null) {
			System.out.println("Minimum element in the BST: " + minElement); // Output the minimum element
		} else {
			System.out.println("The BST is empty."); // BST is empty
		}

		// Remove elements from the BST
		System.out.println("Removing element 20: " + bst.remove(20)); // Should print true
		System.out.println("Removing element 90: " + bst.remove(90)); // Should print false

		// Get descendants of a node
		List<Integer> descendantsList = bst.descendants(15);

		System.out.print("Descendants of node 15: ");
		for (Integer value : descendantsList) {
			System.out.print(value + " ");
		}

		System.out.println();
		// Get ancestors of a node
		List<Integer> ancestorsList = bst.ancestors(44);

		if (ancestorsList.isEmpty()) {
			System.out.println("No ancestors found for node 40");
		} else {
			System.out.print("Ancestors of node 44: ");
			for (Integer value : ancestorsList) {
				System.out.print(value + " ");
			}
		}
		
		System.out.println();
		
		 // Display BST using inorder traversal
        System.out.print("In-order traversal: ");
        bst.inorder();

        // Display BST using preorder traversal
        System.out.print("Pre-order traversal: ");
        bst.preorder();

        // Display BST using postorder traversal
        System.out.print("Post-order traversal: ");
        bst.postorder();
	}
}
