FROM maven:3.8.6-openjdk-18
WORKDIR /usr/local/room
COPY . .
ENV profile=dev
RUN mvn clean package -DskipTests
ENTRYPOINT ["/bin/sh", "-c", "java -jar -Dspring.profiles.active=${profile} target/restful-booker-platform-room-*.jar"]