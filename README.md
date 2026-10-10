# Java Programs

This repository contains two small Java programs:

- `MushroomIdentifier` identifies one of six mushrooms by asking a sequence of yes/no questions.
- `BicycleRental` calculates a bicycle rental cost from a starting hour to an ending hour, using different prices at different times of day.

Both programs use Java's `Scanner` class to read input from the keyboard. They are independent programs, so compile and run the one you want to use.

## Requirements

- A Java Development Kit (JDK) must be installed. The `javac` compiler and `java` launcher should be available in your terminal.
- Run commands from the directory containing the `.java` files.

Check the Java tools are available with:

```sh
javac -version
java -version
```

## Compile and Run

Compile either program:

```sh
javac MushroomIdentifier.java
javac BicycleRental.java
```

Or compile both at once:

```sh
javac MushroomIdentifier.java BicycleRental.java
```

Run a compiled program using its class name, without the `.java` or `.class` extension:

```sh
java MushroomIdentifier
```

```sh
java BicycleRental
```

Compilation creates `.class` files. If using a recent Java version, you can also run a source file directly without a separate compile step:

```sh
java MushroomIdentifier.java
java BicycleRental.java
```

## MushroomIdentifier Logic

The program asks about mushroom features and uses nested `if` statements to narrow the answer to one of six choices. It asks only the questions needed for the selected path. Answers are compared exactly with the lowercase string `yes`; any other input is treated as `no` by the current code.

| Question / condition                                | Answer | Next step or result               |
| --------------------------------------------------- | ------ | --------------------------------- |
| Does it have a convex cup?                          | Yes    | Ask whether it grows in a meadow. |
| Does it grow in a meadow?                           | Yes    | Agaric jaunissant                 |
| Does it grow in a meadow?                           | No     | Ask whether it has a ring.        |
| Does it have a ring after the previous two answers? | Yes    | Amanite tue-mouches               |
| Does it have a ring after the previous two answers? | No     | Pied bleu                         |
| Does it have a convex cup?                          | No     | Ask whether it has pores.         |
| Does it have pores?                                 | Yes    | Cepe de bordeaux                  |
| Does it have pores?                                 | No     | Ask whether it has a ring.        |
| Does it have a ring after the previous two answers? | Yes    | Coprin chevelu                    |
| Does it have a ring after the previous two answers? | No     | Girolle                           |

In short, the first answer divides the decision tree into two groups. The second answer may identify the mushroom immediately; otherwise, the ring question selects between the remaining two candidates in that group. The names and spelling shown in the output follow the Java source.

## BicycleRental Logic

The program reads a starting hour and an ending hour, then loops through each hour from `start` up to, but not including, `end`. For every hour, it selects the price for that hour and adds it to `total`.

| Hour being charged | Rate per hour |
| ------------------ | ------------: |
| 0 through 6        |       500 RWF |
| 7 through 13       |     1,000 RWF |
| 14 through 18      |     1,500 RWF |
| 19 through 20      |     1,000 RWF |
| 21 through 23      |       500 RWF |

The start hour is included and the end hour is excluded. For example, a rental from hour `6` to hour `9` charges hours 6, 7, and 8: `500 + 1,000 + 1,000 = 2,500 RWF`.

The prompts specify a start from `0` to `23` and an end from `1` to `24`, but the program does not validate those ranges. It also expects the ending hour to be later than the starting hour; overnight rentals are not handled. If `end` is equal to or less than `start`, the loop does not add any hourly charges and the displayed total is `0 RWF`.

## Example Sessions

### MushroomIdentifier

```text
1. Does your mushroom have a convex cup?: yes
2. Does your mushroom grow in a meadow?: no
3. Does your mushroom have a ring?: yes
Result: Your mushroom is Amanite tue-mouches.
```

### BicycleRental

```text
Enter starting time (0-23): 6
Enter ending time (1-24): 9
Total rental cost: 2500 RWF
```
