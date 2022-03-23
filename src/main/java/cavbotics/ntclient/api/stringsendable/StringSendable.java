package cavbotics.ntclient.api.stringsendable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.SendableObject;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * String objects to be used in /string routes
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
        super(key, value, "string");
    }

    /**
     * Get the value in the Network Table using this key
     * 
     * @return Value as a String in the Network Table
     */
    @JsonIgnore
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
        NetworkTableEntry entry = Constants.table.getEntry(key);
        return entry.setString(value);
    }
}
