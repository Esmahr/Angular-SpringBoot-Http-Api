FROM openjdk:17
EXPOSE 8088
ADD target/user-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]