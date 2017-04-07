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

    // store the data
    private String first_city = null;
    private String current_city = null;
    private List <String> actual_route = new ArrayList<String>();
    private Map <String, String> cityName = new HashMap<>();
    private Map <String, Integer> route = new TreeMap<String, Integer>(Collections.reverseOrder());

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
        CellReference cellReference = new CellReference(cellCoor);
        workbook.close();
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

    }

    public String terpendek(ArrayList<String> cityList) throws Exception {

        // set the initial map as storage on this method
        // this map will contain the distribution and its distance from start
        // the distributor and its distance will store in this variable

        HashMap<String, Integer> distance_map = new HashMap<String, Integer>();

        // adding city to actual route arraylist
        // adding city and its distributor distance
        // to the distance_map for determine which
        // city will be crossed first

        for (int i = 0; i < cityList.size(); i++) {
            if (getValue(distributor(cityList.get(i))) == "") { distance_map.put(cityList.get(i), 0); }
            else { distance_map.put(cityList.get(i), Integer.parseInt(getValue(distributor(cityList.get(i))))); }
        }

        // add the shortest distributor to the arraylist
        // set the starting point to the current distributor
        // blacklist the city to the visited city for prevent
        // the salesman return to the previous city
        // seek for the shortest city around the sales to
        // continue the delivery

        int pointer = 0;
        for (Map.Entry<String, Integer> eachCity : distance_map.entrySet()) { actual_route.add(eachCity.getKey()); }
        for (Map.Entry<String, Integer> cityMap : distance_map.entrySet()) {

            if (pointer == 0) {

                // seek for the nearest distributor and go to there
                // the nearest distance must not be zero

                int temp = MAXIMUM;

                for (Map.Entry<String, Integer> cityCityMap : distance_map.entrySet()) {
                    if (temp > cityCityMap.getValue() && cityCityMap.getValue() != 0) {
                        temp = cityCityMap.getValue();
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

                String cityRoute = ""; // store the crossed route to reach the destination
                for (int index = 0; index < cityList.size(); index++) { cityRoute += cityList.get(index) + " - "; }
                shortestPath(cityList);

            }

            pointer++;

        }

        route.put(current_city + " - " + first_city, Integer.parseInt(getValue(intersectPoint(current_city, first_city))));

        // set the empty string for return value
        int indeks = 0;
        String firstCity = "";
        List <String> sorted = new ArrayList<>();

        for (String string : route.keySet()) {
            if (indeks == 0) {
                sorted.add(string);
                firstCity = string.split(" - ")[1];
            } else if (indeks < cityList.size()) {
                for (String strings : route.keySet()) {
                    if (sorted.size() != cityList.size()) {
                        if (strings.split(" - ")[0].equals(firstCity)) {
                            sorted.add(strings);
                            firstCity = strings.split(" - ")[1];
                        }
                    }
                }
            }

            indeks++;

        }

        // change address from C XX to City name
        cityName.put("C 11", "BT PN");
        cityName.put("C 12", "Bu Ripto");
        cityName.put("C 13", "Bu Endah");
        cityName.put("C 14", "Bu Mamik");
        cityName.put("C 15", "Bu Heni");
        cityName.put("C 16", "Pak Mujiyono");
        cityName.put("C 17", "Mbak Ismi");
        cityName.put("C 18", "Mbak Miranda");
        cityName.put("C 19", "Happy Juice");
        cityName.put("C 20", "Potong Rambut");
        cityName.put("C 21", "Bu Sulami");
        cityName.put("C 22", "Bu Wiwik");
        cityName.put("C 23", "Ny Suyatmin");
        cityName.put("C 24", "Bu Yayuk");
        cityName.put("C 25", "Bu Suhari");
        cityName.put("C 26", "Bu Nita");
        cityName.put("C 27", "Pak Adam");
        cityName.put("C 28", "Bu Karni");
        cityName.put("C 29", "Bu Sugiyem");
        cityName.put("C 30", "Mbak Septi");
        cityName.put("C 31", "Bu Surip");
        cityName.put("C 32", "Bu Waluyo");
        cityName.put("C 33", "Mas Ragil");
        cityName.put("C 34", "Bu Jum");
        cityName.put("C 35", "Bu Murni");
        cityName.put("C 36", "Bu Maryani");
        cityName.put("C 37", "Bu Sri Sukarti");
        cityName.put("C 38", "Mas Damar");
        cityName.put("C 39", "Bu Supardi");
        cityName.put("C 40", "Pak Broto");

        int indeksu = 0;
        int distanceTotal = 0;
        String late_city = "";
        String routes = "";
        for (String string : sorted) {
            if (indeksu == 0) {
                routes += "Distributor";
                distanceTotal += Integer.parseInt(getValue(distributor(string.split(" - ")[1])));
            } else {
                String first = string.split(" - ")[0];
                String last = string.split(" - ")[1];
                late_city = last;
                distanceTotal += Integer.parseInt(getValue(intersectPoint(first, last)));
                routes += " - " + cityName.get(first);
            }
            indeksu++;
        }

        routes += " - " + cityName.get(late_city) + " - Distributor";
        distanceTotal += Integer.parseInt(getValue(distributor(late_city)));

        /* String distanceCost = "";
        String latest_city = "";
        for (int routeIndex = 0; routeIndex < sorted.size(); routeIndex++) {
            if (routeIndex == 0) {
                String first_city = sorted.get(routeIndex).split(" - ")[1];
                int distance = Integer.parseInt(getValue(distributor(first_city)));
                distanceCost += "Distributor - " + cityName.get(first_city) + " : " + distance + "\n";
            } else if (routeIndex != 0 && routeIndex != sorted.size()-1) {
                String first_city = sorted.get(routeIndex).split(" - ")[0];
                String last_city = sorted.get(routeIndex).split(" - ")[1];
                int distance = Integer.parseInt(getValue(intersectPoint(first_city, last_city)));
                latest_city = last_city; // set the latest city that will back to the DIST
                distanceCost += cityName.get(first_city) + " - " + cityName.get(last_city) + " : " + distance + "\n";
            } else if (routeIndex == sorted.size()-1) {
                int distance = Integer.parseInt(getValue(distributor(latest_city)));
                distanceCost += cityName.get(latest_city) + " - Distributor : " + distance + "\n";
            }
        } */

        System.out.println(routes);
        // return routes + " = "  + distanceTotal;
        return null;

    }

}