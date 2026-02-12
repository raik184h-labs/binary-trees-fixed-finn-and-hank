package edu.unl.raikes.BinarySearchTreeLab;

// TODO: ADD JAVADOC COMMENT 
class BinarySearchNode {
	protected BinarySearchNode parent;
	protected BinarySearchNode leftChild;
	protected BinarySearchNode rightChild;
	protected Person person;

	// TODO: ADD JAVADOC COMMENT
	BinarySearchNode(Person person) {
		this.person = person;
	}

	// TODO: ADD JAVADOC COMMENT
	boolean insert(Person data) {
		// TODO: ADD COMMENT
		if (data == this.person) {
			return false;
		}
		// TODO: ADD COMMENT
		else if (Integer.compare(data.key, person.key) < 0) {
			// TODO: ADD COMMENT
			if (leftChild == null) {
				setLeftChild(new BinarySearchNode(data));
				return true;
			} // TODO: ADD COMMENT
			else {
				return leftChild.insert(data);
			}
		}
		// TODO: ADD COMMENT
		else if (Integer.compare(data.key, person.key) > 0) {
			// TODO: ADD COMMENT
			if (rightChild == null) {
				setRightChild(new BinarySearchNode(data));
				return true;
			} // TODO: ADD COMMENT
			else {
				return rightChild.insert(data);
			}
		}
		return false;
	}

	// TODO: ADD JAVADOC COMMENT
	BinarySearchNode search(int key) {
		// TODO: ADD COMMENT
		if (leftChild != null && Integer.compare(key, person.key) < 0) {
			return leftChild.search(key);
		}
		// TODO: ADD COMMENT
		else if (rightChild != null && Integer.compare(key, person.key) > 0) {
			return rightChild.search(key);
		}
		// TODO: ADD COMMENT
		else if (this.person.key == key) {
			return this;
		}
		// TODO: ADD COMMENT
		else {
			return null;
		}
	}

	// TODO: ADD JAVADOC COMMENT
	Person delete(int key) {
		// TODO: ADD COMMENT
		BinarySearchNode node = search(key);
		if (node == null)
			return null;
		Person deleted = node.person;

		// TODO: ADD COMMENT
		if (node.leftChild == null && node.rightChild == null) {
			if (node.parent.leftChild == node)
				node.parent.setLeftChild(null);
			else if (node.parent.rightChild == node)
				node.parent.setRightChild(null);
		}
		// TODO: ADD COMMENT
		else if (node.leftChild != null && node.rightChild != null) {
			BinarySearchNode min = node.rightChild.getNodeWithMinValue();
			node.person = min.person;
			int minKey = min.person.key;
			min.delete(minKey);
		}
		// TODO: ADD COMMENT
		else if (node.parent.leftChild == node) {
			BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setLeftChild(newLeftChild);
		}
		// TODO: ADD COMMENT
		else if (node.parent.rightChild == node) {
			BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setRightChild(newRightChild);
		}

		return deleted;
	}

	// TODO: ADD JAVADOC COMMENT
	BinarySearchNode getNodeWithMinValue() {
		if (leftChild == null)
			return this;
		else
			return leftChild.getNodeWithMinValue();
	}

	// TODO: ADD JAVADOC COMMENT
	void setLeftChild(BinarySearchNode child) {
		this.leftChild = child;
		if (child != null)
			child.parent = this;
	}

	// TODO: ADD JAVADOC COMMENT
	void setRightChild(BinarySearchNode child) {
		this.rightChild = child;
		if (child != null)
			child.parent = this;
	}

	// TODO: ADD JAVADOC COMMENT (WHAT KIND OF SEARCH SHOULD THIS BE???)
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (leftChild != null) sb.append(leftChild.toString());
		sb.append("  ").append(person.toString()).append("\n");
		if (rightChild != null) sb.append(rightChild.toString());
		return sb.toString();
	}

}