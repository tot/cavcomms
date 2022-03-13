package cavbotics.ntclient.api.doublesendable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cavbotics.ntclient.Constants;

import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a double to be used in
 * /double routes
 */
public class DoubleSendable {
	@NotNull(message = "a key is required")
	@NotEmpty(message = "a key is required")
	private String key;

	@NotEmpty(message = "a value is required")
	@NotNull(message = "a value is required")
	private double value;

	/**
	 * A DoubleSendable object with a key and value
	 * 
	 * @param key   The key to store in the network table
	 * @param value The value for the given key
	 */
	public DoubleSendable(String key, double value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * A DoubleSendable object with a key. Value is set to 0.0 by default.
	 * 
	 * @param key
	 */
	public DoubleSendable(String key) {
		this.key = key;
		this.value = 0.0;
	}

	/**
	 * Get the key
	 * 
	 * @return Current key as String
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Get the value
	 * 
	 * @return Current value as double
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the value in the Network Table using this key
	 * 
	 * @return Value as a double in the Network Table
	 */
	public double getDouble() {
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