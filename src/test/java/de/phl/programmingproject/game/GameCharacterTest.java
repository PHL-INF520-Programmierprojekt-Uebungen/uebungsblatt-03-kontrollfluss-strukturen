package de.phl.programmingproject.game;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the 'Game' exercise in {@link Person}, {@link de.phl.programmingproject.game.GameCharacter}, {@link de.phl.programmingproject.game.Ability}, and {@link de.phl.programmingproject.game.Main}
 */
class GameCharacterTest {

    @Test
    void task_1_enum_person_implemented() throws NoSuchFieldException, IllegalAccessException {
        Class<?> personEnumClazz = getClassForName("Person", "de.phl.programmingproject.game");
        assertTrue(personEnumClazz.isEnum(), "Person is not an enum");

        try {
            assertNotNull(personEnumClazz.getDeclaredField("name"));
        } catch (NoSuchFieldException e) {
            fail("Enum 'Person' does not contain a field 'name'");
        }

        Field nameField = personEnumClazz.getDeclaredField("name");
        nameField.setAccessible(true);

        String[] names = new String[]{"Mario", "Luigi", "Princess Peach", "Bowser"};
        for (String name : names) {
            // Check if the enum contains the values 'Mario', 'Luigi', 'Princess Peach', and 'Bowser'
            assertTrue(Arrays.stream(personEnumClazz.getEnumConstants()).anyMatch(person -> {
                        try {
                            return nameField.get(person).equals(name);
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
        Class<?> abilityEnumClazz = getClassForName("Ability", "de.phl.programmingproject.game");
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

        Class<?> gameCharacterClass = getClassForName("GameCharacter", "de.phl.programmingproject.game");

        // get the enum 'Person' via reflection
        Class<?> personEnumClazz = getClassForName("Person", "de.phl.programmingproject.game");

        // get the enum with name 'MARIO'
        Object marioEnum = getEnumValue(personEnumClazz, "MARIO");

        // get the enum with value 'LUIGI'
        Object luigiEnum = getEnumValue(personEnumClazz, "LUIGI");

        // get the enum with value 'BOWSER'
        Object bowserEnum = getEnumValue(personEnumClazz, "BOWSER");

        // get the enum with value 'PRINCESS_PEACH'
        Object princessPeachEnum = getEnumValue(personEnumClazz, "PRINCESS_PEACH");

        // get the enum 'Ability' via reflection
        Class<?> abilityEnumClazz = getClassForName("Ability", "de.phl.programmingproject.game");

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

        assertEquals("Mario jumps higher than other persons!", activateAbilityMethod.invoke(mario, jumpEnum));
        assertEquals("Luigi runs faster than other persons", activateAbilityMethod.invoke(luigi, runEnum));
        assertEquals("Peach floats longer than other persons", activateAbilityMethod.invoke(peach, floatEnum));
        assertEquals("Bowser stomps harder than other persons", activateAbilityMethod.invoke(bowser, stompEnum));
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

    /**
     * Returns the {@link Class<?>} with the given name in the given package. It fails if the class does not exist.
     * @param className
     * @param packageName
     * @return the {@link Class<?>} with the given name in the given package, or fails the test if the class does not exist
     */
    static Class<?> getClassForName(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className);
        } catch (ClassNotFoundException e) {
            fail(String.format("Class '%s' does not exist in the package '%s'", className, packageName));
        }
        return null;
    }
}