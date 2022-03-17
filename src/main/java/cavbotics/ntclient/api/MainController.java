package cavbotics.ntclient.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * This file handles the Double routes
 */
@RestController
public class MainController {
	/**
	 * Deletes the specified key in this table. The key can not be null.
	 * 
	 * @param key The key to delete
	 * @return True if successful. False otherwise.
	 */
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Object> deleteDoubleController(
			@RequestParam(value = "key", defaultValue = "") String key) {
		if (key == "") {
			return ResponseHandler.generateResponse("Missing key", HttpStatus.BAD_REQUEST, null);
		}
		NetworkTableEntry entry = Constants.table.getEntry(key);
		entry.delete();
		ResponseSendable<Boolean> res = new ResponseSendable<Boolean>(key, true);
		return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, res);
	}
}