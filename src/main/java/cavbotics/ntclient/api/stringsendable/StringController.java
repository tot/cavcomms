package cavbotics.ntclient.api.stringsendable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.ResponseHandler;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * This file handles the String routes
 */
@RestController
@RequestMapping("/string")
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
    public ResponseEntity<Object> getIntController(
            @RequestParam(value = "key", defaultValue = "") String key) {
        if (key == "" || key.length() == 0) {
            NetworkTableEntry[] entries = Constants.inst.getEntries("/datatable", 2);
            List<StringSendable> list = new ArrayList<StringSendable>();
            for (NetworkTableEntry entry : entries) {
                list.add(new StringSendable(entry.getName().substring(11), (String) entry.getString("")));
            }
            StringResponse res = new StringResponse(list);
            return ResponseHandler.generateResponse("Searched all integers in table", HttpStatus.BAD_REQUEST, list);
        }
        StringSendable find = new StringSendable(key, "");
        StringSendable res = new StringSendable(find.getString());
        if ((String) find.getString() == "") {
            return ResponseHandler.generateResponse("Unable to find", HttpStatus.NOT_FOUND, res);
        }
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
    public ResponseEntity<Object> setStringController(@RequestBody StringSendable str) {
        boolean status = str.setString();
        StringResponse res = new StringResponse("set", (String) str.getValue(), status);
        if (!status)
            return ResponseHandler.generateResponse("Unable to set", HttpStatus.CONFLICT, res);
        return ResponseHandler.generateResponse("Successfully set", HttpStatus.OK, res);
    }
}
