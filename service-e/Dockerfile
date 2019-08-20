FROM java:8
VOLUME /tmp
ADD ./target/service-e.jar /service-e.jar
RUN bash -c 'touch /service-e.jar'
EXPOSE 10100
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-e.jar"]