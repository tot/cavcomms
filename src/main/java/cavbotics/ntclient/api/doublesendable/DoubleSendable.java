package cavbotics.ntclient.api.doublesendable;

import cavbotics.ntclient.api.SendableObject;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.SendableObject;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a double to be used in
 * /double routes
 */
public class DoubleSendable<T> extends SendableObject {
	/**
	 * A DoubleSendable object with a key. Value is set to 0.0 by default.
	 * 
	 * @param key
	 */
	public DoubleSendable(String key) {
		super();
		this.key = key;
		this.value = 0.0;
	}

	/**
	 * Get the value in the Network Table using this key
	 * 
	 * @return Value as a double in the Network Table
	 */
	// public T get() {
	// 	return (T) getDouble();
	// }
	private double getDouble() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.getDouble(-1);
	}

	/**
	 * Set the value in the Network Table using this key
	 * 
	 * @return True if successful and false if unsuccessful
	 */
	public boolean setDouble() {
		NetworkTableEntry entry = Constants.table.getEntry(this.key);
		return entry.setNumber(value);
	}

	/**
	 * Deletes an entry from the Network Table using this key
	 * 
	 * @return True if successfully deleted and false if unsuccessful
	 */
	public boolean removeDouble() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		entry.delete();
		// TODO: Add way to check if it was successful/unsuccesful
		// and update the return value accordingly
		return true;
	}
}
