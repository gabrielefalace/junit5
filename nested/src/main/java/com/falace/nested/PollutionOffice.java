package com.falace.nested;


class PollutionOffice {

    Badge assignBadge(Car car){
        switch (car.getFuelSource()){
            case ELECTRIC:
                return Badge.GREEN;
            case GAS:
            default:
                return car.getEngineSize()>4000? Badge.RED : Badge.GREEN;
        }
    }

}
