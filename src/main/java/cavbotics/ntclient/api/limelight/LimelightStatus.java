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
		double ledStatus = entry.getDouble(-1);
		Constants.table = Constants.inst.getTable("/datatable");
		return ledStatus == 0 ? true : false;
	}

	public boolean getTarget() {
		Constants.table = Constants.inst.getTable("/limelight-sam");
		double target = Constants.table.getEntry("tv").getDouble(0);
		Constants.table = Constants.inst.getTable("/datatable");
		return target == 0 ? true : false;
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
			updated = Constants.table.getEntry("ledMode").setDouble(1);
			Constants.table = Constants.inst.getTable("/datatable");
			return updated;
		}
		updated = Constants.table.getEntry("ledMode").setDouble(3);
		Constants.table = Constants.inst.getTable("/datatable");
		return updated;
	}
}
