package cavbotics.ntclient.api.Stringsendable;

/**
 * Response object for /String routes
 */
public class StringResponse {
    private String title;
    private String message;
    private String value;
    private boolean status;

    /**
     * A StringResponse object with a decimal
     * 
     * @param value Value as a String to send in response
     */
    public StringResponse(String value) {
        this.title = "string";
        this.value = value;
    }

    /**
     * A StringResponse object with a boolean
     * 
     * @param status Status as a boolean to send in response
     */
    public StringResponse(boolean status) {
        this.title = "status";
        this.status = status;
    }

    /**
     * A StringResponse object with a title and message
     * 
     * @param title   Title of the response
     * @param message Message to send in response
     */
    public StringResponse(String title, String message) {
        this.title = title;
        this.message = message;
    }

    /**
     * A StringResponse object with a title and status
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public StringResponse(String title, boolean status) {
        this.title = title;
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
     * @return Value as a String
     */
    public String getValue() {
        return value;
    }
}