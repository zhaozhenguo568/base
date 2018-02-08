package cn.cisdom.base.sms.utils;

import cn.cisdom.base.sms.config.AppConfig;
import cn.cisdom.base.sms.lib.MESSAGEXsend;

import java.util.Random;

/**
 * Created by zhenglee on 2017/7/24.
 */
public class SmsUtils {

    /**
     * 生成短信验证码
     */
    public static int generateSmsCode() {
        Random r = new Random();
        return 100000 + r.nextInt(999999 - 100000);
    }

    /**
     * 生成短信验证码
     */
    public static boolean messageXSend(String mobile, String content) {
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
        MESSAGEXsend submail = new MESSAGEXsend(config);
        submail.addTo(mobile);
        submail.setProject("TFFeS1");
        submail.addVar("code", content);
        return submail.xsend();
    }
}
