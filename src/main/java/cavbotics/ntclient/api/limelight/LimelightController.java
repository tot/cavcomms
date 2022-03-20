package cavbotics.ntclient.api.limelight;

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
 * This file handles the Int routes
 */
@RestController
@RequestMapping("/limelight")
public class LimelightController {

	/**
	 * Returns the int the key maps to. If the key does not exist or is of
	 * different type, it will return -1.
	 * 
	 * @param key The key to look up
	 * @return The value associated with the given key or the given default value if
	 *         there is no value associated with the key
	 */
	@GetMapping(value = "/getled", produces = "application/json")
	public ResponseEntity<Object> getLedController() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		LimelightStatus limelight = new LimelightStatus();
		boolean led = limelight.getLedStatus();
		map.put("led", led);
		// if (!led) {
		// return ResponseHandler.generateResponse("Unable to retrieve status",
		// HttpStatus.NOT_FOUND, map);
		// }
		return ResponseHandler.generateResponse("Successfully searched", HttpStatus.OK, map);
	}

	@GetMapping(value = "/gettarget", produces = "application/json")
	public ResponseEntity<Object> getTargetController() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		LimelightStatus limelight = new LimelightStatus();
		boolean target = limelight.getLedStatus();
		map.put("target", target);
		// if (!target) {
		// return ResponseHandler.generateResponse("Unable to retrieve target
		// information", HttpStatus.NOT_FOUND, map);
		// }
		return ResponseHandler.generateResponse("Successfully searched", HttpStatus.OK, map);
	}

	/**
	 * Updates an int in the table. Adds a new int if the key does not exist.
	 * 
	 * @param key The key to be assigned to
	 * @param num The value that will be assigned
	 * @return False if the table key already exists with a different type.
	 *         Otherwise True.
	 */
	@PostMapping(value = "/setstatus", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> setLimelightStatusController(@RequestBody LimelightStatus limelightstatus) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		LimelightStatus limelight = new LimelightStatus();
		boolean led = limelight.getLedStatus();
		map.put("led update", led);
		limelightstatus.setStatus();
		// if (!status)
		// return ResponseHandler.generateResponse("Unable to set", HttpStatus.CONFLICT,
		// res);
		return ResponseHandler.generateResponse("Successfully set", HttpStatus.OK, map);
	}
}