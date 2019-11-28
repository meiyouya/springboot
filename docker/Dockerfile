FROM openjdk:8-jdk-alpine
ADD ./target/docker-1.0.0.jar /service/docker.jar
WORKDIR /service
ENTRYPOINT ["java","-jar","docker.jar"]