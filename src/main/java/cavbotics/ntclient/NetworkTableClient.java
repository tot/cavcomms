package cavbotics.ntclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.wpi.first.networktables.NetworkTableInstance;

@SpringBootApplication
public class NetworkTableClient {
    // Team number
    private static int team;

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/double/set").allowedOrigins("http://localhost:1212");
                registry.addMapping("/string/set").allowedOrigins("http://localhost:1212");
                registry.addMapping("/boolean/set").allowedOrigins("http://localhost:1212");
                registry.addMapping("/getall").allowedOrigins("http://localhost:1212");

			}
		};
	}

    public static void main(String[] args) {
        // Handles team number argument
        if (args.length == 0)
            team = 8590;
        else
            team = Integer.parseInt(args[0]);

        SpringApplication.run(NetworkTableClient.class, args);

        // Connect to the robot after server is initialized
        connect(team);
    }

    /**
     * Connect to the robot's Network Table server
     * 
     * @param team Team number
     */
    public static void connect(int team) {
        Constants.inst = NetworkTableInstance.getDefault();
        Constants.inst.startClient("127.0.0.1");
        // Constants.inst.startClientTeam(8590);
        Constants.table = Constants.inst.getTable("/datatable");
        //Constants.inst.startDSClient(); // recommended if running on DS computer; this gets the robot IP from the DS
    }
}