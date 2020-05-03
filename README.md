# minmax-words-player
This repository contains methods to get longest and shortest of words in a given sentence. 
It makes the use of Java stream library.

# The following version of Java was used on MacOS:

openjdk 13.0.2 2020-01-14

OpenJDK Runtime Environment (build 13.0.2+8)

OpenJDK 64-Bit Server VM (build 13.0.2+8, mixed mode, sharing)


# Test Execution:
1) Clone the build.
2) Make sure you have maven installed.
3) Open terminal at the root folder of the project and execute this command: mvn test

## Tests:
The methods to get longest and shortest words from string have error handling for strings containing whitespaces, empty strings and blank strings. 
The methods also retreive multiple occurences of shortest and longest words from the string.

## Test Examples:
1) Input string is: ["This test asserts multiple longest words in a given sentence"]

Longest words in the sentence are:
"multiple",8
"sentence",8

2) Input string is: ["This test asserts multiple shortest words from given sentence"]

Shortest words in the sentence are:
"This",4
"test",4
"from",4

3) Input string is: ["This test asserts the longest word in a given sentence"]

Longest word in the sentence is:
"sentence",8

4) Input string is: ["This test asserts the shortest word in a given sentence"]

Shortest word in the sentence is:
"a",1

5) Input string is: ["Test                           with      whitespaces"]

Longest word/s in the sentence is/are:
"whitespaces",11
