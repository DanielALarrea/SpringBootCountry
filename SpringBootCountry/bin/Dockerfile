FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/helloweb-0.0.1-SNAPSHOT.jar helloweb.jar 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "helloweb.jar"]