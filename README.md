# Übungsblatt: Kontrollfluss-Strukturen
[Link to English version](./README_en.md)

In diesem Übungsblatt üben Sie verschiedene Kontrollflussstrukturen.


## Übung 1: Achterbahn

Das Paket [`de.phl.programmingproject.rollercoaster`](src/main/java/de/phl/programmingproject/rollercoaster) enthält die Klassen [`Person`](src/main/java/de/phl/programmingproject/rollercoaster/Person.java) und Klasse [`RollerCoaster`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java).
Die Klasse [`RollerCoaster`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java) hat die Methode [`boolean isEligibleToRide(final Person person)`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java), die ein [`Person`](src/main/java/de/phl/programmingproject/rollercoaster/Person.java) Objekt nimmt und überprüft, ob die Person berechtigt ist, die Achterbahn zu fahren.
Alleine berechtigt sind Personen, die mindestens 12 Jahre alt und 1,5 Meter groß sind.
Personen, die mindestens 10 Jahre alt und 1,3 Meter groß sind, sind ebenfalls berechtigt, benötigen aber einen Erwachsenen.
Personen, die jünger als 10 Jahre alt oder kleiner als 1,3 Meter sind, sind überhaupt nicht berechtigt, die Achterbahn zu fahren.

### Aufgaben

1. Implementieren Sie die [`isEligibleToRide`](src/main/java/de/phl/programmingproject/rollercoaster/RollerCoaster.java) Operation entsprechend den Kriterien.
    - **Beachten Sie**, dass `height` in Zentimetern implementiert ist!
2. Diskutieren Sie, ob die Operation in der Lage ist, die Kriterien in vollem Umfang hinsichtlich der Rückgabewerte zu erfüllen.
3. Überlegen Sie sich eine bessere Lösung und implementieren Sie diese in der Methode `isEligibleToRideImproved`.


## Übung 2: Ein seltsam vertrautes Spiel

Du entwickelst ein Spiel, in dem die Spieler*innen aus verschiedenen Charakteren wählen können, um als diese zu spielen.
Das Spiel befindet sich im Paket [`de.phl.programmingproject.game`](src/main/java/de/phl/programmingproject/game).
Jeder Charakter hat eine einzigartige Fähigkeit, die durch Drücken einer Taste aktiviert werden kann.
Die verfügbaren Charaktere sind:

- _Mario_: springt höher als andere Personen (Mario jumps higher than other persons!)
- _Luigi_: läuft schneller als andere Personen (runs faster than other persons!)
- _Prinzessin Peach_: schwebt für kurze Zeit in der Luft (floats in the air for a short period of time)
- _Bowser_: stampft auf den Boden, um nahegelegene Feinde zu betäuben (stomps on the ground to stun nearby enemies)

Du musst zuerst die Funktionalität zur Aktivierung der Fähigkeiten mit Java [`enums`](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) implementieren.

> **WICHTIG:** Implementiert die `enums` nicht innerhalb der `Main`-Klasse. Ihr könnt sie entweder als eigene Java-Datei abspeichern (z.B.: `Person.java`) oder in Datei `Main.java` als eigene `enum` außerhalb der `Main`-Klasse definieren. Ein Beispiel findet ihr unten:

Beispiel einer eigenen `Enum` in der `Main.java` Datei:
```Java
package de.phl.programmingproject.game;

public class Main {
    // TODO: create your game characters here. For each character, print the activation of each ability.
    public static void main(String[] args) {
        
    }
}

enum YourEnum{
    One, Two, Three
}
```

### Aufgaben

1. Erstelle ein Java Enum namens `Person` das die folgenden Werte enthält: `MARIO`, `LUIGI`, `PRINCESS_PEACH`, und `BOWSER`. Jeder Wert sollte eine String-Darstellung des Namens der Person haben ("Mario", "Luigi", "Princess Peach", und "Bowser").
2. Erstelle ein Java Enum namens `Ability`, das die folgenden Werte enthält: `JUMP`, `RUN`, `FLOAT`, und `STOMP`.
3. Erstelle eine Klasse `GameCharacter` mit einem Attribut `person` vom Typ `Person` und einer Methode `activateAbility(final Ability ability)`.
   Die Methode sollte eine Nachricht (`String`) zurückgeben, die die Wirkung der Fähigkeit beschreibt (Signatur: `String activateAbility(final Ability ability)`).
   Zum Beispiel, wenn die Person `Person.MARIO` ist und `ability` `Ability.JUMP` ist, sollte die Nachricht (auf Englisch) lauten: "Mario jumps higher than other persons!".

   Erstelle auch einen Konstruktor zur Initialisierung dieser Attribute.

   Die erwarteten Nachrichten sind in folgender Tabelle dargestellt:

   | Person         | Ability | Message                                                         |
   |----------------|---------|-----------------------------------------------------------------|
   | MARIO          | JUMP    | "Mario jumps higher than other persons!"                        |
   | LUIGI          | RUN     | "Luigi runs faster than other persons!"                         |
   | PRINCESS_PEACH | FLOAT   | "Princess Peach floats in the air!"                             |
   | BOWSER         | STOMP   | "Bowser stomps on the ground to stun nearby enemies!"           |

