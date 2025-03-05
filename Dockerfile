FROM openjdk:24-ea-17-slim
WORKDIR /app
COPY target/*.jar /app/microservice-observabilite-user.jar
EXPOSE 8080
CMD ["java", "-jar", "microservice-observabilite-user.jar"]