FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/vote-api-0.1.jar .

EXPOSE 8080

CMD ["java", "-jar", "vote-api-0.1.jar"]