4. Verwende in der Methode `activateAbility` eine `switch-case` Anweisung, um die Wirkung der Fähigkeit basierend auf dem bereitgestellten Ability-Argument zu bestimmen.
   Wenn das Argument mit der Fähigkeit der Person übereinstimmt, gib die entsprechende Nachricht zurück.
   Wenn die Fähigkeit nicht mit der speziellen Fähigkeit der Person übereinstimmt, gib eine Nachricht zurück, die darauf hinweist, dass es sich nur um eine reguläre Fähigkeit handelt (z.B. "Mario is running", oder "Luigi is jumping").
5. Erstelle die vier `GameCharacter` Objekte mit verschiedenen Personen und teste die Methode`activateAbility` mit verschiedenen Fähigkeiten in der [`main`](src/main/java/de/phl/programmingproject/game/Main.java) Methode der Klasse [`Main`](src/main/java/de/phl/programmingproject/game/Main.java) und gib das Ergebnis aus, um sicherzustellen, dass die `switch-case` Anweisung korrekt funktioniert.
   - Erstelle alle vier `GameCharacter` (_Mario_, _Luigi_, _Prinzessin Peach_, und _Bowser_) und gib die Aktivierung jeder Fähigkeit der Charaktere aus.
6. Implementiere die Logik von `activateAbility` in einer Methode `activateAbilityWithIf` mit `if-else` Anweisungen neu. Diskutiere die Vor- und Nachteile beider Implementierungen.
7. Füge eine neue `Person` und `Ability` hinzu und passe beide Methoden an.
   Diskutiere, wie gut das Programm in Bezug auf Wartungsfähigkeit funktioniert, wenn eine neue Person hinzugefügt wird.


## Übung 3: Summe der Primzahlen

Ihre Aufgabe besteht darin, ein Programm zu schreiben, das die Summe der ersten `n` Primzahlen berechnet, 
wobei `n` auf 20 gesetzt ist. Eine Primzahl ist eine Zahl, die nur durch 1 und sich selbst ohne Rest teilbar ist.

### Aufgaben

1. Implementieren Sie die Operation [`boolean isPrime(final int n)`](src/main/java/de/phl/programmingproject/math/MathHelper.java) mittels einer `for` Schleife, die sich in der Klasse [`MathHelper`](src/main/java/de/phl/programmingproject/math/MathHelper.java) des Pakets [`de.phl.programmingproject.math`](src/main/java/de/phl/programmingproject/math) befindet.
2. Schreiben Sie ein Java-Programm in der Klasse `MathHelper`, das mit einer `while`-Schleife die Summe der ersten 20 Primzahlen berechnet.
3. Geben Sie die Summe der ersten 20 Primzahlen auf der Konsole aus.


## Übung 4: Quersumme (Summe der Ziffern)

Sie wurden beauftragt, ein Java-Programm zu schreiben, das eine Operation namens [`int calculateSumOfDigits(final int number)`](src/main/java/de/phl/programmingproject/math/MathHelper.java) beinhaltet.
Die Operation nimmt eine positive Ganzzahl `n` und berechnet die Summe ihrer Ziffern (=Quersumme).
Zum Beispiel ist die Summe der Ziffern der Zahl `1234` `1 + 2 + 3 + 4 = 10`.
Achten Sie auf mögliche Vorbedingungen.
Implementieren Sie das Programm in der [`MathHelper`](src/main/java/de/phl/programmingproject/math/MathHelper.java) Klasse im [`de.phl.programmingproject.math`](src/main/java/de/phl/programmingproject/math) Paket.

### Aufgaben

