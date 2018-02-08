package cn.cisdom.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties工具类
 *
 * @author zhenglee
 *
 */
public class PropertiesUtils {

    //根据Key读取Value
    public static String getValueByKey(String fileName, String key) {
        Properties pps = new Properties();
        try {
            InputStream in = PropertiesUtils.class.getResourceAsStream(fileName);
            pps.load(in);
            String value = pps.getProperty(key);
            System.out.println(key + " = " + value);
            return value;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
