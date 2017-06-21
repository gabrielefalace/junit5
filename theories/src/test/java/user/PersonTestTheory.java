package user;

import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class PersonTestTheory {

    private Person person;

    @DataPoint
    public static int newBorn = 0, underAge = 14, rightAge = 21, tooOld = 155;

    @DataPoint
    public static boolean badHealth = false, goodHealth = true;

    @Before
    public void init() {
        person = new Person();
    }

    @Theory
    public void testUserCanDrive(int age, boolean health) {
        System.out.println("Trying age:" + age + " and health:" + health);
        person.setAge(age);
        person.setGoodHealth(health);
        assumeTrue(person.getAge() >= 18 && person.getAge() <= 100);
        assumeTrue(person.isGoodHealth());
        assertTrue(person.canDrive());
    }

    @Theory
    public void testUserCannotDrive(int age) {
        person.setAge(age);
        assumeFalse(person.getAge() >= 18 && person.getAge() <= 100);
        assertFalse(person.canDrive());
    }

    @Theory
    public void testUserCannotDriveBecauseOfHealth(boolean health) {
        person.setGoodHealth(health);
        assumeFalse(person.isGoodHealth());
        assertFalse(person.canDrive());
    }

}