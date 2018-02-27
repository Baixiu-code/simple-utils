package test;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenfanglin on 2017/6/12.
 */
public class TestReadExcel {
    public static List<Map<String, Object>> readExcel(String path) {
        try {
            InputStream is = new FileInputStream(path);
            XSSFWorkbook book = new XSSFWorkbook(is);
            List<Map<String, Object>> result = new ArrayList<>();
            List<String> headerList = new ArrayList<>();
            XSSFSheet sheet = book.getSheetAt(0);
            XSSFRow header = sheet.getRow(0);
            int rowMax = sheet.getLastRowNum();
            int colMax = header.getLastCellNum();
            for (int index = 0; index < colMax; index++) {
                headerList.add(header.getCell(index).toString());
            }
            for (int row = 1; row <= rowMax; row++) {
                XSSFRow xssfRow = sheet.getRow(row);
                Map<String, Object> map = new HashMap<>();
                for (int index = 0; index < colMax; index++) {
                    XSSFCell cell = xssfRow.getCell(index);
                    if (cell == null) {
                        map.put(headerList.get(index), "");
                        continue;
                    }
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                        short format = cell.getCellStyle().getDataFormat();
                        SimpleDateFormat sdf = null;
                        if (format == 14 || format == 31 || format == 57 || format == 58 || format == 177) {
                            //日期
                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                        } else if (format == 20 || format == 32) {
                            //时间
                            sdf = new SimpleDateFormat("HH:mm");
                        } else {
                            System.out.print("====>" + xssfRow.getCell(index).toString());
                            map.put(headerList.get(index),xssfRow.getCell(index).toString());
                            continue;
                        }
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil.getJavaDate(value);
                        map.put(headerList.get(index), sdf.format(date));
                    } else {
                        map.put(headerList.get(index), xssfRow.getCell(index).toString());
                    }
                }
                result.add(map);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        List<Map<String,Object>> dataList= readExcel("/Users/chenfanglin/Desktop/batch_update_settle.xlsx");
        System.out.println("start loading");
        for(Map<String,Object> data:dataList){
            System.out.println(data.get("orderNo").toString());
        }
    }
}
