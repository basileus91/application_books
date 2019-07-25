FROM openjdk:8-jdk-alpine
ADD frontend/target/frontend-0.0.1-SNAPSHOT.jar frontend-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "frontend-0.0.1-SNAPSHOT.jar"]