1. Implementieren Sie die Operation [`calculateSumOfDigits`](src/main/java/de/phl/programmingproject/math/MathHelper.java), um die Summe der Ziffern der Zahl `867194` mit einer `while`-Schleife zu berechnen.
2. Geben Sie die Summe der Ziffern, die von der Operation [`calculateSumOfDigits`](src/main/java/de/phl/programmingproject/math/MathHelper.java) berechnet wurde, in der Konsole aus.
3. Implementieren Sie eine Operation `Set<Integer> calculateReverseSumOfDigits(final int number)`, die die möglichen Zahlen berechnet (reverse-engineering), für die `number` die Summe der Ziffern ist, und geben sie als `Set` zurück. Sie müssen nur die Zahlen bis 10000 berücksichtigen.  
Wenn Sie nicht wissen, wie man mit `Set` arbeitet, können Sie sich hier eine Beschreibung durchlesen:  
- [Set in Java (GeeksforGeeks)](https://www.geeksforgeeks.org/set-in-java/)  
- [Java Set Tutorial (DigitalOcean)](https://www.digitalocean.com/community/tutorials/java-set)

## Übung 5: Number Guesser

Ihre Aufgabe besteht darin, ein Java-Programm zu schreiben, das eine zufällige Zahl zwischen 1 und 100 generiert und dem/der Benutzer&ast;in erlaubt, die Zahl zu erraten.
Das Programm sollte dem/der Benutzer&ast;in nach jedem Versuch Feedback geben und ihm mitteilen, ob seine Vermutung zu hoch oder zu
niedrig war. Das Programm sollte auch die Rate-Anzahl der Benutzer&ast;innen speichern.
Implementieren Sie das Programm in der [`NumberGuesser`](src/main/java/de/phl/programmingproject/math/NumberGuesser.java)-Klasse im Paket [`de.phl.programmingproject.math`](src/main/java/de/phl/programmingproject/math).

_Hinweis_: Recherchieren Sie, wie man eine Zufallszahl generiert und wie man Benutzer*innen in der Standardbefehlszeile (standard command line) zur Eingabe auffordert.

### Aufgaben

Schreiben Sie ein Java-Programm, das ....

1. eine zufällige Zahl zwischen 1 und 100 generiert und sie in einer Variable speichert.
2. die Benutzer&ast;innen auffordert, die Zahl zu erraten und die Antwort von der Konsole liest.
3. eine `do-while` Schleife verwendet, um die Benutzer&ast;innen wiederholt aufzufordern, die Zahl zu erraten, bis sie richtig
   geraten wird.
4. den Benutzer&ast;innen nach jedem Versuch Feedback gibt und ihnen mitteilt, ob die Antwort zu hoch oder zu niedrig war.
5. die Anzahl der Versuche der Benutzer&ast;innen speichert und am Ende ausgibt, wenn die Zahl richtig erraten wurde.

## Übung 6: FizzBuzz

Schreiben Sie ein Programm, das Zahlen von 1 bis 100 ausgibt. Für Vielfache von drei, geben Sie "Fizz" statt der Zahl aus, und für Vielfache von fünf, geben Sie "Buzz" aus. Für Zahlen, die Vielfache von sowohl drei als auch fünf sind, geben Sie "FizzBuzz" aus.

Hier ist ein Beispiel für die ersten Zahlen:

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

Implementieren Sie das Programm in der [`FizzBuzz`](src/main/java/de/phl/programmingproject/fizzbuzz/FizzBuzz.java) Klasse, die sich im Paket [`de.phl.programmingproject.fizzbuzz`](src/main/java/de/phl/programmingproject/fizzbuzz) befindet.

## Übung 7: Pizza Desaster

In dieser Übung wird Ihnen ein Java-Programm gegeben, das versucht, eine Pizza zu machen.
Allerdings hat der Code einige Probleme, die zu unerwarteten geworfenen Ausnahmen (exceptions) führen.
Ihre Aufgabe ist es, den Code zu analysieren und die korrekte Ausgabe des Programms zu ermitteln.

### Aufgaben

1. Ermitteln Sie die aktuelle Ausgabe des Programms.
2. Erklären Sie den Kontrollfluss des Programms und die Ausnahmen (exceptions), die geworfen werden können.
3. Identifizieren Sie die `try-catch` Blöcke im Code und erklären Sie, was sie tun.
4. Wie würden Sie das Programm reparieren?
5. Ermitteln Sie die nun korrekte Ausgabe des Programms.
6. Laden Sie Ihre Antworten in einer Markdown-Datei `pizza_disaster.md` im Hauptverzeichnis hoch.

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

## Übung 8: Ausnahmebehandlung (Exception Handling)

Sie bekommen ein Java-Programm mit komplexen, verschachtelten Kontrollflussstrukturen, die Verzweigungen, das Werfen von Ausnahmen und `try-catch`-Anweisungen verwenden.
Ihre Aufgabe ist es, die Ausgabe des Programms zu ermitteln.

### Aufgaben

1. Ermitteln Sie die aktuelle Ausgabe des Programms.
2. Identifizieren Sie alle Ausnahmen, die geworfen werden können.
3. Listen Sie in einer Tabelle für jede Ausnahme, die geworfen werden kann, die Argumente auf, die an die Methode `divide` übergeben werden.
4. Laden Sie Ihre Antworten in einer Markdown-Datei `exception_handling.md` im Hauptverzeichnis hoch.

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

## Übung 9: Bankkonto-Ausnahmen

Ihre Aufgabe ist es, eine Klasse zur Darstellung eines Bankkontos zu implementieren. 
Ihre `BankAccount` Klasse hat ein `balance` Feld, das den aktuellen Kontostand enthält. 
Die `BankAccount` Klasse hat auch zwei Operationen, `deposit` und `withdraw`, die Einzahlungen und Abhebungen vom Konto ermöglichen.

Die Klasse wird als 'Stub' im Paket `de.phl.programmingproject.exceptions` bereitgestellt.
Diese Operationen wurden jedoch noch nicht implementiert, um die möglichen Ausnahmen zu behandeln, die bei der Durchführung dieser Operationen auftreten können.

### Aufgaben

>**Hinweis**: Damit die Testfälle durchlaufen müssen Sie gegebenenfalls die gesamte Fehlermeldung ausgeben. Geben Sie hierfür direkt `Exception` auf der Konsole aus: `System.out.println(e);`.

1. Aktualisieren Sie die `BankAccount` Klasse mit den folgenden Anforderungen:
   - Ändern Sie die `deposit` Operation: Wenn der einzuzahlende Betrag negativ ist, sollte die Operation eine `IllegalArgumentException` mit der Nachricht "Amount to deposit must be positive" werfen.
   - Ändern Sie die `withdraw` Operation: Wenn der abzuhebende Betrag negativ ist, sollte die Operation eine `IllegalArgumentException` mit der Nachricht "Amount to withdraw must be positive" werfen. Wenn der abzuhebende Betrag größer ist als der aktuelle Kontostand, sollte die Operation eine `InsufficientFundsException` mit der Nachricht "Insufficient funds for withdrawal" werfen. Implementieren Sie dafür Ihre eigene `InsufficientFundsException` Klasse im Paket `de.phl.programmingproject.exceptions`.
     - Als Blaupause können Sie sich an folgender Klasse für eine eigene Exception orientieren:
        ```Java
           public class MyException extends Exception {
               public MyException(String message) {
                   super(message);
               }
           } 
        ```
2. Erstellen Sie eine neue Instanz der [`BankAccount`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) Klasse mit einem Kontostand von `1000,0`.
3. Rufen Sie die [`deposit`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) Operation mit einem Betrag von `-500,0` auf und behandeln Sie die [`IllegalArgumentException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html), die geworfen wird, indem Sie die Fehlermeldung auf der Konsole ausgeben.
4. Rufen Sie die [`deposit`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) Operation mit einem Betrag von `500,0` auf und geben Sie den aktualisierten Kontostand auf der Konsole aus.
5. Rufen Sie die [`withdraw`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) Operation mit einem Betrag von `-200,0` auf und behandeln Sie die [`IllegalArgumentException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html), die geworfen wird, indem Sie die Fehlermeldung auf der Konsole ausgeben.
6. Rufen Sie die [`withdraw`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) Operation mit einem Betrag von `2000,0` auf und behandeln Sie die `InsufficientFundsException`, die geworfen wird, indem Sie die Fehlermeldung auf der Konsole ausgeben.
7. Rufen Sie die [`withdraw`](src/main/java/de/phl/programmingproject/exceptions/BankAccount.java) Operation mit einem Betrag von `500,0` auf und geben Sie den aktualisierten Kontostand auf der Konsole aus.
