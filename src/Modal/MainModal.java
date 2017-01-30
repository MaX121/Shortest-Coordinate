package Modal;

import java.util.HashMap;
import java.util.ArrayList;
import distance_measurement.Controller.DistanceMeasurement;

public class MainModal {

    private int nrofBread = 0;
    private static final int MAX_BREAD_EACH_CAR = 6;
    private static final int MAX_THRESHOLD_SAVE = 2;
    private ArrayList<String> cityOnly = new ArrayList<>();
    private DistanceMeasurement distance = new DistanceMeasurement();
    private HashMap<String, Integer> breadTransport = new HashMap<>();
    private HashMap<String, Integer> carBreadTransport = new HashMap<>();

    public void addCity(String city, int jlhRoti) {

        // add city to an ArrayList and a HashMap
        // the HashMap contain the number of bread and its destination
        // while the ArrayList store the destination city

        cityOnly.add(city);
        breadTransport.put(city, jlhRoti);

    }

    public void transport() {
        for (HashMap.Entry<String, Integer> carTransport : breadTransport.entrySet()) {

            if (carTransport.getValue() > MAX_BREAD_EACH_CAR) {

                int nrofCarEachCity = (int) carTransport.getValue() / MAX_BREAD_EACH_CAR;

                // if the bread still have spare and less or equal to two, the next
                // car that can store the bread will handle the distribution. It means
                // the spare will be added into the next car's storage

                // the temp words at the first quote will be remove at the last of
                // this code. The temp words is only used to differentiate with the
                // current city

                int bread_spare = carTransport.getValue() - (nrofCarEachCity * MAX_BREAD_EACH_CAR);
                if (bread_spare <= MAX_THRESHOLD_SAVE) {
                    carBreadTransport.put("temp - " + carTransport.getKey(), bread_spare);
                }

                carBreadTransport.put(carTransport.getKey(), nrofCarEachCity);
            }

        }
    }

}
