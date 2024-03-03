package cn.qiudev.tutorial.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 数值操作工具类
 */
public final class CastUtil {

    public static String castString(Object obj) {
        return castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue) {
        return null == obj ? defaultValue : String.valueOf(obj);
    }

    public static double castDouble(Object obj) {
        return castDouble(obj, 0d);
    }

    public static double castDouble(Object obj, double defaultValue) {
        if (null != obj) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    return Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    return defaultValue;
                }
            }
        }
        return defaultValue;
    }

}
