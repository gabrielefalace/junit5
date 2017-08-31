
package com.falace.nested;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PollutionOfficeTest {


    private PollutionOffice office = new PollutionOffice();

    @Nested
    class CaseElectric {

        Car electricCar = new Car(FuelSource.ELECTRIC);


        @Test
        @DisplayName("Electric car always get a GREEN badge")
        void testSmallElectric() {
            electricCar.setHorsepower(65);
            Badge badge = office.assignBadge(electricCar);
            Assertions.assertEquals(Badge.GREEN, badge);
        }

        @Test
        @DisplayName("Electric car always get a GREEN badge")
        void testBigElectric() {
            electricCar.setHorsepower(250);
            Badge badge = office.assignBadge(electricCar);
            Assertions.assertEquals(Badge.GREEN, badge);
        }

    }

    @Nested
    class CaseGas {

        Car gasCar = new Car(FuelSource.GAS);

        @Test
        @DisplayName("Small gas fueled cars get a GREEN badge")
        void testSmallGasCar() {
            gasCar.setHorsepower(65);
            Badge badge = office.assignBadge(gasCar);
            Assertions.assertEquals(Badge.GREEN, badge);
        }

        @Test
        @DisplayName("Big gas fueled cars get a RED badge")
        void testBigGasCar() {
            gasCar.setHorsepower(250);
            Badge badge = office.assignBadge(gasCar);
            Assertions.assertEquals(Badge.RED, badge);
        }
    }

}



