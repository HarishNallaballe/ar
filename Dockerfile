FROM openjdk:17-jdk-slim

COPY target/AR-API-0.0.1-SNAPSHOT.jar AR-API-0.0.1-SNAPSHOT.jar

EXPOSE 2002

ENTRYPOINT ["java", "-jar", "AR-API-0.0.1-SNAPSHOT.jar"]