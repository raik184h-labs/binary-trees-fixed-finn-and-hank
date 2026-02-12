package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Represents a node in the binary search tree. Stores a {@link Person} and
 * references to the node's parent and children. Most tree operations are
 * implemented by working with these nodes.
 */
class BinarySearchNode {
	protected BinarySearchNode parent;
	protected BinarySearchNode leftChild;
	protected BinarySearchNode rightChild;
	protected Person person;

	/**
	 * A constructor for BinarySearchNode
	 * @param person a person
	 */
	BinarySearchNode(Person person) {
		this.person = person;
	}

	/**
	 * Inserts data into a tree
	 * @param data data
	 * @return true if it inserted, false otherwise
	 */
	boolean insert(Person data) {
		// Return false if this person is identical to data
		if (data == this.person) {
			return false;
		}
		// Checks if data needs to go left 
		else if (Integer.compare(data.key, person.key) < 0) {
			// If left nulll, set it left
			if (leftChild == null) {
				setLeftChild(new BinarySearchNode(data));
				return true;
			} // Otherwise insert it in the left child
			else {
				return leftChild.insert(data);
			}
		}
		// Check if data needs to go right
		else if (Integer.compare(data.key, person.key) > 0) {
			// Creates new if needed
			if (rightChild == null) {
				setRightChild(new BinarySearchNode(data));
				return true;
			} // Inserts right
			else {
				return rightChild.insert(data);
			}
		}
		return false;
	}

	/**
	 * Returns the node if it's in the tree
	 * @param key value to search for
	 * @return the node
	 */
	BinarySearchNode search(int key) {
		// search left
		if (leftChild != null && Integer.compare(key, person.key) < 0) {
			return leftChild.search(key);
		}
		// search right
		else if (rightChild != null && Integer.compare(key, person.key) > 0) {
			return rightChild.search(key);
		}
		// checks if person equals key
		else if (this.person.key == key) {
			return this;
		}
		// if key not in return null
		else {
			return null;
		}
	}

	/**
	 * deletes a node
	 * @param key the value to delete
	 * @return the data in the deleted node
	 */
	Person delete(int key) {
		// search for the node to delete
		BinarySearchNode node = search(key);
		if (node == null)
			return null;
		Person deleted = node.person;

		// checks if node has no sub tree
		if (node.leftChild == null && node.rightChild == null) {
			if (node.parent.leftChild == node)
				node.parent.setLeftChild(null);
			else if (node.parent.rightChild == node)
				node.parent.setRightChild(null);
		}
		// checks if node has two sub trees
		else if (node.leftChild != null && node.rightChild != null) {
			BinarySearchNode min = node.rightChild.getNodeWithMinValue();
			node.person = min.person;
			int minKey = min.person.key;
			min.delete(minKey);
		}
		// node is left tree
		else if (node.parent.leftChild == node) {
			BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setLeftChild(newLeftChild);
		}
		// node is right tree
		else if (node.parent.rightChild == node) {
			BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setRightChild(newRightChild);
		}

		return deleted;
	}

	/**
	 * Gets the node with the lowest value
	 * @return node with lowest value
	 */
	BinarySearchNode getNodeWithMinValue() {
		if (leftChild == null)
			return this;
		else
			return leftChild.getNodeWithMinValue();
	}

	/**
	 * Sets the left child
	 * @param child a child
	 */
	void setLeftChild(BinarySearchNode child) {
		this.leftChild = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * Sets the right child
	 * @param child a child
	 */
	void setRightChild(BinarySearchNode child) {
		this.rightChild = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * returns the tree as a string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (leftChild != null) sb.append(leftChild.toString());
		sb.append("  ").append(person.toString()).append("\n");
		if (rightChild != null) sb.append(rightChild.toString());
		return sb.toString();
	}
}