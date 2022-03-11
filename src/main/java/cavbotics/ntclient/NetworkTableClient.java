package cavbotics.ntclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

@SpringBootApplication
public class NetworkTableClient {
    private static int team;

    public static void main(String[] args) {
        team = Integer.parseInt(args[0]);
        SpringApplication.run(NetworkTableClient.class, args);

        // Connect to the robot after server is initialized
        connect(team);
    }

    public static void connect(int team) {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("datatable");         
        NetworkTableEntry testentry = table.getEntry("test");
        das.setString("false");
        NetworkTableEntry xEntry = table.getEntry("x");
        NetworkTableEntry yEntry = table.getEntry("y");
        inst.startClientTeam(8590); // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar
        inst.startDSClient(); // recommended if running on DS computer; this gets the robot IP from the DS

        // NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

        // To add an entry
        NetworkTableEntry testentry = table.getEntry("test");
        System.out.println(table.getEntry("das").getString(""));
    }
}