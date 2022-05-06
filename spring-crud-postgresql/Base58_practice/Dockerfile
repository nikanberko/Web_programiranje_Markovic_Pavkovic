FROM amazoncorretto:11-alpine-jdk
EXPOSE 8080
COPY target/Base58_practice-0.0.1-SNAPSHOT.jar /Base58_practice.jar
RUN apk --no-cache add curl
CMD ["java", "-jar", "/Base58_practice.jar"]
