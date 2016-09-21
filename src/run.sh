#!/bin/bash

EXTENSION=".b"
FILENAME="$1$EXTENSION"

echo "Generating Lexer and Parser code..."
java -jar antlr-3.2.jar Bali.g 2> /dev/null

echo "Compiling Lexer and Parser..."
if javac -cp antlr-3.2.jar *.java; then
	echo "OK"
	echo "Running parser on $FILENAME"
	if java -cp antlr-3.2.jar:. BaliParser < $1 > $FILENAME; then
		echo "OK"
		echo "      ___           ___           ___             "
		echo "     /\  \         /\  \         /\__\      ___   "
		echo "    /::\  \       /::\  \       /:/  /     /\  \  "
		echo "   /:/\:\  \     /:/\:\  \     /:/  /      \:\  \ "
		echo "  /::\~\:\__\   /::\~\:\  \   /:/  /       /::\__\\"
		echo " /:/\:\ \:|__| /:/\:\ \:\__\ /:/__/     __/:/\/__/"
		echo " \:\~\:\/:/  / \/__\:\/:/  / \:\  \    /\/:/  /   "
		echo "  \:\ \::/  /       \::/  /   \:\  \   \::/__/    "
		echo "   \:\/:/  /        /:/  /     \:\  \   \:\__\    "
		echo "    \::/__/        /:/  /       \:\__\   \/__/    "
		echo "     ~~            \/__/         \/__/            "
		echo ""
		echo "#################### Running $FILENAME ####################"
		echo ""
		if java -jar jasmin-2.4.jar $FILENAME > /dev/null 2>&1; then
			javac Runtime.java
			java Test
		else
			echo "Aborted..."
		fi
	else
		rm $FILENAME 2> /dev/null
		echo "Aborted..."
	fi
else
	rm *.class Bali.tokens 2> /dev/null
	echo "Aborted..."
fi