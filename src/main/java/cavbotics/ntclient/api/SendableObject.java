package cavbotics.ntclient.api;

public abstract class SendableObject<T> {
	protected String key;
	protected T value;
	protected String type;

	public SendableObject() {
		super();
	}

	/**
	 * A DoubleSendable object with a key and value
	 * 
	 * @param key   The key to store in the network table
	 * @param value The value for the given key
	 */
	public SendableObject(String key, T value) {
		this.key = key;
		this.value = value;
		this.type = "";
	}

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
	public Object getValue() {
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