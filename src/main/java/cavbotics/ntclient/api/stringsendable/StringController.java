package cavbotics.ntclient.api.stringsendable;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cavbotics.ntclient.api.ResponseHandler;

/**
 * This file handles the String routes
 */
@RestController
@RequestMapping("/String")
public class StringController {
    /**
     * Returns the String the key maps to. If the key does not exist or is of
     * different type, it will return -1.
     * 
     * @param key The key to look up
     * @return The value associated with the given key or the given default value if
     *         there is no value associated with the key
     */
    @GetMapping(value = "/get", produces = "application/json")
    public ResponseEntity<Object> getStringController(
            @RequestParam(value = "key", defaultValue = "") String key) {
        if (Objects.isNull(key) || key.length() == 0) {
            return ResponseHandler.generateResponse("Missing key", HttpStatus.BAD_REQUEST, null);
        }
        StringSendable find = new StringSendable(key);
        StringResponse res = new StringResponse(find.getValue());
        if (find.getValue().equals("none"))
            return ResponseHandler.generateResponse("Unable to find", HttpStatus.NOT_FOUND, res);
        return ResponseHandler.generateResponse("Successfully searched", HttpStatus.OK, res);
    }

    /**
     * Updates a String in the table. Adds a new String if the key does not exist.
     * 
     * @param key The key to be assigned to
     * @param num The value that will be assigned
     * @return False if the table key already exists with a different type.
     *         Otherwise True.
     */
    @PostMapping(value = "/set", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<Object> setStringController(@Valid @RequestBody StringSendable num) {
        StringSendable set = new StringSendable(num.getKey(), num.getValue());
        boolean status = set.setString();
        StringResponse res = new StringResponse("set", status);
        if (!status)
            return ResponseHandler.generateResponse("Unable to set", HttpStatus.CONFLICT, res);
        return ResponseHandler.generateResponse("Successfully set", HttpStatus.OK, res);
    }

    /**
     * Deletes the specified key in this table. The key can not be null.
     * 
     * @param key The key to delete
     * @return True if successful. False otherwise.
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> deleteStringController(
            @RequestParam(value = "key", defaultValue = "") String key) {
        if (Objects.isNull(key) || key.length() == 0) {
            return ResponseHandler.generateResponse("Missing key", HttpStatus.BAD_REQUEST, null);
        }
        StringSendable updated = new StringSendable(key);
        boolean status = updated.removeString();
        StringResponse res = new StringResponse(status);
        if (!status)
            return ResponseHandler.generateResponse("Unable to delete", HttpStatus.NOT_FOUND, res);
        return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, res);
    }
}
