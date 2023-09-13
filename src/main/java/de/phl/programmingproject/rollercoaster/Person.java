package de.phl.programmingproject.rollercoaster;

/**
 * A person that wants to ride the roller coaster.
 */
public class Person {
    /**
     * Age of the person in years.
     */
    private final int age;
    /**
     * Height of the person in centimeters.
     */
    private final int height;

    /**
     * Creates a new person.
     *
     * @param age The age of the person in years.
     * @param height The height of the person in centimeters.
     * @throws IllegalArgumentException if the age or height is negative.
     */
    public Person(final int age, final int height) {
        if (age < 0 || height < 0) {
            throw new IllegalArgumentException("Age and height must be positive!");
        }
        this.age = age;
        this.height = height;
    }

    /**
     * Returns the age of the person in years.
     * @return the age of the person in years.
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the height of the person in centimeters.
     * @return the height of the person in centimeters.
     */
    public int getHeight() {
        return height;
    }

}
