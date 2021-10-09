FROM maven:3.6.3-openjdk-15-slim

COPY src /home/todomvc-automation/src

COPY pom.xml /home/todomvc-automation

RUN mvn -f /home/todomvc-automation/pom.xml clean test -DskipTests=true