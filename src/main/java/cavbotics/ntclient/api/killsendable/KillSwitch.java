package cavbotics.ntclient.api.killsendable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a double to be used in
 * /double routes
 */
public class KillSwitch {
	private boolean status;

	public KillSwitch() {
		this.status = false;
	}

	public KillSwitch(boolean status) {
		this.status = status;
	}

	/**
	 * Get the value in the Network Table using this key
	 * 
	 * @return Value as a double in the Network Table
	 */
	public boolean getStatus() {
		NetworkTableEntry entry = Constants.table.getEntry("Killswitch");
		boolean switchStatus = entry.getBoolean(false);
		Constants.table = Constants.inst.getTable("/datatable");
		return switchStatus;
	}

	/**
	 * Set the value in the Network Table using this key
	 * 
	 * @return True if successful and false if unsuccessful
	 */
	public boolean setStatus() {
		Constants.table = Constants.inst.getTable("/datatable");
		boolean updated = false;
		if (status) {
			updated = Constants.table.getEntry("Killswitch").setBoolean(false);
			Constants.table = Constants.inst.getTable("/datatable");
			return updated;
		}
		updated = Constants.table.getEntry("Killswitch").setBoolean(true);
		Constants.table = Constants.inst.getTable("/datatable");
		return updated;
	}
}
