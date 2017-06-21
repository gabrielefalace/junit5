package user;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class PersonTestClassic {

    private Person person;

    private int[] allowed = new int[]{21};

    private int[] notAllowed = new int[]{0, 14, 155};

    private boolean[] healthStatuses = new boolean[]{true, false};

    @Before
    public void init() {
        person = new Person();
    }


    @Test
    public void testUserCanDrive() {
        for (int age : allowed) {
            for (boolean healthStatus : healthStatuses) {
                person.setAge(age);
                person.setGoodHealth(healthStatus);
                if (healthStatus) {
                    assertTrue(person.canDrive());
                } else {
                    assertFalse(person.canDrive());
                }
            }
        }
    }

    @Test
    public void testUserCannotDriveBecauseOfAge() {
        for (int age : notAllowed) {
            person.setAge(age);
            assertFalse(person.canDrive());
        }
    }

    @Test
    public void testUserCannotDriveBecauseOfHealth() {
        person.setGoodHealth(false);
        assertFalse(person.canDrive());
    }
}
