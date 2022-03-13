package cavbotics.ntclient.api;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * This creates a Number object to be used in Number routes
 */
public class Number {

	private String key;
	private java.lang.Number value;

	/**
	 * 2-arg constructor for Number object
	 * @param key The key to store in the network table
	 * @param value The value for the given key
	 */
	public Number(String key, java.lang.Number value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * 1-arg constructor for Number object
	 * @param key
	 */
	public Number(String key) {
		this.key = key;
		this.value = 0;
	}

	/**
	 * Get the value of the current Number object
	 * @return Current Number object's value
	 */
	public java.lang.Number getValue() {
		return this.value;
	}

	/**
	 * Get the value in the Network Table using the current Number object's key
	 * @return Value in the Network Table
	 */
	public java.lang.Number getNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.getNumber(5.0);
	}

	/**
	 * Update the number value in the Network Table using the current Number object's key
	 * @return True if successfully updated and false if unsuccessful
	 */
	public boolean updateNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.setNumber(value);
	}

	/**
	 * Deletes an entry from the Network Table using the current Number object's key
	 * @return True if successfully deleted and false if unsuccessful
	 */
	public boolean removeNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		entry.delete();
		// TODO: Add way to check if it was successful/unsuccesful
		// and update the return value accordingly
		return true;
	}
}