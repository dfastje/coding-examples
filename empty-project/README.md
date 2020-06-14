# empty-project
Base template project used for most future examples

## build and run
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
## references
https://mkyong.com/maven/maven-how-to-create-a-multi-module-project/

https://linuxize.com/post/how-to-configure-git-username-and-email/

https://start.spring.io/