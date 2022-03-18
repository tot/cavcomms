package cavbotics.ntclient.api.doublesendable;

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
 * This file handles the Double routes
 */
@RestController
@RequestMapping("/double")
public class DoubleController {

	/**
	 * Returns the double the key maps to. If the key does not exist or is of
	 * different type, it will return -1. If there is no key, then return a list of
	 * all the double keys.
	 * 
	 * @param key The key to look up
	 * @return The value associated with the given key or the given default value if
	 *         there is no value associated with the key
	 */
	@GetMapping(value = "/get", produces = "application/json")
	public ResponseEntity<Object> getDoubleController(
			@RequestParam(value = "key", defaultValue = "") String key) {
		if (key == "" || key.length() == 0) {
			NetworkTableEntry[] entries = Constants.inst.getEntries("/datatable", 2);
			List<DoubleSendable> list = new ArrayList<DoubleSendable>();
			for (NetworkTableEntry entry : entries) {
				list.add(new DoubleSendable(entry.getName().substring(11), entry.getDouble(0)));
			}
			return ResponseHandler.generateResponse("Searched all doubles in table", HttpStatus.OK, list);
		} else {
			DoubleSendable find = new DoubleSendable(key, 0.0);
			DoubleResponse res = new DoubleResponse(find.getDouble());
			if ((int) find.getDouble() == -1) {
				return ResponseHandler.generateResponse("Unable to find", HttpStatus.NOT_FOUND, res);
			}
			return ResponseHandler.generateResponse("Successfully searched", HttpStatus.OK, res);
		}
	}

	/**
	 * Updates a double in the table. Adds a new double if the key does not exist.
	 * 
	 * @param key The key to be assigned to
	 * @param num The value that will be assigned
	 * @return False if the table key already exists with a different type.
	 *         Otherwise True.
	 */
	@PostMapping(value = "/set", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> setDoubleController(@RequestBody DoubleSendable num) {
		boolean status = num.setDouble();
		DoubleResponse res = new DoubleResponse("set", num.getValue(), status);
		if (!status)
			return ResponseHandler.generateResponse("Unable to set", HttpStatus.CONFLICT, res);
		return ResponseHandler.generateResponse("Successfully set", HttpStatus.OK, res);
	}
}