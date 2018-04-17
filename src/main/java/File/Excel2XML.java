package File;

import jodd.util.StringUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by yang.zhang on 2017/3/24.
 */
public class Excel2XML {
    public static void main(String[] args) {
        String srcName = "E:\\test\\src.xlsx";
        File srcFile = new File(srcName);
        FileInputStream in = null;
        StringBuilder stringBuilder = new StringBuilder();
        if(srcFile.exists()){
            Workbook workbook = null;
            try {
                in = new FileInputStream(srcFile);
                workbook = WorkbookFactory.create(in);
                Sheet sheet = workbook.getSheetAt(1);
                Row row = null;
                Cell cell = null;
                //2-72行读，2-30列
                for(int rowIndex = 1;rowIndex<72;rowIndex++){
                    row = sheet.getRow(rowIndex);
                    stringBuilder.append("<age_"+(rowIndex-1)+">");
                    for (int colIndex = 1;colIndex<30;colIndex++){
                        cell = row.getCell(colIndex);
                        String cellValue = ((XSSFCell) cell).getRawValue();
                        if (StringUtil.isNotBlank(cellValue)){
                            stringBuilder.append("<cover_"+(colIndex+1)+">"+cellValue+"</cover_"+(colIndex+1)+">");
                        }
                    }
                    stringBuilder.append("</age_"+(rowIndex-1)+">");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
