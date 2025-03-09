#!/bin/sh

mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=transport=dt_socket,server=y,suspend=n,address=*:5005,suspend=n"

while : ;do
  mvn compile &
  sleep 2
done
