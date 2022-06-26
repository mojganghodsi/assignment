FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/assignment-0.0.1-SNAPSHOT.jar assignment.jar
ENTRYPOINT ["java", "-jar", "assignment.jar"]
