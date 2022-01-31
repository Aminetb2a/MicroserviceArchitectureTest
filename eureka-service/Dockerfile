FROM openjdk:15
MAINTAINER Ahmed Amine T.B <aminetb2a@gmail.com>


# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]

EXPOSE 8761