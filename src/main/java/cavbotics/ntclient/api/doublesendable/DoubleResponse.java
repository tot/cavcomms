package cavbotics.ntclient.api.doublesendable;

/**
 * Response object for /double routes
 */
public class DoubleResponse {
    private String title;
    private String message;
    private double value;
    private boolean status;

    /**
     * A DoubleResponse object with a decimal
     * 
     * @param value Value as a double to send in response
     */
    public DoubleResponse(double value) {
        this.title = "double";
        this.value = value;
    }

    /**
     * A DoubleResponse object with a boolean
     * 
     * @param status Status as a boolean to send in response
     */
    public DoubleResponse(boolean status) {
        this.title = "status";
        this.status = status;
    }

    /**
     * A DoubleResponse object with a title and message
     * 
     * @param title   Title of the response
     * @param message Message to send in response
     */
    public DoubleResponse(String title, String message) {
        this.title = title;
        this.message = message;
    }

    /**
     * A DoubleResponse object with a title and status
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public DoubleResponse(String title, boolean status) {
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
     * @return Value as a double
     */
    public double getValue() {
        return value;
    }
}