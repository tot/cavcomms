package cavbotics.ntclient.api.stringsendable;

import java.util.List;

import cavbotics.ntclient.api.ResponseSendable;

/**
 * Response object for /string routes
 */
public class StringResponse extends ResponseSendable<Object> {
    /**
     * A StringResponse object with a value.
     * 
     * @param value Value as a String to send in response
     */
    public StringResponse(String value) {
        super("string", value);
    }

    /**
     * A StringResponse object with multiple Strings.
     * 
     * @param value Value as a List to send in response.
     */
    public StringResponse(List<StringSendable> value) {
        super("list of strings", value);
    }

    /**
     * A StringResponse object with a title and status.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public StringResponse(String title, String value, boolean status) {
        super(title, value, status);
    }
}