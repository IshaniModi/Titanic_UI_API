FROM openjdk:8-jdk-alpine
VOLUME /tmp

COPY ./target/restapi-1.0.0.jar restapi-1.0.0.jar
COPY ./docker-entrypoint.sh /docker-entrypoint.sh

RUN chmod 755 /docker-entrypoint.sh

RUN touch /restapi-1.0.0.jar && mkdir -p /config

WORKDIR /

EXPOSE 8080

ENTRYPOINT [ "/docker-entrypoint.sh" ]
CMD [ "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /restapi-1.0.0.jar" ]
