## Application Properties
You can change the port where the server will be launch changing this property in the file `/src/main/resources/application.properties`
```
server.port=8090
```

## Build and deploy
To build
```
mvnw package
```
And to deploy
```
java -jar target\c1-spring-boot-web-0.0.1-SNAPSHOT.jar
```
