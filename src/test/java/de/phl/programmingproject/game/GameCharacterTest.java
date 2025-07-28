package de.phl.programmingproject.game;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the 'Game' exercise in {@link Person}, {@link de.phl.programmingproject.game.GameCharacter}, {@link de.phl.programmingproject.game.Ability}, and {@link de.phl.programmingproject.game.Main}
 */
class GameCharacterTest {

    @Test
    void task_1_enum_person_implemented() throws NoSuchFieldException, IllegalAccessException {
        Class<?> personEnumClazz = TestUtils.getClassForName("Person", "de.phl.programmingproject.game");
        assertTrue(personEnumClazz.isEnum(), "Person is not an enum");

        try {
            assertNotNull(personEnumClazz.getDeclaredField("name"));
        } catch (NoSuchFieldException e) {
            fail("Enum 'Person' does not contain a field 'name'");
        }

        Field nameField = personEnumClazz.getDeclaredField("name");
        nameField.setAccessible(true);

        // regex to match either Princess Peach or Prinzessin Peach
        String[] names = new String[]{"Mario", "Luigi", "Princess Peach|Prinzessin Peach", "Bowser"};
        for (String name : names) {
            // Check if the enum contains the values 'Mario', 'Luigi', 'Princess Peach', and 'Bowser'
            assertTrue(Arrays.stream(personEnumClazz.getEnumConstants()).anyMatch(person -> {
                        try {
                            return nameField.get(person).toString().matches(name);
                        } catch (IllegalAccessException e) {
                            fail("Field 'name' of enum 'Person' is not accessible");
                        }
                        return false;
                    }),
                    String.format("Enum 'Person' does not contain a value with name '%s'", name));
        }
    }

    @Test
    void task_2_enum_ability_implemented(){
        Class<?> abilityEnumClazz = TestUtils.getClassForName("Ability", "de.phl.programmingproject.game");
        assertTrue(abilityEnumClazz.isEnum(), "Ability is not an enum");

        // check that the values 'JUMP', 'RUN', 'FLOAT', and 'STOMP' exist in the enum
        String[] abilities = new String[]{"JUMP", "RUN", "FLOAT", "STOMP"};
        for (String ability : abilities) {
            assertTrue(Arrays.stream(abilityEnumClazz.getEnumConstants()).anyMatch(abilityEnum -> abilityEnum.toString().equals(ability)),
                    String.format("Enum 'Ability' does not contain the value '%s'", ability));
        }
    }

    @Test
    void task_3_game_characters_activate_ability_prints_correctly() throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> gameCharacterClass = TestUtils.getClassForName("GameCharacter", "de.phl.programmingproject.game");

        // get the enum 'Person' via reflection
        Class<?> personEnumClazz = TestUtils.getClassForName("Person", "de.phl.programmingproject.game");

        // get the enum with name 'MARIO'
        Object marioEnum = getEnumValue(personEnumClazz, "MARIO");

        // get the enum with value 'LUIGI'
        Object luigiEnum = getEnumValue(personEnumClazz, "LUIGI");

        // get the enum with value 'BOWSER'
        Object bowserEnum = getEnumValue(personEnumClazz, "BOWSER");

        // get the enum with value 'PRINCESS_PEACH'
        Object princessPeachEnum = getEnumValue(personEnumClazz, "PRINCESS_PEACH");

        // get the enum 'Ability' via reflection
        Class<?> abilityEnumClazz = TestUtils.getClassForName("Ability", "de.phl.programmingproject.game");

        // get the ability for values 'JUMP', 'RUN', 'FLOAT', and 'STOMP'
        Object jumpEnum = getEnumValue(abilityEnumClazz, "JUMP");
        Object runEnum = getEnumValue(abilityEnumClazz, "RUN");
        Object floatEnum = getEnumValue(abilityEnumClazz, "FLOAT");
        Object stompEnum = getEnumValue(abilityEnumClazz, "STOMP");

        // get the method 'activateAbility' with parameter 'Ability' via reflection
        Method activateAbilityMethod = null;
        try {
            activateAbilityMethod = gameCharacterClass.getDeclaredMethod("activateAbility", abilityEnumClazz);
        } catch (NoSuchMethodException e) {
            fail("The class 'GameCharacter' does not contain a method 'activateAbility' with a parameter of type 'Ability'");
        }

        // get the constructor of the class 'GameCharacter' via reflection
        Constructor gameCharacterConstructor = null;
        try {
            gameCharacterConstructor = gameCharacterClass.getConstructor(personEnumClazz);
        } catch (NoSuchMethodException e) {
            fail("The class 'GameCharacter' does not contain a constructor with a parameter of type 'Person'");
        }

        final Object mario = gameCharacterConstructor.newInstance(marioEnum);
        final Object luigi = gameCharacterConstructor.newInstance(luigiEnum);
        final Object peach = gameCharacterConstructor.newInstance(princessPeachEnum);
        final Object bowser = gameCharacterConstructor.newInstance(bowserEnum);


        String marioJumpMessage = activateAbilityMethod.invoke(mario, jumpEnum).toString();
        assertTrue(marioJumpMessage.contains("jumps higher than other persons"),
                "The method 'activateAbility' of the class 'GameCharacter' does not print the correct message for Mario's jump ability. The output was '"+ marioJumpMessage + "'");

        String luigiRunMessage = activateAbilityMethod.invoke(luigi, runEnum).toString();
        assertTrue(luigiRunMessage.contains("runs faster than other persons"),
                "The method 'activateAbility' of the class 'GameCharacter' does not print the correct message for Luigi's run ability. The output was '"+ luigiRunMessage + "'");

        String bowserStompMessage = activateAbilityMethod.invoke(bowser, stompEnum).toString();
        assertTrue(bowserStompMessage.contains("stomps on the ground to stun nearby enemies"),
                "The method 'activateAbility' of the class 'GameCharacter' does not print the correct message for Bowser's run ability. The output was '"+ bowserStompMessage + "'");

        String peachFloatMessage = activateAbilityMethod.invoke(peach, floatEnum).toString();
        assertTrue(peachFloatMessage.contains("Peach floats in the air for a short period of time"),
                "The method 'activateAbility' of the class 'GameCharacter' does not print the correct message for Peach's float ability. The output was '"+ peachFloatMessage + "'");
    }

    /**
     * Returns the enum value with the given name. It fails if the enum does not contain the value.
     * @param enumClazz
     * @param name
     * @return the enum value with the given name, or fails the test if the enum does not contain the value
     */
    static Object getEnumValue(Class<?> enumClazz, String name) {
        try {
            return enumClazz.getDeclaredField(name).get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            fail(String.format("Enum '%s' does not contain the value '%s'", enumClazz.getSimpleName(), name));
        }
        return null;
    }

}