package cavbotics.ntclient.api.stringsendable;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.SendableObject;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a String to be used in
 * /string routes
 */
public class StringSendable<T> extends SendableObject<T> {
    /**
     * A StringSendable object with a key and value
     * 
     * @param key   The key to store in the network table
     * @param value The value for the given key
     */
    public StringSendable(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    /**
     * A StringSendable object with a key. Value is set to "" by default.
     * 
     * @param key
     */
    public StringSendable(String key) {
        super();
        this.key = key;
        this.value = "";
    }

    /**
     * Get the value in the Network Table using this key
     * 
     * @return Value as a String in the Network Table
     */
    public String getString() {
        NetworkTableEntry entry = Constants.table.getEntry(key);
        return entry.getString("none");
    }

    /**
     * Set the value in the Network Table using this key
     * 
     * @return True if successful and false if unsuccessful
     */
    public boolean setString() {
        NetworkTableEntry entry = Constants.table.getEntry(this.key);
        return entry.setString((String) value);
    }
}
