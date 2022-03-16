package cavbotics.ntclient.api.intsendable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cavbotics.ntclient.Constants;

import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a int to be used in
 * /int routes
 */
public class IntSendable {
    @NotNull(message = "a key is required")
    @NotEmpty(message = "a key is required")
    private String key;

    @NotEmpty(message = "a value is required")
    @NotNull(message = "a value is required")
    private int value;

    /**
     * A IntSendable object with a key and value
     * 
     * @param key   The key to store in the network table
     * @param value The value for the given key
     */
    public IntSendable(String key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * A IntSendable object with a key. Value is set to 0 by default.
     * 
     * @param key
     */
    public IntSendable(String key) {
        this.key = key;
        this.value = 0;
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
     * @return Current value as int
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Get the value in the Network Table using this key
     * 
     * @return Value as an int in the Network Table
     */
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
        NetworkTableEntry entry = Constants.table.getEntry(this.key);
        return entry.setNumber(value);
    }

    /**
     * Deletes an entry from the Network Table using this key
     * 
     * @return True if successfully deleted and false if unsuccessful
     */
    public boolean removeInt() {
        NetworkTableEntry entry = Constants.table.getEntry(key);
        entry.delete();
        // TODO: Add way to check if it was successful/unsuccesful
        // and update the return value accordingly
        return true;
    }
}