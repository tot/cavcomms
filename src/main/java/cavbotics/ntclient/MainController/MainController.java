package cavbotics.ntclient.MainController;

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

import cavbotics.ntclient.Constants;
import cavbotics.ntclient.api.ResponseHandler;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * This file handles the Double routes
 */
@RestController
public class MainController {

	/**
	 * Returns the double the key maps to. If the key does not exist or is of
	 * different type, it will return -1.
	 * 
	 * @param key The key to look up
	 * @return The value associated with the given key or the given default value if
	 *         there is no value associated with the key
	 */
	@GetMapping(value = "/getentries", produces = "application/json")
	public ResponseEntity<Object> getDoubleController(
			@RequestParam(value = "key", defaultValue = "") String key) {
		if (Objects.isNull(key) || key.length() == 0) {
			NetworkTableEntry[] entries = Constants.inst.getEntries("/datatable", 2);
			for (NetworkTableEntry entry : entries) {
				System.out.println(entry.getName().substring(9) + ": " + entry.getDouble(0));
			}
			return ResponseHandler.generateResponse("check console all doubles", HttpStatus.BAD_REQUEST, null);
		}

		return ResponseHandler.generateResponse("Successfully searched", HttpStatus.OK, res);
	}
}