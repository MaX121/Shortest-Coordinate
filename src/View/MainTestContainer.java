package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainTestContainer {

    private static final int MAX_CONTAINER = 6;

    public static void main(String[] args) {

        HashMap<String, Integer> carContainer = new HashMap();
        HashMap<String, Integer> carTransport = new HashMap();
        HashMap<String, Integer> carTemporary = new HashMap();
        HashMap<String, Integer> actualCarRoute = new HashMap();

        carContainer.put("A", 12);
        carContainer.put("B", 17);
        carContainer.put("C", 20);
        carContainer.put("F", 19);

        int roti_sisa = 0;
        for (Map.Entry<String, Integer> car : carContainer.entrySet()) {
            int current = car.getValue();
            int car_need = (int) current / MAX_CONTAINER;
            carTransport.put("Dist + " + car.getKey(), car_need * MAX_CONTAINER);

            int sisa = current - (car_need * MAX_CONTAINER);
            if (sisa > 0) {
                carTemporary.put(car.getKey(), sisa);
                roti_sisa += sisa;
            }
        }

        String tempCity = "";
        int tempQty = 0, pointer = 0;

        for (Map.Entry <String, Integer> keypair : carTemporary.entrySet()) {

            if (pointer == 0) {
                tempQty += keypair.getValue();
                tempCity += keypair.getKey();
            } else {
                int difference = MAX_CONTAINER - keypair.getValue();
                if (difference < tempQty) {
                    actualCarRoute.put("Dist + " + keypair.getKey() + " + " + tempCity, keypair.getValue() + difference);
                    tempQty  -= difference;
                    tempCity += " + " + keypair.getKey();
                } else {
                    actualCarRoute.put("Dist + " + keypair.getKey() + " + " + tempCity, keypair.getValue() + tempQty);
                    tempQty = 0;
                    tempCity = "";
                }

                difference = 0;
                carTemporary.remove(keypair);
            }
            pointer ++;
        }

        carTransport.putAll(actualCarRoute);
        for (Map.Entry <String, Integer> map : carTransport.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }

    }

}

