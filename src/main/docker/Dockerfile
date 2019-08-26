FROM openjdk:8-jre

VOLUME /tmp

ADD securityjwt-0.0.1-SNAPSHOT.jar securityjwt.jar

RUN bash -c 'touch /securityjwt.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/securityjwt.jar"]
