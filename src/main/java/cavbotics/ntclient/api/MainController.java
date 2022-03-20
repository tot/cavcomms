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
	public ResponseEntity<Object> deleteDoubleController(
			@RequestParam(value = "key", defaultValue = "") String key) {
		if (key == "") {
			return ResponseHandler.generateResponse("Missing key", HttpStatus.BAD_REQUEST, null);
		}
		NetworkTableEntry entry = Constants.table.getEntry(key);
		entry.delete();
		ResponseSendable<Boolean> res = new ResponseSendable<Boolean>(key, false);
		return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, res);
	}
	@GetMapping(value = "/getall")
	public ResponseEntity<Object> getAllEntries(){
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("DeclineHoodCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("DeclineHoodCommand").getBoolean(false));
		map.put("DoNothingCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("DoNothingCommand").getBoolean(false));
		map.put("ExtendClimberCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("ExtendClimberCommand").getBoolean(false));
		map.put("ledMode", NetworkTableInstance.getDefault().getTable("/limelight-sam").getEntry("ledMode").getDouble(0));
		map.put("HoodCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("HoodCommand").getBoolean(false));
		map.put("InnerIndexCommand",NetworkTableInstance.getDefault().getTable("/datatable").getEntry("InnerIndexCommand").getBoolean(false));
		map.put("IntakeCommand",NetworkTableInstance.getDefault().getTable("/datatable").getEntry("IntakeCommand").getBoolean(false));
		map.put("KickOutBallsCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("KickOutBallsCommand").getBoolean(false));
		map.put("OneBallAuto", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("OneBallAuto").getBoolean(false));
		map.put("OuterIndexCommand",NetworkTableInstance.getDefault().getTable("/datatable").getEntry("OuterIndexCommand").getBoolean(false));
		map.put("RaiseHandCommand",NetworkTableInstance.getDefault().getTable("/datatable").getEntry("RaiseHoodCommand").getBoolean(false));
		map.put("RetractClimberCode",NetworkTableInstance.getDefault().getTable("/datatable").getEntry("RetractClimberCode").getBoolean(false));
		map.put("ShootCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("ShootCommand").getBoolean(false));
		map.put("SweverCommand", NetworkTableInstance.getDefault().getTable("/datatable").getEntry("SwerveCommand").getBoolean(false));
		return ResponseHandler.generateResponse("Searched all doubles in table", HttpStatus.OK, map);
	}

}