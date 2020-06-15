# activemq-project
Project for showing basic use of activemq

## build and run

#### Starting activemq:
Download ActiveMQ 5 (Artemis looks to be in Beta still):
```
https://activemq.apache.org/components/classic/download/
```
Extract the directory, CD into the activemq bin folder with the proper cpu architecture,
    and run the start command:
```
./activemq start
```
You can access the admin console at the following with default creds being 
    "admin" and "admin"
```
http://localhost:8161/admin/
```


#### Spring-boot app:
Run this command for the parent project to build everything:
```$xslt
mvn clean install
```
Running Spring-boot:
```
mvn spring-boot:run
```

On startup, the queue should be created when the application subscribes to the non-existing queue
    (Have not gone in and figured out the exact process here, but will if it becomes relevant)
    
Hitting this endpoint should drop a message in the queue, which will then be read multiple 
    times (throwing an exception each time), and eventually go to the configured DLQ:
```
http://localhost:8080/sendMessage
```

## references
https://activemq.apache.org/version-5-getting-started

https://activemq.apache.org/message-redelivery-and-dlq-handling.html

