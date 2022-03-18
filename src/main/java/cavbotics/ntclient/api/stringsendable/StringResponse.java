package cavbotics.ntclient.api.stringsendable;

import java.util.List;

import cavbotics.ntclient.api.ResponseSendable;

/**
 * Response object for /String routes
 */
public class StringResponse extends ResponseSendable<Object> {
    /**
     * A StringResponse object with a decimal. Used in /get endpoint.
     * 
     * @param value Value as a String to send in response
     */
    public StringResponse(String value) {
        super("string", value);
    }

    /**
     * A DoubleResponse object with a decimal, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public StringResponse(List<StringSendable> value) {
        super("list of strings", value);
    }

    /**
     * A StringResponse object with a title and status. Used in /set endpoint.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public StringResponse(String title, String value, boolean status) {
        super(title, value, status);
    }
}