package edu.unl.raikes.BinarySearchTreeLab;

/**
 * A simple binary search tree wrapper that keeps track of the tree root and
 * the number of elements stored. This class delegates node-level operations
 * to {@link BinarySearchNode}.
 */
public class BinarySearchTree {
	boolean verbose = true;
	private BinarySearchNode root = null;
	private int size = 0;

	/**
	 * Insert the given person into the tree. If the tree is empty the new
	 * person becomes the root; otherwise the insertion is delegated to the
	 * root node. The tree size is incremented only when an insert actually
	 * occurs.
	 *
	 * @param data the person to insert
	 */
	public void insert(Person data) {
		boolean inserted = false;
		// If there is no root yet, create one.
		if (root == null) {
			root = new BinarySearchNode(data);
			inserted = true;
		} else {
			// Delegate insertion to the root node.
			inserted = root.insert(data);
		}
		if (inserted) {
			size++;
		}
	}

	/**
	 * Search the tree for a person with the supplied key.
	 *
	 * @param key the key to locate
	 * @return the {@link Person} if found, or null otherwise
	 */
	public Person search(int key) {
		// If the tree is empty, nothing to find.
		if (root == null) {
			return null;
		}
		// Delegate search to the root node.
		BinarySearchNode found = root.search(key);
		if (found != null) {
			return found.person;
		} else {
			return null;
		}

	}

	/**
	 * Delete the person with the specified key from the tree.
	 *
	 * @param key the key identifying the person to delete
	 * @return the removed {@link Person}, or null if not found
	 */
	public Person delete(int key) {
		Person deleted = null;

		// Nothing to delete if tree is empty.
		if (root == null) {
			return null;
		} else {
			// Special handling when the item to remove is the root. To avoid
			// complex parent-pointer updates we create a temporary auxiliary
			// root whose left child points to the real root. This simplifies
			// deletion logic inside the node code.
			if (root.person.key == key) {
				BinarySearchNode auxRoot = new BinarySearchNode(null);
				auxRoot.setLeftChild(root);
				// Perform deletion starting from the real root.
				deleted = root.delete(key);
				// Retrieve the possibly-updated root from the aux root.
				root = auxRoot.leftChild;
				// Ensure the true root's parent reference is null.
				if (root != null)
					root.parent = null;
			} else {
				// Delegate deletion to the root node for non-root keys.
				deleted = root.delete(key);
			}
			if (deleted != null)
				size--;
			return deleted;
		}
	}

	/**
	 * Return a printable representation of the tree, including the size and an
	 * in-order listing of all stored persons (so output appears sorted by key).
	 */
	public String toString() {
		String toReturn = "Binary Search Tree of Size: " + size + "\n";
		// Append the node-level string (in-order traversal) if the tree is not empty.
		if (root != null) {
			toReturn += root.toString();
		}
		return toReturn;
	}

}
