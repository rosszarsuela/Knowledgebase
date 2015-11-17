package com.oris.util;

import java.util.Arrays;
import java.util.Collection;

public final class CollectionsUtil {

    private CollectionsUtil() {
    }

    public static String toDelimString(Object[] o, String delimeter) {
        return toDelimString(Arrays.asList(o), delimeter);
    }

    public static String toDelimString(Collection<?> c, String delimeter) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Object o : c) {
                sb.append(o).append(delimeter);
            }
        } catch (Exception e) {
            return "";
        }

        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - delimeter.length());
        } else {
            return "";
        }
    }
}