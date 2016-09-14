#!/bin/bash

EXTENSION=".b"
FILENAME="$1$EXTENSION"

java -jar antlr-3.2.jar Bali.g 2> /dev/null
if javac -cp antlr-3.2.jar *.java 2> /dev/null; then
	echo "OK"
	echo ""
	if java -cp antlr-3.2.jar:. BaliParser < $1 > $FILENAME; then 

	java -jar jasmin-2.4.jar $FILENAME > /dev/null 2>&1
	java Test
	else
		echo "Aborted..."
	fi
else
	echo "Aborted..."
fi

