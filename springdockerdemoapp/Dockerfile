FROM openjdk:17-jdk-alpine
ADD target/app2.jar app2.jar
ENTRYPOINT [ "java","-jar","app2.jar","--server.port=7070" ]
EXPOSE 7070