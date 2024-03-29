#!/bin/sh

echo Clear project
mvn clean
echo Start generation jar
mvn package
echo Run program
java -jar target/java_11_start_maven.jar
