package cavbotics.ntclient.api.intsendable;

/**
 * Response object for /int routes
 */
public class IntResponse {
    private String title;
    private String message;
    private int value;
    private boolean status;

    /**
     * A IntResponse object with a decimal. Used in /get endpoint.
     * 
     * @param value Value as an int to send in response
     */
    public IntResponse(int value) {
        this.title = "int";
        this.value = value;
    }

    /**
     * A IntResponse object with a boolean. Used in /delete endpoint.
     * 
     * @param status Status as a boolean to send in response
     */
    public IntResponse(int value, boolean status) {
        this.title = "status";
        this.value = value;
        this.status = status;
    }

    /**
     * A IntResponse object with a title and status. Used in /set.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public IntResponse(String title, int value, boolean status) {
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
     * @return Value as a int
     */
    public int getValue() {
        return value;
    }
}