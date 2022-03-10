package cavbotics.ntclient.api;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

public class GetNumber {

	private String key;
	private Number value;

	public GetNumber(String key, Number value) {
		this.key = key;
		this.value = value;
	}

	public Number getNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.getNumber(0);
	}
}