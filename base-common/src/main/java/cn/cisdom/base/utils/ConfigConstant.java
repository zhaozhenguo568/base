package cn.cisdom.base.utils;

import java.io.File;

/**
 * 系统参数相关Key
 *
 * @author zhenglee
 */
public class ConfigConstant {
    /**
     * debug switch
     */
    public static final boolean IS_DEBUG = false;
    /**
     * api Salt
     */
    public static final String API_SALT = "iamlizhengcoder";
    /**
     * 云存储配置KEY
     */
    public final static String CLOUD_STORAGE_CONFIG_KEY = "CLOUD_STORAGE_CONFIG_KEY";
    /**
     * 文件存储服务器路径
     */
    public final static String BASE_FILE_PATH = "E:" + File.separator + "order" + File.separator + "orderweb" + File.separator + "orderimages" + File.separator;
}
