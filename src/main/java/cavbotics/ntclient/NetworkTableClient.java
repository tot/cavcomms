package cavbotics.ntclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.wpi.first.networktables.NetworkTableInstance;

@SpringBootApplication
public class NetworkTableClient {
    private static int team;

    public static void main(String[] args) {
        if (args.length > 0) team = Integer.parseInt(args[0]);
        SpringApplication.run(NetworkTableClient.class, args);

        // Connect to the robot after server is initialized
        //connect(team);
    }

    public static void connect(int team) {
        Constants.inst = NetworkTableInstance.getDefault();
        Constants.table = Constants.inst.getTable("datatable");
        Constants.inst.startClientTeam(team); // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar
        Constants.inst.startDSClient(); // recommended if running on DS computer; this gets the robot IP from the DS
    }
}