#!/usr/bin/env bash
javac -classpath $(find /usr/local/hadoop -name "*.jar" | awk '{printf("%s:",$1)} END{printf("\n")}' | sed 's/:$//') $(find . -name "*.java" | awk '{printf("%s ",$1)} END{printf("\n")}')
jar cvf Job.jar -C . .
rm -rf $(find . -name "*.class" | awk '{printf("%s ",$1)} END{printf("\n")}')
