FROM openjdk:14-alpine
RUN apk add --no-cache bash
SHELL ["/bin/bash","-c"]
COPY ./target/greedy*.jar greedy.jar
ENTRYPOINT java -jar greedy.jar