package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Simple data holder representing a person with a numeric key (NUID) and a
 * name. Implements {@link Comparable} so instances can be ordered by key.
 */
public class Person implements Comparable<Person> {
	int key;
	String name;

	/**
	 * Create a new person with the given NUID and name.
	 *
	 * @param NUID the unique numeric identifier for the person
	 * @param name the person's name
	 */
	Person(int NUID, String name) {
		this.key = NUID;
		this.name = name;
	}

	/**
	 * Return a human-readable representation of this person.
	 */
	public String toString() {
		return "NUID: " + this.key + "  Name: " + name;
	}

	/**
	 * Compare this person to another by their numeric key.
	 */
	public int compareTo(Person other) {
		return Integer.compare(key, other.key);
	}
}
