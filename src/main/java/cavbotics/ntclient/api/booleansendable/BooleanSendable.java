package cavbotics.ntclient.api.booleansendable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.SendableObject;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Boolean objects to be used in /boolean routes
 */
public class BooleanSendable extends SendableObject<Boolean> {

    /**
     * A IntSendable object with a key and value
     * 
     * @param key   The key to store in the network table
     * @param value The value for the given key
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BooleanSendable(@JsonProperty("key") String key, @JsonProperty("value") Boolean value) {
        super(key, value, "boolean");
    }

    public BooleanSendable(@JsonProperty("key") String key, @JsonProperty("value") Boolean value, String name ) {
        super(key, value, name);
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
    public boolean getBoolean() {
        NetworkTableEntry entry = Constants.table.getEntry(key);
        //System.out.print(entry.getValue().getType().getValue());
        return entry.getBoolean(false);
    }



    /**
     * Set the value in the Network Table using this key
     * 
     * @return True if successful and false if unsuccessful
     */
    public boolean setBoolean() {
        NetworkTableEntry entry = Constants.table.getEntry(key);
        return entry.setBoolean(false);
    }
}