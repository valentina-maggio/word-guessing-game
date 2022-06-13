# Word Guessing Game

## Description

This is a simple hangman game for two players built in Java. The players have 10 attempts each. The game ends when one player either wins or looses.
The game runs on the Command Line.

## Instructions to run the program

1. Fork and clone this repo
2. Open the App.java file and run it
3. Follow the instructions on the screen

## Output example

```shell
Welcome to hangman game!

Enter name for player 1
Peggy
Enter name for player 2
Lilly

The word to guess is:
Peggy: M_____
Lilly: L_____

Peggy: Guess a letter! (10 attempts remaining)
K
Right!
M_K___
Lilly: Guess a letter! (10 attempts remaining)
R
Wrong!
L_____
Peggy: Guess a letter! (10 attempts remaining)
A
Right!
MAK___
Lilly: Guess a letter! (9 attempts remaining)
O
Right!
LO__O_
Peggy: Guess a letter! (10 attempts remaining)
A
You have already guessed this letter. Pick another one!
Peggy: Guess a letter! (10 attempts remaining)
S
Right!
MAK__S
Lilly: Guess a letter! (9 attempts remaining)
D
Right!
LO_DO_
Peggy: Guess a letter! (10 attempts remaining)
R
Right!
MAK_RS
Lilly: Guess a letter! (9 attempts remaining)
N
Right! Lilly won!
LONDON
```

## Technologies used

- Java
- JUnit for testing
