#FROM openjdk:11-slim as build
#LABEL maintainer="J.C. <@PrivetDimas>"
#COPY target/PomidoroTimer-0.0.1-SNAPSHOT.jar app.jar
#RUN mkdir "-p target/dependency && (cd target/dependency; jar -xf /app.jar)"
#FROM openjdk:11-slim
#VOLUME /tmp
#ARG DEPENDENCY=/target/dependency
#COPY --from=buiild $DEPENDENCY/BOOT-INF/lib/ /app/lib
#COPY --from=buiild $DEPENDENCY/META-INF /app/META-INF
#COPY --from=buiild $DEPENDENCY/BOOT-INF/classes /app
#ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.example.pomidorotimer.PomodoroTimerApplication"]

FROM openjdk:11-slim
LABEL maintainer="J.C. <@PrivetDimas>"
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]