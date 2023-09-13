# Übungsblatt: Kontrollfluss-Strukturen
[Link to English version](./README_en.md)

In diesem Übungsblatt üben Sie verschiedene Kontrollflussstrukturen.

## Übung: Achterbahn

Das Paket `de.phl.programmingproject.rollercoaster` enthält eine `Person` Klasse und eine `RollerCoaster` Klasse.
Die `RollerCoaster` Klasse hat eine `boolean isEligibleToRide(final Person person)` Operation, die ein `Person` Objekt nimmt und überprüft, ob die Person berechtigt ist, die Achterbahn zu fahren.
Alleine berechtigt sind Personen, die mindestens 12 Jahre alt und 1,5 Meter groß sind.
Personen, die mindestens 10 Jahre alt und 1,3 Meter groß sind, sind ebenfalls berechtigt, benötigen aber einen Erwachsenen.
Personen, die jünger als 10 Jahre alt oder kleiner als 1,3 Meter sind, sind überhaupt nicht berechtigt, die Achterbahn zu fahren.

### Aufgaben

1. Implementieren Sie die `isElidibleToRide` Operation entsprechend den Kriterien.
    - **Beachten Sie**, dass `height` in Zentimetern implementiert ist!
2. Diskutieren Sie, ob die Operation in der Lage ist, die Kriterien in vollem Umfang hinsichtlich der Rückgabewerte zu erfüllen.
3. Überlegen Sie sich eine bessere Lösung und implementieren Sie diese in der Methode `isEligibleToRideImproved`.

## Übung: Summe der Primzahlen

Ihre Aufgabe besteht darin, ein Programm zu schreiben, das die Summe der ersten `n` Primzahlen berechnet, 
wobei `n` auf 20 gesetzt ist. Eine Primzahl ist eine Zahl, die nur durch 1 und sich selbst ohne Rest teilbar ist.

### Aufgaben

1. Implementieren Sie die Operation `boolean isPrime(final int n)`, die sich in der Klasse `MathHelper` des Pakets `de.phl.programmingproject.math` befindet.
2. Schreiben Sie ein Java-Programm in der Klasse `MathHelper`, das mit einer `while`-Schleife die Summe der ersten 20 Primzahlen berechnet.
3. Geben Sie die Summe der ersten 20 Primzahlen auf der Konsole aus.


## Übung: Summe der Ziffern

Sie wurden beauftragt, ein Java-Programm zu schreiben, das eine Operation namens `int calculateSumOfDigits(final int number)` beinhaltet.
Die Operation nimmt eine positive Ganzzahl `n` und berechnet die Summe ihrer Ziffern.
Zum Beispiel ist die Summe der Ziffern der Zahl `1234` `1 + 2 + 3 + 4 = 10`.
Achten Sie auf mögliche Vorbedingungen.
Implementieren Sie das Programm Implement in der `MathHelper` Klasse im `de.phl.programmingproject.math` Paket.

### Aufgaben

1. Implementieren Sie die Operation `calculateSumOfDigits`, um die Summe der Ziffern der Zahl `867194` mit einer `while`-Schleife zu berechnen.
2. Geben Sie die Summe der Ziffern, die von der Operation `calculateSumOfDigits` berechnet wurde, in der Konsole aus.
3. Implementieren Sie eine Operation `Set<Integer> calculateReverseSumOfDigits(final int number)`, die die möglichen Zahlen berechnet (reverse-engineering), für die `number` die Summe der Ziffern ist, und geben sie als `Set` zurück. Sie müssen nur die Zahlen bis 10000 berücksichtigen.

