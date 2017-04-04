package Modal;

import java.util.List;
import java.util.ArrayList;

public class Kota {

    private List <Kota> kotaList = new ArrayList<>();
    private String cityName;
    private int distance;

    public Kota() {
        // empty constructor
    }

    public Kota(String cityName, int distance) {
        this.cityName = cityName;
        this.distance = distance;
    }

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getDistance() { return distance; }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void addCity(String cityName, int distance) {
        Kota kota = new Kota();
        kota.setCityName(cityName);
        kota.setDistance(distance);
        kotaList.add(kota);
    }
}
