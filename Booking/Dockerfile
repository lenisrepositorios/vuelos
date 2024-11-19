FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/Booking-0.0.1-SNAPSHOT.jar /app/java-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "java-app.jar"]