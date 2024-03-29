FROM openjdk:17
WORKDIR /authorization-server-api
COPY ./build/libs/*.jar app.jar
EXPOSE 9098
ENTRYPOINT ["java", "-jar", "app.jar"]
