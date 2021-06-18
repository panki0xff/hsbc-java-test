#HSBC-JAVA-TEST by Benjamin
## How to build
This application can build by maven
`mvn clean package` to build application jar

## How to run
Developer can run the application by two methods

1. maven  
execute `mvn clean compile spring-boot:run`
   
2. java jar
After build application into a jar, execute `java -jar {application}.jar`  
developer can also override parameter after the command.  
e.g. execute `java -jar {application}.jar --server.port=9090` will change the server port to 9090
   
|paramter        |default value|
|-------------   |-------------|
|server.port     | 8080        |
|app.display.gap | 600000      |