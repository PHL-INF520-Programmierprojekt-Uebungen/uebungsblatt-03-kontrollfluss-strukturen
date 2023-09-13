package de.phl.programmingproject.rollercoaster;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the 'Roller Coaster' exercise in {@link de.phl.programmingproject.rollercoaster.RollerCoaster}
 */
public class RollerCoasterTest {

    static RollerCoaster rollerCoaster;
    @BeforeAll
    static void setup(){
        rollerCoaster = new RollerCoaster();
    }
    @Test
    void person_older_than_12_and_taller_than_1_5_meters_eligible_to_ride() {
        Person eligiblePerson = new Person(13, 160);
        assertTrue(rollerCoaster.isEligibleToRide(eligiblePerson));
    }

    @Test
    void person_younger_than_10_but_taller_than_1_3_meters_eligible_with_adult(){
        Person eligibleWithAdult = new Person(10, 135);
        assertTrue(rollerCoaster.isEligibleToRide(eligibleWithAdult));
    }


    @Test
    void person_younger_than_10_not_eligible_to_ride(){
        Person tooYoung = new Person(9, 110);
        assertFalse(rollerCoaster.isEligibleToRide(tooYoung));
    }

    @Test
    void person_taller_than_1_3_meters_but_younger_than_10_not_eligible_to_ride(){
        Person tooYoung = new Person(9, 135);
        assertFalse(rollerCoaster.isEligibleToRide(tooYoung));
    }

    @Test
    void person_smaller_than_1_3_meters_not_eligible_to_ride(){
        Person tooSmall = new Person(13, 120);
        assertFalse(rollerCoaster.isEligibleToRide(tooSmall));
    }


}
