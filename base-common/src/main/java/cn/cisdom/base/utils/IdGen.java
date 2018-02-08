package cn.cisdom.base.utils;

import cn.cisdom.base.sms.utils.SmsUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhenglee on 2017/12/6.
 */
public class IdGen {

    public static String GenId(){
//        SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss");
//        String id = format.format(new Date()) + SmsUtils.generateSmsCode();
        String id = String.valueOf(System.currentTimeMillis() + Thread.currentThread().getId() + SmsUtils.generateSmsCode());
        return id;
    }

}
