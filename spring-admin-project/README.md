# Spring Boot Admin Setup
Base template project used for most future examples

## build and run

-   Building:
```shell script
mvn clean install
```
-   Running:
```shell script
java -jar email-counter-0.0.1-SNAPSHOT.jar
```

-   Accessing:
```
http://localhost:8080/wallboard
```
    
## Notes
It will take some work to get the admin console to be compatible with Swagger ... but that probably wouldn't be an
issue if I had separate apps for the Admin Console and Client parts. 
## references
https://www.baeldung.com/spring-boot-admin