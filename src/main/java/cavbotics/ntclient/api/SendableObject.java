package cavbotics.ntclient.api;

import edu.wpi.first.networktables.NetworkTableType;

public abstract class SendableObject<T> {
	protected String key;
	protected T value;
	protected String type;
	protected NetworkTableType wasd;

	/**
	 * Default no-arg constructor
	 */
	public SendableObject() {
		super();
	}

	/**
	 * A SendableObject with a key and value
	 * 
	 * @param key   The key to store in the network table
	 * @param value The value for the given key
	 */
	public SendableObject(String key, T value) {
		this.key = key;
		this.value = value;
		this.type = "";
	}

	/**
	 * A SendableObject with a key, value, and type
	 * 
	 * @param key
	 * @param value
	 * @param type
	 */
	public SendableObject(String key, T value, String type) {
		this.key = key;
		this.value = value;
		this.type = type;
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
	 * @return Current value as double
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Get the type
	 * 
	 * @return Current type as String
	 */
	public Object getType() {
		return this.type;
	}
}
