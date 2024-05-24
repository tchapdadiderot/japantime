FROM openjdk:11
COPY build/libs/japantime-0.0.1-SNAPSHOT.jar japantime.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "japantime.jar", "--server.port=8080"]