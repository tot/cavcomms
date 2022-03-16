package cavbotics.ntclient.api;

public abstract class SendableObject<T> {
    protected String key;
	protected T value;

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

    public abstract T get();
    public abstract T set();
    public abstract T remove();
    
}