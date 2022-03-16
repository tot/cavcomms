package cavbotics.ntclient.api;

public class ResponseSendable {
    protected String title;
    protected String message;
    protected Object value;
    protected boolean status;

    public ResponseSendable() {
        super();
    }
    
    /**
     * A ResponseSendable object with a decimal, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public ResponseSendable(String type, Object value) {
        this.title = type;
        this.value = value;
    }

    /**
     * A ResponseSendable object with a boolean. Used in /delete endpoint.
     * 
     * @param status Status as a boolean to send in response
     */
    public ResponseSendable(double value, boolean status) {
        this.title = "status";
        this.value = value;
        this.status = status;
    }

    /**
     * A ResponseSendable object with a title and status Used in /set endpoint.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public ResponseSendable(String title, Object value, boolean status) {
        this.title = title;
        this.value = value;
        this.status = status;
    }

    /**
     * Return the title
     * 
     * @return Title as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the message
     * 
     * @return Message as a string
     */
    public String message() {
        return message;
    }

    /**
     * Return the status
     * 
     * @return Status as a boolean
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Return the value
     * 
     * @return Value as a generic
     */
    public Object getValue() {
        return value;
    }
}
