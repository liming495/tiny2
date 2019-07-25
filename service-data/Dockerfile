FROM java:8
VOLUME /tmp
ADD ./target/service-data.jar /service-data.jar
RUN bash -c 'touch /service-data.jar'
EXPOSE 10012
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-data.jar"]