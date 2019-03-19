FROM openjdk:8-jdk-alpine
COPY target/RMSConfigService-0.0.1-SNAPSHOT.jar /tmp/RMSConfigService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/tmp/RMSConfigService-0.0.1-SNAPSHOT.jar", "--server.servlet.context-path=/rms-config" ,"&"]
