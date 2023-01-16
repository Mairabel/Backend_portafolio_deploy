FROM amazoncorretto:11-alpine-jdk
MAINTAINER MMB
COPY target/demo-0.0.1-SNAPSHOT.jar mmb-app.jar
ENTRYPOINT ["java","-jar","/mmb-app.jar"]