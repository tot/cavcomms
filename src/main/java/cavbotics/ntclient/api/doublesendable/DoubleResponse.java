package cavbotics.ntclient.api.doublesendable;

import java.util.List;

import cavbotics.ntclient.api.ResponseSendable;

/**
 * Response object for /double routes
 */
public class DoubleResponse extends ResponseSendable<Double> {
    /**
     * A DoubleResponse object with a decimal, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public DoubleResponse(double value) {
        super("double", value);
    }

    /**
     * A DoubleResponse object with a decimal, Used in /get endpoint.
     * 
     * @param value Value as a double to send in response
     */
    public DoubleResponse(List<DoubleSendable> value) {
        super("double array", value);
    }

    /**
     * A DoubleResponse object with a title and status Used in /set endpoint.
     * 
     * @param title  Title of the response
     * @param status Status to send in response
     */
    public DoubleResponse(String title, double value, boolean status) {
        super(title, value, status);
    }
}