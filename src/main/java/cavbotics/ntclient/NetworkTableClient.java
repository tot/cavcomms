package cavbotics.ntclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

@SpringBootApplication
public class NetworkTableClient {
    public static void main(String[] args) {
        SpringApplication.run(NetworkTableClient.class, args);
    }

    public void connect() {
        Constants.inst = NetworkTableInstance.getDefault();
        NetworkTable table = Constants.inst.getTable("datatable");
        NetworkTableEntry xEntry = table.getEntry("x");
        NetworkTableEntry yEntry = table.getEntry("y");
        Constants.inst.startClientTeam(8590); // where TEAM=190, 294, etc, or use inst.startClient("hostname") or similar
        Constants.inst.startDSClient(); // recommended if running on DS computer; this gets the robot IP from the DS
        System.out.println("hi");
        // while (true) {
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException ex) {
        //         System.out.println("interrupted");
        //         return;
        //     }
        //     double x = xEntry.getDouble(0.0);
        //     double y = yEntry.getDouble(0.0);
        //     System.out.println("X: " + x + " Y: " + y);
        // }
    }

    public String updateString(String key, String value) {
        return "";
    }

    public String updateBoolean(String key, boolean value) {
        return "";
    }

    public String updateNumber(String key, double value) {
        return "";
    }
}