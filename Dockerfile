FROM java:8
ADD target/spring-data-rest.jar /app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar -Dserver.port=8000"]