package com.falace.nested;

public class Car {

    private FuelSource fuelSource = FuelSource.GAS;

    private int engineSize = 1000;

    Car(FuelSource source){
        this.fuelSource = source;
    }

    Car(FuelSource source, int engineSize){
        this.fuelSource = source;
        this.engineSize = engineSize;
    }

    int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    FuelSource getFuelSource() {
        return fuelSource;
    }

    void setFuelSource(FuelSource fuelSource) {
        this.fuelSource = fuelSource;
    }
}
