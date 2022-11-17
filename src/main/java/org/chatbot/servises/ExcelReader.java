package org.chatbot.servises;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.chatbot.Constants;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.chatbot.Constants.*;

public class ExcelReader {

    private static final Map<Integer, List<String>> xlsData = new HashMap<>();
    private static final Map<String, String> streetsMap = new HashMap<>();

    private void remap() {
        for (Map.Entry<Integer, List<String>> entry : xlsData.entrySet()) {
            Integer entryKey = entry.getKey();
            if (entryKey < 80) {
                addToNewMap(entry.getValue(), FIRST);
            } else if (entryKey < 207) {
                addToNewMap(entry.getValue(), SECOND);
            } else if (entryKey < 260) {
                addToNewMap(entry.getValue(), THIRD);
            } else if (entryKey < 372) {
                addToNewMap(entry.getValue(), FOURTH);
            } else if (entryKey < 638) {
                addToNewMap(entry.getValue(), FIFTH);
            } else if (entryKey < 873) {
                addToNewMap(entry.getValue(), SIXTH);
            } else if (entryKey < 1043) {
                addToNewMap(entry.getValue(), SEVENTH);
            } else if (entryKey < 1149) {
                addToNewMap(entry.getValue(), EIGHTH);
            } else if (entryKey < 1342) {
                addToNewMap(entry.getValue(), NINTH);
            } else if (entryKey < 1405) {
                addToNewMap(entry.getValue(), TENTH);
            } else if (entryKey < 1523) {
                addToNewMap(entry.getValue(), ELEVENTH);
            } else {
                addToNewMap(entry.getValue(), TWELFTH);
            }
        }
    }

    private void addToNewMap(List<String> entryValue, Constants contant) {
        String listToString = listToString(entryValue);
        streetsMap.put(listToString, contant.getValue());
    }

    private String listToString(List<String> stringList) {
        StringJoiner sj = new StringJoiner("; ");
        for (String str : stringList) {
            sj.add(str);
        }
        return sj.toString();
    }

    public Map<String, String> getStreetsMap() {
        remap();
        return streetsMap;
    }

    public void read(String filename) throws IOException {
        Workbook workbook = loadWorkbook(filename);
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            processSheet(sheet);
        }
    }

    private Workbook loadWorkbook(String filename) throws IOException {
        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
        try (FileInputStream file = new FileInputStream(filename)) {
            if (extension.equals("xls")) {
                return new HSSFWorkbook(file);
            } else {
                throw new IllegalArgumentException("Unknown Excel file extension: " + extension);
            }
        }
//        switch (extension) {
//            case "xls":
//                // old format
//                return new HSSFWorkbook(file);
//            case "xlsx":
//                // new format
//                return new XSSFWorkbook(file);
//            default:
//                throw new RuntimeException("Unknown Excel file extension: " + extension);
//        }
    }

    private void processSheet(Sheet sheet) {
        Iterator<Row> iterator = sheet.rowIterator();
        for (int rowIndex = 2; iterator.hasNext(); rowIndex++) {
            Row row = iterator.next();
            processRow(rowIndex, row);
        }
    }

    private void processRow(int rowIndex, Row row) {
        ExcelReader.xlsData.put(rowIndex, new ArrayList<>());
        for (Cell cell : row) {
            processCell(cell, ExcelReader.xlsData.get(rowIndex));
        }
    }

    private void processCell(Cell cell, List<String> dataRow) {
        int columnIndex = cell.getColumnIndex();
        if (columnIndex == 12) {
            dataRow.add(cell.getStringCellValue());
//            switch (cell.getCellType()) {
//                case STRING:
//                    dataRow.add(cell.getStringCellValue());
//                    break;
//                case NUMERIC:
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        dataRow.add(cell.getLocalDateTimeCellValue());
//                    } else {
//                        dataRow.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
//                    }
//                    break;
//                case BOOLEAN:
//                    dataRow.add(cell.getBooleanCellValue());
//                    break;
//                case FORMULA:
//                    dataRow.add(cell.getCellFormula());
//                    break;
//                default:
//                    dataRow.add(" ");
//            }
        }
    }
}
