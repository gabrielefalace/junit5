package com.falace.nested;


class PollutionOffice {

    Badge assignBadge(Car car){
        switch (car.getFuelSource()){
            case ELECTRIC:
                return Badge.GREEN;
            case GAS:
            default:
                return car.getHorsepower()>120? Badge.RED : Badge.GREEN;
        }
    }

}
