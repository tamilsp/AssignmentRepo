package com.sampletest.gebtest.util

import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

/**
 * Created by tamils on 11/08/2016.
 */
class ReaderUtil {

    private XSSFSheet ExcelWSheet;
    private XSSFWorkbook ExcelWBook;
    private XSSFCell Cell;
    private XSSFRow Row;
    String excelData;

    ReaderUtil() {
        try {
            FileInputStream fis = new FileInputStream(new File("Testdata.xlsx"));
            ExcelWBook = new XSSFWorkbook(fis);
            ExcelWSheet = ExcelWBook.getSheetAt(0);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String getExcelValues(String CellName) {
        final DataFormatter df = new DataFormatter();
        Row = ExcelWSheet.getRow(0)
        for (int j = 0; j < Row.getLastCellNum(); j++) {
            Cell = ExcelWSheet.getRow(0).getCell(j)
            if (Cell.getStringCellValue().contentEquals(CellName)) {
                Cell = ExcelWSheet.getRow(1).getCell(j);
                excelData = df.formatCellValue(Cell)
                break;
            }
        }
        return excelData
    }


}
