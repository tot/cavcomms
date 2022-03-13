package cavbotics.ntclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.wpi.first.networktables.NetworkTableInstance;

@SpringBootApplication
public class NetworkTableClient {
    // Team number
    private static int team;

    public static void main(String[] args) {
        // Handles team number argument
        if (args.length == 0)
            team = 8590;
        else
            team = Integer.parseInt(args[0]);

        SpringApplication.run(NetworkTableClient.class, args);

        // Connect to the robot after server is initialized
        // connect(team);
    }

    /**
     * Connect to the robot's Network Table server
     * 
     * @param team Team number
     */
    public static void connect(int team) {
        Constants.inst = NetworkTableInstance.getDefault();
        Constants.table = Constants.inst.getTable("datatable");
        Constants.inst.startClientTeam(team);
        Constants.inst.startDSClient(); // recommended if running on DS computer; this gets the robot IP from the DS
    }
}