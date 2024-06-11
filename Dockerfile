FROM openjdk:17-jdk-slim

COPY target/rhode-state.jar rhode-state.jar

EXPOSE 1999

ENTRYPOINT ["java", "-jar", "rhode-state.jar"]