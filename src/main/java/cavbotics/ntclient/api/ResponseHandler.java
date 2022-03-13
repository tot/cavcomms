package cavbotics.ntclient.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Template for creating responses
 */
public class ResponseHandler {
    /**
     * Creates a ResponseEntity object to send in the response
     * 
     * @param message     Message to send to the user
     * @param status      HTTP status code for the response
     * @param responseObj Data to send to the user (null if no data)
     * @return ResponseEntity object as a HashMap
     */
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
}
