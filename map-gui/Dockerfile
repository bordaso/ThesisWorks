FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} analytics-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/analytics-0.0.1-SNAPSHOT.jar"]
