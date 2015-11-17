package com.oris.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataField {
	public enum FieldType {
        STRING, NUMBER, BOOLEAN, DATE
    };
    
    FieldType fieldType() default FieldType.STRING;
    String fieldLabel() default "";
}
