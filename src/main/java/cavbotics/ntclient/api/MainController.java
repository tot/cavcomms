package cavbotics.ntclient.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cavbotics.ntclient.Constants;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * This file handles the Double routes
 */
@RestController
public class MainController {
	/**
	 * Deletes the specified key in this table. The key can not be null.
	 * 
	 * @param key The key to delete
	 * @return false if successful. False otherwise.
	 */
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Object> deleteController(
			@RequestParam(value = "key", defaultValue = "") String key) {
		if (key == "") {
			return ResponseHandler.generateResponse("Missing key", HttpStatus.BAD_REQUEST, null);
		}
		NetworkTableEntry entry = Constants.table.getEntry(key);
		entry.delete();
		ResponseSendable<Boolean> res = new ResponseSendable<Boolean>(key, false);
		return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, res);
	}

	/**
	 * Get the current state of all commands
	 * 
	 * @return An object containing all commands
	 */
	@GetMapping(value = "/getstatuses")
	public ResponseEntity<Object> getStatuses(){
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("DeclineHoodCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("DeclineHoodCommand").getBoolean(false));
		map.put("DoNothingCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("DoNothingCommand").getBoolean(false));
		map.put("ExtendClimberCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("ExtendClimberCommand").getBoolean(false));
		map.put("ledMode", NetworkTableInstance.getDefault().getTable("/limelight-sam").getEntry("ledMode").getDouble(0));
		map.put("HoodCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("HoodCommand").getBoolean(false));
		map.put("InnerIndexCommand",NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("InnerIndexCommand").getBoolean(false));
		map.put("IntakeCommand",NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("IntakeCommand").getBoolean(false));
		map.put("KickOutBallsCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("KickOutBallsCommand").getBoolean(false));
		map.put("OneBallAuto", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("OneBallAuto").getBoolean(false));
		map.put("OuterIndexCommand",NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("OuterIndexCommand").getBoolean(false));
		map.put("RaiseHoodCommand",NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("RaiseHoodCommand").getBoolean(false));
		map.put("RetractClimberCode",NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("RetractClimberCode").getBoolean(false));
		map.put("ShootCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("ShootCommand").getBoolean(false));
		map.put("SwerveCommand", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("SwerveCommand").getBoolean(false));
		map.put("Routine", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("routine").getDouble(0));
		map.put("P", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("P").getDouble(0));
		map.put("I", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("I").getDouble(0));
		map.put("D", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("D").getDouble(0));
		map.put("ShooterMode", NetworkTableInstance.getDefault().getTable(Constants.networkTable).getEntry("shooterMode").getDouble(0));
		return ResponseHandler.generateResponse("Searched all values in table", HttpStatus.OK, map);
	}

	/**
	 * Checks if client can connect to API
	 * 
	 * @return true
	 */
	@GetMapping(value = "/getconnection")
	public ResponseEntity<Object> getConnection(){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("Connected", true);
		return ResponseHandler.generateResponse("Searched all values in table", HttpStatus.OK, map);
	}
}