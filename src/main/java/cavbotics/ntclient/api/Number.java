package cavbotics.ntclient.api;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Number {

	private String key;
	private java.lang.Number value;

	public Number(String key, java.lang.Number value) {
		this.key = key;
		this.value = value;
	}

	public Number(String key) {
		this.key = key;
		this.value = 0;
	}

	public java.lang.Number getValue() {
		return this.value;
	}

	public java.lang.Number getNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.getNumber(5.0);
	}

	public boolean updateNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		return entry.setNumber(value);
	}

	public boolean removeNumber() {
		NetworkTableEntry entry = Constants.table.getEntry(key);
		entry.delete();
		return true;
	}
}