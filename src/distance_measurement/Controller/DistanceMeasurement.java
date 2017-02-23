package distance_measurement.Controller;

            /*==================================
            ---- https://github.com/MaX121/ ----
            admin [at] max [dash] metal [dot] us
            ==================================*/

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DistanceMeasurement {

    // TimeMeasurement object
    TimeMeasurement timeMeasurement = new TimeMeasurement();

    // where the data stored
    private static final File FILE = new File("dataJWfix.xlsx");
    private static final int MAXIMUM = Integer.MAX_VALUE;

    private HashMap <String, String> eachCityName = new HashMap<>();

    // store the data
    private int totalTime = 0;
    private int totalDistance = 0;
    private String first_city = null;
    private String current_city = null;
    private ArrayList<String> actual_route = new ArrayList<String>();
    private TreeMap <String, Integer> route = new TreeMap<String, Integer>(Collections.reverseOrder());
    private TreeMap <String, Integer> shortest_time = new TreeMap<String, Integer>(Collections.reverseOrder());

    // input :: city name
    // return a row coordinate of a cell

    public String rowCoordinate(String target) throws Exception {
        int index = 0;
        XSSFRow row = null;
        String foundCell[] = new String[2];
        FileInputStream fileInputStream = new FileInputStream(FILE);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        workbook.close();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().equals(target)) {
                    foundCell[index] = cell.getAddress().toString();
                    index++;
                }
            }
        }
        fileInputStream.close();
        return foundCell[0];
    }

    // input :: city name
    // return a cell coordinate

    public String cellCoordinate(String target) throws Exception {
        int index = 0;
        XSSFRow row = null;
        String foundCell[] = new String[2];
        FileInputStream fileInputStream = new FileInputStream(FILE);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        workbook.close();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().equals(target)) {
                    foundCell[index] = cell.getAddress().toString();
                    index++;
                }
            }
        }
        workbook.close();
        return foundCell[1];
    }

    // input :: the city name like "C 11" or "C 20"
    // return the distance from the distributor point to market

    public String distributor(String selected_cell) throws Exception {
        String cellCoor = cellCoordinate(selected_cell);
        FileInputStream fileInputStream = new FileInputStream(FILE);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        workbook.close();
        CellReference cellReference = new CellReference(cellCoor);
        return "AF" + cellReference.getCellRefParts()[1];
    }

    // input :: from which city and to which city
    // a cell from an intersection two cell as a String variable

    public String intersectPoint(String where, String from) throws Exception {
        String whereCell = cellCoordinate(where).replaceAll("[a-zA-Z]*", "");
        String fromCell = rowCoordinate(from).replaceAll("[0-9]*", "");
        return fromCell + whereCell;
    }

    // input :: cell coordinate
    // return the value of a cell

    public String getValue(String selected_cell) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(FILE);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        CellReference cellReference = new CellReference(selected_cell);
        workbook.close();
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        fileInputStream.close();
        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            int result = (int) cell.getNumericCellValue();
            return String.valueOf(result);
        } else {
            return cell.getStringCellValue();
        }
    }

    public void shortestPath(ArrayList<String> cityList) throws Exception {

        HashMap<String, Integer> store = new HashMap<String, Integer>();
        int shortest = MAXIMUM;
        String city = "";

        for (int i = 0; i < actual_route.size(); i++) {
            if (getValue(intersectPoint(current_city, actual_route.get(i))) != "") {
                store.put(actual_route.get(i), Integer.parseInt(getValue(intersectPoint(current_city, actual_route.get(i)))));
            }
        }

        // seek for the nearest distance
        // add into the actual_route array

        for (Map.Entry<String, Integer> eachCity : store.entrySet()) {
            if (shortest > eachCity.getValue()) {
                shortest = eachCity.getValue();
            }
        }

        // get name of the city

        for (Map.Entry<String, Integer> getKey : store.entrySet()) {
            if (getKey.getValue() == shortest) {
                city = current_city;
                current_city = getKey.getKey();
                actual_route.remove(getKey.getKey());
            }
        }

        route.put(city + " - " + current_city, shortest);
        shortest_time.put(city + " - " + current_city, Integer.parseInt(timeMeasurement.getValue(intersectPoint(city, current_city))));

    }

    public String terpendek(ArrayList<String> cityList) throws Exception {

        // set the empty string for return value
        String text = "";

        // set the initial map as storage on this method
        // this map will contain the distribution and its distance from start
        // the distributor and its distance will store in this variable

        HashMap<String, Integer> distance_map = new HashMap<String, Integer>();

        // adding city to actual route arraylist
        // adding city and its distributor distance
        // to the distance_map for determine which
        // city will be crossed first

        for (int i = 0; i < cityList.size(); i++) {
            if (getValue(distributor(cityList.get(i))) == "") {
                distance_map.put(cityList.get(i), 0);
            } else {
                distance_map.put(cityList.get(i), Integer.parseInt(getValue(distributor(cityList.get(i)))));
            }
        }

        // add the shortest distributor to the arraylist
        // set the starting point to the current distributor
        // blacklist the city to the visited city for prevent
        // the salesman return to the previous city
        // seek for the shortest city around the sales to
        // continue the delivery

        int pointer = 0;
        for (Map.Entry<String, Integer> eachCity : distance_map.entrySet()) {
            actual_route.add(eachCity.getKey());
        }

        for (Map.Entry<String, Integer> cityMap : distance_map.entrySet()) {

            if (pointer == 0) {

                // seek for the nearest distributor and go to there
                // the nearest distance must not be zero

                int temp = MAXIMUM;

                for (Map.Entry<String, Integer> cityCityMap : distance_map.entrySet()) {
                    if (temp > cityCityMap.getValue() && cityCityMap.getValue() != 0) {
                        temp = cityCityMap.getValue();
                        shortest_time.put("DIST - " + current_city, Integer.parseInt(timeMeasurement.getValue(distributor(cityCityMap.getKey()))));
                    }
                }

                // remove selected city from actual route to prevent looping
                // add the value of the distance to the total distance
                // display the nearest city and the distance from start

                for (Map.Entry<String, Integer> cityCityMap : distance_map.entrySet()) {
                    if (cityCityMap.getValue() == temp) {
                        first_city = cityCityMap.getKey();
                        current_city = cityCityMap.getKey();
                        actual_route.remove(cityCityMap.getKey());
                        route.put("DIST - " + current_city, temp);
                    }
                }

            } else {

                // seek for the nearest city from the current city
                // add the distance from current city to nearest city
                // set the new starting point and new total distance val
                // display the nearest city and the distance from starting pnt

                shortestPath(cityList);

            }

            pointer++;

        }

        route.put(current_city + " - " + first_city, Integer.parseInt(getValue(intersectPoint(current_city, first_city))));
        shortest_time.put(current_city + " - " + first_city, Integer.parseInt(timeMeasurement.getValue(intersectPoint(current_city, first_city))));

        // display the total distance from end to end delivery
        for (Map.Entry<String, Integer> routeList : route.entrySet()) { totalDistance += routeList.getValue(); }
        for (Map.Entry<String, Integer> timeList : shortest_time.entrySet()) { totalTime += timeList.getValue(); }

        // set the city name
        eachCityName.put("C 11", "BT PN");
        eachCityName.put("C 12", "Bu Ripto");
        eachCityName.put("C 13", "Bu Endah");
        eachCityName.put("C 14", "Bu Mamik");
        eachCityName.put("C 15", "Bu Heni");
        eachCityName.put("C 16", "Pak Mujiono");
        eachCityName.put("C 17", "Mbak Ismi");
        eachCityName.put("C 18", "Mbak Miranda");
        eachCityName.put("C 19", "Happy Juice");
        eachCityName.put("C 20", "Potong Rambut");
        eachCityName.put("C 21", "Bu Sulami");
        eachCityName.put("C 22", "Bu Wiwik");
        eachCityName.put("C 23", "Ny. Suyatmin");
        eachCityName.put("C 24", "Bu Yayuk");
        eachCityName.put("C 25", "Bu Suhari");
        eachCityName.put("C 26", "Bu Nita");
        eachCityName.put("C 27", "Pak Adam");
        eachCityName.put("C 28", "Bu Karni");
        eachCityName.put("C 29", "Bu Sugiyem");
        eachCityName.put("C 30", "Mbak Septi");
        eachCityName.put("C 31", "Bu Surip");
        eachCityName.put("C 32", "Bu Waluyo");
        eachCityName.put("C 33", "Mas Ragil");
        eachCityName.put("C 34", "Bu Jum");
        eachCityName.put("C 35", "Bu Murni");
        eachCityName.put("C 36", "Bu Maryani");
        eachCityName.put("C 37", "Bu Sri Sukarti");
        eachCityName.put("C 38", "Mas Damar");
        eachCityName.put("C 39", "Bu Supardi");
        eachCityName.put("C 40", "Pak Broto");

        // separate the key into a single line
        int index = 0;
        String pathCrossed = "";
        for (String eachCityTrack : route.keySet()) {
            if (index == 0) { pathCrossed += "DIST"; }
            else if (index != route.size()) { pathCrossed += " + " + eachCityName.get(eachCityTrack.split(" - ")[1]); }
            index++;
        }

        pathCrossed += " + DIST";
        return pathCrossed;

    }
}