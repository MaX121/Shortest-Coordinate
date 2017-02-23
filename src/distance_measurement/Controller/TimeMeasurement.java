package distance_measurement.Controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class TimeMeasurement {

    // where the data stored
    private static final File FILE = new File("dataJWfix.xlsx");
    private static final int MAXIMUM = Integer.MAX_VALUE;

    // input :: city name
    // return a row coordinate of a cell

    public String rowCoordinate(String target) throws Exception {
        int index = 0;
        XSSFRow row = null;
        String foundCell[] = new String[2];
        FileInputStream fileInputStream = new FileInputStream(FILE);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(1);
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
        XSSFSheet sheet = workbook.getSheetAt(1);
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
        XSSFSheet sheet = workbook.getSheetAt(1);
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

}
