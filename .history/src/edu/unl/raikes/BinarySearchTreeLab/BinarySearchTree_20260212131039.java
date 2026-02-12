package edu.unl.raikes.BinarySearchTreeLab;

//TODO: ADD JAVADOC COMMENT
public class BinarySearchTree {
	boolean verbose = true;
	private BinarySearchNode root = null;
	private int size = 0;

	// TODO: ADD JAVADOC COMMENT
	public void insert(Person data) {
		boolean inserted = false;
		// TODO: ADD COMMENT
		if (root == null) {
			root = new BinarySearchNode(data);
			inserted = true;
		} // TODO: ADD COMMENT
		else {
			inserted = root.insert(data);
		} // TODO: ADD COMMENT
		if (inserted) {
			size++;
		}
	}

	// TODO: ADD JAVADOC COMMENT
	public Person search(int key) {
		// TODO: ADD COMMENT
		if (root == null) {
			return null;
		}
		// TODO: ADD COMMENT
		BinarySearchNode found = root.search(key);
		// TODO: ADD COMMENT
		if (found != null) {
			return found.person;
		} else {
			return null;
		}

	}

	// TODO: ADD JAVADOC COMMENT
	public Person delete(int key) {
		Person deleted = null;

		// TODO: ADD COMMENT
		if (root == null) {
			return null;
		} // TODO: ADD COMMENT
		else {
			// TODO: ADD COMMENT
			if (root.person.key == key) {
				// add fake root in case the element to be removed is the root.
				// (simplifies pointer logic)
				BinarySearchNode auxRoot = new BinarySearchNode(null);
				auxRoot.setLeftChild(root);
				// TODO: ADD COMMENT
				deleted = root.delete(key);
				// retrieve the root from the fake root (in case it changed)
				root = auxRoot.leftChild;
				// TODO: ADD COMMENT
				if (root != null)
					root.parent = null;
			} // TODO: ADD COMMENT
			else {
				deleted = root.delete(key);
			} // TODO: ADD COMMENT
			if (deleted != null)
				size--;
			return deleted;
		}
	}

	// TODO: ADD JAVADOC COMMENT
	public String toString() {
		String toReturn = "Binary Search Tree of Size: " + size + "\n";
		// TODO: ADD COMMENT
		
		if (root != null) {
			toReturn += root.toString();
		}
		return toReturn;
	}

}
