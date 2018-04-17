package File;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/2/11 14:46
 */
public class Excel2Json {
    public static void main(String[] args) throws IOException {
        String path = "/Users/leon/Downloads/简简办公数据埋点.xlsx";
        File srcFile = new File(path);
        FileInputStream in = null;
        StringBuilder sb = new StringBuilder();
        if (srcFile.exists()) {
            Workbook workbook = null;
            try {
                in = new FileInputStream(srcFile);
                workbook = WorkbookFactory.create(in);
                Sheet sheet = workbook.getSheetAt(4);
                Row row = null;
                Cell cell = null;
                int index = 1;
                for (int rowIndex = 6; rowIndex < 107; rowIndex++) {
                    row = sheet.getRow(rowIndex);
                    //		            sb.append("{name:"+row.getCell(1)+"data_ilog:"+row.getCell(2)+"},");
                    if (row.getCell(2)!=null&&StringUtils.isNotBlank(row.getCell(2).toString())){
    
                        sb.append(String.format("{name:\"%s\",data_ilog:\"%s\",index:%d},", row.getCell(1), row.getCell(2), index));
                        index++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
            System.out.println(sb.toString());
        }
    }
}
