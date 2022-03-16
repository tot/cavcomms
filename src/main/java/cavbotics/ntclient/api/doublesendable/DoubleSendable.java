package cavbotics.ntclient.api.doublesendable;

import cavbotics.ntclient.api.SendableObject;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a double to be used in
 * /double routes
 */
public class DoubleSendable<T> extends SendableObject<T> {
	public DoubleSendable(double value) {
		super("double", value);
	}

	public DoubleSendable(String key, double value) {
		super(key, value);
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
		return entry.setNumber((double) value);
	}
}
