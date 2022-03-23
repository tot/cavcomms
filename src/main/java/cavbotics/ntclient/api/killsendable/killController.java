package cavbotics.ntclient.api.killsendable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * This file handles the kill routes
 */
@RestController
@RequestMapping("/killswitch")
public class killController {

	/**
	 * Returns the kill the key maps to. If the key does not exist or is of
	 * different type, it will return -1.
	 * 
	 * @param key The key to look up
	 * @return The value associated with the given key or the given default value if
	 *         there is no value associated with the key
	 */
	@GetMapping(value = "/get", produces = "application/json")
	public ResponseEntity<Object> getkillController() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		KillSwitch killStatus = new KillSwitch();
		boolean status = killStatus.getStatus();
		map.put("killSwitchStatus", status);
		return ResponseHandler.generateResponse("Successfully searched for target", HttpStatus.OK, map);
	}

	/**
	 * Updates an kill in the table. Adds a new kill if the key does not exist.
	 * 
	 * @param key The key to be assigned to
	 * @param num The value that will be assigned
	 * @return False if the table key already exists with a different type.
	 *         Otherwise True.
	 */
	@PostMapping(value = "/set", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> setLimelightStatusController(@RequestBody KillSwitch killStatus) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		KillSwitch killSwitch = new KillSwitch();
		boolean status = killSwitch.getStatus();
		killSwitch.setStatus();
		map.put("status", status);

		// if (!status)
		// return ResponseHandler.generateResponse("Unable to set", HttpStatus.CONFLICT,
		// res);
		return ResponseHandler.generateResponse("Successfully set", HttpStatus.OK, map);
	}

}