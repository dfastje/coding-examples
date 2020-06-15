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
mvn spring-boot run
```

## references
https://activemq.apache.org/version-5-getting-started

