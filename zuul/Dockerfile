FROM openjdk:15
MAINTAINER Ahmed Amine T.B <aminetb2a@gmail.com>


# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} zuul-service.jar
ENTRYPOINT ["java", "-jar", "/zuul-service.jar"]

EXPOSE 8079