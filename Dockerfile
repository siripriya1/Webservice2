FROM openjdk:8-jdk-alpine
WORKDIR / 
ADD target/webservice2-0.0.1-SNAPSHOT.jar .
EXPOSE 8001
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${ENVIRONMENT}","webservice2-0.0.1-SNAPSHOT.jar"]