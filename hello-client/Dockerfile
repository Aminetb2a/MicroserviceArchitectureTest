FROM openjdk:15
MAINTAINER Ahmed Amine T.B <aminetb2a@gmail.com>


# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hello-client.jar
ENTRYPOINT ["java", "-jar", "/hello-client.jar"]

EXPOSE 8072