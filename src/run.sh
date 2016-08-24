#!/bin/bash

EXTENSION=".b"
FILENAME="$1$EXTENSION"

java -jar antlr-3.2.jar Bali.g 2> /dev/null
javac -cp antlr-3.2.jar *.java 2> /dev/null
echo "OK"
echo ""
java -cp antlr-3.2.jar:. BaliParser < $1 > $FILENAME 

java -jar jasmin-2.4.jar $FILENAME > /dev/null 2>&1
java Test
