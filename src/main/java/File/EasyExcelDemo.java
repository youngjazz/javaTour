package File;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author leon
 * @date 2018/11/15
 */
public class EasyExcelDemo {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            System.out.println("start read inputStream");
            inputStream = new FileInputStream("/Users/leon/temp/续保名单分配优化测试_20181115.xls");
            ExcelLisener lisener = new ExcelLisener();
            EasyExcelFactory.readBySax(inputStream, new Sheet(1,1), lisener);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
