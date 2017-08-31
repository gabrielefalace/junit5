package com.falace.nested;

public class Car {

    private FuelSource fuelSource = FuelSource.GAS;

    private int horsepower = 1000;

    Car(FuelSource source){
        this.fuelSource = source;
    }

    Car(FuelSource source, int horsepower){
        this.fuelSource = source;
        this.horsepower = horsepower;
    }

    int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    FuelSource getFuelSource() {
        return fuelSource;
    }

    void setFuelSource(FuelSource fuelSource) {
        this.fuelSource = fuelSource;
    }
}
