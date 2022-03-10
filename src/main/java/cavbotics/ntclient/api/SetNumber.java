package cavbotics.ntclient.api;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

public class SetNumber {

	private Number value;
	private String key;

	public SetNumber(String key, Number value) {
		this.key = key;
		this.value = value;
	}

	public boolean updateNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.setNumber(value);
	}
}