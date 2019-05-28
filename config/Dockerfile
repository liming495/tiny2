FROM java:8
VOLUME /tmp
ADD ./target/config.jar /config.jar
RUN bash -c 'touch /config.jar'
EXPOSE 8761
ENTRYPOINT ["java","-jar","/config.jar"]