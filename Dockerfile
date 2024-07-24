FROM openjdk:17-jdk-slim
WORKDIR /app
COPY /target/pokeapi-0.0.1-SNAPSHOT.jar /app/pokeapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/pokeapi.jar"]