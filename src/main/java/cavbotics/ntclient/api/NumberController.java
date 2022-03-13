package cavbotics.ntclient.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This file handles the Number routes
 */
@RestController
public class NumberController {
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Returns the number the key maps to. If the key does not exist or is of
	 * different type, it will return the default value (0).
	 * Equivalent of edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.getNumber
	 * 
	 * @param key The key to look up
	 * @return The value associated with the given key or the given default value if
	 *         there is no value associated with the key
	 * @throws JsonProcessingException Exception for formatting and returning JSON
	 */
	@GetMapping("/getnumber")
	public String getnumber(@RequestParam(value = "key", defaultValue = "") String key) throws JsonProcessingException {
		Number updated = new Number(key);
		String json = objectMapper.writeValueAsString(updated);
		return json;
	}

	/**
	 * Updates a number in the table. Adds a new number if the key does not exist.
	 * Equivalent of edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putNumber
	 * 
	 * @param key The key to be assigned to
	 * @param num The value that will be assigned
	 * @return False if the table key already exists with a different type.
	 *         Otherwise True.
	 */
	@PostMapping("/setnumber")
	public boolean setnumber(@RequestParam(value = "key", defaultValue = "") String key,
			@RequestParam(value = "value", defaultValue = "") java.lang.Number num) {
		Number updated = new Number(key, num);
		return updated.updateNumber();
	}

	/**
	 * Deletes the specified key in this table. The key can not be null.
	 * Equivalent of edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.delete
	 * 
	 * @param key The key to delete
	 * @return True if successful. False otherwise.
	 */
	@DeleteMapping("/deletenumber")
	public boolean deletenumber(@RequestParam(value = "key", defaultValue = "") String key) {
		Number updated = new Number(key);
		return updated.removeNumber();
	}
}