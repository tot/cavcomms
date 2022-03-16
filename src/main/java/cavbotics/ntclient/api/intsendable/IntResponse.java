package cavbotics.ntclient.api.intsendable;

import cavbotics.ntclient.api.ResponseSendable;

/**
 * Response object for /int routes
 */
public class IntResponse extends ResponseSendable {

    /**
     * A IntResponse object with a decimal. Used in /get endpoint.
     * 
     * @param value Value as an int to send in response
     */
    public IntResponse(int value) {
        super("int", value);
    }

    /**
     * A IntResponse object with a title and status. Used in /set.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public IntResponse(String title, int value, boolean status) {
        super(title, value, status);
    }
}