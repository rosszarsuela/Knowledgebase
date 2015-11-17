package com.oris.util;

import org.apache.log4j.Logger;

public final class StrUtil {

    private static final String REPLACE_PREFIX = "\\$\\{";
    private static final String REPLACE_SUFFIX = "\\}";

    private static final transient Logger log = Logger.getLogger(StrUtil.class);

    private StrUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String asStr(String str) {
        return StrUtil.asStr(str, "");
    }

    public static String asStr(String str, String defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        } else {
            return str;
        }
    }

    public static Boolean asBool(String str) {
        return StrUtil.asBool(str, false);
    }

    public static Boolean asBool(String str, Boolean defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        }

        try {
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            StrUtil.log.warn("Cannot convert string value to boolean. str=" + str);
            return defaultVal;
        }
    }

    public static Long asLong(String str) {
        return StrUtil.asLong(str, 0L);
    }

    public static Long asLong(String str, Long defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        }

        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            StrUtil.log.warn("Cannot convert string value to long. str=" + str);
            return defaultVal;
        }
    }

    public static Integer asInt(String str) {
        return StrUtil.asInt(str, 0);
    }

    public static Integer asInt(String str, Integer defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        }

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            StrUtil.log.warn("Cannot convert string value to integer. str=" + str);
            return defaultVal;
        }
    }

    public static Byte asByte(String str) {
        return StrUtil.asByte(str, (byte) 0);
    }

    public static Byte asByte(String str, Byte defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        }

        try {
            return Byte.parseByte(str);
        } catch (Exception e) {
            StrUtil.log.warn("Cannot convert string value to byte. str=" + str);
            return defaultVal;
        }
    }

    public static Double asDouble(String str) {
        return StrUtil.asDouble(str, 0.0);
    }

    public static Double asDouble(String str, Double defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        }

        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            StrUtil.log.warn("Cannot convert string value to double. str=" + str);
            return defaultVal;
        }
    }

    public static Float asFloat(String str) {
        return StrUtil.asFloat(str, 0.0f);
    }

    public static Float asFloat(String str, Float defaultVal) {
        if (str == null || str.isEmpty()) {
            return defaultVal;
        }

        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            StrUtil.log.warn("Cannot convert string value to float. str=" + str);
            return defaultVal;
        }
    }

    public static String replaceFirst(String src, String key, Object value) {
        return src.replaceFirst(StrUtil.REPLACE_PREFIX + key + StrUtil.REPLACE_SUFFIX, value == null ? "" : value.toString());
    }

    public static String replaceAll(String src, String key, Object value) {
        return src.replaceAll(StrUtil.REPLACE_PREFIX + key + StrUtil.REPLACE_SUFFIX, value == null ? "" : value.toString());
    }
    
    public static String replaceAll(String src, String regex) {
        return src.replaceAll(regex, "");
    }
}