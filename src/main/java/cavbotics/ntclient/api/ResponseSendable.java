package cavbotics.ntclient.api;

import java.util.List;

public class ResponseSendable<T> {
    protected String title;
    protected String message;
    protected T value;
    protected Object test;
    protected boolean status;

    /**
     * A ResponseSendable object with a generic type, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public ResponseSendable(String type, T value) {
        this.title = type;
        this.value = value;
    }

    public ResponseSendable(String type, List value) {
        this.title = type;
        this.test = value;
    }

    /**
     * A ResponseSendable object with a boolean. Used in /delete endpoint.
     * 
     * @param status Status as a boolean to send in response
     */
    public ResponseSendable(T value, boolean status) {
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
    public ResponseSendable(String title, T value, boolean status) {
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
