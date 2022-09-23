FROM openjdk:17-jdk-slim
COPY target/ic-overview-service-1.0-SNAPSHOT.jar /home/ic-overview-service.jar
ENTRYPOINT java -jar /home/ic-overview-service.jar