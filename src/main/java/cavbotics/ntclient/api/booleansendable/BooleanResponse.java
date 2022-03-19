package cavbotics.ntclient.api.booleansendable;

import java.util.List;

import cavbotics.ntclient.api.ResponseSendable;

/**
 * Response object for /int routes
 */
public class BooleanResponse extends ResponseSendable<Object> {

    /**
     * A IntResponse object with a decimal. Used in /get endpoint.
     * 
     * @param value Value as an int to send in response
     */
    public BooleanResponse(Boolean value) {
        super("boolean", value);
    }

    /**
     * A DoubleResponse object with a decimal, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public BooleanResponse(List<BooleanSendable> value) {
        super("list of booleans", value);
    }
    

    /**
     * A IntResponse object with a title and status. Used in /set.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public BooleanResponse(String title, Boolean value, boolean status) {
        super(title, value, status);
    }
}