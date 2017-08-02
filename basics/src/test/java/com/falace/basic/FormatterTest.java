package com.falace.basic;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("formatting")
class FormatterTest {

    private Formatter formatter = new Formatter();

    @Test
    @DisplayName("Formatting succeeds when no field is blank")
    void testFormattingSuccess() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("Joe.Doe@mail.com");
        user.setTelephone("+3912345678910");

        User formattedUser = formatter.format(user);

        Assertions.assertAll(
                () -> Assertions.assertEquals("john", formattedUser.getFirstName()),
                () -> Assertions.assertEquals("doe", formattedUser.getLastName()),
                () -> Assertions.assertEquals("joe.doe@mail.com", formattedUser.getEmail())
        );
    }


}




                    