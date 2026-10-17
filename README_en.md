> **Stand der Übersetzung:** Diese englische Fassung bildet die neue Gliederung noch nicht ab. Maßgeblich ist die aktuelle [deutsche Aufgabenstellung](README.md).

# Exercise Sheet: Control Flow Structures
[Link to German Version](./README.md)

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new)

**Work in the browser:** After clicking, select your own repository under **Repository** (its name ends with your GitHub username), not the template. Alternatively, open your repository on GitHub and choose **Code → Codespaces → Create codespace on main**. How to work locally and run the tests is described in [TESTEN.md](./TESTEN.md) (German).

In this exercise sheet, you will practice different control flow structures.


## Exercise: Roller Coaster

The package [`de.phl.programmingproject.rollercoaster`](src/main/java/de/phl/programmingproject/rollercoaster) includes the classes [`Person`](src/main/java/de/phl/programmingproject/rollercoaster/Person.java) and [`RollerCoaster`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java).
The class [`RollerCoaster`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java) has the method `boolean isEligibleToRide(final Person person)`, which takes a [`Person`](src/main/java/de/phl/programmingproject/rollercoaster/Person.java) object and checks if the person is eligible to ride the roller coaster.
Eligible on their own are persons which are at least 12 years old and 1.5 meters tall.
Persons which are at least 10 years old and 1.3 meters tall are eligible too but require an adult.
Persons younger than 10 years old or less than 1.3 meters tall are not eligible at all to ride the roller coaster.

### Tasks

1. Implement the [`isEligibleToRide`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java) operation according to the criteria.
   - **Note** that `height` is implemented in centimeters!
2. Discuss whether the operation has difficulties to match the criteria in full detail regarding the return values.
3. Think of a better solution and implement it in the method `isEligibleToRideImproved`.



## Exercise: A Strangely Familiar Game

You are developing a game where players can choose from different characters to play as.
The game is located in the package [`de.phl.programmingproject.game`](src/main/java/de/phl/programmingproject/game).
Each character has a unique ability that can be activated by pressing a button.
The available characters are:

- _Mario_: jumps higher than other persons
- _Luigi_: runs faster than other persons
- _Princess Peach_: floats in the air for a short period of time
- _Bowser_: stomps on the ground to stun nearby enemies

You need to implement the ability activation functionality using Java [`enums`](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) first.

> **IMPORTANT:** Do not implement the `enums` inside the `Main` class. You can either save them as their own Java file (e.g. `Person.java`) or define them in a corresponding file, e.g., `GameCharacter.java` as a separate `enum` outside the `Main` class.


Example of a custom `Enum` stored inside the `Class.java` file:
```Java
package de.phl.programmingproject.game;

public class Class {
    // TODO: create your game characters here. For each character, print the activation of each ability.
    public static void main(String[] args) {

    }
}

enum YourEnum{
    One, Two, Three
}
```

### Tasks

1. Create a Java enum called Person that contains the following values: `MARIO`, `LUIGI`, `PRINCESS_PEACH`, and `BOWSER`. Each value should have a String representation of the person's `name` ("Mario", "Luigi", "Princess Peach", and "Bowser", respectively).
2. Create a Java enum called Ability that contains the following values: `JUMP`, `RUN`, `FLOAT`, and `STOMP`.
3. Create a class [`GameCharacter`](src/test/java/de/phl/programmingproject/game/GameCharacterTest.java) (test only, implementation missing) with an attribute `person` of type Person and an operation `activateAbility(final Ability ability)`.
    The `activateAbility` operation should provide a parameter `ability` of type Ability and return a message (`String`) that describes the effect of the ability (signature and return type: `String activateAbility(final Ability ability)`).
    For example, if the person is `Person.MARIO` and `ability` is `Ability.JUMP`, the message should be "Mario jumps higher than other persons!".
   
    Also create a constructor for initializing these attributes.

    The expected messages for each person and ability are as follows:
   
    | Person         | Ability | Message                                                         |
    |----------------|---------|-----------------------------------------------------------------|
    | MARIO          | JUMP    | "Mario jumps higher than other persons!"                        |
    | LUIGI          | RUN     | "Luigi runs faster than other persons!"                         |
    | PRINCESS_PEACH | FLOAT   | "Princess Peach floats in the air!"                             |
    | BOWSER         | STOMP   | "Bowser stomps on the ground to stun nearby enemies!"           |

4. In the `activateAbility` operation, use a `switch-case` statement to determine the effect of the ability based on the provided ability argument.
    If the argument matches the person's ability, return the appropriate message.
    If the ability does not match the person's special ability, return a message that indicates that it only is a regular ability (e.g., "Mario is running", or "Luigi is jumping").
5. Create the four GameCharacter objects with different persons and test the `activateAbility` operation with different abilities in the [`main`](src/main/java/de/phl/programmingproject/game/Main.java) method of the class [`Main`](src/main/java/de/phl/programmingproject/game/Main.java) and print out the result to ensure that the `switch-case` statement is working correctly.
    - create all four GameCharacter (_Mario_, _Luigi_, _Princess Peach_, and _Bowser_) and print out the characters' activation of each ability.
