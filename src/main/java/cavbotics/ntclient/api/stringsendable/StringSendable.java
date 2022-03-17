package cavbotics.ntclient.api.stringsendable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.SendableObject;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a String to be used in
 * /string routes
 */
public class StringSendable extends SendableObject<String> {
    /**
     * A StringSendable object with a key and value
     * 
     * @param key   The key to store in the network table
     * @param value The value for the given key
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StringSendable(@JsonProperty("key") String key, @JsonProperty("value") String value) {
        super(key, value);
    }

    /**
     * A StringSendable object with a key. Value is set to "" by default.
     * 
     * @param key
     */
    public StringSendable(String key) {
        super(key, "");
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
