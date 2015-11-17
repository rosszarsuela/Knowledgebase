/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oris.util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataFieldUtil {

    /*
     * Use to validate if one of the fields on a class that has a @DataField
     * annotation has value.
     */
    public static <T> boolean classHasNotEmptyField(T cls) {
        Class<?> clazz = cls.getClass();

        boolean hasNotEmptyField = false;

        try {
            Field[] fields = clazz.getDeclaredFields();

            for (Field f : fields) {
                Field field = clazz.getDeclaredField(f.getName());

                DataField dataField = field.getAnnotation(DataField.class);

                if (dataField != null) {

                    field.setAccessible(true);

                    Object o = field.get(cls);

                    if (o != null) {
                        DataField.FieldType fieldType = dataField.fieldType();

                        if (fieldType == DataField.FieldType.NUMBER) {
                            try {
                                if (Integer.parseInt(o.toString()) >= 0) {
                                    hasNotEmptyField = true;
                                    break;
                                }
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace(System.out);
                            }
                        } else if (fieldType == DataField.FieldType.BOOLEAN) {
                            if (Boolean.parseBoolean(o.toString())) {
                                hasNotEmptyField = true;
                                break;
                            }
                        } else {
                            if (!o.toString().isEmpty() && !o.toString().equals(" ")) {
                                hasNotEmptyField = true;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return hasNotEmptyField;
    }

    public static <T> List<String> validateUploadFields(T cls) {
        Class<?> clazz = cls.getClass();

        List<String> errorMessages = new ArrayList<String>();

        try {
            Field[] fields = clazz.getDeclaredFields();

            for (Field f : fields) {
                Field field = clazz.getDeclaredField(f.getName());

                DataField dataField = field.getAnnotation(DataField.class);

                if (dataField != null) {

                    field.setAccessible(true);

                    Object o = field.get(cls);

                    if (o != null) {
                        DataField.FieldType fieldType = dataField.fieldType();

                        if (fieldType == DataField.FieldType.NUMBER) {
                            try {
                                if (Double.parseDouble(o.toString()) < 0) {
                                    errorMessages.add("The " + dataField.fieldLabel() + " you have specified is invalid.");
                                }
                            } catch (NumberFormatException ex) {
                                errorMessages.add("The " + dataField.fieldLabel() + " you have specified is invalid.");

                                ex.printStackTrace(System.out);
                            }
                        } else if (fieldType == DataField.FieldType.DATE) {
                            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

                            try {
                                sdf.parse(o.toString());
                            } catch (ParseException e) {
                                errorMessages.add("The " + dataField.fieldLabel() + " you have specified is invalid.");

                                e.printStackTrace(System.out);
                            }
                        } else {
                            if (o.toString().isEmpty() || o.toString().equals(" ")) {
                                errorMessages.add(dataField.fieldLabel() + " is a required field.");
                            }
                        }
                    } else {
                        errorMessages.add(dataField.fieldLabel() + " is a required field.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return errorMessages;
    }

    @SuppressWarnings("deprecation")
	public static <T, S> void transfer(T cls1, S cls2) {

        Class<?> clazz1 = cls1.getClass();

        try {
            Field[] fields1 = clazz1.getDeclaredFields();

            for (Field field1 : fields1) {
                field1.setAccessible(true);

                Object value = field1.get(cls1);

                Class<?> clazz2 = cls2.getClass();

                try {
                    Field field2 = clazz2.getDeclaredField(field1.getName());

                    field2.setAccessible(true);

                    if (value == null || value.toString().isEmpty()) {
                        String className = field2.getType().getSimpleName();

                        if (className.equals("Date")) {
                        } else if (className.equals("Integer")) {
                            field2.set(cls2, 0);
                        } else if(className.equals("Double")) {
                        	field2.set(cls2, new Double(0));
                        }                        
                        else if (className.equals("Byte")) {
                            field2.set(cls2, new Byte("0"));
                        } else {
                            field2.set(cls2, "");
                        }
                    } else {
                        String strValue = value.toString();

                        String className = field2.getType().getSimpleName();

                        if (className.equals("Date")) {
                            field2.set(cls2, new Date(strValue));
                        } else if (className.equals("Integer")) {
                            field2.set(cls2, Integer.parseInt(strValue));
                        } else if(className.equals("Double")) {
                        	field2.set(cls2, new Double(0));
                        }else if (className.equals("Byte")) {
                            field2.set(cls2, new Byte(strValue));
                        } else {
                            field2.set(cls2, strValue);
                        }

                    }
                } catch (NoSuchFieldException ex) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static <T> void printValues(T t) {
        Class<?> clazz1 = t.getClass();

        try {
            Field[] fields1 = clazz1.getDeclaredFields();

            for (Field field1 : fields1) {
                field1.setAccessible(true);
                System.out.println("FIELD NAME : " + field1.getName() + " >>> VALUE : " + field1.get(t));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
    }
}
