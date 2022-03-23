package cavbotics.ntclient.api.intsendable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.SendableObject;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Int objects to be used in /int routes
 */
public class IntSendable extends SendableObject<Integer> {

    /**
     * A IntSendable object with a key and value
     * 
     * @param key   The key to store in the network table
     * @param value The value for the given key
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public IntSendable(@JsonProperty("key") String key, @JsonProperty("value") int value) {
        super(key, value, "int");
    }




    /**
     * A IntSendable object with a key. Value is set to 0 by default.
     * 
     * @param key
     */

    /**
     * Get the value in the Network Table using this key
     * 
     * @return Value as an int in the Network Table
     */
    @JsonIgnore
    public int getInt() {
        NetworkTableEntry entry = Constants.table.getEntry(key);
        return (int) entry.getNumber(-1);
    }

    /**
     * Set the value in the Network Table using this key
     * 
     * @return True if successful and false if unsuccessful
     */
    public boolean setInt() {
        NetworkTableEntry entry = Constants.table.getEntry(key);
        return entry.setNumber(value);
    }
}