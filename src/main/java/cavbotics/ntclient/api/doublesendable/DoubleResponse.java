package cavbotics.ntclient.api.doublesendable;

/**
 * Response object for /double routes
 */
public class DoubleResponse {
    private String title;
    private String message;
    private Double value;
    private boolean status;

    /**
     * A DoubleResponse object with a decimal, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public DoubleResponse(double value) {
        this.title = "double";
        this.value = value;
    }

    /**
     * A DoubleResponse object with a boolean. Used in /delete endpoint.
     * 
     * @param status Status as a boolean to send in response
     */
    public DoubleResponse(double value, boolean status) {
        this.title = "status";
        this.value = value;
        this.status = status;
    }

    /**
     * A DoubleResponse object with a title and status Used in /set endpoint.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public DoubleResponse(String title, double value, boolean status) {
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
     * @return Value as a double
     */
    public double getValue() {
        return value;
    }
}