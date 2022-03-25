<p align="center">
  <img src="https://i.imgur.com/Bcdjg1Q.png" alt="Cavbotics" width="400"/>
</p>
  
# CavComms
### _A backend server designed for FRC robot communication_
<p><br /></p>

### About
CavComms is a backend server written in Java using Spring Boot and WPILib. It is intended to be used with the dashboard client. However, it can be accessed directly through API its routes. 


### Features
- Ready to use out-of-the-box
- Easily customizable for any team
- Organized API endpoints
- NetworkTables support
- Support for multiple data types ([view full list here](https://github.com/tot/cavbotics-dashboard-backend/wiki/Endpoints))
<p>more to come...</p>


### Usage
Build the server

```sh 
gradle build
```
> Note: if you don't have Gradle configured, you can just run the `build.gradle` file.

Run the server
```sh
java -jar {path/to/file/name}.jar {teamNumber}
```
Connect to the server
> Note: the default port is 8080


### Customizing
Changing the port: Edit the `server.port` value in `application.properties`

<br />

### Made with:
- [WPILib](https://docs.wpilib.org/en/stable/index.html)
- [Spring Boot](https://spring.io/projects/spring-boot)

### Credits
- [Cavbotics Team #8590](https://wtwcsr.org)
- [Tony T.](https://github.com/tot)
- [Joseph T.](https://github.com/jt914)