6. Re-implement the logic of `activateAbility` in an `activateAbilityWithIf` operation using `if-else` statements. Discuss the pros and cons of both implementations.
7. Add a new Person and Ability and adapt both operations.
    Discuss how well the program performs with regard to maintenance when adding a new person.


## Exercise: Prime Number Sum

You are tasked with writing a program that generates the sum of the first `n` prime numbers, where `n` is set to 20. A prime number is a number that is only divisible by 1 and itself.

### Tasks

1. Implement the [`isPrime(final int n)`](src/main/java/de/phl/programmingproject/math/MathHelper.java) operation in the [`MathHelper`](src/main/java/de/phl/programmingproject/math/MathHelper.java) class of the [`de.phl.programmingproject.math`](src/main/java/de/phl/programmingproject/math) package using a `for` loop.
2. Write a Java program in the [`MathHelper`](src/main/java/de/phl/programmingproject/math/MathHelper.java) class that generates the sum of the first 20 prime numbers using a `while` loop.
3. Print the sum of the first 20 prime numbers to the console.


## Exercise: Sum of Digits

You are tasked with writing a Java program that includes an operation called `int calculateSumOfDigits(final int number)`.
The operation takes a positive integer `n` and calculates the sum of its digits.
For example, the sum of the digits of the number `1234` is `1 + 2 + 3 + 4 = 10`.
Pay attention to potential preconditions.
Implement the program in the [`MathHelper`](src/main/java/de/phl/programmingproject/math/MathHelper.java) class in the [`de.phl.programmingproject.math`](src/main/java/de/phl/programmingproject/math) package.

### Tasks

1. Implement the `calculateSumOfDigits` operation to calculate the sum of the digits of the number `867194` using a `while` loop.
2. Print the sum of the digits calculated by the `calculateSumOfDigits` operation to the console.
3. Implement an operation `Set<Integer> calculateReverseSumOfDigits(final int number)` which reverse engineers the potential numbers which `number` is the sum of the digits for and returns them as a set. You only have to consider the numbers up to 10000. If you don't know how to work with `Set`, you can take a look at [https://www.geeksforgeeks.org/set-in-java/](https://www.geeksforgeeks.org/set-in-java/) or [https://www.digitalocean.com/community/tutorials/java-set](https://www.digitalocean.com/community/tutorials/java-set).


## Exercise: Number Guesser

You are tasked with writing a Java program that generates a random number between 1 and 100, and allows the user to guess the number.
The program should provide feedback to the user after each guess, telling them whether their guess was too high or too low.
The program should also keep track of the number of guesses the user has made.
Implement the program in the [`NumberGuesser`](src/main/java/de/phl/programmingproject/math/NumberGuesser.java) class which is located in the [`de.phl.programmingproject.math`](src/main/java/de/phl/programmingproject/math) package.

_Note_: Google how to generate a random number and how to prompt the user for input in the standard command line.

### Tasks

Write a Java program that ....
1. generates a random number between 1 and 100 and stores it in a variable.
2. prompts the user to guess the number and reads the guess from the console.
3. uses a `do-while` loop to repeatedly prompt the user to guess the number until they guess correctly.
4. provides feedback to the user after each guess, telling them whether their guess was too high or too low.
5. keeps track of the number of guesses the user has made and displays it to the user after they guess correctly.

## Exercise: FizzBuzz

Write a program that prints numbers from 1 to 100. For multiples of three, print "Fizz" instead of the number, and for multiples of five, print "Buzz". For numbers that are multiples of both three and five, print "FizzBuzz".

Here's an example output for the first few numbers:

1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
...

Implement the program in the [`FizzBuzz`](src/main/java/de/phl/programmingproject/fizzbuzz/FizzBuzz.java) class which is located in the [`de.phl.programmingproject.fizzbuzz`](src/main/java/de/phl/programmingproject/fizzbuzz) package.

## Exercise: Pizza Disaster

In this exercise, you will be given a Java program that attempts to make a pizza.
However, the code has some problems that result in unexpected exceptions being thrown.
Your task is to analyze the code and identify the correct output of the program.

### Tasks

1. Identify the current output of the program.
2. Explain the control flow of the program and the exceptions that may be thrown.
3. Identify the `try-catch` blocks in the code and explain what they do.
4. How would you repair the program?
5. Identify the now correct output of the program.
6. Submit your answers in a markdown file `pizza_disaster.md` in the root directory.


