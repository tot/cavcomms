package cavbotics.ntclient.api.doublesendable;

import cavbotics.ntclient.api.SendableObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a double to be used in
 * /double routes
 */
public class DoubleSendable extends SendableObject<Double> {
	public DoubleSendable(double value) {
		super("double", value);
	}

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public DoubleSendable(@JsonProperty("key") String key, @JsonProperty("value") double value) {
		super(key, value);
	}

	public DoubleSendable(String key, double value, String type) {
		super(key, value, type);
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
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.setNumber(value);
	}
}
