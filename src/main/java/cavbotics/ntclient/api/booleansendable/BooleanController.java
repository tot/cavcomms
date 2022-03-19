package cavbotics.ntclient.api.booleansendable;

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
import edu.wpi.first.networktables.EntryInfo;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * This file handles the Int routes
 */
@RestController
@RequestMapping("/boolean")
public class BooleanController {

	/**
	 * Returns the int the key maps to. If the key does not exist or is of
	 * different type, it will return -1.
	 * 
	 * @param key The key to look up
	 * @return The value associated with the given key or the given default value if
	 *         there is no value associated with the key
	 */
	@GetMapping(value = "/get", produces = "application/json")
	public ResponseEntity<Object> getBooleanController(
			@RequestParam(value = "key", defaultValue = "") String key) {
		if (key == "" || key.length() == 0) {
			NetworkTableEntry[] entries = Constants.inst.getEntries("/datatable", 1);
			List<BooleanSendable> list = new ArrayList<BooleanSendable>();
			for (NetworkTableEntry entry : entries) {
				list.add(new BooleanSendable(entry.getName().substring(11), entry.getBoolean(false)));
			}
			return ResponseHandler.generateResponse("Searched all booleans in table", HttpStatus.OK, list);
		} else {
			BooleanSendable find = new BooleanSendable(key, false);
			BooleanResponse res = new BooleanResponse(find.getBoolean());
			if (find.getBoolean() == false) {
				return ResponseHandler.generateResponse("Unable to find", HttpStatus.NOT_FOUND, res);
			}
			return ResponseHandler.generateResponse("Successfully searched", HttpStatus.OK, res);
		}
	}

	/**
	 * Updates an int in the table. Adds a new int if the key does not exist.
	 * 
	 * @param key The key to be assigned to
	 * @param num The value that will be assigned
	 * @return False if the table key already exists with a different type.
	 *         Otherwise True.
	 */
	@PostMapping(value = "/set", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> setBooleanController(@RequestBody BooleanSendable num) {
		boolean status = num.setBoolean();
		BooleanResponse res = new BooleanResponse("set", num.getBoolean(), status);
		if (!status)
			return ResponseHandler.generateResponse("Unable to set", HttpStatus.CONFLICT, res);
		return ResponseHandler.generateResponse("Successfully set", HttpStatus.OK, res);
	}
}