FROM openjdk:8-jdk-alpine
COPY target/RMSConfigService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/RMSConfigService-0.0.1-SNAPSHOT.jar"]