```java
class Cooking {
    public static void main(String[] args) {
        try {
            String ingredient1 = "flour";
            String ingredient2 = "water";
            String ingredient3 = "yeast";
            String ingredient4 = "salt";
            String ingredient5 = "sugar";
            String ingredient6 = "oil";
            String ingredient7 = "tomato sauce";
            String ingredient8 = "cheese";
            int temperature = 425;
            Dough dough = new Dough(ingredient1, ingredient3, ingredient3, ingredient4, ingredient5, ingredient6);
            Pizza pizza = new Pizza(dough, ingredient7, ingredient8, temperature);
            System.out.println(pizza);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class Dough {
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;
    private String ingredient6;

    public Dough(String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
    }

    public boolean isMixed() throws MixingException {
        if (ingredient1.equals("flour") && ingredient2.equals("water") && ingredient3.equals("yeast") && ingredient4.equals("salt") && ingredient5.equals("sugar") && ingredient6.equals("oil")) {
            return true;
        } else {
            throw new MixingException("Dough ingredients are not mixed properly");
        }
    }
}

class Pizza {
    private Dough dough;
    private String ingredient7;
    private String ingredient8;
    private int temperature;

    public Pizza(Dough dough, String ingredient7, String ingredient8, int temperature) throws CookingException {
        this.dough = dough;
        this.ingredient7 = ingredient7;
        this.ingredient8 = ingredient8;
        this.temperature = temperature;
        cook();
    }

    private void cook() throws CookingException {
        try {
            if (!dough.isMixed()) {
                throw new CookingException("Cannot cook pizza, dough is not mixed properly");
            }
            if (temperature < 400 || temperature > 450) {
                throw new CookingException("Cannot cook pizza, temperature is not within range");
            }
            System.out.println("Cooking pizza...");
        } catch (CookingException e) {
            throw e;
        } catch (Exception e) {
            throw new CookingException("Error cooking pizza: " + e.getMessage());
        } finally {
            System.out.println("Pizza is done");
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", ingredient7='" + ingredient7 + '\'' +
                ", ingredient8='" + ingredient8 + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}

class MixingException extends Exception {
    public MixingException(String message) {
        super(message);
    }
}

class CookingException extends Exception {
    public CookingException(String message) {
        super(message);
    }
}
```

## Exercise: Exception Handling

You are given a Java program with complex nested control flow using branching, throwing of exceptions, and try-catch statements.
Your task is to identify the output of the program.

### Tasks

1. Identify the current output of the program.
2. Identify all exceptions that can be thrown by the program.
3. List all arguments that are passed to the `divide` method for each exception that can be thrown.
4. Submit your answers (i.e., the output of the program) in a markdown file `exception_handling.md` in the root directory.
 
### Code

```java
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int result = divide(100, 2);
            System.out.println("Result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int divide(int x, int y) {
        int result = 0;
        try {
            if (x < 0) {
                throw new IllegalArgumentException("x must be non-negative");
            }
            if (y == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            if (y == 1) {
                return x;
            }
            try {
                result = x / y;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Done with division");
            }
            if (result > 100) {
                throw new ArithmeticException("Result is too large");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("End of program");
        }
        return result;
    }
}
```

## Exercise: Banking Account Exceptions

You are tasked with implementing a class to represent a bank account. Your [`BankAccount`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) class has a [`balance`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) field that holds the current balance of the account. The `BankAccount` class also has two operations, [`deposit`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) and [`withdraw`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java), that allow deposits and withdrawals from the account.  
[See the BankAccount class here.](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java)


The class [`BankAccount`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) is provided as a stub in the [`de.phl.programmingproject.exceptions`](src/main/java/de/phl/programmingproject/exceptions) package.
However, these operations have not yet been implemented to handle the possible exceptions that may occur when performing these operations.

### Tasks

> **Note:** To make the test cases pass you may need to print the full error message. For this, print the `Exception` directly to the console: `System.out.println(e);`.

1. Update the [`BankAccount`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) class with the following requirements:
        - Modify the [`deposit`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) operation: If the amount to be deposited is negative, the operation should throw an `IllegalArgumentException` with the message "Amount to deposit must be positive".
        - Modify the [`withdraw`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) operation: If the amount to be withdrawn is negative, the operation should throw an `IllegalArgumentException` with the message "Amount to withdraw must be positive". If the amount to be withdrawn is greater than the current balance, the operation should throw an `InsufficientFundsException` with the message "Insufficient funds for withdrawal". Implement your own `InsufficientFundsException` class in the [`de.phl.programmingproject.exceptions`](src/main/java/de/phl/programmingproject/exceptions) package.
            - You can use the following class as a blueprint for your own exception:
        ```Java
           public class MyException extends Exception {
               public MyException(String message) {
                   super(message);
               }
           } 
        ```
2. [Create a new instance of the `BankAccount` class with a balance of 1000.0.](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java)
3. [Call the `deposit` operation with an amount of -500.0 and handle the `IllegalArgumentException` that is thrown by printing the error message to the console.](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java)
4. [Call the `deposit` operation with an amount of 500.0 and print the updated balance to the console.](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java)
5. [Call the `withdraw` operation with an amount of -200.0 and handle the `IllegalArgumentException` that is thrown by printing the error message to the console.](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java)
6. [Call the `withdraw` operation with an amount of 2000.0 and handle the `InsufficientFundsException` that is thrown by printing the error message to the console.](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java)
7. Call the `withdraw` operation with an amount of 500.0 and print the updated balance to the console.