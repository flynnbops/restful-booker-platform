FROM maven:3.8.6-openjdk-18
WORKDIR /usr/local/auth
COPY . .
ENV profile=dev
RUN mvn clean package -DskipTests
ENTRYPOINT ["/bin/sh", "-c", "java -jar -Dspring.profiles.active=${profile} -Dhoneycomb.beeline.write-key=${HONEYCOMB_API_KEY} target/restful-booker-platform-auth-*.jar"]