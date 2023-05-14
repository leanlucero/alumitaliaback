FROM amazoncorretto:11-alpine-jdk
MAINTAINER chata
COPY target/aluminio-0.0.1-SNAPSHOT.jar alita-app.jar
ENTRYPOINT ["java","-jar","/alita-app.jar"]