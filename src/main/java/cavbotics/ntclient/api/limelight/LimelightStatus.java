package cavbotics.ntclient.api.limelight;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Object containing the key and value as a double to be used in
 * /double routes
 */
public class LimelightStatus {
	private boolean status;

	public LimelightStatus() {
		this.status = false;
	}

	public LimelightStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Get the value in the Network Table using this key
	 * 
	 * @return Value as a double in the Network Table
	 */
	public boolean getLedStatus() {
		NetworkTableEntry entry = Constants.table.getEntry("ledMode");
		int ledStatus = (int) entry.getNumber(-1);
		Constants.table = Constants.inst.getTable("/datatable");
		return ledStatus == 0 ? false : true;
	}

	public boolean getTarget() {
		Constants.table = Constants.inst.getTable("/limelight-sam");
		int target = (int) Constants.table.getEntry("tv").getNumber(0);
		Constants.table = Constants.inst.getTable("/datatable");
		return target == 0 ? false : true;
	}

	/**
	 * Set the value in the Network Table using this key
	 * 
	 * @return True if successful and false if unsuccessful
	 */
	public boolean setStatus() {
		Constants.table = Constants.inst.getTable("/limelight-sam");
		boolean updated = false;
		if (status) {
			updated = Constants.table.getEntry("ledMode").setNumber(1);
			Constants.table = Constants.inst.getTable("/datatable");
			return updated;
		}
		updated = Constants.table.getEntry("ledMode").setNumber(3);
		Constants.table = Constants.inst.getTable("/datatable");
		return updated;
	}
}
