package View;

import distance_measurement.Controller.DistanceMeasurement;

import java.util.ArrayList;

public class MainTestDistance {

    public static void main(String[] args) throws Exception {

        DistanceMeasurement distance = new DistanceMeasurement();
        ArrayList <String> cityList = new ArrayList<>();
        cityList.add("C 11");
        cityList.add("C 13");
        cityList.add("C 20");

        distance.terpendek(cityList);

    }


}
