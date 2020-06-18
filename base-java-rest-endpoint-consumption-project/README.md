# base-java-rest-endpoint-consumption-project
I have always used frameworks to hit restful endpoints and would like to 
    use native java to do so.

## build and run

#### build and start:
```$xslt
mvn clean install
```
Now running is a little more problematic, as the app doesn't really 
    shutdown nicely from intellij when run using mvn. You can use these, 
    but get used to regular restarts, port switches, or killing the java 
    processes:
```$xslt
mvn spring-boot:run
```
My strong preference is to start the app using the command line or using the
    dedicated spring-boot run configuration.

#### run:
After the application is running, hit this endpoint and review the logs:
```
http://localhost:8080/endpoint-eater
```
logs:
```
endpoint-eater
example-endpoint
Output from endpoint: example-endpoint
```


## references
https://stackoverflow.com/questions/12916169/how-to-consume-rest-in-java