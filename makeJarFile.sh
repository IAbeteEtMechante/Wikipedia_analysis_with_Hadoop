#!/usr/bin/env bash
javac -classpath $(find /usr/local/hadoop -name "*.jar" | awk '{printf("%s:",$1)} END{printf("\n")}' | sed 's/:$//') *.java
jar cvf Job.jar *.class
rm -rf *.class
